package tw.rocky.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.rocky.apis.GamePanel2;

public class MyGame2 extends JFrame {
	private GamePanel2 gp;
	
	public MyGame2() throws Exception {
		setLayout(new BorderLayout());
		
		gp = new GamePanel2();
		add(gp, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new MyGame2();
	}

}
