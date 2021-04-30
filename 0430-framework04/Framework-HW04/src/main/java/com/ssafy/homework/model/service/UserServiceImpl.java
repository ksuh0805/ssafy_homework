package com.ssafy.homework.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.homework.model.dto.User;
import com.ssafy.homework.model.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;
	
	@Override
	public User login(User user) throws SQLException {
		return mapper.login(user);
	}

}
