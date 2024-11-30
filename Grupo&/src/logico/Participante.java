package logico;

public class Participante extends Persona {
	private String direccion;
	private String email;
	
	public Participante(String codigo, String nombre, String apellido, String direccion, String email) {
		super(codigo, nombre, apellido);
		this.direccion = direccion;
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
