package controlers;

import data.DataCabana;

import entity.Cabana;


public class CtrlABMCabana {
	
	private DataCabana dataPer = new DataCabana();
	
	public CtrlABMCabana() {
		dataPer = new DataCabana();
	}
	
	public Cabana getById(int id) {
		return dataPer.getById(id);
	}
}
