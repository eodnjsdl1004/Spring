package com.simple.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.simple.command.BoardVO;

@Repository("BoardDAOImpl")
public class BoardDAOImpl implements BoardDAO{

	
//	private List<BoardVO> DB = new ArrayList<>();	
//	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void boardRegist(BoardVO vo) {
		
//		DB.add(vo);
//		System.out.println("DB저장 성공");
		
		String sql = "insert into board(bno,name,title,content) values(bno_seq.nextval,?,?,?)";
		
		int result = jdbcTemplate.update(sql, new Object[] {vo.getName(),vo.getTitle(), vo.getContent()});
		
		System.out.println("성공 실패"+result);
		
	}

	@Override
	public List<BoardVO> getList() {
//		System.out.println("DB호출");
//		return DB;
		String sql ="select * from board";
		List<BoardVO> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<BoardVO>() {

			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				BoardVO vo = new BoardVO();
				vo.setBno(rs.getInt("bno"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));								
				
				return vo;
			}
		});
		
		
		return list;
	}

	@Override
	public void boardDelete(int num) {
		
//		DB.remove(num);
//		System.out.println(num+"번째 DB 삭제 성공");
		
		String sql = "delete from board where bno =?";
		int result = jdbcTemplate.update(sql, new Object[] {num});
		
		
		System.out.println("성공 실패"+result);
	}

}
