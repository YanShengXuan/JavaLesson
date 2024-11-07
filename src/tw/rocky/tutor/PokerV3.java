package tw.rocky.tutor;

import java.util.Arrays;

public class PokerV3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		int[] poker = new int[52];
		for(int i = 0; i < poker.length; i++) {
			poker[i] = i;
		}
		
		for(int i = poker.length - 1; i > 0; i--) {
			int rand = (int)(Math.random() * (52 + 1));
			int temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		}
		
		//分牌給四個玩家
		int[][] players = new int[4][13];
		for(int i = 0; i < poker.length; i++) {
			players[i % 4][i / 4] = poker[i];
		}
		
		//花色與編號
		String[] color = {"梅花","方塊","紅心","黑桃"};
		String[] values = new String[] {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		for(int[] player : players) {
			Arrays.sort(player);
			for(int card : player) {
				System.out.printf("%s %s \t", color[card / 13], values[card % 13]);
			}
			System.out.println();
		}
		
		
		System.out.println("----------------");
		System.out.println(System.currentTimeMillis() - start); //毫秒
	}

}
