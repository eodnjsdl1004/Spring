package ex08.javaconfig;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ex01.SpringTest;
import ex03.setter.DatabaseDev;
import ex04.quiz.Airplane;
import ex04.quiz.Car;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		SpringTest t = ctx.getBean(SpringTest.class);
		t.test();
		
		DatabaseDev dev = ctx.getBean(DatabaseDev.class);
		System.out.println(dev.getUrl()+" "+dev.getUid()+" "+dev.getUpw());
		
		Car car = ctx.getBean(Car.class);
		car.getBattery().energy();
		car.getBattery2().energy();
		
		Airplane air = ctx.getBean(Airplane.class);
		air.getBattery().energy();
		
	}
}
