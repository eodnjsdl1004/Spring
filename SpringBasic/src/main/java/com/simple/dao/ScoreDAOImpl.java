package com.simple.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.simple.command.ScoreVO;

@Repository("scoreDAOImpl")
public class ScoreDAOImpl implements ScoreDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
//	private List<ScoreVO> DB = new ArrayList<>();
	
	@Override
	public void scoreRegist(ScoreVO vo) {
		String sql = "insert into score(num,name,kor,eng,math) values(score_seq.nextval,?,?,?,?)";
		
		int result=jdbcTemplate.update(sql, new Object[] {vo.getName(),vo.getKor(),vo.getEng(),vo.getMath()});
		
		System.out.println("성공 실패"+result);
//		DB.add(vo);
//		System.out.println(DB.toString());
	}

	@Override
	public List<ScoreVO> scoreList() {	
		String sql ="select * from score";
		List<ScoreVO> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<ScoreVO>() {

			@Override
			public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				//제네릭에는 select 구문을 처리할 vo 가 들어갑니다.
				//mapRow에서도 안에서는 resultSet 객체를 처리하는 구문이 들어갑니다.
				
				ScoreVO vo = new ScoreVO();
				
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getString("kor"));
				vo.setEng(rs.getString("eng"));
				vo.setMath(rs.getString("math"));
				return vo;
			}
		});
		return list;
	}

	@Override
	public boolean scoreDelete(int num) {
		
		String sql = "delete from score where num = ?";
		
		int result=jdbcTemplate.update(sql, new Object[] {num});
		
		System.out.println("성공 실패"+result);
		
//		DB.remove(num);			
		return true;
	}

}
