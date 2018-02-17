package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet({ "/NuevoUsuario", "/nuevoUsuario", "/Nuevousuario", "/NUEVOUSUARIO" })
public class NuevoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoUsuario() {
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
					
				}
			}
		}
			catch (Exception e) {
				// TODO: handle exception
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
