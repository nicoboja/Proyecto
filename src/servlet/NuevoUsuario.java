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

import controlers.CtrlABMNivel;
import controlers.CtrlABMUsuario;
import entity.Nivel;
import entity.Usuario;

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
		String pagina = "/agregar_usuario.jsp";
		HttpSession session = request.getSession();
		
		try {
			if(session.getAttribute("uss")!=null) {
				if(session.getAttribute("Administrador") ==null){
					pagina = "/escritorio.jsp";
					request.setAttribute("infoNav", "No tiene permisos para ingresar a Usuarios");
				}else{

					CtrlABMNivel ctrlNiv = new CtrlABMNivel();
					request.setAttribute("nivBD", ctrlNiv.getAll());
				}
			}else{
				request.setAttribute("infoTipo", "info");
				request.setAttribute("infoText", "Ingrese usuario y contraseña");
				pagina = "/login.jsp";
			}
		}
			catch (Exception e) {
				pagina= "/escritorio.jsp";
				request.setAttribute("infoNav", e);
			}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/agregar_usuario.jsp";
		HttpSession session = request.getSession();
		
		try {
			if(session.getAttribute("uss")!=null) {
				if(session.getAttribute("Administrador") ==null){
					pagina = "/escritorio.jsp";
					request.setAttribute("infoNav", "No tiene permisos para ingresar a Usuarios");
				}else{
					
					Usuario uss = new Usuario();
					uss.setUser(request.getParameter("usuario"));
					uss.setApellido(request.getParameter("apellido"));
					uss.setNombre(request.getParameter("nombre"));
					uss.setCorreo(request.getParameter("correon"));
					uss.setEstado(request.getParameter("estado"));
					uss.setPass(request.getParameter("passn"));
					uss.setNotas(request.getParameter("notas"));
					
					CtrlABMNivel ctrlNiv = new CtrlABMNivel();
					ArrayList<Nivel> listNivBD = ctrlNiv.getAll();
					ArrayList<Nivel> listNiv = new ArrayList<Nivel>();
				
					
					for (Nivel n : listNivBD) {
						System.out.println(n.getDescripcion());
						if (request.getParameter(n.getDescripcion()) != null) {
						//	System.out.println("ACEPTADO: "+n.getDescripcion());
							listNiv.add(n);
						}
						
						
					}
					uss.setNivel(listNiv);
					CtrlABMUsuario ctrlUss = new CtrlABMUsuario();
					boolean rta =ctrlUss.add(uss);
					if(rta){
						uss = ctrlUss.getByUser(uss);
						request.setAttribute("idmodificar", uss.getIdU());
						request.setAttribute("infoText","Se agrego el usuario: "+uss.getUser());
						request.setAttribute("infoTipo","success");
					}else{
						request.setAttribute("infoText","Ya existe el usuario: "+uss.getUser());
						uss = ctrlUss.getByUser(uss);
						request.setAttribute("idmodificar", uss.getIdU());
						request.setAttribute("infoTipo","danger");
					}
					
			
					request.setAttribute("nivBD", ctrlNiv.getAll());
				}
			}else{
				request.setAttribute("infoTipo", "info");
				request.setAttribute("infoText", "Ingrese usuario y contraseña");
				pagina = "/login.jsp";
			}
		}
			catch (Exception e) {
				pagina= "/agregar_usuario.jsp";
				request.setAttribute("infoTipo","danger");
				request.setAttribute("infoText", e);
			}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
