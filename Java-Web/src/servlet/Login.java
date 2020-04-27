package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Persona;
import controlers.CtrlABMPersona;





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
				    
						
						request.getRequestDispatcher("PersonaCrud.jsp").forward(request, response);
					}else {
						
						request.getRequestDispatcher("Home.jsp").forward(request, response);
						
						
					}
				
				}else {
						
					       request.getRequestDispatcher("Login.jsp").forward(request, response);	
						
				
				      }
				
				
				
		}
			
			//System.out.println();
			//request.getRequestDispatcher("PaginaError.jsp").forward(request, response);

			
			//request.getRequestDispatcher("menuPrincipal.jsp").forward(request, response);
			//response.getWriter().append(user).append(" ").append(pass);
			
			
		//} catch (Exception e) {
			//e.printStackTrace();

			
		//}
		if (request.getParameter("salir") != null) {
			
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			
			
		}
		
	}
	}
