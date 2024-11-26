package logico;

import java.util.Date;

public class Conferencia extends Evento {
	private String tiempoConferencia;
	private String tema;
	private String CantPersonas;
	
	public Conferencia(String nombre, String idEvento, Date fechaEvento, String tipoEvento, String tiempoConferencia,
			String tema, String cantPersonas) {
		super(nombre, idEvento, fechaEvento, tipoEvento);
		this.tiempoConferencia = tiempoConferencia;
		this.tema = tema;
		CantPersonas = cantPersonas;
	}

	public String getTiempoConferencia() {
		return tiempoConferencia;
	}

	public void setTiempoConferencia(String tiempoConferencia) {
		this.tiempoConferencia = tiempoConferencia;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getCantPersonas() {
		return CantPersonas;
	}

	public void setCantPersonas(String cantPersonas) {
		CantPersonas = cantPersonas;
	}
	
}
