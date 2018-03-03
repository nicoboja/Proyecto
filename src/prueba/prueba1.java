package prueba;

import java.util.ArrayList;
import java.util.Scanner;

import controlers.CtrlABMNivel;
import controlers.CtrlABMPaciente;
import controlers.CtrlABMUsuario;
import entity.Nivel;
import entity.Paciente;
import entity.Usuario;

public class prueba1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		CtrlABMPaciente ctrlPac=new CtrlABMPaciente();
		Paciente p=new Paciente();
		System.out.println("Ingresar Paciente");
		System.out.println("Ingresar DNI:");
		p.setNroDoc(Integer.parseInt(s.nextLine()));
		try {
			if(ctrlPac.validaDoc(p)){
				System.out.println("ya existeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			}else{
				System.out.println("no exiets");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		CtrlABMUsuario ctrlUser=new CtrlABMUsuario();
//		CtrlABMNivel ctrlNiv=new CtrlABMNivel();
//		Scanner s=new Scanner(System.in);
//		Usuario u=new Usuario();
//		Nivel n=new Nivel();
//		ArrayList<Nivel> niv= new ArrayList<Nivel>();
//		u.setUser("bruno");
//		try {
//			u=ctrlUser.getByUser(u);
//		} catch (Exception e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		System.out.println(u.getApellido());
//
//		System.out.println("Ingresar USUARIO");
//		System.out.println("Ingresar Nombre:");
//		u.setNombre(s.nextLine());
//		System.out.println("Ingresar Apellido:");
//		u.setApellido(s.nextLine());
//		System.out.println("Ingresar Mail:");
//		u.setCorreo(s.nextLine());
//		u.setEstado("Habilitado");
//		System.out.println("Ingresar User:");
//		u.setUser(s.nextLine());
//		System.out.println("Ingresar pass:");
//		u.setPass(s.nextLine());
//		try {
//			niv=ctrlNiv.getAll();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		u.setNivel(niv);
//
//
//		try {
//			ctrlUser.add(u);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
