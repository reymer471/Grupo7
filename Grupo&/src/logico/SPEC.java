package logico;

import java.util.ArrayList;

public class SPEC {
	
	private ArrayList<TrabajoCientifico>mistrabajosCientificos;
	private ArrayList<Evento>misEventos;
	private ArrayList<Persona>misPersonas;
	private ArrayList<Comision>misComisiones;
	
	public static int codTrajCientifico = 1;
	public static int codEvento = 1; 
	public static int codPersona = 1;
	public static int codComision = 1;
	
	private static SPEC sistemaSpec = null;
	
	public SPEC() {
		
		super();
		mistrabajosCientificos = new ArrayList<>();
		misEventos = new ArrayList<>();
		misPersonas = new ArrayList<>();
		misComisiones = new ArrayList<>();
	}
	
	public static SPEC getInstance() {
		if(sistemaSpec == null) {
			sistemaSpec = new SPEC();
		}
		return sistemaSpec;
	}

	public ArrayList<TrabajoCientifico> getMistrabajosCientificos() {
		return mistrabajosCientificos;
	}

	public void setMistrabajosCientifico(ArrayList<TrabajoCientifico> mistrabajosCientificos) {
		this.mistrabajosCientificos = mistrabajosCientificos;
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
	
	
	public void insertarpersona(Persona persona) {
		misPersonas.add(persona);
		codPersona++;
	}
	
	public void insertarTrabajoCientifico(TrabajoCientifico t) {
		mistrabajosCientificos.add(t);
		codTrajCientifico++;
	}
	
	public void inertarEvento(Evento event) {
		misEventos.add(event);
		codEvento++;
	}
	
	public void insertarComision(Comision comision) {
		misComisiones.add(comision);
		codComision++;
	}

}
