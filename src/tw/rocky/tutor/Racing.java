package tw.rocky.tutor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Racing extends JFrame {
	private JButton go;
	private JLabel[] lanes;
	private Car[] cars;
	private int rank;
	
	public Racing() {
		setLayout(new GridLayout(9, 1));
		go = new JButton("GO");
		add(go);
		
		lanes = new JLabel[8];
		for(int i = 0; i < lanes.length;i++) {
			lanes[i] = new JLabel(String.format("%d", (i+1)));
			add(lanes[i]);
		}
		
		setSize(800,  480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initEvant();
	}
	
	private void initEvant() {
		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				go();
				
			}
		});
	}
	
	private void go() {
		go.setEnabled(false);
		for(int i = 0; i < lanes.length; i++) {
			lanes[i].setText("");
		}
		
		cars = new Car[8];
		for(int i = 0; i < cars.length; i++) {
			cars[i] = new Car(i);
			cars[i].start();
		}
	}
	
	private class Car extends Thread{
		
		private int lane;
		private StringBuffer sb;
		Car(int lane) {
			// TODO Auto-generated constructor stub
			this.lane = lane;
			sb = new StringBuffer((lane + 1) + ".");
		}
		@Override
		public void run() {
			for(int i = 0; i < 100; i++) {
				if(i == 99) {
//					sb.append(">" + ++rank);
					sb.append("> winer");
					stopGame();
				}else {
					sb.append(">");
				}
				lanes[lane].setText(sb.toString());
				try {
					Thread.sleep(10 + (int)(Math.random() * 100));
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}
	
	private void stopGame() {
		for(int i = 0; i < cars.length; i++) {
			cars[i].interrupt();
		}
		go.setEnabled(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Racing();
	}

}
