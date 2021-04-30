package com.ssafy.homework.model.service;

import java.sql.SQLException;

import com.ssafy.homework.model.dto.User;

public interface UserService {
	public User login(User user) throws SQLException;
}
