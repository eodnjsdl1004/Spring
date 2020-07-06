package com.simple.basic;

interface ABC{
	public void abc();
}

public class JDBCAnonymous {
	
	public void test() {
		ABC abc = new ABC() {
			
			@Override
			public void abc() {
				System.out.println("익명클래스~");				
			}
		};
		
		abc.abc(); 
		//보통의 경우에는 별도의 클래스를 생성해서 쓰지만,
		//재사용 될 일이 없는 1회성 클래스는 익명클래스로 빠르게 생성해서 사용합니다.		
	}
}
