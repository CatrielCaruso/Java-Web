package data;
import java.sql.*;
import entity.Cabana;
import entity.Reserva;
import entity.Persona;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataReserva {

	
	
	
	
	public void add(Reserva r){
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into reserva ( FechaDesde, FechaHasta,IdPersona,IdCabana) values (?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			//stmt.setTimestamp(1, new java.sql.Timestamp(r.getFecha_hora().getTime()));
 			
 			
			stmt.setTimestamp(1, new java.sql.Timestamp(r.getFechaDesde().getTime()));
			stmt.setTimestamp(2, new java.sql.Timestamp(r.getFechaHasta().getTime()));
			stmt.setInt(2, r.getPer().getIdPersona());
 			stmt.setInt(3, r.getCaba().getIdCabana());
 			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				r.setIdReserva(keyResultSet.getInt(1));
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
	
	
	
	
	
	
	
	
	
	
	public boolean estaDisponible(Reserva r){
	
		
		PreparedStatement stmt= null;
		ResultSet rs=null;
		boolean i=true;
		try{ 
		stmt= FactoryConexion.getInstancia().getConn().prepareStatement( "select * from reserva r  where r.IdCabana=? AND r.FechaDesde >= ? AND r.FechaHasta <= ?   ");
		
		stmt.setInt(1, r.getCaba().getIdCabana());
		stmt.setTimestamp(2, new java.sql.Timestamp(r.getFechaDesde().getTime()));
		stmt.setTimestamp(3, new java.sql.Timestamp(r.getFechaHasta().getTime()));
		
			 rs=stmt.executeQuery();
			 if(rs!=null && rs.next()){
						i=false;
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
			return (i);	
		} 
		 
	

}
