package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Clet;

public class PrikazLetova extends AbstractTableModel{
	
	private List<Clet> letovi = null;
	private String[] kolone = {"Dolazni aerodrom", "Vreme", "Trajanje"};

	public PrikazLetova(List<Clet> letovi) {
		super();
		this.letovi = letovi;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return letovi.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Clet let = letovi.get(rowIndex);
		switch(columnIndex) {
		case 0: return let.getCaerodrom2().getNaziv();
		case 1: return let.getVreme();
		case 2: return let.getTrajanje();
		}
		return null;
	}
	
	public String getColumnName(int i) {
		return kolone[i];
	}

}
