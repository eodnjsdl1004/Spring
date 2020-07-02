package ex08.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ex01.SpringTest;
import ex02.construct.Chef;
import ex02.construct.Hotel;
import ex03.setter.DatabaseDev;
import ex03.setter.MemberDAO;
import ex04.quiz.Airplane;
import ex04.quiz.Battery1;
import ex04.quiz.Battery2;
import ex04.quiz.Car;



//이클래스가 스프링 설정파일이라는 것을 표기합니다. .xml을 대신할 수 있음

@Configuration
public class JavaConfig {
	//<bean class="ex01.SpringTest" id="test" scope="prototype"/>
	
	//@bean이 붙은 메서드를 스피링 컨테이너 bean처럼 사용 가능
	@Bean
	public SpringTest test() {
		return new SpringTest();
	}
	
//	<bean class="ex02.construct.Chef" id="chef" />
	
	@Bean
	public Chef chef() {
		return new Chef();
	}
	
//	<bean class="ex02.construct.Hotel" id="hotel" >
	
	@Bean
	public Hotel hotel() {
		return new Hotel(chef());
	}
	
	//setter주입
	//<bean class="ex03.setter.DatabaseDev" id="dbDev">
	@Bean
	public DatabaseDev dbDev() {
		
		DatabaseDev dev = new DatabaseDev();
		dev.setUrl("오라클");
		dev.setUid("아이디");
		dev.setUpw("비밀번호");
		
		return dev;
	}

	//setter2
	//<bean class="ex03.setter.MemberDAO" id="mDAO">
	@Bean
	public MemberDAO mDAO() {
		MemberDAO dao = new MemberDAO();
		dao.setDatasource(dbDev());
		return dao;
	}
	
	//quiz
	@Bean
	public Battery1 b1() {
		return new Battery1();
	}
	
	@Bean
	public Battery2 b2() {
		return new Battery2();
	}

	@Bean
	public Car car() {
		return new Car(b1(),b2());
	}
	
	@Bean
	public Airplane airplane() {
		
		Airplane air = new Airplane();
		air.setBattery(b2());
		
		return air;
	}
	
}
