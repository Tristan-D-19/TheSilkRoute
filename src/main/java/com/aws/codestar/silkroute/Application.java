package com.aws.codestar.silkroute;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.aws.codestar.silkroute.models.Role;
import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.repositories.RoleRepository;
import com.aws.codestar.silkroute.repositories.UserRepository;
import com.aws.codestar.silkroute.service.UserService;

/** Simple class to start up the application.
 *
 * @SpringBootApplication adds:
 *  @Configuration
 *  @EnableAutoConfiguration
 *  @ComponentScan
 */


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.aws.codestar.silkroute.repositories")
@EnableWebSecurity
public class Application extends SpringBootServletInitializer {

	
	
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
    
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
//    	createAdmin();
        SpringApplication.run(Application.class, args);
        
        
    }

}
