package com.simple.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.simple.command.BoardVO;
import com.simple.dao.BoardDAO;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService{

	@Resource(name="BoardDAOImpl")
	private BoardDAO boardDAO;
	
	@Override
	public void boardRegist(BoardVO vo) {
		boardDAO.boardRegist(vo);
	}

	@Override
	public List<BoardVO> getList() {
		
		return boardDAO.getList();
	}

	@Override
	public void boardDelete(int num) {
		boardDAO.boardDelete(num);
	}

}
