package prueba;

import java.util.ArrayList;
import java.util.Scanner;

import controlers.CtrlABMPaciente;
import controlers.CtrlABMUsuario;
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
		

		
		
		s.close();
	}

}
