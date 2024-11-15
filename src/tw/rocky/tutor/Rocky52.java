package tw.rocky.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Rocky52 {
	/*網路通信接收端*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] data = new byte[1024];
		try {
			DatagramSocket socket = new DatagramSocket(8888);
			DatagramPacket packet = new DatagramPacket(data, data.length);
			
			socket.receive(packet);
			byte[] temp = packet.getData();
			int len = packet.getLength();
			String urip = packet.getAddress().getHostAddress();
			System.out.printf("%s : %s", urip, new String(temp, 0, len));
			
			System.out.println("UDP OK");
			
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
