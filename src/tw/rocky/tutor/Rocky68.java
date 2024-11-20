package tw.rocky.tutor;

import tw.rocky.apis.BCrypt;

public class Rocky68 {
// bcrypt 加密
	public static void main(String[] args) {
		String passwold = "123456";
		String newPassword = BCrypt.hashpw(passwold, BCrypt.gensalt());
		System.out.println(newPassword);
		System.out.println(BCrypt.checkpw("123456", newPassword));
	}

}
