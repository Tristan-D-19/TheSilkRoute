package com.aws.codestar.silkroute;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.repositories.UserRepository;
import com.aws.codestar.silkroute.service.AuthService;
//import com.aws.codestar.silkroute.service.LoginService;
import com.aws.codestar.silkroute.service.CustomUserDetails;

@EnableGlobalMethodSecurity(prePostEnabled=true)
@Configuration
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	

	@Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Autowired
	private DataSource dataSource;

  
    @Autowired 
    AuthService userDetailsService;
	    @Bean
	    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {

	        http.
	                authorizeRequests()
	                .antMatchers("/").permitAll()
	                .antMatchers("/login").permitAll()
	                .antMatchers("/registration").permitAll()
	                .antMatchers("/silk/**").hasRole("USER") 
	                .antMatchers("/admin/**").hasAuthority("ADMIN")
	                .anyRequest().authenticated()
	                	.and().csrf().disable()
	                .formLogin().loginPage("/login").failureUrl("/login?error=true")
	                .defaultSuccessUrl("/silk/home")
	                .usernameParameter("email")
	                .passwordParameter("password")
	                	.and().logout()
	                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	                .logoutSuccessUrl("/").and().exceptionHandling()
	                .accessDeniedPage("/access-denied")
	                ;
	        
	     //authorize admin
	        http.authorizeRequests().antMatchers("**/admin/**").hasRole("ADMIN");
	        
	     
	       
	      //authorize users
	        
	        http.authorizeRequests().antMatchers("**/silk/**").hasAuthority("USER").anyRequest()
	        .authenticated().anyRequest().permitAll()
	        .and().formLogin().permitAll();    
	    }

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	    	 UserDetailsBuilder <User> users = User.withDefaultPasswordEncoder();
	    	
	    	auth.		
	                    jdbcAuthentication()
	                    .usersByUsernameQuery(usersQuery)
	                    .authoritiesByUsernameQuery(rolesQuery)
	                    .dataSource(dataSource)
	                    .passwordEncoder(bCryptPasswordEncoder())
	                    .and();
	    	    
				auth.userDetailsService(userDetailsService);
//	    	    auth.jdbcAuthentication().withUser("tsr_admin").password("$lowJaguar29").roles("USER","ADMIN");
	        }

	    @Override
	    public void configure(WebSecurity web) throws Exception {
	        web
	                .ignoring()
	                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	    } 
	    
	 
}
