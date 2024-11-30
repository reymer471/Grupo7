package logico;

public class Recurso {
	
	 private String id ;
	 private String nombre;
	 private int cantidadTotal;
	 private String tiporecurso;
 
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

	public String getTiporecurso() {
		return tiporecurso;
	}

	public void setTiporecurso(String tiporecurso) {
		this.tiporecurso = tiporecurso;
	}

}
