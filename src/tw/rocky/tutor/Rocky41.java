package tw.rocky.tutor;

import java.io.FileOutputStream;

public class Rocky41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mesg = "Hello, World\n";
		
		try(FileOutputStream fout = new FileOutputStream("dir1/file2.txt", true);){
			fout.write(mesg.getBytes());
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
		

	}

}
