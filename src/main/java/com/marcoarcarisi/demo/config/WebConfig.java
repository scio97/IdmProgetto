package com.marcoarcarisi.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.marcoarcarisi.demo.rest", "com.marcoarcarisi.demo.service", "com.marcoarcarisi.demo.config"})
@Import({ AppConfig.class })
public class WebConfig implements WebMvcConfigurer{

    @Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp"); 
		return resolver; 
	}
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/");
	}
    
}
