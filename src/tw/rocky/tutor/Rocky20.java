package tw.rocky.tutor;

import tw.rocky.apis.Bike;

public class Rocky20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s0 = "Rocky";
		String s1 = new String();
		byte[] b1 = {97, 98, 99, 100, 101, 102};
		String s2 = new String(b1);
		String s3 = new String(b1, 2, 3);
		
		System.out.println(s0);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		Bike bike = new Bike();
		System.out.println(bike); //印出記憶體位置
		Object obj = new Object();
		System.out.println(obj);
	}

}
