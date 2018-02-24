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
import controlers.CtrlABMPaciente;
import controlers.CtrlABMUsuario;
import entity.Paciente;
import entity.Usuario;

/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet({ "/NuevoPaciente", "/nuevoPaciente", "/Nuevopaciente", "/NUEVOPACIENTE" })
public class NuevoPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public NuevoPaciente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/agregar_paciente.jsp";
		HttpSession session = request.getSession();
		
		try {
			if(session.getAttribute("uss")!=null) {
				if(session.getAttribute("Administrador") ==null && session.getAttribute("Optico") ==null ){
					pagina = "/escritorio.jsp";
					request.setAttribute("infoNav", "No tiene permisos para ingresar crear un nuevo paciente");
				}else{

					
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
		String pagina = "/agregar_paciente.jsp";
		HttpSession session = request.getSession();
		
		try {
			if(session.getAttribute("uss")!=null) {
				if(session.getAttribute("Administrador") ==null && session.getAttribute("Optico") ==null){
					pagina = "/escritorio.jsp";
					request.setAttribute("infoNav", "No tiene permisos para ingresar a crear un nuevo paciente");
				}else{
					if (request.getParameter("dni")!= null &&  request.getParameter("dni")!= "") {
						int cel = 0 , nrobra = 0 , tel = 0;
						
						Paciente pacForm = new Paciente();
						if (request.getParameter("cel")!= null) {cel = Integer.parseInt(request.getParameter("cel"));}
						if (request.getParameter("tel")!= null) {tel = Integer.parseInt(request.getParameter("tel"));}
						if (request.getParameter("nroaf")!= null) {nrobra = Integer.parseInt(request.getParameter("nroaf"));}
						
						int dni = Integer.parseInt(request.getParameter("dni"));
						pacForm.setNroDoc(dni);
						pacForm.setNombre(request.getParameter("nombre"));
						pacForm.setApellido(request.getParameter("apellido"));
						pacForm.setCorreo(request.getParameter("correo"));
						pacForm.setDireccion(request.getParameter("dir"));
						pacForm.setCiudad(request.getParameter("ciudad"));
						pacForm.setCelular(cel);
						pacForm.setTelefono(tel);
						pacForm.setOs(request.getParameter("osocial"));
						pacForm.setNroOs(nrobra);
						pacForm.setFecNac(request.getParameter("fecnac"));
						pacForm.setNota(request.getParameter("notas"));
						
						Paciente pacBD = new Paciente();
						
						CtrlABMPaciente ctrlPac = new CtrlABMPaciente();
						pacBD= ctrlPac.getByDoc(pacForm);
						
						if(pacBD == null ){
							ctrlPac.add(pacForm);
							request.setAttribute("infoText","Paciente creado con exito, DNI: "+pacForm.getNroDoc());
							request.setAttribute("infoTipo","success");
							
						}else{
							request.setAttribute("infoText","Ya existe el DNI "+pacBD.getNroDoc()+" en el registro de Fichas ");
							request.setAttribute("infoTipo","warning");
						}
						
					}else{
						request.setAttribute("infoText","DNI invalido!");
						request.setAttribute("infoTipo","danger");
					}
					
			
					
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

}
