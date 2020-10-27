package com.local.cobranca;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;


@SpringBootApplication
public class CobrancaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CobrancaApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localResolver(){
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}	
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
	   return (container -> {
	        ErrorPage  error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");	         
	        container.addErrorPages(error404Page);
	   });
	}	
	
	@Configuration
	public static class MvcConfig extends WebMvcConfigurerAdapter {		
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addRedirectViewController("/", "/titulos/filtro");
		}		
	}	
	
}