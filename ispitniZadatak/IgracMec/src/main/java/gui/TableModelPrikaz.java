package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Mec;

public class TableModelPrikaz extends AbstractTableModel {
	
	private String[] kolone= {"Igrac", "Datum", "Rezultat"};
	private List<Mec> lista=null;
	
	public TableModelPrikaz(List<Mec> lista) {
		this.lista=lista;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Mec m=lista.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return m.getIgrac1().getIgracIme();
		case 1:
			return m.getDatum();
		case 2:
			return m.getRezultat();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return kolone[column];
	}

}
