package data;

import java.sql.*;

import entity.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataPersona {

	public void add(Persona p) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into persona(Dni, Nombre, Telefono, Estado, Usuario,Contrasena) values (?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getTelefono());
			stmt.setString(4, p.getEstado());
			stmt.setString(5, p.getUsuario());
			stmt.setString(6, p.getContrasena());

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

}