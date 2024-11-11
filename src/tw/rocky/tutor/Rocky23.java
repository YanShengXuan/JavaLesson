package tw.rocky.tutor;

public class Rocky23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Rocky231.counter);
		Rocky231 x = new Rocky231();
		Rocky231 y = new Rocky231();
		Rocky231 z = new Rocky231();
		System.out.println(Rocky231.counter);
		System.out.println(x.i);
		System.out.println(y.i);
		System.out.println(z.i);
		System.out.println(x.counter);
		System.out.println(y.counter);
		System.out.println(z.counter);
	}

}

class Rocky231 {
	static int counter;
	int i;
	
	Rocky231(){
		counter++;
		i++;
	}
}
