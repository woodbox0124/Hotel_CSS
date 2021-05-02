package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.RoomDTO;
import com.dto.RoomInfoDTO;

public class RoomDAO {

	

	public List<RoomDTO> roomList(SqlSession session, String seq) {
		List<RoomDTO> list = session.selectList("HotelMapper.roomList",seq);
		return list;
	}
	public List<RoomInfoDTO> roomInfo(SqlSession session, String seq) {
		List<RoomInfoDTO> list = session.selectList("HotelMapper.roomInfo",seq);
		return list;
	}

	public List<RoomDTO> roomList2(SqlSession session, String seq) {
		List<RoomDTO> list = session.selectList("HotelMapper.roomList2",seq);
		return list;
	}

}
