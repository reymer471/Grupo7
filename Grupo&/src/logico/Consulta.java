package logico;

public class Consulta extends infoEvento {
	private String tipoConsulta;
	private String disponibilidadEvento;
	
	public Consulta(String temaEvento, String numeroPersonas, String duracionEvento, String tipoConsulta,
			String disponibilidadEvento) {
		super(temaEvento, numeroPersonas, duracionEvento);
		this.tipoConsulta = tipoConsulta;
		this.disponibilidadEvento = disponibilidadEvento;
	}

	public String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public String getDisponibilidadEvento() {
		return disponibilidadEvento;
	}

	public void setDisponibilidadEvento(String disponibilidadEvento) {
		this.disponibilidadEvento = disponibilidadEvento;
	}
   
}
