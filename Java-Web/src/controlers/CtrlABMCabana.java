package controlers;

import java.util.ArrayList;

import data.DataCabana;

import entity.Cabana;
import entity.Reserva;


public class CtrlABMCabana {
	
	private DataCabana dataCaba = new DataCabana();
	
	public CtrlABMCabana() {
		dataCaba = new DataCabana();
	}
	
	public Cabana getById(int id) {
		return dataCaba.getById(id);
	}
	
	
	
	public ArrayList<Cabana> getAll(){
		return dataCaba.getAll();}
	
	
}
