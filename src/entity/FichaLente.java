package entity;

public class FichaLente {
	private int idFicha;
	private String fecEntrada;
	private String armazon;
	private String modelo;
	private String color;
	private LenteTipo Tipo;
	private LenteMaterial Material;
	private float codesf;
	private float codcil;
	private float coiesf;
	private float coicil;
	private float lodesf;
	private float lodcil;
	private int codgrados;
	private int coigrados;
	private int lodgrados;
	private int loigrados;
	private float costoArm;
	private float costoCrist;
	private float sena;
	private Paciente paciente;
	private Usuario optico;
	private Usuario tallerista;
	private String estado;
	private String fecEstado;
	private String fecReceta;
	private String fecEstimadaS;
	private String notas;
	
	public int getIdFicha() {
		return idFicha;
	}
	public void setIdFicha(int idFicha) {
		this.idFicha = idFicha;
	}
	public String getFecEntrada() {
		return fecEntrada;
	}
	public void setFecEntrada(String fecEntrada) {
		this.fecEntrada = fecEntrada;
	}
	public String getArmazon() {
		return armazon;
	}
	public void setArmazon(String armazon) {
		this.armazon = armazon;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public LenteTipo getTipo() {
		return Tipo;
	}
	public void setTipo(LenteTipo tipo) {
		Tipo = tipo;
	}
	public LenteMaterial getMaterial() {
		return Material;
	}
	public void setMaterial(LenteMaterial material) {
		Material = material;
	}
	public float getCodesf() {
		return codesf;
	}
	public void setCodesf(float codesf) {
		this.codesf = codesf;
	}
	public float getCodcil() {
		return codcil;
	}
	public void setCodcil(float codcil) {
		this.codcil = codcil;
	}
	public float getCoiesf() {
		return coiesf;
	}
	public void setCoiesf(float coiesf) {
		this.coiesf = coiesf;
	}
	public float getCoicil() {
		return coicil;
	}
	public void setCoicil(float coicil) {
		this.coicil = coicil;
	}
	public float getLodesf() {
		return lodesf;
	}
	public void setLodesf(float lodesf) {
		this.lodesf = lodesf;
	}
	public float getLodcil() {
		return lodcil;
	}
	public void setLodcil(float lodcil) {
		this.lodcil = lodcil;
	}
	public int getCodgrados() {
		return codgrados;
	}
	public void setCodgrados(int codgrados) {
		this.codgrados = codgrados;
	}
	public int getCoigrados() {
		return coigrados;
	}
	public void setCoigrados(int coigrados) {
		this.coigrados = coigrados;
	}
	public int getLodgrados() {
		return lodgrados;
	}
	public void setLodgrados(int lodgrados) {
		this.lodgrados = lodgrados;
	}
	public int getLoigrados() {
		return loigrados;
	}
	public void setLoigrados(int loigrados) {
		this.loigrados = loigrados;
	}
	public float getCostoArm() {
		return costoArm;
	}
	public void setCostoArm(float costoArm) {
		this.costoArm = costoArm;
	}
	public float getCostoCrist() {
		return costoCrist;
	}
	public void setCostoCrist(float costoCrist) {
		this.costoCrist = costoCrist;
	}
	public float getSena() {
		return sena;
	}
	public void setSena(float sena) {
		this.sena = sena;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Usuario getOptico() {
		return optico;
	}
	public void setOptico(Usuario optico) {
		this.optico = optico;
	}
	public Usuario getTallerista() {
		return tallerista;
	}
	public void setTallerista(Usuario tallerista) {
		this.tallerista = tallerista;
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
	public String getFecReceta() {
		return fecReceta;
	}
	public void setFecReceta(String fecReceta) {
		this.fecReceta = fecReceta;
	}
	public String getFecEstimadaS() {
		return fecEstimadaS;
	}
	public void setFecEstimadaS(String fecEstimadaS) {
		this.fecEstimadaS = fecEstimadaS;
	}
	public String getNotas() {
		return notas;
	}
	public void setNotas(String notas) {
		this.notas = notas;
	} 	
			
}