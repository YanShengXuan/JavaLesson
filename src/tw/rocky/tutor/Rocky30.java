package tw.rocky.tutor;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Rocky30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> lottery = new HashSet<Integer>();
		TreeSet<Integer> lottery2 = new TreeSet<Integer>(); // 有排序的
		
		while(lottery.size() < 6) {
//			lottery.add(new Random().nextInt(49) + 1);
			lottery.add((int) (Math.random()*49+1));
		}
		while(lottery2.size() < 6) {
			lottery2.add(new Random().nextInt(49) + 1);
		}
		
		System.out.println(lottery);
		System.out.println(lottery2);
		
		for(Integer number : lottery) {
			System.out.println(number);
		}
	}

}
