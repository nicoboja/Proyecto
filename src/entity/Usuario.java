package entity;

import java.util.ArrayList;

public class Usuario {
	private int idU;
	private String user;
	private String nombre;
	private String apellido;
	private String correo;
	private String fecAlta;
	private String estado;
	private String fecEstado;
	private ArrayList<Nivel> nivel;
	
	public int getIdU() {
		return idU;
	}
	public void setIdU(int idU) {
		this.idU = idU;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getFecAlta() {
		return fecAlta;
	}
	public void setFecAlta(String fecAlta) {
		this.fecAlta = fecAlta;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFecEstado() {
		return fecEstado;
	}
	public void setFecEstado(String fecEstado) {
		this.fecEstado = fecEstado;
	}
	public ArrayList<Nivel> getNivel() {
		return nivel;
	}
	public void setNivel(ArrayList<Nivel> nivel) {
		this.nivel = nivel;
	}
	
	
}
