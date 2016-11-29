package com.mp.mp_auth;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mp.mp_auth.domain.User;
import com.mp.mp_auth.mapper.UserMapper;
import com.mp.mp_auth.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class AppTest{
	
	@Autowired
	private UserService userMapper;


	/****
	 * 测试成功
	 * @throws Exception
	 */
	
	@Test
	public void test() throws Exception {
		
		Collection<User> user = userMapper.queryUser();
		System.out.println(user.toString());
		
	}
}
