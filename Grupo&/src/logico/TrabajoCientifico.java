package logico;

import java.util.ArrayList;

public class TrabajoCientifico {
	
	private String numTrabajo;
	private String titulo;
	private String contexto;
	private String areacomision;
	private ArrayList<Participante>particiantes;
	
	public TrabajoCientifico(String numTrabajo, String titulo, String contexto, String areacomision,
			ArrayList<Participante> particiantes) {
		super();
		this.numTrabajo = numTrabajo;
		this.titulo = titulo;
		this.contexto = contexto;
		this.areacomision = areacomision;
		this.particiantes = particiantes;
	}

	public String getNumTrabajo() {
		return numTrabajo;
	}

	public void setNumTrabajo(String numTrabajo) {
		this.numTrabajo = numTrabajo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContexto() {
		return contexto;
	}

	public void setContexto(String contexto) {
		this.contexto = contexto;
	}

	public String getAreacomision() {
		return areacomision;
	}

	public void setAreacomision(String areacomision) {
		this.areacomision = areacomision;
	}

	public ArrayList<Participante> getParticiantes() {
		return particiantes;
	}

	public void setParticiantes(ArrayList<Participante> particiantes) {
		this.particiantes = particiantes;
	}
	
	

}
