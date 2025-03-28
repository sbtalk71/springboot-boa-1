package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.jwt.util.AuthRequest;
import com.demo.spring.jwt.util.JwtUtil;

@RestController
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@PostMapping(path="/authenticate",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String authenticate(@RequestBody AuthRequest request) throws Exception{
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
			
		} catch (Exception e) {
			throw new Exception("invalid Credentials...");
		}
		return jwtUtil.generateToken(request.getUserName());
	}
	
}
