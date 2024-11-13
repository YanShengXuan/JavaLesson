package tw.rocky.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MyDrawerText extends JPanel{
	public MyDrawerText() {
		setBackground(Color.BLUE);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(Color.RED);
	}
}
