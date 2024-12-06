package logico;

import java.io.Serializable;

public class Recurso implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
    private String tipoRecurso;
    private String nombre;
    private int cantidadTotal;


    public Recurso(String id, String tipoRecurso, String nombre, int cantidadTotal) {
        this.id = id;
        this.tipoRecurso = tipoRecurso;
        this.nombre = nombre;
        this.cantidadTotal = cantidadTotal;
    }

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCantidadTotal() {
		return cantidadTotal;
	}
	
	public void setCantidadTotal(int cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

	public String getTiporecurso() {
		return tipoRecurso;
	}

	public void setTiporecurso(String tiporecurso) {
		this.tipoRecurso = tiporecurso;
	}
	
	  public void usar() {
	        if (cantidadTotal > 0) {
	            cantidadTotal--;
	        } else {
	            System.out.println("No hay recursos disponibles.");
	        }
	    }

	    public void desuso() {
	        cantidadTotal++;
	    }

	    public boolean verificarDispo() {
	        return cantidadTotal > 0;
	    }

}
