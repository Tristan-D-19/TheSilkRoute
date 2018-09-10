package com.aws.codestar.silkroute.controller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
 
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan
public class MvcConfig extends WebMvcConfigurerAdapter {

	
	public MvcConfig() {
		// TODO Auto-generated constructor stub
	}

	
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        registry.viewResolver(resolver);
        
 
        
    }
	
//	@Bean
//	 public InternalResourceViewResolver mvcView() {
//	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//	        resolver.setPrefix("/WEB-INF/view/");
//	        resolver.setSuffix(".jsp");
//	        resolver.setViewClass(JstlView.class);
//	        
////	        registry.viewResolver(resolver);
//	        
//	        return resolver;
//	}
	        
}




