package tw.rocky.apis;

public class TWId {
	private String id;
	
	public TWId() {
		// 隨機
		this((int)(Math.random() * 2) == 0);
	}
	
	public TWId(boolean isMale) {
		this(isMale, 'A');
	}
	
	public TWId(char area) {
		this((int)(Math.random() * 2) == 0, 'A');
	}
	
	public TWId(boolean isMale, char area) {
		
		
	}
	
	private TWId(String id){
		// 實質傳入
		this.id = id;
	}
	
	public static boolean isRight(String id) {
		boolean isRight = false;
		int sum = 0;
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numbers = "0123456789";
		
		int[] serialNumbers = {10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21,
				22,	35, 23, 24, 25, 26, 27, 28, 29, 32, 30, 31, 33};
		
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
			isRight = true;
		}
		
		int firstNumber = serialNumbers[letters.indexOf(id.charAt(0))];		
		sum = (firstNumber / 10) + (firstNumber % 10 * 9) +
				numbers.indexOf(id.charAt(1)) * 8 + numbers.indexOf(id.charAt(2)) * 7 + numbers.indexOf(id.charAt(3)) * 6 +
				numbers.indexOf(id.charAt(4)) * 5 + numbers.indexOf(id.charAt(5)) * 4 + numbers.indexOf(id.charAt(6)) * 3 +
				numbers.indexOf(id.charAt(7)) * 2 + numbers.indexOf(id.charAt(8)) + numbers.indexOf(id.charAt(9));
		System.out.println(sum);
		
		return isRight;
		
		
	}
}
