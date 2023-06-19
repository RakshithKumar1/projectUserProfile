package com.dxc.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.project.model.UserProfile;

public interface UserProfileRepo extends JpaRepository<UserProfile, Integer> {

}
