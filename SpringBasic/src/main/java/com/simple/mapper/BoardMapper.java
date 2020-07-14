package com.simple.mapper;

import java.util.List;

import com.simple.command.BoardVO;

public interface BoardMapper {
	
	public int boardRegist(BoardVO vo); //board 등록 메서드
	public List<BoardVO> getList(); //모든 게시물 가져오기
	public void boardDelete(int num); //게시글 삭제 메서드
}
