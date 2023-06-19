package com.dxc.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.project.exception.UserExistsException;
import com.dxc.project.exception.UserNotFoundException;
import com.dxc.project.model.UserProfile;
import com.dxc.project.service.UserProfileSerImpl;

@RestController
@RequestMapping("/user")
public class Controller {

	@Autowired
	UserProfileSerImpl service;
	
	@PostMapping("saveInfo")
	public UserProfile saveInfo(@RequestBody UserProfile userProf) throws UserExistsException {
		return service.saveInfo(userProf);
	}
	
	@PutMapping("updateInfo/{userId}")
	public UserProfile updateUserInfo(@PathVariable("userId") int userId,@RequestBody UserProfile userProf) {
		return service.updateInfo(userId,userProf);
	}
	
	@DeleteMapping("deleteAccount/{userId}")
	public void deleteMyAccount(@PathVariable int userId) throws UserNotFoundException {
		service.deleteByUserId(userId);
	}
}
