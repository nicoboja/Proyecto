package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controlers.CtrlABMNivel;
import controlers.CtrlABMUsuario;
import entity.Usuario;

/**
 * Servlet implementation class Validar
 */
@WebServlet({ "/Validar", "/validar", "/VALIDAR" })
public class Validar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/NuevoUsuario";
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/pedro";
		HttpSession session = request.getSession();
		try {
			if(session.getAttribute("uss")!=null) {
			if(request.getParameter("usuario")!= null){
				if(session.getAttribute("Administrador") !=null){
					pagina="/agregar_usuario.jsp";
					CtrlABMUsuario ctrlUss = new CtrlABMUsuario();
					Usuario u = new Usuario();
					u.setUser(request.getParameter("usuario"));
					if(!ctrlUss.validaUser(u)){
						CtrlABMNivel ctrlNiv = new CtrlABMNivel();
						request.setAttribute("valido", u.getUser());
						request.setAttribute("usuario", request.getParameter("usuario"));
						request.setAttribute("nivBD", ctrlNiv.getAll());
					}else{
						u = ctrlUss.getByUser(u);
						request.setAttribute("idmodificar", u.getIdU());
						request.setAttribute("infoText","Ya existe el usuario: "+request.getParameter("usuario"));
						request.setAttribute("infoTipo","danger");
					}
					
				}else{
					pagina = "/escritorio.jsp";
					request.setAttribute("infoNav", "No tiene permisos para ingresar a Usuarios");
				}
				
			}
			}else{
				request.setAttribute("infoTipo", "info");
				request.setAttribute("infoText", "Ingrese usuario y contraseña");
				pagina = "/login.jsp";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			pagina="error";
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
	}

}
