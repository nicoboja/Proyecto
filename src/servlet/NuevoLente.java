package servlet;

import java.io.IOException;

import javax.print.PrintException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controlers.CtrlABMFichaLente;
import controlers.CtrlABMLenteMaterial;
import controlers.CtrlABMLenteTipo;
import controlers.CtrlABMPaciente;
import entity.FichaLente;
import entity.LenteMaterial;
import entity.LenteTipo;
import entity.Paciente;
import entity.Usuario;

/**
 * Servlet implementation class NuevoLente
 */
@WebServlet("/NuevoLente")
public class NuevoLente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoLente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/nuevo_lente.jsp";
		HttpSession session = request.getSession();
		try {
			if(session.getAttribute("uss")!=null) {
				if(session.getAttribute("Optico") ==null){
					pagina = "/Inicio";
					request.setAttribute("infoNav", "No tiene permisos para crear una nueva ficha de lente recetado");
				}else{
					if (request.getParameter("hc")!= null &&  request.getParameter("dni")!= "") {
						
						int id = Integer.parseInt(request.getParameter("hc"));
						
						Paciente pac = new Paciente();
						CtrlABMPaciente ctrlPac = new CtrlABMPaciente();
						pac.setIdPac(id);
						pac = ctrlPac.getById(pac);
						
						request.setAttribute("pac", pac);
						
						
					}else{
						request.setAttribute("infoText","No existe paciente ");
						request.setAttribute("infoTipo","warning");
					}
				}
			}else{
				request.setAttribute("infoTipo", "info");
				request.setAttribute("infoText", "Ingrese usuario y contraseña");
				pagina = "/login.jsp";
			}
			
		} catch (Exception e) {
			pagina= "/Inicio";
			request.setAttribute("infoNav", e);
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DO NUEVO LENTE");
		String pagina = "/escritorio.jsp";
		HttpSession session = request.getSession();
		try {
			if(session.getAttribute("uss")!=null) {
				
				if(session.getAttribute("Optico") == null){
					request.setAttribute("infoNav", "No tiene permisos para crear una nueva ficha de lente recetado");
				}else{
					if (request.getParameter("hc")!= null &&  request.getParameter("hc")!= "") {
							FichaLente ficha = new FichaLente();
							CtrlABMFichaLente ctrlFicha = new CtrlABMFichaLente();
						
							int codgrados = 0, coigrados =0, lodgrados=0, loigrados=0, tipo = 1, material = 1;
							float codesf = 0, codcil=0, coiesf=0, coicil=0, lodesf=0, lodcil=0, loiesf=0, loicil=0, costoArm=0, costoCrist=0, sena=0; 
							
							ficha.setFecEstimadaS(request.getParameter("fecha_estimada"));
							ficha.setFecReceta(request.getParameter("fecha_receta"));
							
							if (request.getParameter("a_od_c")!= null) {codgrados = Integer.parseInt(request.getParameter("a_od_c"));}
							ficha.setCodgrados(codgrados);
							
							if (request.getParameter("a_oi_c")!= null) {coigrados = Integer.parseInt(request.getParameter("a_oi_c"));}
							ficha.setCoigrados(coigrados);
							if (request.getParameter("a_od_l")!= null) {lodgrados = Integer.parseInt(request.getParameter("a_od_l"));}
							ficha.setLodgrados(lodgrados);
							if (request.getParameter("a_oi_l")!= null) {loigrados = Integer.parseInt(request.getParameter("a_oi_l"));}
							ficha.setLoigrados(loigrados);
							
							if (request.getParameter("esf_od_c")!= null) {codesf = Float.parseFloat(request.getParameter("esf_od_c"));}
							ficha.setCodesf(codesf);
							if (request.getParameter("cil_od_c")!= null) {codcil = Float.parseFloat(request.getParameter("cil_od_c"));}
							ficha.setCodcil(codcil);
							if (request.getParameter("esf_oi_c")!= null) {coiesf = Float.parseFloat(request.getParameter("esf_oi_c"));}
							ficha.setCoiesf(coiesf);
							if (request.getParameter("cil_oi_c")!= null) {coicil = Float.parseFloat(request.getParameter("cil_oi_c"));}
							ficha.setCoicil(coicil);
							if (request.getParameter("esf_od_l")!= null) {lodesf = Float.parseFloat(request.getParameter("esf_od_l"));}
							ficha.setLodesf(lodesf);
							if (request.getParameter("cil_od_l")!= null) {lodcil = Float.parseFloat(request.getParameter("cil_od_l"));}
							ficha.setLodcil(lodcil);
							//
							if (request.getParameter("esf_oi_l")!= null) {loiesf = Float.parseFloat(request.getParameter("esf_oi_l"));}
							ficha.setLoiesf(loiesf);
							if (request.getParameter("cil_oi_l")!= null) {loicil = Float.parseFloat(request.getParameter("cil_oi_l"));}
							ficha.setLoicil(loicil);
							//
							if (request.getParameter("tot_arma")!= null) {costoArm = Float.parseFloat(request.getParameter("tot_arma"));}
							ficha.setCostoArm(costoArm);
							if (request.getParameter("total_cris")!= null) {costoCrist = Float.parseFloat(request.getParameter("total_cris"));}
							ficha.setCostoCrist(costoCrist);
							if (request.getParameter("sena")!= null) {sena = Float.parseFloat(request.getParameter("sena"));}
							ficha.setSena(sena);
							
							int id = Integer.parseInt(request.getParameter("hc"));
							
							Paciente pac = new Paciente();
							CtrlABMPaciente ctrlPac = new CtrlABMPaciente();
							pac.setIdPac(id);
							pac = ctrlPac.getById(pac);
							ficha.setPaciente(pac);
							
							Usuario us = new Usuario();
							us = (Usuario)session.getAttribute("uss");
							ficha.setOptico(us);
							
							ficha.setArmazon(request.getParameter("armazon"));
							ficha.setModelo(request.getParameter("modelo"));
							ficha.setColor(request.getParameter("color"));
							ficha.setNotas(request.getParameter("notas"));
						
							LenteTipo lt = new LenteTipo();
							if (request.getParameter("tipo")!= null) {tipo = Integer.parseInt(request.getParameter("tipo"));}
							lt.setIdTipo(tipo);
							
							LenteMaterial lm = new LenteMaterial();
							if (request.getParameter("lente")!= null) {material = Integer.parseInt(request.getParameter("lente"));}
							lm.setIdMaterial(material);
							
							CtrlABMLenteMaterial ctrlLm = new CtrlABMLenteMaterial();
							CtrlABMLenteTipo ctrLt = new CtrlABMLenteTipo();
							
							lm = ctrlLm.getById(lm);
							lt = ctrLt.getById(lt);
							
							ficha.setMaterial(lm);
							ficha.setTipo(lt);
							
						
						
						
						ctrlFicha.add(ficha);
						pagina="/Atenciones?hc="+id+"";
						
					}else{
						
						request.setAttribute("infoText","No existe paciente ");
						request.setAttribute("infoTipo","warning");
					}
				}
			}else{
				request.setAttribute("infoTipo", "info");
				request.setAttribute("infoText", "Ingrese usuario njknjky contraseña");
				pagina = "/login.jsp";
			}
			
		} catch (Exception e) {
			System.out.println("catch");
			e.printStackTrace();
			request.setAttribute("infoNav", e);
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}