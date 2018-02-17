package prueba;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controlers.CtrlABMNivel;
import controlers.CtrlABMPaciente;
import controlers.CtrlABMUsuario;
import entity.Nivel;
import entity.Paciente;
import entity.Usuario;

public class consola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		Usuario usu=new Usuario();
		Usuario uLogueado=new Usuario();
		Paciente pac=new Paciente();
		CtrlABMUsuario ctrlUser=new CtrlABMUsuario();
		ArrayList<Usuario> usus= new ArrayList<Usuario>();
		CtrlABMPaciente ctrlPac=new CtrlABMPaciente();
		ArrayList<Paciente> pacs= new ArrayList<Paciente>();
		CtrlABMNivel ctrlNiv=new CtrlABMNivel();
		boolean x = false;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate)); //2016/11/16
		
		System.out.println("Ingrese Usuario:");
		usu.setUser(s.nextLine());
		System.out.println("Ingrese Pass:");
		usu.setPass(s.nextLine());
		try {
			uLogueado=ctrlUser.login(usu);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println(uLogueado.getApellido());
//		System.out.println("Ingresar numero:");
//		String g;
//		g=(s.nextLine());
//		int z=Integer.parseInt(g);
//		System.out.println(z);
		
		try {
			pacs=ctrlPac.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<pacs.size();i++){
			System.out.println("Paciente "+(i+1));
			System.out.println(pacs.get(i).getNombre());
			System.out.println(pacs.get(i).getApellido());
			System.out.println("------------------------");
		}
		Usuario uN=new Usuario();
		uN.setIdU(6);
		System.out.println("Ingresar USUARIO");
		System.out.println("Ingresar Nombre:");
		uN.setNombre(s.nextLine());
		System.out.println("Ingresar Apellido:");
		uN.setApellido(s.nextLine());
		System.out.println("Ingresar Nota:");
		uN.setNotas(s.nextLine());
		System.out.println("Ingresar Mail:");
		uN.setCorreo(s.nextLine());
		System.out.println("Ingresar Contraseña:");
		uN.setPass(s.nextLine());
		uN.setEstado("Inhabilitado");
		uN.setFecEstado("2018-02-17");
		try {
			ctrlUser.update(uN);
			System.out.println(x);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if(x){
//			System.out.println("Se agrego un nuevo usuario ");
//		}else{
//			System.out.println("Nombre de usuario ya utilizado");
//		}
//		System.out.println("Ingresar PACIENTE");
//		System.out.println("Ingresar Nombre:");
//		pac.setNombre(s.nextLine());
//		System.out.println("Ingresar Apellido:");
//		pac.setApellido(s.nextLine());
//		System.out.println("Ingresar Nro. Documento:");
//		pac.setNroDoc(Integer.parseInt(s.nextLine()));
//		System.out.println("Ingresar Telefono:");
//		pac.setTelefono(Integer.parseInt(s.nextLine()));
//		System.out.println("Ingresar Celular");
//		pac.setCelular(Integer.parseInt(s.nextLine()));
//		System.out.println("Ingresar Ciudad:");
//		pac.setCiudad(s.nextLine());
//		System.out.println("Ingresar Mail:");
//		pac.setCorreo(s.nextLine());
//		System.out.println("Ingresar Direccion:");
//		pac.setDireccion(s.nextLine());
//		System.out.println("Ingresar Fecha Nacimiento:");
//		pac.setFecNac(s.nextLine());
//		System.out.println("Ingresar Nota:");
//		pac.setNota(s.nextLine());
//		System.out.println("Ingresar OS:");
//		pac.setOs(s.nextLine());
//		System.out.println("Ingresar Nro OS:");
//		pac.setNroOs(Integer.parseInt(s.nextLine()));
//		pac.setIdPac(3);
//		try {
//			ctrlPac.update(pac);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(uLogueado.getNivel().get(0).getIdNivel());
//		try {
//			usus=ctrlUser.getAll();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		for(int i=0;i<usus.size();i++){
//			System.out.println(usus.get(i).getIdU());
//			System.out.println(usus.get(i).getNombre());
//			System.out.println(usus.get(i).getApellido());
//			for(int v=0;v<usus.get(i).getNivel().size(); v++){
//				System.out.println(usus.get(i).getNivel().get(v).getIdNivel());
//				System.out.println(usus.get(i).getNivel().get(v).getDescripcion());
//			}			
//		}
//		
//		try {
//			pacs=ctrlPac.getAll();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//		
//		for(int i=0;i<pacs.size();i++){
//			System.out.println(pacs.get(i).getIdPac());
//			System.out.println(pacs.get(i).getNombre());
//			System.out.println(pacs.get(i).getApellido());
//		}
//		
//		
//		
//		Usuario us=new Usuario();
//		System.out.println("ingresar id usuario:");	
//		
//		us.setIdU(Integer.parseInt(s.nextLine()));
//		try {
//			us=ctrlUser.getById(us);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(us.getNombre());
//		System.out.println(us.getApellido());
//		System.out.println(us.getFecAlta());
//		
//		for(int i=0;i<us.getNivel().size();i++){			
//			System.out.println(us.getNivel().get(i).getIdNivel());
//			System.out.println(us.getNivel().get(i).getDescripcion());
//		}			
//		int j=0;
//		String salir;
//		ArrayList<Nivel> niv=new ArrayList<Nivel>();
//		Nivel n=new Nivel();
//		
//		try {
//			niv=ctrlNiv.getAll();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		for(int i=0;i<niv.size();i++){			
//			System.out.println(niv.get(i).getIdNivel());
//			System.out.println(niv.get(i).getDescripcion());
//		}	
//		
//		do {
//			System.out.println("Ingrese codigo de rol:");
//			n.setIdNivel(Integer.parseInt(s.nextLine()));
//			niv.add(n);
//			
//			
//			j++;	
//			System.out.println("desea salir? si= s");
//			salir=(s.nextLine());
//		}while (salir=="s");
//		us.setNivel(niv);
//		try {
//			ctrlUser.update(us);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println("actualizado correctamente!");
		
//		System.out.println("Notas del usuario:");
//		us.setNotas(s.nextLine());
//		try {
//			ctrlUser.update(us);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		System.out.println("ingresar id usuario:");	
//		
//		us.setIdU(Integer.parseInt(s.nextLine()));
		
//		System.out.println(us.getNotas());	
		
		
		s.close();
	}
}
