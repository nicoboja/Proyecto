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

import controlers.CtrlABMFichaLente;
import controlers.CtrlABMPaciente;
import entity.FichaLente;
import entity.Paciente;

/**
 * Servlet implementation class Pendientes
 */
@WebServlet({ "/Pendientes", "/PENDIENTES", "/pendientes" })
public class Pendientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pendientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/pendientes.jsp";
		HttpSession session = request.getSession();
		try {
			if(session.getAttribute("uss")!=null) {
				try {
					String estado = request.getParameter("estado");
					System.out.println();
					CtrlABMFichaLente ctrlFicha = new CtrlABMFichaLente();
					ArrayList<FichaLente> listFic = ctrlFicha.getByEstado(estado);
					
					if(listFic==null){
						pagina= "/Inicio";
						request.setAttribute("infoNav", "No existen tareas con estado: "+estado);
					}else{
						request.setAttribute("listFicha", listFic);
						request.setAttribute("Estado", estado);
						
					}
				} catch (Exception e) {
					pagina= "/Inicio";
					request.setAttribute("infoNav", e);
				}
				
			}else{
				request.setAttribute("infoTipo", "info");
				request.setAttribute("infoText", "Ingrese paciente y contraseña");
				pagina = "/login.jsp";
			}
		} catch (Exception e) {
			pagina= "/Inicio";
			request.setAttribute("infoNav", e);
			
		}
		System.out.println(pagina);
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
