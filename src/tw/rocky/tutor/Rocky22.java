package tw.rocky.tutor;

import java.util.Scanner;

import tw.rocky.apis.TWId;

public class Rocky22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		System.out.print("請輸入身分證字號 => ");
//		String id = sc.nextLine().toString();
//		
//		System.out.println(TWId.isRight(id));
		TWId id1 = new TWId();
		TWId id2 = new TWId(true);
		TWId id3 = new TWId('T');
		TWId id4 = new TWId(false, 'B');
		TWId id5 = TWId.createTWId("A123456780");
		
		System.out.println(id1);
		System.out.println(id2);
		System.out.println(id3);
		System.out.println(id4);
		System.out.println(id5);
	}

}
