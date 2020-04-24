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
					"insert into persona(Dni,Apellido, Nombre, Email, Telefono, Usuario,Contrasena) values (?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getApellido());
			stmt.setString(3, p.getNombre());
			stmt.setString(4, p.getEmail());
			stmt.setString(5, p.getTelefono());
			stmt.setString(6, p.getUsuario());
			stmt.setString(7, p.getContrasena());

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
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select * persona where Usuario=? and Contrasena = ? ");
			stmt.setString(1, user);
			stmt.setString(2, pass);

			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				p = new Persona();

				p.setIdPersona(rs.getInt("id_persona"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setDni(rs.getString("dni"));

				p.setEmail(rs.getString("email"));

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

	
	
	
	public ArrayList<Persona> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Persona> pers= new ArrayList<Persona>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from persona");
			if(rs!=null){
				while(rs.next()){
					Persona p=new Persona();
					p.setIdPersona(rs.getInt("IdPersona"));
					p.setDni(rs.getString("Dni"));
					p.setNombre(rs.getString("Nombre"));
					p.setApellido(rs.getString("Apellido"));
					p.setEmail(rs.getString("Email"));
					p.setTelefono(rs.getString("Telefono"));
					p.setContrasena(rs.getString("Contrasena"));
					p.setUsuario(rs.getString("Usuario"));
		 			pers.add(p);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return pers;
		
	}
	
	public Persona getById(int id){
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from persona  where IdPersona=?");
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				p=new Persona();
				
				p.setIdPersona(rs.getInt("IdPersona"));
				p.setDni(rs.getString("Dni"));
				p.setNombre(rs.getString("Nombre"));
				p.setApellido(rs.getString("Apellido"));
				p.setEmail(rs.getString("Email"));
				p.setTelefono(rs.getString("Telefono"));
				p.setContrasena(rs.getString("Contrasena"));
				p.setUsuario(rs.getString("Usuario"));
	 		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	
	public void borrar(Persona p){
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"DELETE FROM persona where IdPersona=?",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setInt(1,p.getIdPersona());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				p.setIdPersona(keyResultSet.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void actualizar(Persona p){
PreparedStatement stmt= null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"UPDATE  persona SET Dni=?,Apellido=?,Nombre=?,Email=?,Telefono=?,Usuario=?,Contrasena=? where IdPersona=? ",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			
			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getApellido());
			stmt.setString(3, p.getNombre());
			stmt.setString(4, p.getEmail());
			stmt.setString(5, p.getTelefono());
			stmt.setString(6, p.getUsuario());
			stmt.setString(7, p.getContrasena());
			
 		    stmt.setInt(8, p.getIdPersona());
 		    stmt.executeUpdate();
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(stmt!=null)stmt.close();
                FactoryConexion.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
    }
	
	
	
	
}