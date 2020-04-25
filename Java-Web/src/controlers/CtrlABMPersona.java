package controlers;

import entity.Persona;

import java.util.ArrayList;

import data.DataPersona;

public class CtrlABMPersona {

	private DataPersona dataPer = new DataPersona();

	public CtrlABMPersona() {
		dataPer = new DataPersona();
	}

	public void add(Persona p) {

		dataPer.add(p);
	}

	public Persona loguearUsuario(String user,String pass) {
		return dataPer.validarUsuario(user,pass);
	}

	public ArrayList<Persona> getAll() {
		dataPer = new DataPersona();
		return dataPer.getAll();
	}

	public void delete(Persona p) {
		dataPer.borrar(p);
	}

	public Persona getById(int id) {
		return dataPer.getById(id);
	}

	public void update(Persona newp) {

		dataPer.actualizar(newp);
	}

}