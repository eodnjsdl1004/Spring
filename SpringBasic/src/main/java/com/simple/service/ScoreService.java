package com.simple.service;

import java.util.List;

import com.simple.command.ScoreVO;

public interface ScoreService {
	
	//점수등록 추상메서드
	public void ScoreRegist(ScoreVO vo);
	public List<ScoreVO> scoreList();
	public boolean scoreDelete(int num);
		
}
