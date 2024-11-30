package logico;

import java.util.ArrayList;
import java.util.Date;

public class Evento {
	private String nombre;
	private String idEvento;
	private Date fechaEvento;
	private String tipoEvento;
	private infoEvento iEvento;
	private ArrayList<Recurso>recursosEvento;
	private ArrayList<TrabajoCientifico>trajsCientificosEvento;
	private ArrayList<Comision> comisionesevento;
	
	
	public Evento(String nombre, String idEvento, Date fechaEvento, String tipoEvento, infoEvento iEvento) {
		super();
		this.nombre = nombre;
		this.idEvento = idEvento;
		this.fechaEvento = fechaEvento;
		this.tipoEvento = tipoEvento;
		this.iEvento = iEvento;
		recursosEvento = new ArrayList<>();
		trajsCientificosEvento = new ArrayList<>();
		comisionesevento = new ArrayList<>();
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}

	public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public infoEvento getiEvento() {
		return iEvento;
	}

	public void setiEvento(infoEvento iEvento) {
		this.iEvento = iEvento;
	}

	public ArrayList<Recurso> getRecursosEvento() {
		return recursosEvento;
	}

	public void setRecursosEvento(ArrayList<Recurso> recursosEvento) {
		this.recursosEvento = recursosEvento;
	}

	public ArrayList<TrabajoCientifico> getTrajsCientificosEvento() {
		return trajsCientificosEvento;
	}

	public void setTrajsCientificosEvento(ArrayList<TrabajoCientifico> trajsCientificosEvento) {
		this.trajsCientificosEvento = trajsCientificosEvento;
	}

	public ArrayList<Comision> getComisionesevento() {
		return comisionesevento;
	}

	public void setComisionesevento(ArrayList<Comision> comisionesevento) {
		this.comisionesevento = comisionesevento;
	}
	
}
