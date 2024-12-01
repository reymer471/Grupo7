package logico;

public class Jurado extends Persona {
	private String experiencia;
	private String especialidad;
	
    public Jurado(String codigo, String nombre, String apellido, String experiencia, String especialidad) {
        super(codigo, nombre, apellido);
		this.experiencia=experiencia;
		this.especialidad=especialidad;
	}
	
    @Override
    public void registrar() {
        System.out.println("Jurado registrado: " + nombre + " " + apellido);
    }

    @Override
    public void eliminar() {
        System.out.println("Jurado eliminado: " + nombre + " " + apellido);
    }

    public void evaluarTrabajo() {
        System.out.println(nombre + " está evaluando un trabajo.");
    }

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	

}
