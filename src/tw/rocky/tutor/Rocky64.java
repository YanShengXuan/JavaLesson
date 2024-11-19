package tw.rocky.tutor;

import java.util.Timer;
import java.util.TimerTask;

public class Rocky64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.schedule(new Rocky641(), 1 * 1000, 1 * 1000);
		timer.schedule(new Stop(timer), 10 * 1000);
		System.out.println("main");
	}

}

class Rocky641 extends TimerTask{
	private int i; 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(i++);
		
	}
}

class Stop extends TimerTask{
	private Timer timer;
	Stop(Timer timer){
		this.timer = timer;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		timer.purge();
		timer.cancel();
		timer = null;
	}
	
}
