package tw.rocky.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tw.rocky.apis.MyDrawer2;

public class MySign extends JFrame{
	private MyDrawer2 myDrawer;
	private JButton clear, undo, redo, color, save, saveObj, loadObj;
	
	public MySign() {
		super("簽名");
		
		setLayout(new BorderLayout());
		myDrawer = new MyDrawer2();
		add(myDrawer, BorderLayout.CENTER);
		
		clear = new JButton("清除");
		undo = new JButton("上一步");
		redo = new JButton("下一步");
		color = new JButton("更換顏色");
		save = new JButton("存檔");
		saveObj = new JButton("儲存紀錄");
		loadObj = new JButton("讀取紀錄");
		
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear);
		top.add(undo);
		top.add(redo);
		top.add(color);
		top.add(save);
		top.add(saveObj);
		top.add(loadObj);
		add(top, BorderLayout.NORTH);
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initEvent();
	}
	
	private void initEvent() {
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDrawer.clear();
				
			}
		});
		
		undo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDrawer.undo();
			}
		});
		
		redo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDrawer.redo();
				
			}
		});
		
		color.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changeColor();
			}
		});
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveName();
			}
		});
		
		saveObj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveObject();
			}
		});
		
		loadObj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadObject();
			}
		});
		
	}
	
	private void changeColor() {
		Color newColor = JColorChooser.showDialog(this, "顏色", myDrawer.getColor());
		if(newColor != null) {
			myDrawer.setColor(newColor);
		}
	}
	
	private void saveName() {
		JFileChooser jfc = new JFileChooser();
		if(jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File saveFile = jfc.getSelectedFile();
			try {
				myDrawer.save(saveFile);
				JOptionPane.showMessageDialog(this, "存檔成功");
			}catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "存檔失敗");
			}
		}
	}
	
	private void saveObject() {
		try {
			myDrawer.saveLines(new File("dir2/lines.ok"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void loadObject() {
		try {
			myDrawer.loadLines(new File("dir2/lines.ok"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MySign();
	}

}
