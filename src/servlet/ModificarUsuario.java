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
 * Servlet implementation class ModificarUsuario
 */
@WebServlet({ "/ModificarUsuario", "/modificarusuario", "/MODIFICARUSUARIO", "/MODIFICARusuario" })
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/usuario_modificar.jsp";
		HttpSession session = request.getSession();
		
		try {
			if(session.getAttribute("uss")!=null) {
				if(session.getAttribute("Administrador") ==null){
					pagina = "/escritorio.jsp";
					request.setAttribute("infoNav", "No tiene permisos para ingresar a Usuarios");
				}else{
					if(request.getParameter("id") != null){
						int idU = Integer.parseInt(request.getParameter("id"));
						CtrlABMUsuario ctrlUss = new CtrlABMUsuario();
						Usuario uss = new Usuario();
						uss.setIdU(idU);
						uss= ctrlUss.getById(uss);
						if(uss== null){
							pagina = "/gestionar_usuarios.jsp";
							request.setAttribute("infoNav", "No existe Usuario");
							
						}else{
							request.setAttribute("ussM", uss);
						}
						
					}else{
						pagina = "/gestionar_usuarios.jsp";
						request.setAttribute("infoNav", "Se produjo un error al querer modificar el usuario");
					}
					
					
					
					}
				
				}else{
					request.setAttribute("infoTipo", "info");
					request.setAttribute("infoText", "Ingrese usuario y contraseña");
					pagina = "/login.jsp";
				}
		
			}catch (Exception e) {
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
