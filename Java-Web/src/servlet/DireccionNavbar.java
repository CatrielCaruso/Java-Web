package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMPersona;
import controlers.CtrlABMReserva;

/**
 * Servlet implementation class DireccionNavbar
 */
@WebServlet("/DireccionNavbar")
public class DireccionNavbar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DireccionNavbar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<entity.Persona> alp;
		CtrlABMPersona ctp = new CtrlABMPersona();

		alp = ctp.getAll();

		request.setAttribute("allPeople", alp);
		request.getRequestDispatcher("PersonaCrud.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if (request.getParameter("reservas") != null) {
			request.getRequestDispatcher("MisReservas.jsp").forward(request, response);
		
		
		}
		
		if (request.getParameter("contacto") != null) {
			request.getRequestDispatcher("Contacto.jsp").forward(request, response);
		
		
		}
	
		if (request.getParameter("home") != null) {
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		
		
		}
	
		if (request.getParameter("crud") != null) {
			this.doGet(request, response);
		
		
		}
		
		
		if (request.getParameter("crudreservas") != null) {
			
			ArrayList<entity.Reserva> res;

			CtrlABMReserva ctrl = new CtrlABMReserva();
			
                    res=ctrl.getAll();
	          
	          
	          request.setAttribute("todasReservas", res);
				request.getRequestDispatcher("HomeAdministrador.jsp").forward(request, response);
			
		
		}
		
		
	}
	
	
	
	
	
	

	
	
}
