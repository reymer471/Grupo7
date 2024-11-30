package logico;

public abstract class infoEvento {
	
	protected String temaEvento;
	protected String numeroPersonas;
	protected String duracionEvento;
	
	public infoEvento(String temaEvento, String numeroPersonas, String duracionEvento) {
		super();
		this.temaEvento = temaEvento;
		this.numeroPersonas = numeroPersonas;
		this.duracionEvento = duracionEvento;
	}
	public String getTemaEvento() {
		return temaEvento;
	}
	public void setTemaEvento(String temaEvento) {
		this.temaEvento = temaEvento;
	}
	public String getNumeroPersonas() {
		return numeroPersonas;
	}
	public void setNumeroPersonas(String numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}
	public String getDuracionEvento() {
		return duracionEvento;
	}
	public void setDuracionEvento(String duracionEvento) {
		this.duracionEvento = duracionEvento;
	}
	
}
