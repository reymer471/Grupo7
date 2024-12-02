package logico;

import java.util.ArrayList;

public class SPEC {
	
	private ArrayList<TrabajoCientifico>mistrabajosCientificos;
	private ArrayList<Evento>misEventos;
	private ArrayList<Persona>misPersonas;
	private ArrayList<Comision>misComisiones;
	private ArrayList<Recurso>misRecursos;
	
	public static int codTrajCientifico = 1;
	public static int codEvento = 1; 
	public static int codPersona = 1;
	public static int codComision = 1;
	public static int codRecurso = 1;
	
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
	
	public void insertarRecurso(Recurso nuevoRecurso) {
		// TODO Auto-generated method stub
		misRecursos.add(nuevoRecurso);
		codRecurso++;
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
			i++;
		}
		return t;
	}
	public TrabajoCientifico buscarTCientificoByNombre (String nombre) {
		TrabajoCientifico t = null;
		boolean encontrado = false; 
		int i = 0;
		while (i < mistrabajosCientificos.size() && !encontrado) {
			if(mistrabajosCientificos.get(i).getTitulo().equalsIgnoreCase(nombre)) {
				t = mistrabajosCientificos.get(i);
				encontrado = true;
			}
			i++;
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
	
	public Jurado buscarJuradoByNombre(String nombre) {
		// TODO Auto-generated method stub
		Jurado jurado = null;
		boolean encontrado = false; 
		int i = 0;
		
		while (i < misPersonas.size() && !encontrado) {
			Persona persona =  misPersonas.get(i);
			
			if(persona instanceof Jurado) {
				
				if(persona.getNombre().equalsIgnoreCase(nombre)) {
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
	
	public Participante buscarParticipanteByNombre(String nombre) {
		// TODO Auto-generated method stub
		Participante participante = null;
		boolean encontrado = false; 
		int i = 0;
		
		while (i < misPersonas.size() && !encontrado) {
			Persona persona =  misPersonas.get(i);
			
			if(persona instanceof Participante) {
				
				if(persona.getNombre().equalsIgnoreCase(nombre)) {
					participante = (Participante) persona;
					encontrado = true;
				}
			}
			
			i++;
		}
		return (Participante) participante;
	}

	public Evento buscarEventoByCodigo(String idevento) {
		// TODO Auto-generated method stub
		Evento evento = null;
		boolean found = false; 
		int i = 0; 
		
		while(i < misEventos.size() && !found) {
			if (misEventos.get(i).getIdEvento().equalsIgnoreCase(idevento)) {
				evento = misEventos.get(i);
				found = true;
			}
			i++;
		}
		return evento;
	}

	public Evento buscarEventoByNombre(String nombre) {
		// TODO Auto-generated method stub
		Evento evento = null;
		boolean found = false; 
		
		int i = 0; 
		
		while(i < misEventos.size() && !found) {
			if (misEventos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				evento = misEventos.get(i);
				found = true;
			}
			i++;
		}
		return evento;
	}

	public Comision buscarComisionById(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comision buscarComisionByNombre(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	

	


	
	

}
