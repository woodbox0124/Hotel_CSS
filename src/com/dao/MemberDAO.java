package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {

   public int memberAdd(SqlSession session,MemberDTO dto) {
	    int n = session.insert("MemberMapper.memberAdd",dto);
	    return n;  
   }

   public MemberDTO login(SqlSession session, HashMap<String, String> map) {
		MemberDTO dto = session.selectOne("MemberMapper.login", map);
		return dto;
	}

public MemberDTO mypage(SqlSession session, String userid) {
	   MemberDTO dto1 = session.selectOne("MemberMapper.mypage", userid);
	return dto1;
}

public int idCheck(SqlSession session, String userid) 
	{
	   int count = session.selectOne("MemberMapper.idCheck", userid);
	   return count;
	}


	public int memberDelete(SqlSession session, String u_id) {
		int n = session.delete("MemberMapper.memberDelete",u_id);
		return n;
	}

	public int memberUpdate(SqlSession session, MemberDTO dto) {
		int n = session.update("MemberMapper.memberUpdate", dto);
		return n;
	}

	public int pwchk(SqlSession session, String u_pw) {
		int num = session.selectOne("MemberMapper.pwChk",u_pw);
		return num;
	}


}
