package crud;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Prodaja;

public class TableModelProdaja extends AbstractTableModel {
	
	private String[] kolone= {"Naziv", "Datum", "Kolicina"};
	private List<Prodaja> lista=null;
	
	public TableModelProdaja(List<Prodaja> lista) {
		this.lista=lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Prodaja p=lista.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return p.getProizvod().getNaziv();
		case 1:
			return p.getDatum();
		case 2:
			return p.getKolicina();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

}
