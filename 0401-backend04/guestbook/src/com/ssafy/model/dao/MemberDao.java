package com.ssafy.model.dao;

import java.sql.SQLException;

import com.ssafy.model.MemberDto;

public interface MemberDao {

	public void insertMember(MemberDto memberDto) throws SQLException;
	
}
