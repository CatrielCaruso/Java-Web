package controlers;


import data.DataReserva;
import entity.Reserva;

public class CtrlABMReserva {
	
	
	

	
	
	private DataReserva dr = new DataReserva();
	
	
	public CtrlABMReserva() {
		dr = new DataReserva();
	}
	
		
	public boolean estaDisponible(Reserva r) {
		return dr.estaDisponible(r);
	}
	


	public void add(Reserva r) {
		dr.add(r);;
	}
    
    
}
