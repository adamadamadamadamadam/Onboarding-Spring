package com.example.onboarding.bm.obbm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onboarding.bm.obbm.dao.AuthorDao;
import com.example.onboarding.bm.obbm.dto.CreateAuthorDTO;
import com.example.onboarding.bm.obbm.dto.ResponseDTO;
import com.example.onboarding.bm.obbm.model.Author;
import com.example.onboarding.bm.obbm.service.AuthorService;

@RestController
@RequestMapping("/controller")
public class OBBMController {

	@Autowired
	AuthorDao authorDao;

	@Autowired
	AuthorService authorService;

	@PostMapping("/hello")
	public ResponseDTO hello(@RequestBody String name) {
		ResponseDTO response = new ResponseDTO();

		response.setCode("200");
		response.setMessage(HttpStatus.OK.toString());
		response.setData(String.format("hello %s", name));

		return response;
	}

	@GetMapping("/hello-world")
	public ResponseDTO helloWorld() {
		ResponseDTO response = new ResponseDTO();

		response.setCode("200");
		response.setMessage(HttpStatus.OK.toString());
		response.setData(String.format("hello world"));

		return response;
	}

	@GetMapping("/authors")
	public ResponseDTO getAuthors() {
		ResponseDTO response = new ResponseDTO();
		try {
			List<Author> authors = authorService.getAllAuthors();
			
			response.setCode("200");
			response.setMessage(HttpStatus.OK.toString());
			response.setData(authors);
			
			return response;
		} catch(Exception e) {
			response.setCode("500");
			response.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			response.setData(e);
			
			return response;
		}
	}
	
	@GetMapping("/authors/name/{name}")
	public ResponseDTO getAuthorsByName(@PathVariable("name") String name) {
		ResponseDTO response = new ResponseDTO();
		try {
			List<Author> authors = authorService.getAuthor(name);
			
			response.setCode("200");
			response.setMessage(HttpStatus.OK.toString());
			response.setData(authors);
			
			return response;
		} catch(Exception e) {
			response.setCode("500");
			response.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			response.setData(e);
			
			return response;
		}
	}
	
	@PostMapping("/authors/insert")
	public ResponseDTO insertNewAuthors(@RequestBody CreateAuthorDTO input) {
		ResponseDTO response = new ResponseDTO();
		try {
			Author author = authorService.insertAuthor(input.getName());
			
			response.setCode("200");
			response.setMessage(HttpStatus.OK.toString());
			response.setData(author);
			
			return response;
		} catch(Exception e) {
			response.setCode("500");
			response.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			response.setData(e);
			
			return response;
		}
	}
}
