package tw.rocky.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	private int x, y;
	private Timer timer;
	private BufferedImage ball;
	private int w, h, dx, dy;
	
	public GamePanel() {
		try {
			ball =  ImageIO.read(new File("dir2/ball0.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		setBackground(Color.yellow);
		x = y = 0;
		dx = dy = 4;
		timer = new Timer();
		timer.schedule(new BallTask(), 1 * 1000,  2);
		
	}
	
	private class BallTask extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			if(x < 0 || x + ball.getWidth() > w) {
				dx *= -1;
			}
			if(y < 0 || y + ball.getHeight() > h) {
				dy *= -1;
			}
			x += dx;
			y += dy;
			repaint();
		}
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		w = getWidth();
		h = getHeight(); 
		g.drawImage(ball, x, y, null);
		
	}
}