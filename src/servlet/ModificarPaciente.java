package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controlers.CtrlABMPaciente;
import entity.Paciente;

/**
 * Servlet implementation class ModificarPaciente
 */

@WebServlet({ "/ModificarPaciente", "/modificarPaciente", "/Modificarpaciente", "/MODIFICARPACIENTE", "/modificarpaciente" })
public class ModificarPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarPaciente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/modificar_paciente.jsp";
		HttpSession session = request.getSession();
		
		try {
			if(session.getAttribute("uss")!=null) {
				if(session.getAttribute("Administrador") ==null && session.getAttribute("Optico") ==null){
					pagina = "/escritorio.jsp";
					request.setAttribute("infoNav", "No tiene permisos para ingresar a Modifiar Pacientes");
				}else{
					if(request.getParameter("id") != null){
						int idU = 0;
						try {
							idU = Integer.parseInt(request.getParameter("id"));
						} catch (Exception e) {
							request.setAttribute("infoNav", "No existe Paciente con HC = "+request.getParameter("id"));
							pagina = "/Pacientes";
						}
						
						CtrlABMPaciente ctrlPac = new CtrlABMPaciente();
						Paciente pac = new Paciente();
						pac.setIdPac(idU);
						pac= ctrlPac.getById(pac);
						System.out.println(pac);
						
						if(pac== null){
							request.setAttribute("infoNav", "No existe Paciente con HC = "+request.getParameter("id"));
							pagina = "/Pacientes";
						}else{
							request.setAttribute("pacM", pac);
						}
						
					}else{
						pagina = "/Pacientes";
						request.setAttribute("infoNav", "Se produjo un error al querer modificar el paciente");
					}
					
					
					
					}
				
				}else{
					request.setAttribute("infoTipo", "info");
					request.setAttribute("infoText", "Ingrese paciente y contraseña");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
