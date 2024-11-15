package tw.rocky.tutor;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Rpcky50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress ip = InetAddress.getByName("www.iii.org.tw"); // 主機名稱
			System.out.println(ip.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
