package tw.rocky.practise;

import java.util.Scanner;

public class Rabbit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*有一對兔子，從出生後第3個月起每個月都生一對兔子，小兔子長到第三個月後
		  每個月開始生一對兔子，依序下去，假如兔子都不會死，試問個月兔子會有多少*/
		Scanner sc = new Scanner(System.in);
		System.out.print("請輸入欲得知月份之兔子數量 => ");
		int month = sc.nextInt();
		System.out.printf("%d月總共有%d對兔子", month, count(month));
	}
	
	protected static int count(int month) {
		if(month == 1 || month == 2) {
			return 1;
		}else {
			return count(month -1) + count(month -2);
		}
	}

}
