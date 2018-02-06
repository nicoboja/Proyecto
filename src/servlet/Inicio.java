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
		String pagina = "/home.jsp";
		HttpSession session = request.getSession();
		try {
			if(session.getAttribute("usuario")!=null) {
				System.out.println("sesion iniciada");

				
				
			}else{
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
		String pagina = "/escritorio.jsp";
		HttpSession session = request.getSession();
		
		try {
			
			String user=request.getParameter("user");
			String pass=request.getParameter("pass");
			if(user!=null && pass!=null){
				Usuario uss = new Usuario();
				
				
			}else{
				
				pagina = "/login.jsp";
				request.setAttribute("errTipo", "warning");
				request.setAttribute("errDesc", "Ingrese usuario y contraseña");
				
			}
			
		} catch (Exception e) {
			
		}
//		try {
//				String user=request.getParameter("user");
//				String pass=request.getParameter("pass");
//			if (user!=null) {
//	//			Persona per=new Persona();
//				per.setUss(user);
//				per.setPass(pass);
//				
//				Persona plog=new Persona();
//				plog= null;
//				
//				CtrlABMPersona ctrlPer= new CtrlABMPersona();
//				plog=ctrlPer.login(per);
//				
//				if (plog != null) {
//					System.out.println("diferente a nulo");
//					if (plog.isHabilitado()) {
//						System.out.println("habilitado");
//						session.setAttribute("usuario", plog);
//						CtrlABMReserva ctrlRes = new CtrlABMReserva();
//						ArrayList<Reserva> listaRes = ctrlRes.getById(plog.getId());
//						listaRes.get(1).getDetalle();
//						request.setAttribute("listares", listaRes );
//					}else{
//						request.setAttribute("error", "Error: <b>"+plog.getUss()+"<b> no esta <b>Habilitado</b>");
//						session.setAttribute("usuario", null);
//						pagina = "/login.jsp";
//					}
//					
//				}else{
//					request.setAttribute("error", "Error: Usuario o Contraseña incorrecta!");
//					session.setAttribute("usuario", null);
//					pagina = "/login.jsp";
//				}
//				
//			}else{
//				request.setAttribute("error", "Error: Ingrese Usuario y Contraseña");
//				session.setAttribute("usuario", null);
//				pagina = "/login.jsp";
//			}
//			
//			} catch (AppDataException e) {
//				request.setAttribute("error", "Error: "+e);
//				pagina = "/login.jsp";
//			} catch (Exception e) {
//				request.setAttribute("error", "Error: "+e);
//				pagina = "/login.jsp";
//			}
//		
//			System.out.println("#############INGRESO##############");
//			
//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
//	        dispatcher.forward(request, response); 
//		
	}
}


