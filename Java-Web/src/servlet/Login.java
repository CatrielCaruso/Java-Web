package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Persona;
import controlers.CtrlABMPersona;
import controlers.CtrlABMReserva;





/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		ArrayList<entity.Reserva> res;

		CtrlABMReserva ctrl = new CtrlABMReserva();
		// CtrlABMPersona cp = new CtrlABMPersona();
		entity.Persona per = (Persona) request.getSession().getAttribute("personaLogueada");
		request.getSession().getAttribute("caba");
		
		
		
		
	          res=ctrl.getAll();
	          
	          
	            request.setAttribute("todasReservas", res);
				request.getRequestDispatcher("HomeAdministrador.jsp").forward(request, response);
	
	
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		    
	
		
		
		if (request.getParameter("loguear") != null) {
			
			
		    String user=request.getParameter("user");
			String pass=request.getParameter("pass");
			
			CtrlABMPersona ctrl= new CtrlABMPersona();
			Persona per=ctrl.loguearUsuario(user,pass);
			
			
				if(per != null){
					
					
					request.getSession().setAttribute("personaLogueada", per);

					if (per.getRol().equals("Administrador")) {
				    
						
						this.doGet(request, response);
					}else {
						
						request.getRequestDispatcher("Home.jsp").forward(request, response);
						
						
					}
				
				}else {
						
					       request.getRequestDispatcher("Login.jsp").forward(request, response);	
						
				
				      }
				
				
				
		}
			
			
		if (request.getParameter("salir") != null) {
			
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			
			
		}
		
	}
	}
