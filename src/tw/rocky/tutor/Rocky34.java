package tw.rocky.tutor;

public class Rocky34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10, b = 0, c = 0, e = 0;
		try {
		c = a / b;
		System.out.println(c);
		}catch(ArithmeticException ae1) {
			System.out.println(0);
			
		}
		int [] d = {1, 2, 3, 4};
		try {
		System.out.println(d[100]);
		}catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println(1);
		}
		
		try {
			System.out.println(d[100]);
			e = a / b;
			System.out.println(c);
		}catch(ArithmeticException ae2) {
			System.out.println(3);
		}catch(ArrayIndexOutOfBoundsException ae3) {
			System.out.println(4);
		}
	}

}
