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
		res = ctrl.reservasDePer(per);

		request.setAttribute("todasReservas", res);
		request.getRequestDispatcher("MisReservas.jsp").forward(request, response);

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

				DateFormat f = new SimpleDateFormat("dd/MM/yyyy");

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
			if (rc.estaDisponible(r)) {
				// esta disponible ese elemento para las horas seleccionadas

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

	}

}