package ex07.quiz;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Computer {

	@Autowired
	private Keyboard kb;
	
	@Autowired
	@Qualifier("Monitor2")
	private Monitor monitor;
	
	@Resource(name="Mouse")
	private Mouse mouse;
	
	public void computerInfo() {
		System.out.println("***컴퓨터 정보***");
		kb.info();
		monitor.info();
		mouse.info();
	}

	public Mouse getMouse() {
		return mouse;
	}
	
	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}

	public Keyboard getKb() {
		return kb;
	}

	public void setKb(Keyboard kb) {
		this.kb = kb;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}	
}
