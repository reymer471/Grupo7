package logico;

import java.util.ArrayList;

public class Comision {
	
private String nombreComision;
private String codigo;
private ArrayList<Jurado>losJurados;



public Comision(String nombreComision, String codigo, ArrayList<Jurado> losJurados) {
	super();
	this.nombreComision = nombreComision;
	this.codigo = codigo;
	this.losJurados = losJurados;
	
}
public String getNombreComision() {
	return nombreComision;
}
public void setNombreComision(String nombreComision) {
	this.nombreComision = nombreComision;
}
public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public ArrayList<Jurado> getLosJurados() {
	return losJurados;
}
public void setLosJurados(ArrayList<Jurado> losJurados) {
	this.losJurados = losJurados;
}



}
