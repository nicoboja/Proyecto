package prueba;

import java.util.ArrayList;
import java.util.Scanner;

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
		CtrlABMUsuario ctrlUser=new CtrlABMUsuario();
		ArrayList<Usuario> usus= new ArrayList<Usuario>();
		CtrlABMPaciente ctrlPac=new CtrlABMPaciente();
		ArrayList<Paciente> pacs= new ArrayList<Paciente>();
		
		System.out.println("Ingrese Usuario:");
		usu.setUser(s.nextLine());
		System.out.println("Ingrese Pass:");
		usu.setPass(s.nextLine());
		try {
			uLogueado=ctrlUser.login(usu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(uLogueado.getApellido());
		System.out.println(uLogueado.getNivel().get(0).getIdNivel());
		try {
			usus=ctrlUser.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<usus.size();i++){
			System.out.println(usus.get(i).getIdU());
			System.out.println(usus.get(i).getNombre());
			System.out.println(usus.get(i).getApellido());
			for(int v=0;v<usus.get(i).getNivel().size(); v++){
				System.out.println(usus.get(i).getNivel().get(v).getIdNivel());
				System.out.println(usus.get(i).getNivel().get(v).getDescripcion());
			}			
		}
		
		try {
			pacs=ctrlPac.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		for(int i=0;i<pacs.size();i++){
			System.out.println(pacs.get(i).getIdPac());
			System.out.println(pacs.get(i).getNombre());
			System.out.println(pacs.get(i).getApellido());
		}
		
		
		
		Usuario us=new Usuario();
		System.out.println("ingresar id usuario:");	
		
		us.setIdU(Integer.parseInt(s.nextLine()));
		try {
			us=ctrlUser.getById(us);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(us.getNombre());
		System.out.println(us.getApellido());
		System.out.println(us.getFecAlta());
		
		for(int i=0;i<us.getNivel().size();i++){			
			System.out.println(us.getNivel().get(i).getIdNivel());
			System.out.println(us.getNivel().get(i).getDescripcion());
		}			
		int j=0;
		String salir;
		ArrayList<Nivel> niv=new ArrayList<Nivel>();
		Nivel n=new Nivel();
		do {
			System.out.println("Ingrese codigo de rol:");
			n.setIdNivel(Integer.parseInt(s.nextLine()));
			niv.add(n);
			
			
			j++;	
			System.out.println("desea salir? si= s");
			salir=(s.nextLine());
		}while (salir=="s");
		us.setNivel(niv);
		try {
			ctrlUser.update(us);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("actualizado correctamente!");
		
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
		
		//System.out.println(us.getNotas());	

		
		
		s.close();
	}

}
