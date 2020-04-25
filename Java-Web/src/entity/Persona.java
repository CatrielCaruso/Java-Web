package entity;

public class Persona {
	private int IdPersona;
	private String Dni;
	private String Apellido;
	private String Nombre;
	private String Email;
	private String Telefono;
	private String Usuario;
	private String Contrasena;
	private String Rol;
	
	public Persona() {
		super();
	}
	public Persona(int idPersona, String dni, String apellido, String nombre, String email, String telefono,
			String usuario, String contrasena, String rol) {
		super();
		IdPersona = idPersona;
		Dni = dni;
		Apellido = apellido;
		Nombre = nombre;
		Email = email;
		Telefono = telefono;
		Usuario = usuario;
		Contrasena = contrasena;
		Rol = rol;
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
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
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
	public String getRol() {
		return Rol;
	}
	public void setRol(String rol) {
		Rol = rol;
	}
	
	
}