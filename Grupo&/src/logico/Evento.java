package logico;

import java.util.ArrayList;
import java.util.Date;

public class Evento {
	
	    private String nombre;
	    private String idEvento;
	    private Date fechaEvento;
	    private String tipoEvento;
	    private infoEvento infoEvento;
	    private ArrayList<Recurso> recursosEvento;
	    private ArrayList<String> trabajosCientificos; 
	    private ArrayList<String> comisiones; 

	    
	    public Evento(String nombre, String idEvento, Date fechaEvento, String tipoEvento, infoEvento infoEvento) {
	        this.nombre = nombre;
	        this.idEvento = idEvento;
	        this.fechaEvento = fechaEvento;
	        this.tipoEvento = tipoEvento;
	        this.infoEvento = infoEvento;
	        this.recursosEvento = new ArrayList<>();
	        this.trabajosCientificos = new ArrayList<>();
	        this.comisiones = new ArrayList<>();
	    }


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getIdEvento() {
			return idEvento;
		}


		public void setIdEvento(String idEvento) {
			this.idEvento = idEvento;
		}


		public Date getFechaEvento() {
			return fechaEvento;
		}


		public void setFechaEvento(Date fechaEvento) {
			this.fechaEvento = fechaEvento;
		}


		public String getTipoEvento() {
			return tipoEvento;
		}


		public void setTipoEvento(String tipoEvento) {
			this.tipoEvento = tipoEvento;
		}


		public infoEvento getInfoEvento() {
			return infoEvento;
		}


		public void setInfoEvento(infoEvento infoEvento) {
			this.infoEvento = infoEvento;
		}


		public ArrayList<Recurso> getRecursosEvento() {
			return recursosEvento;
		}


		public void setRecursosEvento(ArrayList<Recurso> recursosEvento) {
			this.recursosEvento = recursosEvento;
		}


		public ArrayList<String> getTrabajosCientificos() {
			return trabajosCientificos;
		}


		public void setTrabajosCientificos(ArrayList<String> trabajosCientificos) {
			this.trabajosCientificos = trabajosCientificos;
		}


		public ArrayList<String> getComisiones() {
			return comisiones;
		}


		public void setComisiones(ArrayList<String> comisiones) {
			this.comisiones = comisiones;
		}
	    
		 public void crearEvento() {
		        System.out.println("Evento creado: " + nombre);
		    }

		    public void agregarRecurso(Recurso recurso) {
		        recursosEvento.add(recurso);
		    }

		    public void agregarTrabajoCientifico(String trabajo) {
		        trabajosCientificos.add(trabajo);
		    }

		    public void agregarComision(String comision) {
		        comisiones.add(comision);
		    }

}
