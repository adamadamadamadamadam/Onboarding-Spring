package com.example.onboarding.bm.obbm.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OBBMControllerTests {
	
	@LocalServerPort
	private int port;
	
	private String url;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@BeforeEach
	public void startUp() {
		url = String.format("http://localhost:%d/controller", port);
	}
	
	@Test
	public void testHello() {
		url += "/hello";
		
		assertThat(this.restTemplate.getForObject(url, String.class).contains("hello"));
	}
	
	@Test
	public void testGetAuthors() {
		url += "/authors";
		
		assertThat(this.restTemplate.getForObject(url, String.class).contains("xester"));
	}
}
