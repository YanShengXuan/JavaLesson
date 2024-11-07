package tw.rocky.tutor;

public class Rocky09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int Rows = 1;
		final int Cols = 9;
		final int Start = 1;
		
		for(int k = 0; k < Rows; k++) {
			for(int j = 1; j <= 9; j++) {
				for(int i = Start; i < Start + Cols; i++) {
					int newi = i + Cols * k;
					int r = newi * j;
					System.out.printf("%d * %d = %d\t", newi, j, r);
				}
				System.out.println();
			}
		}

	}

}
