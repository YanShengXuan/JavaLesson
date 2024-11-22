package tw.rocky.apis;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FoodTable extends JTable{
	private FoodModel model;
	
	public FoodTable() {
		model = new FoodModel();
		setModel(model);
	}
	
	private class FoodModel extends DefaultTableModel{

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return 6;
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 10;
		}

		@Override
		public Object getValueAt(int row, int column) {
			// TODO Auto-generated method stub
			return String.format("%s : %d :%d", "Rocky", row,  column);
		}
		
	}
}
