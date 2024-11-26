package logico;

import java.util.Date;

public class MesasRedondas extends Evento {
	
	private String moderador;
	private String participantes;
	
	public MesasRedondas(String nombre, String idEvento, Date fechaEvento, String tipoEvento, String moderador,
			String participantes) {
		super(nombre, idEvento, fechaEvento, tipoEvento);
		this.moderador = moderador;
		this.participantes = participantes;
	}

	public String getModerador() {
		return moderador;
	}

	public void setModerador(String moderador) {
		this.moderador = moderador;
	}

	public String getParticipantes() {
		return participantes;
	}

	public void setParticipantes(String participantes) {
		this.participantes = participantes;
	}
	

}
