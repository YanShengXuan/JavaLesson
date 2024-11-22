package tw.rocky.apis;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FoodTable extends JTable{
	private FoodModel model;
	private FoodDB db;
	
	public FoodTable() {
		try {
			db = new FoodDB();
			db.query();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		model = new FoodModel();
		setModel(model);
		model.setColumnIdentifiers(db.getFieldName());
	}
	
	public void delRow() {
		// TODO Auto-generated method stub
		db.delData(getSelectedRow());
		repaint();
	}
	
	private class FoodModel extends DefaultTableModel{

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return db.getRows();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return db.getCols();
		}

		@Override
		public Object getValueAt(int row, int column) {
			// TODO Auto-generated method stub
			return db.getDate(row, column);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			// TODO Auto-generated method stub
			return column != 0;
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			// TODO Auto-generated method stub
			db.updateData((String)aValue, row, column);
		}
	}
}
