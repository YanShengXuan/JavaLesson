package tw.rocky.tutor;

import java.io.BufferedReader;
import java.io.FileReader;

public class Rocky46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(FileReader fr = new FileReader("dir1/ns1hosp.csv");){
			BufferedReader reader = new BufferedReader(fr);
			String line;
			
			while((line =  reader.readLine()) != null) {
				System.out.println(line);
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		
	}

}