package data;

import java.sql.*;

import entity.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DataPersona {

	public void add(Persona p) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into persona(Dni,Apellido, Nombre, Email, Telefono, Usuario,Contrasena,Rol) values (?,?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getApellido());
			stmt.setString(3, p.getNombre());
			stmt.setString(4, p.getEmail());
			stmt.setString(5, p.getTelefono());
			stmt.setString(6, p.getUsuario());
			stmt.setString(7, p.getContrasena());
			stmt.setString(8, p.getRol());

			stmt.executeUpdate();
			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {
				p.setIdPersona(keyResultSet.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (keyResultSet != null)
				keyResultSet.close();
			if (stmt != null)
				stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Persona validarUsuario(String user, String pass) {
		Persona p = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select p.IdPersona,p.Dni,p.Apellido,p.Nombre,p.Email,p.Telefono,p.Rol from persona p where p.Usuario=? and p.Contrasena=?");
			stmt.setString(1, user);
			stmt.setString(2, pass);

			rs = stmt.executeQuery();

			if (rs != null && rs.next()) {
				p = new Persona();

				p.setIdPersona(rs.getInt("IdPersona"));
				p.setDni(rs.getString("Dni"));
				p.setApellido(rs.getString("Apellido"));
				p.setNombre(rs.getString("Nombre"));
				p.setEmail(rs.getString("Email"));
				p.setTelefono(rs.getString("Telefono"));
				p.setRol(rs.getString("Rol"));
				p.setUsuario(user);
				p.setContrasena(pass);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	public ArrayList<Persona> getAll() {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Persona> pers = new ArrayList<Persona>();
		try {
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from persona");
			if (rs != null) {
				while (rs.next()) {
					Persona p = new Persona();
					p.setIdPersona(rs.getInt("IdPersona"));
					p.setDni(rs.getString("Dni"));
					p.setNombre(rs.getString("Nombre"));
					p.setApellido(rs.getString("Apellido"));
					p.setEmail(rs.getString("Email"));
					p.setTelefono(rs.getString("Telefono"));
					p.setContrasena(rs.getString("Contrasena"));
					p.setUsuario(rs.getString("Usuario"));
					p.setRol(rs.getString("Rol"));
					pers.add(p);
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return pers;

	}

	public Persona getById(int id) {
		Persona p = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select * from persona  where IdPersona=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				p = new Persona();

				p.setIdPersona(rs.getInt("IdPersona"));
				p.setDni(rs.getString("Dni"));
				p.setNombre(rs.getString("Nombre"));
				p.setApellido(rs.getString("Apellido"));
				p.setEmail(rs.getString("Email"));
				p.setTelefono(rs.getString("Telefono"));
				p.setContrasena(rs.getString("Contrasena"));
				p.setUsuario(rs.getString("Usuario"));
			}
			p.setRol(rs.getString("Rol"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	public void borrar(Persona p) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("DELETE FROM persona where IdPersona=?",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, p.getIdPersona());
			stmt.executeUpdate();
			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {
				p.setIdPersona(keyResultSet.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (keyResultSet != null)
				keyResultSet.close();
			if (stmt != null)
				stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actualizar(Persona p) {
		PreparedStatement stmt = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"UPDATE  persona SET Dni=?,Apellido=?,Nombre=?,Email=?,Telefono=?,Usuario=?,Contrasena=?,Rol=? where IdPersona=? ",
					PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getApellido());
			stmt.setString(3, p.getNombre());
			stmt.setString(4, p.getEmail());
			stmt.setString(5, p.getTelefono());
			stmt.setString(6, p.getUsuario());
			stmt.setString(7, p.getContrasena());
			stmt.setString(8, p.getRol());
			stmt.setInt(9, p.getIdPersona());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	
	public ArrayList<Persona> Nombre(String nombre) {
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		ArrayList<Persona> pers = new ArrayList<Persona>();
		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select * from persona where Apellido=?");
			
			stmt.setString(1, nombre);
			rs = stmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Persona p = new Persona();
					p.setIdPersona(rs.getInt("IdPersona"));
					p.setDni(rs.getString("Dni"));
					p.setNombre(rs.getString("Nombre"));
					p.setApellido(rs.getString("Apellido"));
					p.setEmail(rs.getString("Email"));
					p.setTelefono(rs.getString("Telefono"));
					p.setContrasena(rs.getString("Contrasena"));
					p.setUsuario(rs.getString("Usuario"));
					p.setRol(rs.getString("Rol"));
					pers.add(p);
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return pers;

	}
	
	
	
}