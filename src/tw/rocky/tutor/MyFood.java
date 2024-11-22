package tw.rocky.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.rocky.apis.FoodTable;

public class MyFood extends JFrame {
	private FoodTable foodTable;
	public MyFood(){
		
		setLayout(new BorderLayout());
		foodTable = new FoodTable();
		add(foodTable, BorderLayout.CENTER);
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFood();

	}

}
