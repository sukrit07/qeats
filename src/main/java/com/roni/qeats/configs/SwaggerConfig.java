package com.roni.qeats.configs;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo())
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.roni"))
				.build()
				.pathMapping("/")
				.useDefaultResponseMessages(false);
	}

	private ApiInfo getInfo() {
		
		return new ApiInfo("Qe App APIs", "Backend API for Qe App using Java SpringBoot", "1.0",
				"Terms of Service", new Contact("Sukrit", "https://github.com/sukrit07", "sukrit07"
				+ "@gmail.com"), "License of APIs", "API License URL", Collections.emptyList());
	}

}
