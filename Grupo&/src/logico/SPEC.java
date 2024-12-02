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
	
	
	public void insertarPersona(Persona persona) {
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
	
	public void eliminarPersona(Persona persona) {
		if (persona != null) {
			misPersonas.remove(persona);
		}
	}
	
	public void eliminarEvento(Evento evento) {
		if (evento != null) {
			misEventos.remove(evento);
		}
	}
	
	public TrabajoCientifico buscarTCientificoById(String id) {
		TrabajoCientifico t = null;
		boolean encontrado = false; 
		int i = 0;
		while (i < mistrabajosCientificos.size() && !encontrado) {
			if(mistrabajosCientificos.get(i).getCodTrabajo().equalsIgnoreCase(id)) {
				t = mistrabajosCientificos.get(i);
				encontrado = true;
			}
		}
		return t;
	}
	
	public TrabajoCientifico buscarTCientificoByNombre(String titulo) {
		TrabajoCientifico t = null;
		boolean encontrado = false; 
		int i = 0;
		while (i < mistrabajosCientificos.size() && !encontrado) {
			if(mistrabajosCientificos.get(i).getTitulo().equalsIgnoreCase(titulo)) {
				t = mistrabajosCientificos.get(i);
				encontrado = true;
			}
		}
		return t;
	}
	
	public Jurado buscarJuradoById(String id) {
		Jurado jurado = null;
		boolean encontrado = false; 
		int i = 0;
		
		while (i < misPersonas.size() && !encontrado) {
			Persona persona =  misPersonas.get(i);
			
			if(persona instanceof Jurado) {
				
				if(persona.getCodigo().equalsIgnoreCase(id)) {
					jurado = (Jurado) persona;
					encontrado = true;
				}
			}
			
			i++;
		}
		return (Jurado) jurado;
	}
	
	public Participante buscarParticipanteById(String id) {
		Participante participante = null;
		boolean encontrado = false; 
		int i = 0;
		
		while (i < misPersonas.size() && !encontrado) {
			Persona persona =  misPersonas.get(i);
			
			if(persona instanceof Participante) {
				
				if(persona.getCodigo().equalsIgnoreCase(id)) {
					participante = (Participante) persona;
					encontrado = true;
				}
			}
			
			i++;
		}
		return (Participante) participante;
	}

}
