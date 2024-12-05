package logico;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String tipo;
	private String username;
	private String pass;
	
	public Usuario(String username, String tipo, String pass) {
		super();
		this.username = username;
		this.tipo= tipo;
		this.pass = pass;
	}
	
	public String getTipo1() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo =tipo;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
		
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}

	public Object getLoginUser() {
		// TODO Auto-generated method stub
		return null;
	}
   
	
}
