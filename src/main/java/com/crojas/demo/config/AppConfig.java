package com.crojas.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.crojas.demo.*")
public class AppConfig extends WebMvcConfigurerAdapter {
	
	
	@Bean
	public ViewResolver beanNameViewresolver() {
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		return resolver;
	}
	
	
	@Override
	public void addResourceHandlers( ResourceHandlerRegistry registry ) {
		registry.addResourceHandler( "/resources/**" )
				.addResourceLocations( "/resources/" );
	}
	
	
	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setPrefix( "/WEB-INF/pages/" );
		irvr.setSuffix( ".jsp" );
		return irvr;
	}
	
	
}
