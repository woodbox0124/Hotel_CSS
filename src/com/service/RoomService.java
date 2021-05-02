package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.RoomDAO;
import com.dto.RoomDTO;
import com.dto.RoomInfoDTO;

public class RoomService {

	
	public List<RoomDTO> roomList(String seq) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<RoomDTO> list = null;
		try {
			RoomDAO dao = new RoomDAO();
			list = dao.roomList(session,seq);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	public List<RoomInfoDTO> roomInfo(String seq) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<RoomInfoDTO> list = null;
		try {
			RoomDAO dao = new RoomDAO();
			list = dao.roomInfo(session,seq);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	public List<RoomDTO> roomList2(String seq) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<RoomDTO> list = null;
		try {
			RoomDAO dao = new RoomDAO();
			list = dao.roomList2(session,seq);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

}
