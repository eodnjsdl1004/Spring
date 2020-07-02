package ex04.quiz;

public class Car {

	private IBattery battery;
	private IBattery battery2;
	
	public Car(IBattery battery,IBattery battery2) {
		this.battery = battery;
		this.battery2 = battery2;
	}

	//getter
	public IBattery getBattery() {
		return battery;
	}
	
	public IBattery getBattery2() {
		return battery2;
	}
	
}
