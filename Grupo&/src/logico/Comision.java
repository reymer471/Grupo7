package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Comision implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigocomision;
	private String nombreComision;
	private ArrayList<Jurado>losJurados;

	public Comision(String nombreComision, String codigocomision) {
		super();
		this.nombreComision = nombreComision;
		this.codigocomision = codigocomision;
		losJurados = new ArrayList<>();	
	}
	
	public void integrarComision(Jurado jurado) {
        losJurados.add(jurado);
        System.out.println("Jurado agregado a la comision: " + jurado.getNombre());
    }

	public String getNombreComision() {
		return nombreComision;
	}
	public void setNombreComision(String nombreComision) {
		this.nombreComision = nombreComision;
	}
	public String getCodigo() {
		return codigocomision;
	}
	public void setCodigo(String codigocomision) {
		this.codigocomision = codigocomision;
	}
	public ArrayList<Jurado> getLosJurados() {
		return losJurados;
	}
	public void setLosJurados(ArrayList<Jurado> losJurados) {
		this.losJurados = losJurados;
	}

}
