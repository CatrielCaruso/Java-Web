package data;
import java.sql.*;

import entity.*;

import java.util.ArrayList;


public class DataCabana {
	
	
	
	public Cabana getById(int id){
		Cabana p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from cabana  where IdCabana=?");
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				p=new Cabana();
				
				p.setIdCabana(rs.getInt("IdCabana"));
				p.setPrecioDia(rs.getDouble("PrecioDia"));
				p.setTelevisor(rs.getString("Televisor"));
				p.setCalefaccion(rs.getString("Calefaccion"));
				p.setWiFi(rs.getString("WiFi"));
				p.setCochera(rs.getString("Cochera"));
				p.setLavarropa(rs.getString("Lavarropa"));
				p.setHeladera(rs.getString("Heladera"));
				p.setCocina(rs.getString("Cocina"));
				p.setAsador(rs.getString("Asador"));
				p.setCapacidad(rs.getString("Capacidad"));
				p.setLugar(rs.getString("Lugar"));
				p.setDireccion(rs.getString("Direccion"));
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

	
	
	
	public ArrayList<Cabana> getAll() {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Cabana> cab = new ArrayList<Cabana>();
		try {
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from cabana");
			if (rs != null) {
				while (rs.next()) {
					Cabana c = new Cabana();
					c.setIdCabana(rs.getInt("IdCabana"));
					c.setPrecioDia(rs.getDouble("PrecioDia"));
					c.setTelevisor(rs.getString("Televisor"));
					c.setCalefaccion(rs.getString("Calefaccion"));
					c.setWiFi(rs.getString("WiFi"));
					c.setCochera(rs.getString("Cochera"));
					c.setLavarropa(rs.getString("Lavarropa"));
					c.setHeladera(rs.getString("Heladera"));
					c.setCocina(rs.getString("Cocina"));
					c.setAsador(rs.getString("Asador"));
					c.setCapacidad(rs.getString("Capacidad"));
					c.setLugar(rs.getString("Lugar"));
					c.setDireccion(rs.getString("Direccion"));
					cab.add(c);
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

		return cab;

	}
	
	
	
	
	
	
	
	
	
}
