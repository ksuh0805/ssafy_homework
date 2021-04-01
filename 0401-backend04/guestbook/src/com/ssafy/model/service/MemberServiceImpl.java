package com.ssafy.model.service;

import com.ssafy.model.MemberDto;
import com.ssafy.model.dao.MemberDao;
import com.ssafy.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	}

	@Override
	public void join(MemberDto memberDto) throws Exception {
		memberDao.insertMember(memberDto);
	}
}
