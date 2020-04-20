package entity;

public class Persona {
	private int IdPersona;
	private String Dni;
	private String Nombre;
	private String Telefono;
	private String Estado;
	private String Usuario;
	private String Contrasena;

	public Persona() {

	}

	public Persona(int idPersona, String dni, String nombre, String telefono, String estado, String usuario,
			String contrasena) {
		super();
		IdPersona = idPersona;
		Dni = dni;
		Nombre = nombre;
		Telefono = telefono;
		Estado = estado;
		Usuario = usuario;
		Contrasena = contrasena;
	}

	public int getIdPersona() {
		return IdPersona;
	}

	public void setIdPersona(int idPersona) {
		IdPersona = idPersona;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getContrasena() {
		return Contrasena;
	}

	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}

}