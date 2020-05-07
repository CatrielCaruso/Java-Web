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

	public void add(Reserva r) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into reserva ( FechaDesde, FechaHasta,IdPersona,IdCabana,CantidadDias,PrecioTotal) values (?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			// stmt.setTimestamp(1, new java.sql.Timestamp(r.getFecha_hora().getTime()));

			stmt.setTimestamp(1, new java.sql.Timestamp(r.getFechaDesde().getTime()));
			stmt.setTimestamp(2, new java.sql.Timestamp(r.getFechaHasta().getTime()));
			stmt.setInt(3, r.getPer().getIdPersona());
			stmt.setInt(4, r.getCaba().getIdCabana());
			stmt.setInt(5, r.getCantidadDias());
			stmt.setDouble(6, r.getPrecioTotal());
			stmt.executeUpdate();
			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {
				r.setIdReserva(keyResultSet.getInt(1));
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

	public boolean estaDisponible(Reserva r) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date date = new Date();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean i = true;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from reserva r  where r.IdCabana=? AND r.FechaDesde >= ? AND r.FechaHasta <= ? ");

			stmt.setInt(1, r.getCaba().getIdCabana());
			stmt.setString(2, dateFormat.format(r.getFechaDesde().getTime()));
			stmt.setString(3, dateFormat.format(r.getFechaHasta().getTime()));
			
			
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				i = false;
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
		return (i);
	}

	public ArrayList<Reserva> getReservasdePer(Persona per) { // OBTENER RESERVAS POR PERSONA

		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select r.IdReserva,r.FechaDesde,r.FechaHasta,r.IdPersona,r.IdCabana,r.CantidadDias,r.PrecioTotal,c.Lugar from reserva r "
							+ "inner join cabana c on r.IdCabana=c.IdCabana where  r.IdPersona=?",
					PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, per.getIdPersona());

			rs = stmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Reserva r = new Reserva();
					Cabana c = new Cabana();
					c.setLugar(rs.getString("c.Lugar"));
					r.setIdReserva(rs.getInt("r.IdReserva"));
					r.setFechaDesde(rs.getTimestamp("r.FechaDesde"));
					r.setFechaHasta(rs.getTimestamp("r.FechaHasta"));

					r.setPer(per);
					c.setIdCabana(rs.getInt("r.IdCabana"));

					r.setCantidadDias(rs.getInt("r.CantidadDias"));
					r.setPrecioTotal(rs.getDouble("r.PrecioTotal"));

					r.setCaba(c);

					reservas.add(r);
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
		return reservas;
	}

	public Reserva getById(int id) {
		Reserva r = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select * from Reserva  where IdReserva=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				r = new Reserva();
				Cabana c = new Cabana();
				Persona p = new Persona();
				r.setIdReserva(rs.getInt("IdReserva"));
				r.setFechaDesde(rs.getDate("FechaDesde"));
				r.setFechaHasta(rs.getDate("FechaHasta"));
				c.setIdCabana(rs.getInt("IdCabana"));
				p.setIdPersona(rs.getInt("IdPersona"));
				// r.getCaba().setIdCabana(rs.getInt("IdCabana"));
				// r.getPer().setIdPersona(rs.getInt("IdPersona"));
				r.setCantidadDias(rs.getInt("CantidadDias"));
				r.setPrecioTotal(rs.getDouble("PrecioTotal"));
				r.setCaba(c);
				r.setPer(p);

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

		return r;
	}

	public void borrar(Reserva r) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("DELETE FROM reserva where IdReserva=?",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, r.getIdReserva());
			stmt.executeUpdate();
			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {
				r.setIdReserva(keyResultSet.getInt(1));
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

	
	
	
	
	
	public ArrayList<Reserva> getAll(){
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//java.util.Date date = new Date();
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Reserva> reservas= new ArrayList<Reserva>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select r.IdReserva,r.FechaDesde,r.FechaHasta,r.IdPersona,r.IdCabana,r.CantidadDias,r.PrecioTotal,c.Lugar,p.Nombre,p.Apellido from reserva r "
					+ "inner join cabana c on r.IdCabana=c.IdCabana " + " inner join persona p on r.IdPersona=p.IdPersona");
			if(rs!=null){
				while(rs.next()){
					Reserva r = new Reserva();
					Cabana c = new Cabana();
					Persona p = new Persona();
					c.setLugar(rs.getString("c.Lugar"));
					r.setIdReserva(rs.getInt("r.IdReserva"));
					r.setFechaDesde(rs.getTimestamp("r.FechaDesde"));
					r.setFechaHasta(rs.getTimestamp("r.FechaHasta"));

					p.setIdPersona(rs.getInt("r.IdPersona"));
					c.setIdCabana(rs.getInt("r.IdCabana"));

					r.setCantidadDias(rs.getInt("r.CantidadDias"));
					r.setPrecioTotal(rs.getDouble("r.PrecioTotal"));
					p.setNombre(rs.getString("p.Nombre"));
                    p.setApellido(rs.getString("p.Apellido"));
					r.setPer(p);
					r.setCaba(c);

					reservas.add(r);
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
		return reservas;	
	}
	
	
	
	
	
	public void actualizar(Reserva p) {
		PreparedStatement stmt = null;
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"UPDATE  reserva SET FechaDesde=?,FechaHasta=?, CantidadDias=?,PrecioTotal=? where IdReserva=? ",
					PreparedStatement.RETURN_GENERATED_KEYS);

			
			stmt.setTimestamp(1, new java.sql.Timestamp(p.getFechaDesde().getTime()));
			stmt.setTimestamp(2, new java.sql.Timestamp(p.getFechaHasta().getTime()));
			
			stmt.setInt(3, p.getCantidadDias());
			stmt.setDouble(4, p.getPrecioTotal());
			stmt.setInt(5, p.getIdReserva());
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
	
	
	
	
public ArrayList<Reserva> Nombre(String nombre) {
		
	PreparedStatement stmt = null;
	ResultSet rs=null;
	ArrayList<Reserva> reservas= new ArrayList<Reserva>();
	try {
		stmt = FactoryConexion.getInstancia()
				.getConn().prepareStatement("select r.IdReserva,r.FechaDesde,r.FechaHasta,r.IdPersona,r.IdCabana,r.CantidadDias,r.PrecioTotal,c.Lugar,p.Nombre,p.Apellido from reserva r "
						+ "inner join cabana c on r.IdCabana=c.IdCabana " + " inner join persona p on r.IdPersona=p.IdPersona where p.Apellido=?");
		 stmt.setString(1, nombre);
		rs = stmt.executeQuery();
		
		if(rs!=null){
			while(rs.next()){
				Reserva r = new Reserva();
				Cabana c = new Cabana();
				Persona p = new Persona();
				c.setLugar(rs.getString("c.Lugar"));
				r.setIdReserva(rs.getInt("r.IdReserva"));
				r.setFechaDesde(rs.getTimestamp("r.FechaDesde"));
				r.setFechaHasta(rs.getTimestamp("r.FechaHasta"));

				p.setIdPersona(rs.getInt("r.IdPersona"));
				c.setIdCabana(rs.getInt("r.IdCabana"));

				r.setCantidadDias(rs.getInt("r.CantidadDias"));
				r.setPrecioTotal(rs.getDouble("r.PrecioTotal"));
				p.setNombre(rs.getString("p.Nombre"));
                p.setApellido(rs.getString("p.Apellido"));
				r.setPer(p);
				r.setCaba(c);

				reservas.add(r);
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
	return reservas;	
	
	
}
	
	


public boolean Disponible(Reserva r) {

	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	java.util.Date date = new Date();
	
	PreparedStatement stmt = null;
	ResultSet rs = null;
	boolean i = true;
	try {
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
				"select * from reserva r  where r.IdCabana=? AND r.FechaDesde >= ? AND r.FechaHasta <= ? and r.IdReserva != ?");

		stmt.setInt(1, r.getCaba().getIdCabana());
		stmt.setString(2, dateFormat.format(r.getFechaDesde().getTime()));
		stmt.setString(3, dateFormat.format(r.getFechaHasta().getTime()));
		stmt.setInt(4, r.getIdReserva());
		
		rs = stmt.executeQuery();
		if (rs != null && rs.next()) {
			i = false;
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
	return (i);
}

	
	
	
	
}
