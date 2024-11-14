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

public class MyDrawer2 extends JPanel{
	// 單點 ==> 線 ==> 多線
	private LinkedList<Line> lines, recycle;
	private Color nowColor;
	
	public MyDrawer2() {
		setBackground(Color.PINK);
		MyListener listener = new MyListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		lines = new LinkedList<Line>();
		recycle = new LinkedList<Line>();
		nowColor = Color.RED;
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		for(Line line : lines) {
			g2d.setColor(line.getColor());
			g2d.setStroke(new BasicStroke(line.getWidth()));
			
			for(int i = 1; i < line.getSize(); i++) {
				Point p0 = line.getPoint(i-1);
				Point p1 = line.getPoint(i);
				g2d.drawLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
			}
		}
	}
	
	private class MyListener extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
//			System.out.println(String.format("Press: %d %d", e.getX(), e.getY()));
			recycle.clear();
			Line line = new Line(nowColor, 4);
			Point point = new Point(e.getX(), e.getY());
			line.addPoint(point);
			lines.add(line);
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
//			System.out.println(String.format("Drag: %d %d", e.getX(), e.getY()));
			Point point = new Point(e.getX(), e.getY());
			lines.getLast().addPoint(point);
			
			
			repaint();
		}
	}
	public void clear() {
		lines.clear();
		repaint();
	}
	
	public void undo() {
		if(lines.size() > 0) {
		recycle.add(lines.removeLast());
		repaint();
		}
	}
	
	public void redo() {
		if(recycle.size() > 0) {
		lines.add(recycle.removeLast());
		repaint();
		}
	}
	
	public void setColor(Color newColor) {
		nowColor = newColor;
	}
	
	public Color getColor() {
		return nowColor;
	}
}

