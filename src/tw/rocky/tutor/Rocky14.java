package tw.rocky.tutor;

public class Rocky14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = -10, b = 4;
		//xor 交換
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		
		System.out.printf("a = %d, b = %d\n", a, b);
		
		int v1 = 3, v2 = 2;
		
		System.out.println(v1 & v2);
		System.out.println(v1 | v2);
		System.out.println(v1 ^ v2);
	}

}
