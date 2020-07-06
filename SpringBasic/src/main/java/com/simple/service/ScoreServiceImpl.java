package com.simple.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.dao.ScoreDAO;

@Service("scoreService") //컴포넌트 스캔이 읽어서 scoreService이름으로 빈으로 생성(빈=스프링파일이름)
public class ScoreServiceImpl implements ScoreService{
	
	@Resource(name="scoreDAOImpl")
	private ScoreDAO scoreDAO;
	

	@Override
	public void ScoreRegist(ScoreVO vo) {
		scoreDAO.scoreRegist(vo);		
	}


	@Override
	public List<ScoreVO> scoreList() {
		
		return scoreDAO.scoreList();
	}


	@Override
	public boolean scoreDelete(int num) {
		
		return scoreDAO.scoreDelete(num);
	}

}
