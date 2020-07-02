package ex06.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Printer {

	/*
	 *	@Autowired -> 타입으로 주입 -> 이름으로 찾음
	 *	생성자, 세터, 변수 사용가능 
	 *
	 *	required = false 옵션은
	 *	스프링이 주입할 빈이 없으면 자동으로 에러를 발생시키는데
	 *	이를 무시한다는 속성 
	 *
	 *	@Qualifier -> 빈 강제 연결
	 *	컨테이너 동일 객체가 여러개 있을때 어느 객체를 주입할지 선택해주는 어노테이션
	 *	변수, 세터에서 주로 사용한다.
	 */
	
	@Autowired
	@Qualifier("doc1")
	private Document document;
	
	public Printer() {}
	//생성자
	
	public Printer(Document document) {
		this.document = document;
	}

	public Document getDocument() {
		return document;
	}
	
	public void setDoc1(Document document) {
		this.document = document;
	}
	
}
