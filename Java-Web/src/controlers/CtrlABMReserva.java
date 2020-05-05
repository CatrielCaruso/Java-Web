package controlers;

import java.util.ArrayList;

import data.DataPersona;
import data.DataReserva;
import entity.Persona;
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
		dr.add(r);
		;
	}

	public ArrayList<Reserva> reservasDePer(Persona logged) {
		return dr.getReservasdePer(logged);

	}

	public Reserva getById(int id) {
		return dr.getById(id);
	}

	public void delete(Reserva r) {
		dr.borrar(r);
	}

	public ArrayList<Reserva> getAll(){
		return dr.getAll();}
	
	
	
	public void update(Reserva newp) {

		dr.actualizar(newp);
	}
	
	public ArrayList<Reserva> Nombre(String nombre) {
		dr = new DataReserva();
		return dr.Nombre(nombre);
	}
	
}
