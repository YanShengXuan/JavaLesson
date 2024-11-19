package tw.rocky.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel2 extends JPanel{
	private Timer timer;
	private BufferedImage[] ballImages;
	private int viewW, viewH;
	private LinkedList<BallTask> balls;
	
	public GamePanel2() throws Exception{
		setBackground(Color.yellow);
		timer = new Timer();
		timer.schedule(new RefreshTask(), 0, 16);
		ballImages = new BufferedImage[]{
				ImageIO.read(new File("dir2/ball0.png")),
				ImageIO.read(new File("dir2/ball1.png")),
				ImageIO.read(new File("dir2/ball2.png")),
				ImageIO.read(new File("dir2/ball3.png"))
		}; 
		balls = new LinkedList<GamePanel2.BallTask>();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BallTask ball = new BallTask(e.getX(), e.getY());
				balls.add(ball);
				timer.schedule(ball, 500, 10);
			}
		});
	}
	
	private class RefreshTask extends TimerTask{
		@Override
		public void run() {
			repaint();
		}
	}
	
	private class BallTask extends TimerTask{
		private int x, y, dx, dy;
		private int img;
		private int w, h;
		
		public BallTask(int x, int y) {
			dx = (int)(Math.random() * 30) - 26;
			dy = (int)(Math.random() * 30) - 26;
			img = (int)(Math.random() * ballImages.length);
			w = ballImages[img].getWidth();
			h = ballImages[img].getHeight();
			this.x = x - (int)(w / 2.0);
			this.y = y - (int)(h / 2.0);
		}
		
		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getImg() {
			return img;
		}


		@Override
		public void run() {
			// TODO Auto-generated method stub
			x += dx;
			y += dy;
			if(x < 0 || x +  w > viewW) {
				dx *= -1;
			}
			if(y < 0 || y + h > viewH) {
				dy *= -1;
			}
		}
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		viewW = getWidth();
		viewH = getHeight(); 
		for(BallTask ball : balls) {
			g.drawImage(ballImages[ball.getImg()], ball.getX(), ball.getY(), null);
		}
	}
}
