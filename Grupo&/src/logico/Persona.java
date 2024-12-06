package logico;

import java.io.Serializable;

public abstract class Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String codigo;
	protected String nombre;
	protected String apellido;
	
	
	public Persona(String codigo, String nombre, String apellido) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
	}

    public abstract void registrar();
    
    public abstract void eliminar();
    
    
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	
	
	

}
