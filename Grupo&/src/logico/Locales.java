package logico;

public class Locales extends Recurso {
	private String tipoAudio;

	public Locales(String id, String nombre, int cantidadTotal, String tipoAudio) {
		super(id, nombre, cantidadTotal);
		this.tipoAudio = tipoAudio;
	}

	public String getTipoAudio() {
		return tipoAudio;
	}

	public void setTipoAudio(String tipoAudio) {
		this.tipoAudio = tipoAudio;
	}
		
}
