package com.aws.codestar.silkroute;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.repositories.UserRepository;
import com.aws.codestar.silkroute.service.AuthService;
import com.aws.codestar.silkroute.service.CustomAuthenticationProvider;
//import com.aws.codestar.silkroute.service.LoginService;
import com.aws.codestar.silkroute.service.CustomUserDetails;
//import com.aws.codestar.silkroute.service.UserDetailsServiceImpl;
import com.aws.codestar.silkroute.service.UserService;

@EnableGlobalMethodSecurity(prePostEnabled=true)
@Configuration
@EnableWebSecurity
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
//@ComponentScan(basePackageClasses = AuthService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	

	private static final String ADMIN = "ADMIN";

	private static final String USER = "USER";

	@Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Autowired
	private DataSource dataSource;

    @Autowired
    private CustomAuthenticationProvider authenticationProvider;
   
    @Autowired
    private AuthService userDetailsService;
    
    
	    @Bean
	    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

//	    @Autowired
//	    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//	    	auth.authenticationProvider(authenticationProvider());
//	    } 
	  
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {

	        http.
	                authorizeRequests()
	                .antMatchers("/").permitAll()
	                .antMatchers("/test").permitAll()
	                .antMatchers("/auth/login").permitAll()
	                .antMatchers("/confirm").permitAll()
	                .antMatchers("/products/**").permitAll()
	                .antMatchers("/cart/**").permitAll()
	                .antMatchers("/auth/registration","/auth/register").permitAll()
	                .antMatchers("/market/**").permitAll()
	                .antMatchers("/products/**").permitAll()
	                .antMatchers("index.jsp?txtKeyword=**").permitAll()
	                .antMatchers("user-home.jsp").hasAnyRole(USER, ADMIN)
	                .antMatchers("/search").permitAll()
	                .antMatchers("/silk/**").authenticated() 
	                .antMatchers("/admin/**").hasRole(ADMIN)
	                .anyRequest().authenticated()
	                	.and().csrf().disable()
	                .formLogin().loginPage("/auth/login").failureUrl("/login?error=true")
//	                .loginProcessingUrl("/auth/login")
	                .defaultSuccessUrl("/silk/home")
	                .usernameParameter("email")
	                .passwordParameter("password")
	                	.and().logout()
	                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	                .logoutSuccessUrl("/").and().exceptionHandling()
	                .accessDeniedPage("/access-denied")
	                .and().httpBasic()
	                ;
  
	    }

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    	
	    	
//	    	auth.inMemoryAuthentication().withUser(ADMIN).password("admin").roles("ADMIN");
//	    	
//	    	auth.		
//	                    jdbcAuthentication()                   
//	                    .dataSource(dataSource)
//	                    .passwordEncoder(bCryptPasswordEncoder())
//	                    .usersByUsernameQuery(usersQuery)
//	                    .authoritiesByUsernameQuery(rolesQuery);
//	                   
	    	auth.authenticationProvider(authenticationProvider());
	    	
//				auth.			
//				userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
//	    	    auth.jdbcAuthentication().withUser("tsr_admin").password("$lowJaguar29").roles("USER","ADMIN");
	        }

	    @Bean
	    public DaoAuthenticationProvider authenticationProvider(){
	        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
	        auth.setUserDetailsService(userDetailsService);
	        auth.setPasswordEncoder(bCryptPasswordEncoder());
	        return auth;
	    }
	    
	    @Override
	    public void configure(WebSecurity web) throws Exception {
	        web
	                .ignoring()
	                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/webjars/**");
	    } 
	    


}
