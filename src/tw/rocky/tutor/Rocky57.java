package tw.rocky.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Rocky57 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("https://www.ispan.com.tw/");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			
			String line;
			
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
