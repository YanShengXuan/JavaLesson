package tw.rocky.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.System.Logger;

public class Rocky43 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		try(FileInputStream fin = new FileInputStream("dir1/cat.jpg");
			FileOutputStream fout = new FileOutputStream("dir2/cat.jpg");){
			int b;
			while((b = fin.read()) != -1) {
				fout.write(b);
			}
			
			fout.flush();
			System.out.println("OK");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		System.out.println(System.currentTimeMillis() - start);
	}

}
