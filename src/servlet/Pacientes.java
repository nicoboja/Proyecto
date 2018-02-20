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

import controlers.CtrlABMPaciente;
import entity.Paciente;



/**
 * Servlet implementation class Pacientes
 */
@WebServlet({ "/Pacientes", "/pacientes", "/PACIENTES" })
public class Pacientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pacientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/escritorio.jsp";
		HttpSession session = request.getSession();
		
		try {
			if(session.getAttribute("uss")!=null) {
					pagina = "/buscar_paciente.jsp";
					CtrlABMPaciente ctrlPac = new CtrlABMPaciente();
					ArrayList<Paciente> listPac = new ArrayList<>();
					listPac=null;
					Paciente pac = new Paciente();
					if (request.getParameter("dni") != null && request.getParameter("dni") != "") {
						request.setAttribute("infoNav", "DNI");	
						int doc = Integer.parseInt(request.getParameter("dni"));
						pac.setNroDoc(doc);
						listPac = ctrlPac.getListDoc(pac);
					}else{
						
					if (request.getParameter("ape") != null && request.getParameter("ape") != ""){
						request.setAttribute("infoNav", "APELLIDO");
						pac.setApellido((String) request.getAttribute("ape"));
						listPac = ctrlPac.getByApe(pac);
						}else{
							
					if (request.getParameter("hc") != null && request.getParameter("hc") != ""){
							request.setAttribute("infoNav", "HC");	
							int hc = Integer.parseInt(request.getParameter("hc"));
							pac.setNroDoc(hc);
							listPac = ctrlPac.getListDoc(pac);
						}
					}
					}
					
						
					request.setAttribute("listPac", listPac);		
					
			}else{
					request.setAttribute("infoTipo", "info");
					request.setAttribute("infoText", "Ingrese usuario y contraseña");
					pagina = "/login.jsp";
				}
		} catch (Exception e) {
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
