package tw.rocky.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.rocky.apis.MyDrawerText;

public class MySignText extends JFrame{
	private MyDrawerText myDrawerText;
	
	public MySignText() {
		super("測試測試");
		
		setLayout(new BorderLayout());
		myDrawerText = new MyDrawerText();
		add(myDrawerText, BorderLayout.CENTER);
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MySignText();
	}

}
