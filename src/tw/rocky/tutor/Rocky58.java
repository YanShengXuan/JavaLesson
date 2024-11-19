package tw.rocky.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Rocky58 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("https://www.ispan.com.tw/img/servicePlace/taizhong.jpg");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("dir2/3345678.jpg"));
			
			byte[] buf = new byte[4 * 1024 * 1024];
			int len;
			
			while((len = bin.read(buf))  != -1) {
				bout.write(buf, 0, len);
			}
			bout.flush();
			bout.close();
			bin.close();
			System.out.println("下載完成");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
