package logico;

import java.util.ArrayList;

public class SPEC {
	
	private ArrayList<TrabajoCientifico>mistrabajosCientifico;
	private ArrayList<Evento>misEventos;
	private ArrayList<Persona>misPersonas;
	private ArrayList<Comision>misComisiones;
	
	public SPEC(ArrayList<TrabajoCientifico> mistrabajosCientifico, ArrayList<Evento> misEventos,
			ArrayList<Persona> misPersonas, ArrayList<Comision> misComisiones) {
		super();
		this.mistrabajosCientifico = mistrabajosCientifico;
		this.misEventos = misEventos;
		this.misPersonas = misPersonas;
		this.misComisiones = misComisiones;
	}

	public ArrayList<TrabajoCientifico> getMistrabajosCientifico() {
		return mistrabajosCientifico;
	}

	public void setMistrabajosCientifico(ArrayList<TrabajoCientifico> mistrabajosCientifico) {
		this.mistrabajosCientifico = mistrabajosCientifico;
	}

	public ArrayList<Evento> getMisEventos() {
		return misEventos;
	}

	public void setMisEventos(ArrayList<Evento> misEventos) {
		this.misEventos = misEventos;
	}

	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}

	public void setMisPersonas(ArrayList<Persona> misPersonas) {
		this.misPersonas = misPersonas;
	}

	public ArrayList<Comision> getMisComisiones() {
		return misComisiones;
	}

	public void setMisComisiones(ArrayList<Comision> misComisiones) {
		this.misComisiones = misComisiones;
	}

}
