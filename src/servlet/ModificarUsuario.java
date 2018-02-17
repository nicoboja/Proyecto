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
							try {
								ArrayList<Usuario> listUss = ctrlUss.getAll();
								request.setAttribute("listUss", listUss);
						
							} catch (Exception e) {
								request.setAttribute("infoNav", e);
							}
							request.setAttribute("infoNav", "No existe Usuario");
							
						}else{
							CtrlABMNivel ctrlNiv = new CtrlABMNivel();
							request.setAttribute("nivBD", ctrlNiv.getAll());
							request.setAttribute("ussM", uss);
						}
						
					}else{
						pagina = "/Usuarios";
						request.setAttribute("infoNav", "Se produjo un error al querer modificar el usuario");
					}
					
					
					
					}
				
				}else{
					request.setAttribute("infoTipo", "info");
					request.setAttribute("infoText", "Ingrese usuario y contraseña");
					pagina = "/login.jsp";
				}
		
			}catch (Exception e) {
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
		String pagina = "/usuario_modificar.jsp";
		HttpSession session = request.getSession();
		
		try {
			if(session.getAttribute("uss")!= null) {
				if(session.getAttribute("Administrador") == null){
					pagina = "/escritorio.jsp";
					request.setAttribute("infoNav", "No tiene permisos para ingresar a Usuarios");
					}
				else{
						try {
						
							int id = Integer.parseInt(request.getParameter("id"));
							Usuario uss = new Usuario();
							uss.setApellido(request.getParameter("apellido"));
							
							uss.setNombre(request.getParameter("nombre"));
							uss.setCorreo(request.getParameter("correo"));
							uss.setEstado(request.getParameter("estado"));
							uss.setPass(request.getParameter("pass"));
							uss.setFecEstado(request.getParameter("fecEstado"));
							uss.setNotas(request.getParameter("notas"));
							uss.setIdU(id);
							
							/*System.out.println(uss.getApellido());
							System.out.println(uss.getNombre());
							System.out.println(uss.getIdU());
							System.out.println(uss.getCorreo());
							System.out.println(uss.getEstado());
							System.out.println(uss.getPass());
							System.out.println(uss.getFecEstado());
							System.out.println(uss.getNotas());*/
							
							CtrlABMUsuario ctrlUss = new CtrlABMUsuario();
							ctrlUss.update(uss);
							
							CtrlABMNivel ctrlNiv = new CtrlABMNivel();
							request.setAttribute("nivBD", ctrlNiv.getAll());
							
							Usuario us= ctrlUss.getById(uss);
							request.setAttribute("ussM", us);
							
							request.setAttribute("infoText","Se modifico usuario"+us.getUser());
							request.setAttribute("infoTipo","success");
							
							} catch (Exception e) {
									e.printStackTrace();
									pagina= "/escritorio.jsp";
									request.setAttribute("infoNav", e);
							}
					}
			}else{
				request.setAttribute("infoTipo", "info");
				request.setAttribute("infoText", "Ingrese usuario y contraseña");
				pagina = "/login.jsp";
			}
		} catch (Exception e) {
			pagina= "/escritorio.jsp";
			request.setAttribute("infoNav", e);
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
