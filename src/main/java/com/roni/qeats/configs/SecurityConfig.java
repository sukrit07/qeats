package com.roni.qeats.configs;


import com.roni.qeats.security.*;
import com.roni.qeats.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfig {
	
	public static final String[] PUBLIC_URLS = {
			"/api/v1/auth/**",
			"/v3/api-docs",
			"/v3/api-docs/**",
			"/v2/api-docs",
			"/swagger-resources/**",
			"/swagger-ui/**",
			"/webjars/**"
	};

	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       return http
						.csrf(csrf -> csrf.disable())
						.authorizeHttpRequests(auth -> auth
								.requestMatchers(PUBLIC_URLS).permitAll()
								.anyRequest().authenticated()
						)
						.exceptionHandling(exceptions -> exceptions
								.authenticationEntryPoint(this.jwtAuthenticationEntryPoint))
						.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
						.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
						.build();
    }
		
	
	/* 
	 * === No Need for authenticationManager in Spring Security >= 5.7.2 === 
	 * https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
	 * It is also no longer necessary to manually set UserDetailsService implementation in AuthenticationManager instance, 
	 * it only needs to exist in the spring context (example is done with the help of annotations to create beans).
	 */
//	@Bean
//    AuthenticationManager authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
//        return builder.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder()).and().build();
//    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
