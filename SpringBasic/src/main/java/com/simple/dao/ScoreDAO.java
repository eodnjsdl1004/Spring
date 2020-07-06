package com.simple.dao;

import java.util.List;

import com.simple.command.ScoreVO;

public interface ScoreDAO {
	public void scoreRegist(ScoreVO vo);
	public List<ScoreVO> scoreList();
	public boolean scoreDelete(int num);
}
