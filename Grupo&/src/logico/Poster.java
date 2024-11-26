package logico;

import java.util.Date;

public class Poster extends Evento {
	private String nomPoster;
	private String descripcion;
	private String categoria;
	
	public Poster(String nombre, String idEvento, Date fechaEvento, String tipoEvento, String nomPoster,
			String descripcion, String categoria) {
		super(nombre, idEvento, fechaEvento, tipoEvento);
		this.nomPoster = nomPoster;
		this.descripcion = descripcion;
		this.categoria = categoria;
	}

	public String getNomPoster() {
		return nomPoster;
	}

	public void setNomPoster(String nomPoster) {
		this.nomPoster = nomPoster;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	

}
