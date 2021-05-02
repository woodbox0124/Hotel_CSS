package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.ResvDAO;
import com.dto.ResvDTO;
import com.dto.ResvMyDTO;

public class ResvService {
	

	public ResvService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<ResvMyDTO> resvMy(String u_id) {
		SqlSession session = MySqlSessionFactory.getSession();		
		List<ResvMyDTO> list = null;
		try {
			ResvDAO dao = new ResvDAO();
			 list = dao.resvMy(session, u_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int resvInsert(ResvDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int num=0;
		try {
			ResvDAO dao = new ResvDAO();
			num = dao.resvInsert(session,dto);
			System.out.println("dao"+num);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return num;
	}
	public int resvCancel(int seq) {
		SqlSession session = MySqlSessionFactory.getSession();
		int num=0;
		try {
			ResvDAO dao = new ResvDAO();
			num = dao.resvCancel(session,seq);
			System.out.println("dao"+seq);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return num;
	}

}
