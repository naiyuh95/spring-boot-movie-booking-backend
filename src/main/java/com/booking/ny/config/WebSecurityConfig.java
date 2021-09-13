package com.booking.ny.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.CorsConfiguration;



@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true) //disable this to allow all roles to access
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
        
			http.cors().and().csrf().disable().authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest)
			.permitAll().antMatchers(HttpMethod.OPTIONS).permitAll().antMatchers("/**").permitAll();


			http.headers().contentSecurityPolicy("script-src 'self'");
	    }
		
		@Bean
		public CorsFilter corsFilter() {
			final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			final CorsConfiguration config = new CorsConfiguration();
			config.addAllowedOrigin("https://hackit-submission-frontend-ny.herokuapp.com/");
			config.addAllowedMethod("*");
			config.addAllowedHeader("*");
			source.registerCorsConfiguration("/**", config);
			return new CorsFilter(source);
		}
	  
}

