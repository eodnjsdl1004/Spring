package com.team404.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.FreeBoardVO;
import com.team404.mapper.FreeBoardMapper;

@Service("freeBoardService")
public class FreeBoardServiceImpl implements FreeBoardService{

	@Autowired
	private FreeBoardMapper freeBoardMapper;
	
	@Override
	public void regist(FreeBoardVO vo) {
		freeBoardMapper.Regist(vo);
	}

	@Override
	public List<FreeBoardVO> getList() {
		
		return freeBoardMapper.getList();
	}

	@Override
	public FreeBoardVO getContent(int bno) {
		
		return freeBoardMapper.getContent(bno);
	}

	@Override
	public int getUpdate(FreeBoardVO vo) {
		
		return freeBoardMapper.getUpdate(vo);
	}

	@Override
	public int getDelete(int bno) {
		
		return freeBoardMapper.getDelete(bno);
	}

}
