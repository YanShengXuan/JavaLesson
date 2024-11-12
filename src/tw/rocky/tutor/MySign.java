package tw.rocky.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MySign extends JFrame{
	public MySign() {
		super("簽名");
		
		setLayout(new BorderLayout());
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MySign();
	}

}
