package tw.rocky.tutor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tw.rocky.apis.FoodTable;

public class MyFood extends JFrame {
	private FoodTable foodTable;
	private JButton del;
	public MyFood(){
		
		setLayout(new BorderLayout());
		foodTable = new FoodTable();
		JScrollPane jsp = new JScrollPane(foodTable);
		add(jsp, BorderLayout.CENTER);
		
		JPanel top = new JPanel(new FlowLayout());
		del = new JButton("Delete");
		top.add(del);
		add(top, BorderLayout.NORTH);
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initEven();
	}
	
	private void initEven(){
		del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				foodTable.delRow();
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFood();

	}
}

