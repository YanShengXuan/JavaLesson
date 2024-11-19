package tw.rocky.tutor;

public class Rocky65 {

	public static void main(String[] args) {
		Store store = new Store();
		Producer p1 = new Producer(store);
		Consumer c1 = new Consumer(store);
		p1.start();
		c1.start();
	}
}


class Store{
	private int qty;
	private final int max = 10;
	
	void add(int add) {
		System.out.printf("進貨中...%d\n", add);
		while(qty + add > max) {
//			wait();
		}
		qty += add;
		System.out.printf("完成進貨：%d， 目前庫存：%d\n", add, qty);
	}
	
	void buy(int buy) {
		System.out.printf("想買...%d\n", buy);
		while(qty < buy) {
//			wait();
		}
		qty -= buy;
		System.out.printf("完成購買：%d， 目前庫存：%d\n", buy, qty);
	}
}

class Producer extends Thread{
	private Store store;
	Producer(Store store){
		this.store = store;
	}
	@Override
	public void run() {
		for(int i = 0; i < 7; i++) {
			store.add(5);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}
	}
}

class Consumer extends Thread{
	private Store store;
	Consumer(Store store) {
		this.store = store;
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			store.buy((int)(Math.random() * 3) + 1);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}
	}
}




