package com.br.sgt.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.jaxrs2.SwaggerSerializers;
import springfox.documentation.swagger2.annotations.EnableSwagger2;








@Configuration
@ApplicationPath("/sgt")

public class JerseyConfig extends ResourceConfig{
	public JerseyConfig(ObjectMapper objectMapper) {
		packages("com.br.sgt.service");	
	}
	

	

	
	

}
