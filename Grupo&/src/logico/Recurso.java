package logico;

public abstract class Recurso {
	
 protected String id ;
 protected String nombre;
 protected int cantidadTotal;
 
public Recurso(String id, String nombre, int cantidadTotal) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.cantidadTotal = cantidadTotal;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public int getCantidadTotal() {
	return cantidadTotal;
}

public void setCantidadTotal(int cantidadTotal) {
	this.cantidadTotal = cantidadTotal;
}
 



}
