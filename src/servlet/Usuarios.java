package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import controlers.CtrlABMUsuario;

import entity.Usuario;

/**
 * Servlet implementation class Usuarios
 */
@WebServlet({ "/Usuarios", "/usuarios", "/USUARIOS" })
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pagina = "/gestionar_usuarios.jsp";
		HttpSession session = request.getSession();
		
		try {
			if(session.getAttribute("uss")!=null) {
		
		
				if(session.getAttribute("Administrador") ==null){
					pagina = "/escritorio.jsp";
					request.setAttribute("infoNav", "No tiene permisos para ingresar a Usuarios");
				}else{
			
					try {
						CtrlABMUsuario ctrlUss = new CtrlABMUsuario();
						ArrayList<Usuario> listUss = ctrlUss.getAll();
						request.setAttribute("listUss", listUss);
				
					} catch (Exception e) {
						request.setAttribute("infoNav", e);
					}
			
				}
			}else{
					request.setAttribute("infoTipo", "info");
					request.setAttribute("infoText", "Ingrese usuario y contraseña");
					pagina = "/login.jsp";
				}
		} catch (Exception e) {
			request.setAttribute("infoNav", e);
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
