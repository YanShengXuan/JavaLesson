package tw.rocky.tutor;

import java.util.HashMap;

public class Rocky32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Object> person = new HashMap<String, Object>();
		person.put("name", "Rocky");
		person.put("age", 29);
		person.put("weight", 80);
		person.put("gener", true);
		
		System.out.println(person.get("name"));
		System.out.println(person.keySet());
		
	}

}
