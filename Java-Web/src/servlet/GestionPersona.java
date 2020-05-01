package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMPersona;

/**
 * Servlet implementation class GestionPersona
 */
@WebServlet("/GestionPersona")
public class GestionPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionPersona() {
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
		ArrayList<entity.Persona> alp;
		CtrlABMPersona ctp = new CtrlABMPersona();

		alp = ctp.getAll();

		request.setAttribute("allPeople", alp);
		request.getRequestDispatcher("PersonaCrud.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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

			this.doGet(request, response);

		}
		// doGet(request, response);

		if (request.getParameter("listar") != null) {
			this.doGet(request, response);
		}

		if (request.getParameter("borrar") != null) {

			entity.Persona p = new entity.Persona();
			CtrlABMPersona ctp = new CtrlABMPersona();

			int id = Integer.parseInt(request.getParameter("borrar"));

			p = ctp.getById(id);
			ctp.delete(p);

			this.doGet(request, response);
		}

		if (request.getParameter("modificar") != null) {

			entity.Persona p = new entity.Persona();
			CtrlABMPersona ctp = new CtrlABMPersona();

			int id = Integer.parseInt(request.getParameter("modificar"));

			p = ctp.getById(id);

			request.setAttribute("persona", p);

			this.doGet(request, response);

		}

		if (request.getParameter("actualizar") != null) {

			entity.Persona p = new entity.Persona();
			CtrlABMPersona ctp = new CtrlABMPersona();

			p.setIdPersona(Integer.parseInt(request.getParameter("idpersona")));

			p.setNombre(request.getParameter("nombre"));
			p.setApellido(request.getParameter("apellido"));
			p.setDni(request.getParameter("dni"));
			p.setUsuario(request.getParameter("usuario"));
			p.setContrasena(request.getParameter("contrasena"));
			p.setEmail(request.getParameter("email"));
			p.setTelefono(request.getParameter("telefono"));
			p.setRol(request.getParameter("rol"));

			ctp.update(p);
			this.doGet(request, response);

		} else {
			this.doGet(request, response);
		}

	}

}
