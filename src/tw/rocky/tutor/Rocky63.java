package tw.rocky.tutor;

public class Rocky63 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rocky631 obj = new Rocky631();
		obj.setDaemon(false);
		obj.start();
		System.out.println("Main");
	}

}


class Rocky631 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}