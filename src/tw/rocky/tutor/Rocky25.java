package tw.rocky.tutor;

public class Rocky25 {
	public static void main(String[] args) {
		//虛擬類別無法建立物件
		Rocky251 a1 = new Rocky252();
		Rocky251 a2 = new Rocky253();
		
	}
}
// 虛擬類別
abstract class Rocky251 {
	void m1() {}
	void m2() {}
	abstract void m3();
}
// 利用子類別來使用虛擬類別 ==> 多形
class Rocky252 extends Rocky251{
	void m3() {
		System.out.println("Rocky252:m3()");
	}
}

class Rocky253 extends Rocky251{
	void m3() {
		System.out.println("Rocky253:m3()");
	}
}