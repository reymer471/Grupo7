package logico;

public class Usuario {
	
	public String username;
	public String contrasena;
	public String rol;
	
	public Usuario(String username, String contrasena, String rol) {
		super();
		this.username = username;
		this.contrasena = contrasena;
		this.rol = rol;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
