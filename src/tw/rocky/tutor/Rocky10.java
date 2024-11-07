package tw.rocky.tutor;

public class Rocky10 {
	public static void main(String[] args) {
		int[] ary1;
		ary1 = new int[3];
		System.out.println(ary1.length);
		System.out.println("-----------------");
		
		ary1[0] = 12;
		ary1[1] = 123;
		ary1[2] = 1234;
		
		for(int i = 0; i < ary1.length; i++) {
			System.out.println(ary1[i]);
		}
		System.out.println("-----------------");
		
		for(int i : ary1) {
			System.out.println(i);
		}
	}

}
