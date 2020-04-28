package entity;
import java.util.*;

public class Reserva {
	
	
	private int IdReserva;
	private Date FechaDesde;
	private Date FechaHasta;
	private Double PrecioTotal;
	
	private Cabana caba;
	private Persona per;
	
	public Reserva() {
		super();
	}

	public Reserva(int idReserva, Date fechaDesde, Date fechaHasta, Double precioTotal, Cabana caba, Persona per) {
		super();
		IdReserva = idReserva;
		FechaDesde = fechaDesde;
		FechaHasta = fechaHasta;
		PrecioTotal = precioTotal;
		this.caba = caba;
		this.per = per;
	}

	public int getIdReserva() {
		return IdReserva;
	}

	public void setIdReserva(int idReserva) {
		IdReserva = idReserva;
	}

	public Date getFechaDesde() {
		return FechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		FechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return FechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		FechaHasta = fechaHasta;
	}

	public Double getPrecioTotal() {
		return PrecioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		PrecioTotal = precioTotal;
	}

	public Cabana getCaba() {
		return caba;
	}

	public void setCaba(Cabana caba) {
		this.caba = caba;
	}

	public Persona getPer() {
		return per;
	}

	public void setPer(Persona per) {
		this.per = per;
	}
	
	

}
