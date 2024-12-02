package logico;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String contrasena;
	private String pass;
	
	public Usuario(String username, String contrasena, String pass) {
		super();
		this.username = username;
		this.contrasena = contrasena;
		this.pass = pass;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
   
	
}
