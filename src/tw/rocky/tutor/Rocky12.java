package tw.rocky.tutor;

public class Rocky12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p = new int[7];
		
		for(int i = 0; i < 100000; i++) {
			int point = (int)(Math.random()*9) + 1;
			//機率變化 ==> 灌水
			if(point >=1 && point <=9) {
				p[point > 6 ? point - 3 : point]++;
			}else {
				p[0]++;
			}
		}
		
		if(p[0] > 0) {
			System.out.println("ERROR");
		}else {
			for(int i = 1; i < p.length; i++) {
				System.out.printf("點數%d出現%d次\n", i, p[i]);
			}
		}
	}

}
