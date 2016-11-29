package com.mp.mp_auth.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.mp.mp_auth.domain.User;
import com.mp.mp_auth.mapper.UserMapper;

@Configuration
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public Collection<User> queryUser(){
		return userMapper.queryUser();
	}
	
	public User queryUserByName(User user){
		return userMapper.queryUserByName(user);
	}
}
