package com.team404.mapper;

import java.util.List;

import com.team404.command.FreeBoardVO;
import com.team404.utill.Criteria;

public interface FreeBoardMapper {
	public void Regist(FreeBoardVO vo);
	public List<FreeBoardVO> getList(Criteria cri);
	public FreeBoardVO getContent(int bno);
	public int getUpdate(FreeBoardVO vo);
	public int getDelete(int bno);
	public int getTotal();
}
