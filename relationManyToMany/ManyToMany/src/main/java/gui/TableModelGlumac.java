package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Glumac;

public class TableModelGlumac extends AbstractTableModel {
	
	private String[] kolone= {"ime", "prezime", "godinaRodjenja"};
	private List<Glumac> glumci;
	
	

	public TableModelGlumac(List<Glumac> glumci) {
		super();
		this.glumci = glumci;
	}

	@Override
	public int getRowCount() {
		return this.glumci.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Glumac g=glumci.get(rowIndex);
		
		switch(columnIndex) {
		case 0:
			return g.getIme();
		case 1:
			return g.getPrezime();
		case 2:
			return g.getGodinaRodjenja();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return kolone[column];
	}

}
