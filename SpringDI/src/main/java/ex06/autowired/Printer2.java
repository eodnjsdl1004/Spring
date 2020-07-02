package ex06.autowired;

import javax.annotation.Resource;

public class Printer2 {

	/*
	 * @Rename -> 이름으로 찾는다 -> 타입으로 찾음
	 * 세터, 멤버변수에 적용가능 
	 */	
	@Resource(name="doc2")
	private Document document;
	
	public Printer2() {}
	//생성자
	
	public Printer2(Document document) {
		this.document = document;
	}

	public Document getDocument() {
		return document;
	}
	
	public void setDoc1(Document document) {
		this.document = document;
	}
}
