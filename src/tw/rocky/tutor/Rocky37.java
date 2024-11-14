package tw.rocky.tutor;

import java.io.File;

public class Rocky37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		
		File file1 = new File("C:\\Users\\a2422\\Desktop\\text1");
		File file2 = new File("C:\\Users\\a2422\\Desktop\\text2");
		
		System.out.println(file1.exists()); // 驗證檔案是否存在
		System.out.println(file2.exists());
		
		File file3 = new File("./dir3"); // 指向專案執行位置
		
		if(!file3.exists()) {
			if(file3.mkdir()) {
				System.out.println("OO");
			}else {
				System.out.println("XX");
			}
		}
	}

}
