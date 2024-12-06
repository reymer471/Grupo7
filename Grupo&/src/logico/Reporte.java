package logico;

import java.util.Date;

public class Reporte extends infoEvento {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoReporte; 
	private Date generacion;
	
	public Reporte(String temaEvento, String numeroPersonas, String duracionEvento, String tipoReporte,
			Date generacion) {
		super(temaEvento, numeroPersonas, duracionEvento);
		this.tipoReporte = tipoReporte;
		this.generacion = generacion;
	}

	public String getTipoReporte() {
		return tipoReporte;
	}

	public void setTipoReporte(String tipoReporte) {
		this.tipoReporte = tipoReporte;
	}

	public Date getGeneracion() {
		return generacion;
	}

	public void setGeneracion(Date generacion) {
		this.generacion = generacion;
	}
	
	

}
