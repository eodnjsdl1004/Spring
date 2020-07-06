package com.simple.basic;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링프레임 워크에서 독립적으로 테스트 환경을 가동
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml") //해당 파일을 스프링 설정파일로 적용
public class JDBCHikari {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	public  void Test() {
		try {

			Connection conn = dataSource.getConnection();
			System.out.println("결과확인:"+conn);
			
			System.out.println("스프링 jdbc결과확인:"+jdbcTemplate);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
