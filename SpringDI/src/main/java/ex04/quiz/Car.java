package ex04.quiz;

public class Car {

	private IBattery battery;
	
	public Car(IBattery battery) {
		this.battery = battery;
	}

	//getter
	public IBattery getBattery() {
		return battery;
	}
	
}
