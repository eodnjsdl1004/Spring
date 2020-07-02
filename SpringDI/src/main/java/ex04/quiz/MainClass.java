package ex04.quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//Car, Airplane 빈을 생성하고, 의존성 주입
		//각 객체안에 있는 배터리를 자바클래스에서 출력
		
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context.xml");
		Car car = ctx.getBean(Car.class);		
		Airplane airplane = ctx.getBean(Airplane.class);
		
		car.getBattery().energy();	
		
		airplane.getBattery().energy();
	}
}
