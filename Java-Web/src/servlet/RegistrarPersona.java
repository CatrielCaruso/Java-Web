package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMPersona;
import entity.Persona;

/**
 * Servlet implementation class RegistrarPersona
 */
@WebServlet("/RegistrarPersona")
public class RegistrarPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarPersona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		if (request.getParameter("accion") != null) {

			entity.Persona p = new entity.Persona();
			CtrlABMPersona ctp = new CtrlABMPersona();

			p.setApellido(request.getParameter("apellido"));
			p.setNombre(request.getParameter("nombre"));
			p.setDni(request.getParameter("dni"));
			p.setEmail(request.getParameter("email"));
			p.setTelefono(request.getParameter("telefono"));
			p.setUsuario(request.getParameter("usuario"));
			p.setContrasena(request.getParameter("contrasena"));
			p.setRol(request.getParameter("rol"));
			ctp.add(p);

			//this.doGet(request, response);
			request.getSession().setAttribute("personaLogueada", p);
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
		

		}
		
		
      if (request.getParameter("crear") != null) {
			
			
			request.getRequestDispatcher("CrearPersona.jsp").forward(request, response);
		}

      
      if (request.getParameter("acciones") != null) {

			entity.Persona p = new entity.Persona();
			CtrlABMPersona ctp = new CtrlABMPersona();

			p.setApellido(request.getParameter("apellido"));
			p.setNombre(request.getParameter("nombre"));
			p.setDni(request.getParameter("dni"));
			p.setEmail(request.getParameter("email"));
			p.setTelefono(request.getParameter("telefono"));
			p.setUsuario(request.getParameter("usuario"));
			p.setContrasena(request.getParameter("contrasena"));
			p.setRol(request.getParameter("rol"));
			ctp.add(p);

			this.doGet(request, response);

		}
      
      if (request.getParameter("volver") != null) {
			
			
			
			this.doGet(request, response);
		}
      if (request.getParameter("buscar") != null) {
    	  
    	  ArrayList<entity.Persona> alp;
  		CtrlABMPersona ctp = new CtrlABMPersona();

			
			String nombre = request.getParameter("nombre");
			System.out.println(nombre);
			
			alp =  ctp.Nombre(nombre);
			

			request.setAttribute("allPeople", alp);
    	  
    		request.getRequestDispatcher("PersonaCrud.jsp").forward(request, response);
    	  
    	  
      }
	}

}
