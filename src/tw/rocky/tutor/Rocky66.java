package tw.rocky.tutor;

public class Rocky66 {

	public static void main(String[] args) {
		Store2 store = new Store2();
		Producer2 p1 = new Producer2(store);
		Consumer2 c1 = new Consumer2(store, "R");
		Consumer2 c2 = new Consumer2(store, "B");
		p1.start();
		c1.start();
		c2.start();
	}
}


class Store2{
	private int qty;
	private final int max = 10;
	// synchronized ==> 鎖定功能，一次只能一個執行續使用
	synchronized void add(int add) throws InterruptedException {
		System.out.printf("進貨中...%d\n", add);
		while(qty + add > max) {
			wait();
		}
		qty += add;
		System.out.printf("完成進貨：%d， 目前庫存：%d\n", add, qty);
	}
	
	synchronized void buy(int buy, String name) throws InterruptedException {
		System.out.printf("%s 想買...%d\n", name, buy);
		while(qty < buy) {
			wait();
		}
		qty -= buy;
		notify();
		System.out.printf("%s 完成購買：%d， 目前庫存：%d\n", name, buy, qty);
	}
}

class Producer2 extends Thread {
	private Store2 store;
	Producer2(Store2 store){
		this.store = store;
	}
	@Override
	public void run() {
		for(int i = 0; i < 7; i++) {
			try {
				store.add(5);
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}
	}
}

class Consumer2 extends Thread{
	private Store2 store;
	private String name;
	Consumer2(Store2 store, String name) {
		this.store = store;
		this.name = name;
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			try {
				store.buy((int)(Math.random() * 3) + 1, name);
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}
	}
}




