package com.nicesoft.service;

import java.util.Optional;

import com.nicesoft.dto.LoginRequest;
import com.nicesoft.entity.Users;

public interface UsersService {

	
	public Users addUsers( Users users); 
	
	public Optional<Users> loginUser(LoginRequest loginRequest);
}
