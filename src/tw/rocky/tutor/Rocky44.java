package tw.rocky.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.System.Logger;

public class Rocky44 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 傳輸效能較好
		long start = System.currentTimeMillis();
		File source = new File("dir1/cat.jpg");
		File target = new File("dir2/cat2.jpg");
		try(FileInputStream fin = new FileInputStream(source);
			FileOutputStream fout = new FileOutputStream(target);){
			byte[] buf = new byte[(int)source.length()];
			fin.read(buf);
			fout.write(buf);		
			
			fout.flush();
			System.out.println("OK");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		System.out.println(System.currentTimeMillis() - start);
	}

}
