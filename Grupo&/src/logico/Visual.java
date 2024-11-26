package logico;

public class Visual extends Recurso {
	private String proyectorTipo;

	public Visual(String id, String nombre, int cantidadTotal, String proyectorTipo) {
		super(id, nombre, cantidadTotal);
		this.proyectorTipo = proyectorTipo;
	}

	public String getProyectorTipo() {
		return proyectorTipo;
	}

	public void setProyectorTipo(String proyectorTipo) {
		this.proyectorTipo = proyectorTipo;
	}

}
