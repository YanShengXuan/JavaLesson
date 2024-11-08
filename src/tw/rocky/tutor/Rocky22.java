package tw.rocky.tutor;

import java.util.Scanner;

import tw.rocky.apis.TWId;

public class Rocky22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("請輸入身分證字號 => ");
		String id = sc.nextLine().toString();
		
		System.out.println(TWId.isRight(id));
	}

}
