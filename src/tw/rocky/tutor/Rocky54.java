package tw.rocky.tutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Rocky54 {
// TCP Server
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket sever = new ServerSocket(9999);
			Socket socket = sever.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String mesg = br.readLine();
			String urip = socket.getInetAddress().getHostAddress();
			
			System.out.printf("%s :%s\n", urip, mesg);
			
			br.close();
			sever.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

}
