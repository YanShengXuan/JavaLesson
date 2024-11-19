package tw.rocky.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.rocky.apis.GamePanel;

public class MyGame extends JFrame {
	private GamePanel gp;
	
	public MyGame() {
		setLayout(new BorderLayout());
		
		gp = new GamePanel();
		add(gp, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyGame();
	}

}
