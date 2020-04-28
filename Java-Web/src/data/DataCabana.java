package data;
import java.sql.*;

import entity.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

}
