package tw.rocky.tutor;

import java.util.LinkedList;

public class Rocky31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> names = new LinkedList<String>();
		names.add(0, "AAA");
		names.add(0, "BBB");
		names.add(0, "CCC");
		names.add(0, "DDD");
		names.add(0, "EEE");
		
		
		for(String name :names) {
			System.out.println(name);
		}
		System.out.println("---------");
		System.out.println(names.get(2));
		names.remove(2);
		System.out.println(names.get(2));
	}

}
