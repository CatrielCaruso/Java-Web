package servlet;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import controlers.CtrlABMCabana;
import controlers.CtrlABMPersona;
import controlers.CtrlABMReserva;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
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
			
			SimpleDateFormat f= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//YYYY-MM-DD HH-MM-SS
			
			
		


		
			

		
		
			
			
			
				try {
					
					Date fecha_desde = f.parse(request.getParameter("fecha_desde"));
					r.setFechaDesde(fecha_desde);

					Date fecha_hasta = f.parse(request.getParameter("fecha_hasta"));
					r.setFechaHasta(fecha_hasta);
					
				
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					}
			
			
			
			
			
			
			r.setCaba(c); 
			r.setPer(per);
			
			
			
			
			if (rc.estaDisponible(r)){
				//esta disponible ese elemento para las horas seleccionadas
				
				try {
					System.out.println("reserva creada");
					rc.add(r);
					
					request.getRequestDispatcher("exitoRes.jsp").forward(request, response);
				} catch (Exception e2) {
					System.out.println("Aca tira error");
				}
			}else {request.getRequestDispatcher("errorAlReservar.jsp").forward(request, response);}
	}
}

	
}
	
	
	
	

