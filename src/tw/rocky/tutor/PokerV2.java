package tw.rocky.tutor;

public class PokerV2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		int[] poker = new int[52];
		int temp;
		boolean isRepeat;
		for(int i = 0; i < 52; i++) {
			do {
				temp = (int)(Math.random() * 52);
				isRepeat = false;
				for(int j = 0; j < i; j++) {
					if(poker[j] == temp) {
						isRepeat = true;
						break;
					}
				}
			}while(isRepeat);
			
			poker[i] = temp;
			System.out.println(poker[i]);
		}
		System.out.println("----------------");
		System.out.println(System.currentTimeMillis() - start); //毫秒
	}

}
