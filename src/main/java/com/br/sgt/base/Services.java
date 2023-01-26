package com.br.sgt.base;

import org.springframework.context.annotation.Bean;

import com.google.gson.Gson;

public class Services {

	
	@Bean
	public Gson gs() {
		return new Gson();
	}
}
