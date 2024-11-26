package logico;

import java.util.Date;

public abstract class Evento {
	protected String nombre;
	protected String idEvento;
	protected Date fechaEvento;
	protected String tipoEvento;
	
	public Evento(String nombre, String idEvento, Date fechaEvento, String tipoEvento) {
		super();
		this.nombre = nombre;
		this.idEvento = idEvento;
		this.fechaEvento = fechaEvento;
		this.tipoEvento = tipoEvento;
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
	




}
