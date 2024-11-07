package tw.rocky.tutor;

import tw.rocky.apis.Bike;

public class Rocky15 {
	public static void main(String[] args) {
		Bike b1 = new Bike(11.22);
		System.out.println(b1.getSpeed());
		b1.upSpeed();
		b1.upSpeed();
		b1.upSpeed();
		System.out.println(b1.getSpeed());
		b1.downSpeed();
		b1.downSpeed();
		b1.downSpeed();
		System.out.println(b1.getSpeed());
	}
}
