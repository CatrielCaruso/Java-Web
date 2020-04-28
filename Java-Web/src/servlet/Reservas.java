package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMCabana;
import controlers.CtrlABMPersona;

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
			
			request.getRequestDispatcher("MisReservas.jsp").forward(request, response);
			
			
		}
		
		
		if (request.getParameter("contacto") != null) {
			
			
			request.getRequestDispatcher("Contacto.jsp").forward(request, response);
			
			
			
		}
	}

}
