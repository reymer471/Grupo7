package logico;

public class Jurado extends Persona {
	private String experiencia;
	
	public Jurado(String codigo, String nombre, String apellido) {
		super(codigo, nombre, apellido);
		// TODO Auto-generated constructor stub
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	

}