package tw.rocky.tutor;

public class Rocky26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rocky261 r1 = new Rocky263();
		Rocky262 r2 = new Rocky263();
		Rocky263 r3 = new Rocky263();
		r1.m1();
		r1.m2();
		r2.m3();
		r2.m4();
		r3.m1();
		r3.m2();
		r3.m3();
		r3.m4();
	}

}
// 介面 ==> 定義規格，無實作
interface Rocky261{
	void m1();
	void m2();
}

interface Rocky262{
	void m3();
	void m4();
}

// extends Object
class Rocky263 implements Rocky261, Rocky262{
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
}

// 介面可多個繼承
interface Rocky264 extends Rocky261, Rocky262{
	void m5();
}
// 多型
class Rocky265 implements Rocky264{

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m5() {
		// TODO Auto-generated method stub
		
	}
	
}





