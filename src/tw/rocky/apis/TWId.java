package tw.rocky.apis;

import java.util.Random;

public class TWId {
	private String id;
	private static String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
	
	public TWId() {
		// 隨機
		this((int)(Math.random() * 2) == 0);
	}
	
	public TWId(boolean isMale) {
		this(isMale, letters.charAt(new Random().nextInt(26)));
	}
	
	public TWId(char area) {
		this((int)(Math.random() * 2) == 0, area);
	}
	
	public TWId(boolean isMale, char area) {
		StringBuffer sb = new StringBuffer();
		sb.append(area);
		sb.append(isMale ? '1' : '2');
		for(int i = 0; i < 7; i++) {
			sb.append(new Random().nextInt(10));
		}
		
		for(int i = 0; i < 10; i++) {
			if(isRight(sb.toString() + i)) {
				id = sb.toString() + i;
				break;
			}
		}
		
	}
//	上述為亂數產生
	private TWId(String id){
		// 實質傳入
		this.id = id;
	}
	
	public String getTWId() {
		return id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getArea() {
		return "台中市";
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public static TWId createTWId(String id) {
		if(isRight(id)) {
			return new TWId(id);
		}
		else {
			return null;
		}
	}
	
	
	public static boolean isRight(String id) {
		boolean isRight = false;
//		int sum = 0;
//		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		String numbers = "0123456789";
		
//		int[] serialNumbers = {10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21,
//				22,	35, 23, 24, 25, 26, 27, 28, 29, 32, 30, 31, 33};
		
		// 條件一 長度是否十碼
//		if(id.length() == 10) {
//			// 條件二 第一碼是否為英文
//			char c1 = id.charAt(0);
//			if(letters.indexOf(c1) != -1) {
//				// 條件三 第二碼是否為1或2
//				if(id.charAt(1) == '1' || id.charAt(1) == '2') {
//					// 條件四 檢查後八碼是否為數字
//					for(int i = 2; i < 10; i++) {
//						if(numbers.indexOf(id.charAt(i)) != -1) {
//							isRight = true;
//						}else {
//							isRight = false;
//							break;
//						}
//					}
//				}
//			}
//		}

		if(id.matches("[A-Z][12][0-9]{8}")) {
			
//			int firstNumber = serialNumbers[letters.indexOf(id.charAt(0))];		
//			sum = (firstNumber / 10) + (firstNumber % 10 * 9) +
//					numbers.indexOf(id.charAt(1)) * 8 + numbers.indexOf(id.charAt(2)) * 7 + numbers.indexOf(id.charAt(3)) * 6 +
//					numbers.indexOf(id.charAt(4)) * 5 + numbers.indexOf(id.charAt(5)) * 4 + numbers.indexOf(id.charAt(6)) * 3 +
//					numbers.indexOf(id.charAt(7)) * 2 + numbers.indexOf(id.charAt(8)) + numbers.indexOf(id.charAt(9));
//			if(sum % 10 == 0) {
//				isRight = true;
//			}
			char c1 = id.charAt(0);
			int a12 = letters.indexOf(c1) + 10;
			int a1 = a12 / 10;
			int a2 = a12 % 10;
			isRight = true;
			String s1 = id.substring(1, 2);
			int n1 = Integer.parseInt(s1);
			String s2 = id.substring(2, 3);
			int n2 = Integer.parseInt(s2);
			String s3 = id.substring(3, 4);
			int n3 = Integer.parseInt(s3);
			String s4 = id.substring(4, 5);
			int n4 = Integer.parseInt(s4);
			String s5 = id.substring(5, 6);
			int n5 = Integer.parseInt(s5);
			String s6 = id.substring(6, 7);
			int n6 = Integer.parseInt(s6);
			String s7 = id.substring(7, 8);
			int n7 = Integer.parseInt(s7);
			String s8 = id.substring(8, 9);
			int n8 = Integer.parseInt(s8);
			String s9 = id.substring(9, 10);
			int n9 = Integer.parseInt(s9);
			int sum = a1 * 1 + a2 * 9 + n1 * 8 + n2 * 7 + n3 * 6 + n4 * 5 + n5 * 4 + n6 * 3 + n7 * 2 + n8 * 1 + n9 * 1;
			isRight = sum % 10 == 0;
		}
		return isRight;
	}
}
