package servlet;

import java.io.IOException;

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
 * Servlet implementation class Notas
 */
@WebServlet({ "/Notas", "/notas", "/NOTAS" })
public class Notas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Notas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/Inicio";
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/Inicio";
		HttpSession session = request.getSession();
		try {
			if (session.getAttribute("uss")!=null) {
				Usuario u = new Usuario();
				u = (Usuario)session.getAttribute("uss");
				u.setNotasInt(request.getParameter("notaint"));
				CtrlABMUsuario ctrlUss = new CtrlABMUsuario();
				ctrlUss.actulizaNotasInt(u);
			}
			
		} catch (Exception e) {
			request.setAttribute("infoNav", e);
		}
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);  
	}

}
