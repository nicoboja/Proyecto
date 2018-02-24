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
import controlers.CtrlABMUsuario;
import entity.Usuario;
import util.AppDataException;

/**
 * Servlet implementation class Inicio
 */

@WebServlet({ "/Inicio", "/inicio", "/INICIO" })
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" GET -INICIO ");
		String pagina = "/escritorio.jsp";
		HttpSession session = request.getSession();
		CtrlABMFichaLente ctrlFicha=new CtrlABMFichaLente();
		try {
			if(session.getAttribute("uss")!=null) {
				System.out.println("sesion iniciada");
				int nuevos=ctrlFicha.getCantEstado("Pendiente");
				int taller=ctrlFicha.getCantEstado("Taller");
				int terminado=ctrlFicha.getCantEstado("Terminado");
				int comunicado=ctrlFicha.getCantEstado("Comunicado");
				request.setAttribute("nnuevos", nuevos);
				request.setAttribute("ntaller", taller);
				request.setAttribute("nterminados", terminado);
				request.setAttribute("ncomunicados", comunicado);

			}else{
				request.setAttribute("infoTipo", "info");
				request.setAttribute("infoText", "Ingrese usuario y contraseña");
				pagina = "/login.jsp";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);  
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/login.jsp";
		HttpSession session = request.getSession();
		CtrlABMFichaLente ctrlFicha=new CtrlABMFichaLente();
		
		
		
		try {
			String user=request.getParameter("user");
			String pass=request.getParameter("pass");
			if(user!=null && pass!=null){
				Usuario uForm = new Usuario();
				uForm.setUser(user);
				uForm.setPass(pass);
				Usuario uLog = new Usuario();
				uLog = null;
				CtrlABMUsuario ctrlUss = new CtrlABMUsuario();
				uLog = ctrlUss.login(uForm);
				if(uLog!=null){
					if (uLog.getEstado().equals("Habilitado")) {
						pagina = "/escritorio.jsp";
						session.setAttribute("uss", uLog);
						System.out.println("Estado: "+uLog.getEstado());
						
						for(int i=0;i<uLog.getNivel().size();i++){
							System.out.println(uLog.getNivel().get(i).getDescripcion());
							session.setAttribute(uLog.getNivel().get(i).getDescripcion(), true);
						}
						int nuevos=ctrlFicha.getCantEstado("Pendiente");
						int taller=ctrlFicha.getCantEstado("Taller");
						int terminado=ctrlFicha.getCantEstado("Terminado");
						int comunicado=ctrlFicha.getCantEstado("Comunicado");
						request.setAttribute("nnuevos", nuevos);
						request.setAttribute("ntaller", taller);
						request.setAttribute("nterminados", terminado);
						request.setAttribute("ncomunicados", comunicado);
					}else {
						 
						request.setAttribute("infoTipo", "danger");
						request.setAttribute("infoText", "Usuario <b>"+user+"</b> Inhabilitado!");
					}
				}else{
					request.setAttribute("infoTipo", "danger");
					request.setAttribute("infoText", "Usuario o contraseña incorrecta!");
				}
			}else{
				request.setAttribute("infoTipo", "warning");
				request.setAttribute("infoText", "Ingrese usuario y contraseña!");
			}
			
		} catch (Exception e) {
			request.setAttribute("infoTipo", "danger");
			request.setAttribute("infoText", e);
			e.printStackTrace();
			
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
        
	}
	
	private void iniNiveles() {
		
		
		
	}
}


