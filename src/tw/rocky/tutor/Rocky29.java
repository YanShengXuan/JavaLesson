package tw.rocky.tutor;

import java.util.HashSet;
import java.util.Iterator;

import tw.rocky.apis.Bike;

public class Rocky29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet set = new HashSet();
		set.add("A");
		set.add(1); // int => Auto-boxing => Integer
		set.add(1.23);
		set.add(1.2);
		set.add("B");
		set.add(new Bike());
		
		System.out.println(set.size());
		System.out.println(set);
		
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

}
