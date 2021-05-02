package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.HotelDTO;
import com.dto.PageDTO;

public class HotelDAO {

	
	public List<HotelDTO> hotelList(SqlSession session) {
		List<HotelDTO> list = session.selectList("HotelMapper.hotelList");
		System.out.println(list);
		return list;
	}

	public List<HotelDTO> searchKey(SqlSession session, String place) {
		List<HotelDTO> list = session.selectList("HotelMapper.searchKey", place);
		return list;
	}


	public List<HotelDTO> hotelList(SqlSession session, String location) {
		List<HotelDTO> list = session.selectList("HotelMapper.hotelLoc",location);
		return list;
	}

	public PageDTO hotelList1(SqlSession session, String location, int curPage) {
		PageDTO pDTO = new PageDTO();
		int perPage = pDTO.getPerPage();
		int offset = (curPage-1)*perPage;
		List<HotelDTO> list = session.selectList("HotelMapper.hotelLoc", location, new RowBounds(offset,perPage));
		pDTO.setCurPage(curPage);//현재 페이지
		pDTO.setList(list);//리스트 저장
		pDTO.setTotalCount(totalCount(session, location));//검색어도 넘겨서 검색에 관련 전체 레코드 개수 구하기
		System.out.println("pDTO\t"+pDTO);
		return pDTO;
	}
	/*
	 * public PageDTO hotelList1(SqlSession session, int curPage) { PageDTO pDTO =
	 * new PageDTO(); int perPage = pDTO.getPerPage(); int offset =
	 * (curPage-1)*perPage; List<HotelDTO> list =
	 * session.selectList("HotelMapper.hotelLoc", location, new
	 * RowBounds(offset,perPage)); pDTO.setCurPage(curPage);//현재 페이지
	 * pDTO.setList(list);//리스트 저장 pDTO.setTotalCount(totalCount(session,
	 * location));//검색어도 넘겨서 검색에 관련 전체 레코드 개수 구하기 System.out.println("pDTO\t"+pDTO);
	 * return pDTO; }
	 */
	
	
	private int totalCount(SqlSession session, String location) {
		int num = session.selectOne("HotelMapper.totalCount", location);
		System.out.println("totalCount\t"+num);
		return num; 
	}

	public PageDTO hotelList1(SqlSession session, int curPage) {
		PageDTO pDTO = new PageDTO();
		int perPage = pDTO.getPerPage();
		int offset = (curPage-1)*perPage;
		List<HotelDTO> list = session.selectList("HotelMapper.hotelList", null, new RowBounds(offset,perPage));
		pDTO.setCurPage(curPage);//현재 페이지
		pDTO.setList(list);//리스트 저장
		pDTO.setTotalCount(totalCount(session));//검색어도 넘겨서 검색에 관련 전체 레코드 개수 구하기
		System.out.println("pDTO\t"+pDTO);
		return pDTO;
	}
	
	private int totalCount(SqlSession session) {
		int num = session.selectOne("HotelMapper.totalCount1");
		System.out.println("totalCount\t"+num);
		return num; 
	}
}
