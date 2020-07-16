package com.team404.service;

import java.util.List;

import com.team404.command.FreeBoardVO;
import com.team404.utill.Criteria;

public interface FreeBoardService {
	public void regist(FreeBoardVO vo); //등록
	public List<FreeBoardVO> getList(Criteria cri);
	public FreeBoardVO getContent(int bno);
	public int getUpdate(FreeBoardVO vo);
	public int getDelete(int bno);
	public int getTotal();
}
