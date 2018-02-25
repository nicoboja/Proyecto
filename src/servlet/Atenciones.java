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
import entity.Usuario;

/**
 * Servlet implementation class Atenciones
 */
@WebServlet({ "/Atenciones", "/atenciones", "/ATENCIONES" })
public class Atenciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Atenciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/atenciones.jsp";
		HttpSession session = request.getSession();
		try {
			if(session.getAttribute("uss")!=null) {
				try {
					Paciente pac = new Paciente();
					int id = Integer.parseInt(request.getParameter("hc"));
					
					pac.setIdPac(id);
					CtrlABMPaciente ctrlPac = new CtrlABMPaciente();
					pac = ctrlPac.getById(pac);
					CtrlABMFichaLente ctrlFicha = new CtrlABMFichaLente();
					ArrayList<FichaLente> listFic = ctrlFicha.getByPaciente(pac);
					request.setAttribute("listFicha", listFic);
					request.setAttribute("pac", pac);
					
					
				} catch (Exception e) {
				e.printStackTrace();
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
