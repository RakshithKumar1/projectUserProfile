package com.dxc.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.project.exception.UserExistsException;
import com.dxc.project.exception.UserNotFoundException;
import com.dxc.project.model.UserProfile;
import com.dxc.project.repo.UserProfileRepo;


@Service
public class UserProfileSerImpl implements UserProfileSerive {
	
	@Autowired
	UserProfileRepo repo;



	@Override
	public UserProfile saveInfo(UserProfile userProf) throws UserExistsException{
		// TODO Auto-generated method stub
		final boolean existById = repo.existsById(userProf.getUserId());
		if(existById) {
			throw new UserExistsException("User Already Exists");
		}
		return repo.save(userProf);
	}
	
	@Override
	public UserProfile updateInfo(int userId, UserProfile userProf)  {
		
		UserProfile up = repo.findById(userId).get();
		
		 if ((userProf.getFirstName()!= null) && !"".equalsIgnoreCase(userProf.getFirstName())){
		            up.setFirstName(userProf.getFirstName());
		 }
		 if((userProf.getLastName()!=null) && !"".equalsIgnoreCase(userProf.getLastName())) {
			 up.setLastName(userProf.getLastName());
		 }
		 if((userProf.getEmail()!=null) && !"".equalsIgnoreCase(userProf.getEmail())) {
			 up.setEmail(userProf.getEmail());
		 }
		 if((userProf.getPhoneNumber()!= 0)) {
			 up.setPhoneNumber(userProf.getPhoneNumber());
		 }
		 if((userProf.getGender()!=null) && !"".equalsIgnoreCase(userProf.getGender())) {
			 up.setGender(userProf.getGender());
		 }
		 if((userProf.getAddress()!=null) && !"".equalsIgnoreCase(userProf.getAddress())) {
			 up.setAddress(userProf.getAddress());
		 }
		 if((userProf.getPincode()!= 0)) {
			 up.setPincode(userProf.getPincode());
		 }
		 return repo.save(up);
	}


	

	@Override
	public void deleteByUserId(int userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		final boolean existsOrNot = repo.existsById(userId);
		if(existsOrNot) {
			repo.delete(read(userId));
		}
		else {
			throw new UserNotFoundException("User record not found");
		}
		
	}
	public UserProfile read(int userId) {
		UserProfile result = null;
		Optional<UserProfile> temp = repo.findById(userId);
		if(temp.isPresent()) {
			result = repo.findById(userId).get();
		}
		return result;
	}




}
