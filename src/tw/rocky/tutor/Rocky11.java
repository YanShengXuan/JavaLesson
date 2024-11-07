package tw.rocky.tutor;

public class Rocky11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p0, p1, p2, p3, p4, p5, p6;
		p0 = p1 = p2 = p3 = p4 = p5 = p6 = 0;
		
		for(int i = 0; i < 100; i++) {
			int point = (int)(Math.random() * 6) + 1;
			switch(point) {
				case 1: p1++; break;
				case 2: p2++; break;
				case 3: p3++; break;
				case 4: p4++; break;
				case 5: p5++; break;
				case 6: p6++; break;
				default: p0++;
			}
		}
		
		if(p0 > 0) {
			System.out.println("ERROR");
		}else {
			System.out.printf("點數1出現 %d 次\n", p1);
			System.out.printf("點數2出現 %d 次\n", p2);
			System.out.printf("點數3出現 %d 次\n", p3);
			System.out.printf("點數4出現 %d 次\n", p4);
			System.out.printf("點數5出現 %d 次\n", p5);
			System.out.printf("點數6出現 %d 次\n", p6);
		}
	}

}
