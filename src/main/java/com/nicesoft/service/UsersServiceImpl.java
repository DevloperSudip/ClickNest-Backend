package com.nicesoft.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicesoft.dto.LoginRequest;
import com.nicesoft.entity.Users;
import com.nicesoft.repository.UserRepo;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UserRepo userRepo;

	public Users addUsers(Users users) {
		return userRepo.save(users);

	}


	
	
	public Optional<Users> loginUser(LoginRequest loginRequest) {
	    Optional<Users> userOpt = Optional.ofNullable(userRepo.findByEmail(loginRequest.getEmail()));

	    if (userOpt.isPresent()) {
	        Users user = userOpt.get();
	        // Compare passwords (hashing recommended in real apps)
	        if (user.getPassword().equals(loginRequest.getPassword())) {
	            return userOpt; // ✅ return the Optional<Users> itself
	        }
	    }

	    return Optional.empty(); // ✅ login failed
	}

}
