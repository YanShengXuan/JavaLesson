package tw.rocky.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.Socket;

public class Rocky55 {
	// TCP client
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File source = new File("");
		try {
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream("dir2/cat3.jpg"));
			byte[] buf = new byte[(int)source.length()];
			
			bin.read(buf);
			bin.close();
			
			Socket socket = new Socket(InetAddress.getByName("10.0.104.177"), 7777);
			BufferedOutputStream bout = new BufferedOutputStream(socket.getOutputStream());
			bout.write(buf);
			bout.flush();
			bout.close();
			System.out.println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
