package com.ssafy.model.dao;

/**
 CREATE TABLE IF NOT EXISTS `ssafyweb`.`ssafy_member` (
  `userid` VARCHAR(16) NOT NULL,
  `username` VARCHAR(20) NOT NULL,
  `userpwd` VARCHAR(16) NOT NULL,
  `email` VARCHAR(50) NULL,
  `address` VARCHAR(100) NULL,
  `joindate` TIMESTAMP NULL DEFAULT current_timestamp,
  PRIMARY KEY (`userid`))
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ssafy.model.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {

	@Override
	public void insertMember(MemberDto memberDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into ssafy_member (userid, username, userpwd, email, address) \n");
			sql.append("values (?, ?, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			int index = 1;
			pstmt.setString(index++, memberDto.getUserid());
			pstmt.setString(index++, memberDto.getUsername());
			pstmt.setString(index++, memberDto.getUserpwd());
			pstmt.setString(index++, memberDto.getEmail());
			pstmt.setString(index++, memberDto.getAddress());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}
}
