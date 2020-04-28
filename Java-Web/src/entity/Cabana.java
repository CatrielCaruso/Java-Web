package entity;

public class Cabana {
	
	private int IdCabana;
	private Double PrecioDia;
	private String Televisor;
	private String Calefaccion;
	private String WiFi;
	private String Cochera;
	private String Lavarropa;
	private String Heladera;
	private String Cocina;
	private String Asador;
	private String Capacidad;
	private String Lugar;
	private String Direccion;
	public Cabana() {
		super();
	}
	public Cabana(int idCabana, Double precioDia, String televisor, String calefaccion, String wiFi, String cochera,
			String lavarropa, String heladera, String cocina, String asador, String capacidad, String lugar,
			String direccion) {
		super();
		IdCabana = idCabana;
		PrecioDia = precioDia;
		Televisor = televisor;
		Calefaccion = calefaccion;
		WiFi = wiFi;
		Cochera = cochera;
		Lavarropa = lavarropa;
		Heladera = heladera;
		Cocina = cocina;
		Asador = asador;
		Capacidad = capacidad;
		Lugar = lugar;
		Direccion = direccion;
	}
	public int getIdCabana() {
		return IdCabana;
	}
	public void setIdCabana(int idCabana) {
		IdCabana = idCabana;
	}
	public Double getPrecioDia() {
		return PrecioDia;
	}
	public void setPrecioDia(Double precioDia) {
		PrecioDia = precioDia;
	}
	public String getTelevisor() {
		return Televisor;
	}
	public void setTelevisor(String televisor) {
		Televisor = televisor;
	}
	public String getCalefaccion() {
		return Calefaccion;
	}
	public void setCalefaccion(String calefaccion) {
		Calefaccion = calefaccion;
	}
	public String getWiFi() {
		return WiFi;
	}
	public void setWiFi(String wiFi) {
		WiFi = wiFi;
	}
	public String getCochera() {
		return Cochera;
	}
	public void setCochera(String cochera) {
		Cochera = cochera;
	}
	public String getLavarropa() {
		return Lavarropa;
	}
	public void setLavarropa(String lavarropa) {
		Lavarropa = lavarropa;
	}
	public String getHeladera() {
		return Heladera;
	}
	public void setHeladera(String heladera) {
		Heladera = heladera;
	}
	public String getCocina() {
		return Cocina;
	}
	public void setCocina(String cocina) {
		Cocina = cocina;
	}
	public String getAsador() {
		return Asador;
	}
	public void setAsador(String asador) {
		Asador = asador;
	}
	public String getCapacidad() {
		return Capacidad;
	}
	public void setCapacidad(String capacidad) {
		Capacidad = capacidad;
	}
	public String getLugar() {
		return Lugar;
	}
	public void setLugar(String lugar) {
		Lugar = lugar;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}


}
