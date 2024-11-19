package tw.rocky.tutor;

public class Rocky62 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rocky621 object1 = new Rocky621("A");
		Rocky621 object2 = new Rocky621("B");
		Rocky622 object3 = new Rocky622("C");
		Thread t3 = new Thread(object3);
		
		object1.run();
		System.out.println("Main");
		object1.start() ;
		object2.start();
		t3.start();
		System.out.println("Finish");
	}
}

class Rocky621 extends Thread{
	private String name;
	Rocky621(String name){
		this.name = name;
	}
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.printf("%s, %d\n", name, i);
			try {
				Thread.sleep(100);
			} catch (Exception e) {

			}
		}
	}
}

class Rocky622 implements Runnable{
	private String name;
	Rocky622(String name){
		this.name = name;
	}
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.printf("%s, %d\n", name, i);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("起床");
			}
		}
	}
}
