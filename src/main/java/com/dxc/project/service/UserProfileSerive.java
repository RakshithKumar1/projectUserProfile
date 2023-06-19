package com.dxc.project.service;

import com.dxc.project.exception.UserExistsException;
import com.dxc.project.exception.UserNotFoundException;
import com.dxc.project.model.UserProfile;

public interface UserProfileSerive {
	
	public UserProfile saveInfo(UserProfile userProf) throws UserExistsException;
	public UserProfile updateInfo(int userId, UserProfile userProf);
	public void deleteByUserId(int userId) throws UserNotFoundException;
}
