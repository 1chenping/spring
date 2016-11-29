package com.mp.mp_auth.controller;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mp.mp_auth.domain.User;
import com.mp.mp_auth.service.UserService;

@RestController
public class LoginController {
	

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private UserService userServicel;
    
    @RequestMapping(value = "/add" /*,method = RequestMethod.GET*/)
    public Collection<User> add(@RequestParam Integer a, @RequestParam Integer b) {
        Integer r = a + b;
        logger.info("/add, host:, service_id: result:" + r);
        Collection<User> user = null;
        user = userServicel.queryUser();
        logger.info(user);
        return user;
    }
    
    @RequestMapping(value = "/login")
    public User login(@RequestParam String userName) {
        logger.info("username:" + userName);
        User user = new User();
        user.setUser_username(userName);
        User res = userServicel.queryUserByName(user );
        logger.info(res);
        return res;
    }
    
}
