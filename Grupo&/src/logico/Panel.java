package logico;

import java.util.Date;

public class Panel extends Evento {
	private String CantPublico;
	private String CantPanelistas;
	
	public Panel(String nombre, String idEvento, Date fechaEvento, String tipoEvento, String cantPublico,
			String cantPanelistas) {
		super(nombre, idEvento, fechaEvento, tipoEvento);
		CantPublico = cantPublico;
		CantPanelistas = cantPanelistas;
	}

	public String getCantPublico() {
		return CantPublico;
	}

	public void setCantPublico(String cantPublico) {
		CantPublico = cantPublico;
	}

	public String getCantPanelistas() {
		return CantPanelistas;
	}

	public void setCantPanelistas(String cantPanelistas) {
		CantPanelistas = cantPanelistas;
	}
	

}
