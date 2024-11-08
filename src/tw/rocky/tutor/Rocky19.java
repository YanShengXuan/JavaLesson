package tw.rocky.tutor;

public class Rocky19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CCC text1 = new CCC();
		System.out.println();
		CCC text2 = new CCC(1);
	}
}

class AAA{
	AAA(){
		// super(); ==> 沒有寫建構式，會自行定義
		System.out.println("AAA");
	}
}

class BBB extends AAA{
	BBB(){
		// super();
		System.out.println("BBB");
	}
}

class CCC extends BBB{
	CCC(){
		// super();
		System.out.println("CCC");
	}
	CCC(int a){
		System.out.println("Number");
	}
}
