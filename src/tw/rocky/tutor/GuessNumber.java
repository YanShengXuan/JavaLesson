package tw.rocky.tutor;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumber extends JFrame implements ActionListener{
	private JButton guess;
	private JTextField input;
	private JTextArea log;
	private String answer;
	private int counter;
	private int d;
	
	public GuessNumber() {
		super("猜數字");
		
		setLayout(new BorderLayout(4, 4));
		guess = new JButton("猜");
		input = new JTextField();
		log = new JTextArea();
		
		input.setFont(new Font(null, Font.BOLD | Font.ITALIC, 24));
		log.setFont(new Font(null, Font.BOLD, 24));
		
		JPanel top = new JPanel(new BorderLayout(4, 4));
		top.add(guess, BorderLayout.EAST);
		top.add(input, BorderLayout.CENTER);
		add(top, BorderLayout.NORTH);
		add(log, BorderLayout.CENTER);		
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		guess.addActionListener(this);
		
		initGame();
	}
	
	private String createAnswer() {
		final int nums = 10;
		int[] numbers = new int[nums];
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}
		
		for(int i = numbers.length - 1; i > 0; i--) {
			int rand = (int)(Math.random() * (i+1));
			int temp = numbers[rand];
			numbers[rand] = numbers[i];
			numbers[i] = temp;
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < d; i++) {
			sb.append(numbers[i]);
		}
		return sb.toString();
	}
	
	private void initGame() {
		d = 4;
		answer = createAnswer();
		counter = 0;
		log.setText(" ");
		System.out.println(answer);
	}

	private String checkAB(String g) {
		int countA = 0, countB = 0;
		
		for(int i = 0; i < answer.length(); i++) {
			if(answer.charAt(i) == g.charAt(i)) {
				countA++;
				continue;
			}else if(answer.indexOf(g.charAt(i)) != -1) {
				countB++;
				continue;
			}
		}
		
		return String.format("%dA%dB", countA, countB);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GuessNumber();
	}
	
	@Override //按鍵觸發
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		counter++;
		String strInupt = input.getText();
		String result = checkAB(strInupt);
		log.append(String.format("%d.%s => %s\n", counter, strInupt, result));
		input.setText("");
		
		if(result.equals(String.format("%dA0B", d))) {
			JOptionPane.showMessageDialog(this, "通關");
			initGame();
		}else if(counter >= 10) {
			JOptionPane.showMessageDialog(this, "未通關，答案是" + answer);
			initGame();
		}
		
	}
}




class myListener implements ActionListener{
	@Override //按鍵觸發
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
	}
}
