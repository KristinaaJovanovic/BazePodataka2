package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Knjiga;

public class TableModelKnjige extends AbstractTableModel {
	
	private String[] kolone= {"Naziv", "Autor"};
	private List<Knjiga> knjige=null;
	
	public TableModelKnjige(List<Knjiga> knjige) {
		this.knjige=knjige;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return knjige.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Knjiga k=knjige.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return k.getKnjigaNaziv();
		case 1:
			return k.getAutor();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return kolone[column];
	}

}
