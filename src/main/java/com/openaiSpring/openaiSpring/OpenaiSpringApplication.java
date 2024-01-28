package com.openaiSpring.openaiSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OpenaiSpringApplication {

	// OpenAI API key
	private String openaiApiKey = "API KEY GOES HERE";

	public static void main(String[] args) {
		// Starts this application
		SpringApplication.run(OpenaiSpringApplication.class, args);
	}

	@Bean // Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add((request, body, execution) -> {
			request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
			return execution.execute(request, body);
		});
		return restTemplate;
	}
}
