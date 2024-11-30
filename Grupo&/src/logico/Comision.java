package logico;

import java.util.ArrayList;

public class Comision {
	
	private String codigocomision;
	private String nombreComision;
	private ArrayList<Jurado>losJurados;

	public Comision(String nombreComision, String codigocomision) {
		super();
		this.nombreComision = nombreComision;
		this.codigocomision = codigocomision;
		losJurados = new ArrayList<>();
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
