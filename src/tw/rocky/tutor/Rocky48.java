package tw.rocky.tutor;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import tw.rocky.apis.Student;

public class Rocky48 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		FileInputStream fin = new FileInputStream("dir1/student.s");
		ObjectInputStream oin = new ObjectInputStream(fin);
		
		Object obj = oin.readObject();
		Student s1 = (Student)obj;
		Student s2 = (Student)oin.readObject();
		System.out.printf("%s : %d, %f\n", s1.getName(), s1.score(), s1.avg());
		System.out.printf("%s : %d, %f\n", s2.getName(), s2.score(), s2.avg());
		
		oin.close();
		
		System.out.println("OK");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
