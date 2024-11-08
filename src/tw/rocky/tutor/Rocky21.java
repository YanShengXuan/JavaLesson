package tw.rocky.tutor;

public class Rocky21 {
	public static void main(String[] args) {
		String s1 = "Rocky";
		String s2 = new String("Rocky");
		String s3 = new String(s1);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
		System.out.println(s1 == s3); // ==>比較內容（記憶體位置)
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s2.equals(s3));
	}
}
