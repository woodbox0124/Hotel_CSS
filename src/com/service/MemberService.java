package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDAO;
import com.dto.MemberDTO;

public class MemberService {

	public int mamberAdd(MemberDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		System.out.println(session);
		int n = 0;
		try {
			MemberDAO dao = new MemberDAO();
			n = dao.memberAdd(session, dto);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			session.close();
		}
		return n;	
	}

	public MemberDTO login(HashMap<String, String> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		 MemberDTO dto = null;
		 try {
			 MemberDAO dao = new MemberDAO();
			 dto = dao.login(session, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public MemberDTO mypage(String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDTO dto1 = null;
		try {
			MemberDAO dao = new MemberDAO();
			dto1 = dao.mypage(session, userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto1;
	}
	public int idCheck(String userid) 
	{
		SqlSession session = MySqlSessionFactory.getSession();
		int count = 0;
		try 
		{
			MemberDAO dao = new MemberDAO();
            count = dao.idCheck(session, userid);
		}
		catch(Exception e)
		{
			e.printStackTrace(); 		
		}
		finally 
		{
			session.close();		
		}
		return count;
 }

	public int memberDelete(String u_id) {
		int n = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try
		{
			MemberDAO dao = new MemberDAO();
			n = dao.memberDelete(session, u_id);
			session.commit();
		}
		finally 
		{
			session.close();
		}
		return n;
	}

	public int memberUpdate(MemberDTO dto1) {
		int n = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try
		{
			MemberDAO dao = new MemberDAO();
			n = dao.memberUpdate(session, dto1);
			session.commit();
		}
		finally 
		{
			session.close();
		}
		return n;
	}

	public int pwchk(String u_pw) {
		SqlSession session = MySqlSessionFactory.getSession();
		int num = 0;
		try
		{
			MemberDAO dao = new MemberDAO();
			num = dao.pwchk(session, u_pw);
		}
		finally 
		{
			session.close();
		}
		return num;
	}
	
}