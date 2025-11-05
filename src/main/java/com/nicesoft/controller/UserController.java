package com.nicesoft.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nicesoft.dto.LoginRequest;
import com.nicesoft.dto.LoginResponse;
import com.nicesoft.entity.Users;
import com.nicesoft.service.UsersService;

@RestController
public class UserController {

	@Autowired
	UsersService usersService;

	@PostMapping("/register")
	public ResponseEntity<Users> addUser(@RequestBody Users user) {
		Users saved = usersService.addUsers(user);
		return ResponseEntity.ok(saved);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
	    Optional<Users> userOpt = usersService.loginUser(loginRequest);
	    if (userOpt.isPresent()) {
	        return ResponseEntity.ok(new LoginResponse(userOpt.get().getName(), "Login successful"));
	    } else {
	        return ResponseEntity.status(401).body(new LoginResponse("", "Invalid email or password"));
	    }
	}

}