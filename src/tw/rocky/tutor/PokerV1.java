package tw.rocky.tutor;

public class PokerV1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		int[] poker = new int[52];
		
		for(int i = 0; i < 52; i++) {
			int temp = (int)(Math.random() * 52);
			
			boolean isRepeat = false;
			for(int j = 0; j < i; j++) {
				if(poker[j] == temp) {
					isRepeat = true;
					break;
				}
			}
			
			if(!isRepeat) {
				poker[i] = temp;
				System.out.println(poker[i]);
			}else {
				i--;
			}
		}
		System.out.println("----------------");
		System.out.println(System.currentTimeMillis() - start); //毫秒
	}

}
