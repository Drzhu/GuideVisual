package com.guide.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guide.mapper.UserMapper;
import com.guide.pojo.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	public int validate_user(User user) {
		// TODO Auto-generated method stub
		return userMapper.validate_user(user);
	}

	public int update(User user) {
		// TODO Auto-generated method stub
		return userMapper.update(user);
	}

	public int validate_right(User user) {
		// TODO Auto-generated method stub
		return userMapper.validate_right(user);
	}

}
