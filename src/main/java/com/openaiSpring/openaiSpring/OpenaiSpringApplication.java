package com.openaiSpring.openaiSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OpenaiSpringApplication {

	private String openaiApiKey = "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";

	public static void main(String[] args) {
		SpringApplication.run(OpenaiSpringApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add((request, body, execution) -> {
			request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
			return execution.execute(request, body);
		});
		return restTemplate;
	}
}
