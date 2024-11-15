package tw.rocky.apis;

import java.io.Serializable;

public class Bike implements Serializable {
	protected void name() {
		
	} double speed;
	
	//建構式
	public Bike() {
		System.out.println("Bike()");
	}
	
	public Bike(double speed) {
		this.speed = speed;
		System.out.println("Bike()");
	}
	//-----------------------------
	public void upSpeed() {
		speed += 1;
	}
	
	public void downSpeed() {
		speed = speed < 1 ? speed : speed - 1;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
