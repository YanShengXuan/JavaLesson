package tw.rocky.tutor;

public class Rocky35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bird b1 = new Bird();
		try {
		b1.setLeg(31);
		}catch(Exception e) {
			System.out.println("ERROR");
		}
		System.out.println(b1.getLeg());
	}

}

class Bird{
	private int leg;
	int getLeg() {
		return leg;
	}
	// 語意：throws 會拋出 Exception 實立
	void setLeg(int leg) throws Exception {
		if(leg >= 0 && leg <= 2) {
			this.leg = leg;
		}else {
			throw new Exception();
		}
	}
}
