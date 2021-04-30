package com.ssafy.homework.model.repository;

import java.sql.SQLException;

import com.ssafy.homework.model.dto.User;

public interface UserMapper {
	/**
	 * user에 해당하는 사용자 정보 반환
	 * 
	 * @param user
	 * @return 사용자 정보 객체 User
	 * @throws SQLException
	 */
	User login(User user) throws SQLException;
}
