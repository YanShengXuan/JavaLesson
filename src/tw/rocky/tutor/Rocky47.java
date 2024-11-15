package tw.rocky.tutor;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import tw.rocky.apis.Student;

public class Rocky47 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("Rocky", 90, 80, 70);
		Student s2 = new Student("Bard", 60, 50, 40);
		System.out.printf("%s : %d, %f\n", s1.getName(), s1.score(), s1.avg());
		
		try{
			FileOutputStream fout = new FileOutputStream("dir1/student.s");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			
			oout.writeObject(s1);
			oout.writeObject(s2);
			
			oout.flush();
			oout.close();
			
			System.out.println("OK");
			
			}catch (Exception e) {
			// TODO: handle exception
				System.out.println(e);
		}
	}

}
