package tw.rocky.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Rocky39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try {
//			FileInputStream fin = new FileInputStream("dir1/file1.txt");
//			fin.close();
//			System.out.println("OK");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		// 可自動關閉敘述方式
		try(FileInputStream fin = new FileInputStream("dir1/file1.txt");) {
			int len;
			byte[] buf = new byte[3] ;
			while((len = fin.read(buf)) != -1) {
				System.out.print(new String(buf, 0, len));
			}
			System.out.println();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
