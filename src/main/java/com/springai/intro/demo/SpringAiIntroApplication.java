package com.springai.intro.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springai.intro.demo.Service.OpenAiServiceImp;

@SpringBootApplication
public class SpringAiIntroApplication {
	
	@Autowired
	OpenAiServiceImp service;

	public static void main(String[] args) {
		SpringApplication.run(SpringAiIntroApplication.class, args);
	}

}
