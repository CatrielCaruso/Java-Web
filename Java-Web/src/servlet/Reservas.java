package servlet;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.text.DateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Date;
import controlers.CtrlABMCabana;
import controlers.CtrlABMPersona;
import controlers.CtrlABMReserva;
import entity.Cabana;
import entity.Persona;
import entity.Reserva;

/**
 * Servlet implementation class Reservas
 */
@WebServlet("/Reservas")
public class Reservas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Reservas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		ArrayList<entity.Reserva> res;

		CtrlABMReserva ctrl = new CtrlABMReserva();
		// CtrlABMPersona cp = new CtrlABMPersona();
		entity.Persona per = (Persona) request.getSession().getAttribute("personaLogueada");
		request.getSession().getAttribute("caba");

		if (per.getRol().equals("Administrador")) {

			res = ctrl.getAll();

			request.setAttribute("todasReservas", res);
			request.getRequestDispatcher("HomeAdministrador.jsp").forward(request, response);
		} else {

			res = ctrl.reservasDePer(per);

			request.setAttribute("todasReservas", res);
			request.getRequestDispatcher("MisReservas.jsp").forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		if (request.getParameter("alquilar") != null) {

			entity.Cabana p = new entity.Cabana();
			CtrlABMCabana ctp = new CtrlABMCabana();

			int id = Integer.parseInt(request.getParameter("idcabana"));

			p = ctp.getById(id);

			request.setAttribute("caba", p);

			request.getRequestDispatcher("Reservas.jsp").forward(request, response);

		}

		if (request.getParameter("contacto") != null) {

			request.getRequestDispatcher("Contacto.jsp").forward(request, response);

		}

		if (request.getParameter("prereserva") != null) {

			Reserva r = new Reserva();
			CtrlABMCabana ctp = new CtrlABMCabana();
			CtrlABMReserva rc = new CtrlABMReserva();
			entity.Cabana c = ctp.getById(Integer.parseInt(request.getParameter("idcabana")));
			entity.Persona per = (Persona) request.getSession().getAttribute("personaLogueada");

			// SimpleDateFormat f= new SimpleDateFormat("yyyy/MM/dd");//YYYY-MM-DD HH-MM-SS

			Date fecha_desde = null;

			Date fecha_hasta = null;

			String fechaDesde = request.getParameter("fecha_desde");
			String fechaHasta = request.getParameter("fecha_hasta");

			System.out.println(fechaDesde);

			try {

				DateFormat f = new SimpleDateFormat("yyyy/MM/dd");

				fecha_desde = f.parse(fechaDesde);
				r.setFechaDesde(fecha_desde);

				fecha_hasta = f.parse(fechaHasta);
				r.setFechaHasta(fecha_hasta);

				System.out.println(fecha_desde);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
			}

			System.out.println(fecha_desde);

			r.setCaba(c);
			r.setPer(per);
			// double costo=c.getPrecioDia()*dias;

			// System.out.println(costo);

			int dias = (int) ((fecha_hasta.getTime() - fecha_desde.getTime()) / 86400000);
			r.setCantidadDias(dias);
			double costo = c.getPrecioDia() * dias;
			r.setPrecioTotal(costo);

			System.out.println(dias);
			System.out.println(costo);
			System.out.println(fecha_desde);

			if (rc.estaDisponible(r)) {

				try {
					// System.out.println("reserva creada");
					// rc.add(r);

					request.getSession().setAttribute("caba", c);
					request.getSession().setAttribute("reservahecha", r);
					request.getRequestDispatcher("ConfirmarReserva.jsp").forward(request, response);
				} catch (Exception e2) {
					System.out.println("Aca tira error");
				}
			} else {
				request.getRequestDispatcher("errorAlReservar.jsp").forward(request, response);
			}
		}

		if (request.getParameter("confirmar") != null) {

			Reserva r = new Reserva();
			CtrlABMReserva resCtrl = new CtrlABMReserva();

			r = (Reserva) request.getSession().getAttribute("reservahecha");

			resCtrl.add(r);

			request.getRequestDispatcher("Home.jsp").forward(request, response);

		}

		if (request.getParameter("volver") != null) {

			Reserva r = new Reserva();

			r = (Reserva) request.getSession().getAttribute("reservahecha");

			request.getSession().setAttribute("reservahecha", r);

			request.getRequestDispatcher("Reservas.jsp").forward(request, response);

		}

		if (request.getParameter("listar") != null) {

			this.doGet(request, response);

		}

		if (request.getParameter("borrar") != null) {

			entity.Reserva r = new entity.Reserva();
			CtrlABMReserva ctp = new CtrlABMReserva();

			int id = Integer.parseInt(request.getParameter("borrar"));

			r = ctp.getById(id);
			ctp.delete(r);

			this.doGet(request, response);

		}

		if (request.getParameter("error") != null) {

			Reserva r = new Reserva();

			r = (Reserva) request.getSession().getAttribute("reservahecha");

			request.getSession().setAttribute("reservahecha", r);

			request.getRequestDispatcher("Reservas.jsp").forward(request, response);

		}

		if (request.getParameter("modificar") != null) {

			entity.Reserva r = new entity.Reserva();
			CtrlABMReserva ctp = new CtrlABMReserva();

			int id = Integer.parseInt(request.getParameter("modificar"));

			r = ctp.getById(id);

			request.setAttribute("reserva", r);

			request.getRequestDispatcher("ModificarReserva.jsp").forward(request, response);
		}

		if (request.getParameter("actualizar") != null) {

			entity.Reserva r = new entity.Reserva();
			CtrlABMReserva rc = new CtrlABMReserva();

			int idr = Integer.parseInt(request.getParameter("idreserva"));

			r = rc.getById(idr);

			CtrlABMCabana ctp = new CtrlABMCabana();

			entity.Cabana c = ctp.getById(Integer.parseInt(request.getParameter("idcabana")));

			entity.Persona p = new entity.Persona();
			CtrlABMPersona cp = new CtrlABMPersona();

			int id = Integer.parseInt(request.getParameter("idpersona"));

			p = cp.getById(id);

			Date fecha_desde = null;

			Date fecha_hasta = null;

			String fechaDesde = request.getParameter("fecha_desde");
			String fechaHasta = request.getParameter("fecha_hasta");

			System.out.println(fechaDesde);

			try {

				DateFormat f = new SimpleDateFormat("yyyy/MM/dd");

				fecha_desde = f.parse(fechaDesde);
				r.setFechaDesde(fecha_desde);

				fecha_hasta = f.parse(fechaHasta);
				r.setFechaHasta(fecha_hasta);

				System.out.println(fecha_desde);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
			}

			System.out.println(fecha_desde);

			r.setCaba(c);
			r.setPer(p);
			// double costo=c.getPrecioDia()*dias;

			// System.out.println(costo);

			int dias = (int) ((fecha_hasta.getTime() - fecha_desde.getTime()) / 86400000);
			r.setCantidadDias(dias);
			double costo = c.getPrecioDia() * dias;
			r.setPrecioTotal(costo);

			System.out.println(dias);
			System.out.println(costo);
			System.out.println(fecha_desde);

			if (rc.Disponible(r)) {

				try {
					// System.out.println("reserva creada");
					// rc.add(r);

					// request.getSession().setAttribute("caba", c);
					request.getSession().setAttribute("reservahecha", r);
					request.getRequestDispatcher("ConfirmarModificarReserva.jsp").forward(request, response);
				} catch (Exception e2) {
					System.out.println("Aca tira error");
				}
			} else {
				request.getRequestDispatcher("ErrorAlreservarAdministrador.jsp").forward(request, response);
			}

		}

		if (request.getParameter("actualizareserva") != null) {

			Reserva r = new Reserva();
			CtrlABMReserva resCtrl = new CtrlABMReserva();

			r = (Reserva) request.getSession().getAttribute("reservahecha");

			resCtrl.update(r);

			this.doGet(request, response);

		}

		if (request.getParameter("errorAdministrador") != null) {

			Reserva r = new Reserva();

			r = (Reserva) request.getSession().getAttribute("reservahecha");

			request.getSession().setAttribute("reservahecha", r);

			request.getRequestDispatcher("ModificarReserva.jsp").forward(request, response);

		}

		if (request.getParameter("vol") != null) {

			this.doGet(request, response);

		}

		if (request.getParameter("buscar") != null) {

			ArrayList<entity.Reserva> res;
			CtrlABMReserva ctp = new CtrlABMReserva();

			String nombre = request.getParameter("nombre");
			System.out.println(nombre);

			res = ctp.Nombre(nombre);

			request.setAttribute("todasReservas", res);
			request.getRequestDispatcher("HomeAdministrador.jsp").forward(request, response);

		}

		if (request.getParameter("volveratras") != null) {

			Reserva r = new Reserva();

			r = (Reserva) request.getSession().getAttribute("reservahecha");

			request.getSession().setAttribute("reservahecha", r);

			request.getRequestDispatcher("ModificarReserva.jsp").forward(request, response);

		}

		if (request.getParameter("nuevaReserva") != null) {

			ArrayList<entity.Persona> alp;
			CtrlABMPersona ctp = new CtrlABMPersona();

			alp = ctp.getAll();

			request.setAttribute("allPeople", alp);

			request.getRequestDispatcher("NuevaReservaAdministrador.jsp").forward(request, response);

		}

	
	
		if (request.getParameter("PersonaReserva") != null) {
	    	  
	    	  ArrayList<entity.Persona> alp;
	  		CtrlABMPersona ctp = new CtrlABMPersona();

				
				String nombre = request.getParameter("nombre");
				System.out.println(nombre);
				
				alp =  ctp.Nombre(nombre);
				

				request.setAttribute("allPeople", alp);
	    	  
	    		request.getRequestDispatcher("NuevaReservaAdministrador.jsp").forward(request, response);
	    	  
	    	  
	      }
	
		if (request.getParameter("seleccionarReserva") != null) {
			
			ArrayList<entity.Cabana> cab;

			CtrlABMCabana ctrl = new CtrlABMCabana();
			
			cab = ctrl.getAll();
			
			entity.Persona p = new entity.Persona();
			CtrlABMPersona cp = new CtrlABMPersona();
			int id = Integer.parseInt(request.getParameter("seleccionarReserva"));

			p = cp.getById(id);
			
			request.setAttribute("persona", p);
			
			request.setAttribute("allCabana", cab);
			request.getRequestDispatcher("SeleccionarReservaAdministrador.jsp").forward(request, response);
			
			
			
		}
	
	
		
		
		
		
		if (request.getParameter("ReservaAdministrador") != null) {

			Reserva r = new Reserva();
			CtrlABMReserva rc = new CtrlABMReserva();
			
			CtrlABMCabana ctp = new CtrlABMCabana();
			
			entity.Cabana c = ctp.getById(Integer.parseInt(request.getParameter("idcabana")));
			
			
			
			entity.Persona p = new entity.Persona();
			CtrlABMPersona cp = new CtrlABMPersona();

			int id = Integer.parseInt(request.getParameter("idpersona"));

			p = cp.getById(id);

			// SimpleDateFormat f= new SimpleDateFormat("yyyy/MM/dd");//YYYY-MM-DD HH-MM-SS

			Date fecha_desde = null;

			Date fecha_hasta = null;

			String fechaDesde = request.getParameter("fecha_desde");
			String fechaHasta = request.getParameter("fecha_hasta");

			System.out.println(fechaDesde);

			try {

				DateFormat f = new SimpleDateFormat("yyyy/MM/dd");

				fecha_desde = f.parse(fechaDesde);
				r.setFechaDesde(fecha_desde);

				fecha_hasta = f.parse(fechaHasta);
				r.setFechaHasta(fecha_hasta);

				System.out.println(fecha_desde);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
			}

			System.out.println(fecha_desde);

			r.setCaba(c);
			r.setPer(p);
			// double costo=c.getPrecioDia()*dias;

			// System.out.println(costo);

			int dias = (int) ((fecha_hasta.getTime() - fecha_desde.getTime()) / 86400000);
			r.setCantidadDias(dias);
			double costo = c.getPrecioDia() * dias;
			r.setPrecioTotal(costo);

			System.out.println(dias);
			System.out.println(costo);
			System.out.println(fecha_desde);

			if (rc.estaDisponible(r)) {

				try {
					// System.out.println("reserva creada");
					// rc.add(r);

					//request.getSession().setAttribute("caba", c);
					request.getSession().setAttribute("reservahecha", r);
					request.getRequestDispatcher("ConfirmarReservaAdministrador.jsp").forward(request, response);
				} catch (Exception e2) {
					System.out.println("Aca tira error");
				}
			} else {
				request.getRequestDispatcher("ErrorAdministrador.jsp").forward(request, response);
			}
		}
		
		
		
		
		if (request.getParameter("reservaAdmin") != null) {

			Reserva r = new Reserva();
			CtrlABMReserva resCtrl = new CtrlABMReserva();

			r = (Reserva) request.getSession().getAttribute("reservahecha");

			resCtrl.add(r);

			this.doGet(request, response);

		}
		
		
		
		
		
		if (request.getParameter("ErrorAdministrador") != null) {

			

			
				
			this.doGet(request, response);
				
				
				
			
		

		}
		
	
		
		
		
		
		
		
		
	
	}
}
