package logico;

public class Audio extends Recurso {
	private String tipoAudio;

	public Audio(String id, String nombre, int cantidadTotal, String tipoAudio) {
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
