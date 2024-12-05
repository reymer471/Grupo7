package logico;

import java.util.ArrayList;

public class TrabajoCientifico {
	
	private String codTrabajo;
	private String titulo;
	private String contexto;
	private Comision comisiontc;
	private ArrayList<Participante> particiantes;
	
	public TrabajoCientifico(String numTrabajo, String titulo, String contexto, Comision comisiontc) {
		super();
		this.codTrabajo = numTrabajo;
		this.titulo = titulo;
		this.contexto = contexto;
		this.comisiontc = comisiontc;
		particiantes = new ArrayList<>();
	}

	public String getCodTrabajo() {
		return codTrabajo;
	}

	public void setCodTrabajo(String codTrabajo) {
		this.codTrabajo = codTrabajo;
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

	public ArrayList<Participante> getParticiantes() {
		return particiantes;
	}

	public void setParticiantes(ArrayList<Participante> particiantes) {
		this.particiantes = particiantes;
	}
    public void agregarParticipante(Participante participante) {
        this.particiantes.add(participante);
    }

   
    public void eliminarParticipante(Participante participante) {
        this.particiantes.remove(participante);
    }

	public Comision getComisiontc() {
		return comisiontc;
	}

	public void setComisiontc(Comision comisiontc) {
		this.comisiontc = comisiontc;
	}
	

}
