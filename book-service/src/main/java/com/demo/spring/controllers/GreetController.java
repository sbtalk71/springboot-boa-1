package com.demo.spring.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.util.ResponseMessage;

@RestController
public class GreetController {

	@GetMapping(path = "/greet/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseMessage greet(@PathVariable("name") String name) {
		return new ResponseMessage(name+", Welcome to Spring REST");
	}
}
