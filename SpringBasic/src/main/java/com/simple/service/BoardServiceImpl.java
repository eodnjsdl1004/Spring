package com.simple.service;


//import java.util.HashMap;
import java.util.List;

//import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.command.BoardVO;
//import com.simple.dao.BoardDAO;
import com.simple.mapper.BoardMapper;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService{
	
	/*
	 * 1. board 관련 mybatis 인터페이스 선언, 구현체를 생성 
	 * 2. xml 파일에서는 아이디를 이용해서 메퍼태그를 생성 
	 * 3. 서비스 영역에서 매퍼 주입하고 추상메서드를 실행
	 */
	
	@Autowired
	private BoardMapper boardMapper; 
	
	@Override
	public void boardRegist(BoardVO vo) {
		
		System.out.println(vo.getBno());
		System.out.println(vo.getName());
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		
		
		//1st
		int result = boardMapper.boardRegist(vo);		
		System.out.println("성공 실패"+result);
		
//		//2nd
//		HashMap<String, String> map = new HashMap<>();
//		map.put("name", vo.getName());
//		map.put("title", vo.getTitle());
//		map.put("content", vo.getContent());		
	}

	@Override
	public List<BoardVO> getList() {
		
		return boardMapper.getList();
	}

	@Override
	public void boardDelete(int num) {
		boardMapper.boardDelete(num);		
	}

//	@Resource(name="BoardDAOImpl")
//	private BoardDAO boardDAO;
//	
//	@Override
//	public void boardRegist(BoardVO vo) {
//		boardDAO.boardRegist(vo);
//	}
//
//	@Override
//	public List<BoardVO> getList() {
//		
//		return boardDAO.getList();
//	}
//
//	@Override
//	public void boardDelete(int num) {
//		boardDAO.boardDelete(num);
//	}

}
