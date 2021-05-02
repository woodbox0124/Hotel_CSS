package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.HotelDAO;
import com.dto.HotelDTO;
import com.dto.PageDTO;

public class HotelService {

	
	public List<HotelDTO> hotelList() {
		SqlSession session = MySqlSessionFactory.getSession();
		System.out.println(session);
		List<HotelDTO> list = null;
		try {
			HotelDAO dao = new HotelDAO();
			list = dao.hotelList(session);
			System.out.println("service"+list);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	public List<HotelDTO> searchKey(String location) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<HotelDTO> list = null;
		try {
			HotelDAO dao = new HotelDAO();
			list = dao.searchKey(session, location);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}


	public List<HotelDTO> hotelList(String place) {
		SqlSession session = MySqlSessionFactory.getSession();
		System.out.println(session);
		List<HotelDTO> list = null;
		try {
			HotelDAO dao = new HotelDAO();
			list = dao.hotelList(session,place);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	public PageDTO hotelList1(int curPage, String location) {
		SqlSession session = MySqlSessionFactory.getSession();
		PageDTO pDTO = null;
		try {
			HotelDAO dao = new HotelDAO();
			pDTO = dao.hotelList1(session, location, curPage);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return pDTO;
	}
	public PageDTO hotelList1(int curPage) {
		SqlSession session = MySqlSessionFactory.getSession();
		PageDTO pDTO = null;
		try {
			HotelDAO dao = new HotelDAO();
			pDTO = dao.hotelList1(session, curPage);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return pDTO;
	}
}
