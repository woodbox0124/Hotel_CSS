package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.ResvDTO;
import com.dto.ResvMyDTO;

public class ResvDAO {

	public List<ResvMyDTO> resvMy(SqlSession session, String u_id) {
		List<ResvMyDTO> list = session.selectList("ResvMapper.resvMy", u_id);
		return list;
	}
	public int resvInsert(SqlSession session, ResvDTO dto) {
		int num = session.insert("ResvMapper.resvInsert", dto);
		System.out.println("dao num = "+num);
		return num;
		}

	public int resvCancel(SqlSession session, int seq) {
		int num = session.update("ResvMapper.resvCancel", seq);
		System.out.println("dao num = "+num);
		return num;
	}
}
