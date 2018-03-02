package servlet;

import java.io.IOException;

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
 * Servlet implementation class EstadoFicha
 */
@WebServlet({ "/EstadoFicha", "/estadoficha", "/Esetadoficha", "/estadoFIcha", "/ESTADOFICHA" })
public class EstadoFicha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EstadoFicha() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/modificar_lente.jsp";
		HttpSession session = request.getSession();
		try {if (session.getAttribute("uss")!=null) {
			try {
				int idF = Integer.parseInt(request.getParameter("ff"));
				int idP = Integer.parseInt(request.getParameter("hc"));
				
				Paciente pac = new Paciente();
				CtrlABMPaciente ctrlPac = new CtrlABMPaciente();
				pac.setIdPac(idP);
				pac = ctrlPac.getById(pac);
				
				CtrlABMFichaLente ctrlfic = new CtrlABMFichaLente();
				FichaLente ficha = new FichaLente();
				ficha.setIdFicha(idF);
				ficha = ctrlfic.getById(ficha);
				ctrlfic.cambiarEstado(ficha);
				ficha = ctrlfic.getById(ficha);
				request.setAttribute("ficha", ficha);
				request.setAttribute("pac", pac);
				
				
			} catch (Exception e) {
				pagina= "/Inicio";
				request.setAttribute("infoNav", "Upss! Hubo un problema al querer actualizar el estado de la ficha");				
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
