package tw.rocky.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JPanel;

public class MyDrawer extends JPanel{
	// 單點 ==> 線 ==> 多線
	private LinkedList<LinkedList<HashMap<String , Integer>>> lines;
	
	public MyDrawer() {
		setBackground(Color.PINK);
		MyListener listener = new MyListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		lines = new LinkedList<LinkedList<HashMap<String,Integer>>>();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setStroke(new BasicStroke(4));
		g2d.setColor(Color.RED);
		
		for(LinkedList<HashMap<String,Integer>> line : lines) {
			for(int i = 1; i < line.size(); i++) {
				HashMap<String, Integer> p0 = line.get(i-1);
				HashMap<String, Integer> p1 = line.get(i);
				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
			}
		}
	}
	
	private class MyListener extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
//			System.out.println(String.format("Press: %d %d", e.getX(), e.getY()));
			HashMap<String, Integer> point = new HashMap<String, Integer>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			LinkedList<HashMap<String,Integer>> line = new LinkedList<HashMap<String,Integer>>();
			line.add(point);
			lines.add(line);
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
//			System.out.println(String.format("Drag: %d %d", e.getX(), e.getY()));
			HashMap<String, Integer> point = new HashMap<String, Integer>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			lines.getLast().add(point);
			
			repaint();
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println(String.format("Releas: %d %d", e.getX(), e.getY()));
		}
	}
	
}

