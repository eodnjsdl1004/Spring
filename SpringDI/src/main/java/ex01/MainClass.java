package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
//		SpringTest test = new SpringTest();
//		test.test();
		
		//스프링 설정 파일
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context.xml");
		SpringTest test1 = ctx.getBean("test",SpringTest.class);
		SpringTest test2 = ctx.getBean("test",SpringTest.class);
		test1.test();
		
		//스프링 IOC컨테이너는 기본적으로 bean을 싱글톤 형식으로 생성합니다. 안쓰면 싱글톤
		//만약, bean을 사용할 때마다 새로운 객체 형태로 쓰고싶다면 scope ="prototype"을 기술하면 됩니다. 
		System.out.println(test1);
		System.out.println(test2);
		
	}	
}
