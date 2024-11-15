package tw.rocky.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Rocky51 {
/*網路通信發送端*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mesg = "HelloWorld";
		byte[] data = mesg.getBytes();
			try {
				DatagramSocket socket = new DatagramSocket();
				DatagramPacket packet = new DatagramPacket(data, data.length,
								InetAddress.getByName("10.0.104.177"), 8888);
				
				socket.send(packet);
				socket.close();
				System.out.println("UDP OK");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			

	}

}
