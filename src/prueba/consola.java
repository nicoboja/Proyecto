package prueba;

import java.util.Scanner;

import controlers.CtrlABMUsuario;
import entity.Usuario;

public class consola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		Usuario usu=new Usuario();
		Usuario uLogueado=new Usuario();
		CtrlABMUsuario ctrlUser=new CtrlABMUsuario();
		
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

		
		
		s.close();
	}

}
