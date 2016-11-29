package com.mp.mp_auth.mapper;

import java.util.Collection;

import com.mp.mp_auth.domain.User;


public interface UserMapper {

	public Collection<User> queryUser();
	
	public User queryUserByName(User user);
}
