package tw.rocky.tutor;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Rocky28 extends JFrame{
	private JButton b1, b2, b3;
	private int counter;
	
	public Rocky28() {
		b1 = new JButton("B1");
		b2 = new JButton("B2");
		b3 = new JButton("B3");
			
		setLayout(new FlowLayout());
		add(b1); add(b2); add(b3);
			
		setVisible(true);
		setSize(640, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initEvent();
	}
	
	private void initEvent() {
//		MyListener2 listener = new MyListener2(this);
//		b1.addActionListener(listener);
//		b2.addActionListener(listener);
//		b3.addActionListener(listener);
		
		b1.addActionListener(null);
	}
	
	public JButton getB1() {
		return b1;
	}
	
	public JButton getB2() {
		return b2;
	}
	
	public JButton getB3() {
		return b3;
	}
	
	public void addCounter(int n) {
		counter += n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Rocky28();
	}
	
class MyListener2 implements ActionListener{
	private Rocky28 Rocky28;
	public MyListener2(Rocky28 Rocky28) {
		// TODO Auto-generated constructor stub
		this.Rocky28 = Rocky28;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(e.getActionCommand());
		if(e.getSource() == Rocky28.getB1()) {
			System.out.println("B1");
			Rocky28.addCounter(1);
		}else if(e.getSource() == Rocky28.getB2()) {
			System.out.println("B2");
			Rocky28.addCounter(2);
		}else if(e.getSource() == Rocky28.getB3()) {
			System.out.println("B3");
			Rocky28.addCounter(3);
		}
	}
}

}
