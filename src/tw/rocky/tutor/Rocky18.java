package tw.rocky.tutor;

import tw.rocky.apis.Bike;
import tw.rocky.apis.Scooter;

public class Rocky18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bike b1 = new Bike();
		Bike b2 = new Scooter();
		Scooter b3 = new Scooter();
		
		b1.upSpeed();
		b2.upSpeed();
		b3.changeGear(3);
		
		Scooter s2 = (Scooter) b2;
		s2.changeGear(2);
	}
	
	static void m2(int a) {
		
	}

}
