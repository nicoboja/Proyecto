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
 * Servlet implementation class Pacientes
 */
@WebServlet({ "/Pacientes", "/pacientes", "/PACIENTES" })
public class Pacientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pacientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/escritorio.jsp";
		HttpSession session = request.getSession();
		
		try {
			if(session.getAttribute("uss")!=null) {
					pagina = "/buscar_paciente.jsp";
					
			
					try {
						
				
					} catch (Exception e) {
						request.setAttribute("infoNav", e);
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
