package tw.rocky.tutor;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Rocky53 {
// TCP client
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		Socket socket = new Socket(InetAddress.getByName("10.0.104.89"), 9999);
		
		OutputStream out = socket.getOutputStream();
		out.write("HelloWorld".getBytes());
		out.flush();
		out.close();
		System.out.println("OK");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

}
