package logico;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JTextField;

public class Control implements Serializable{
	
	private static final long  serialVersionUID = 1L;
	private ArrayList<Usuario> misUsers;
	private static Control control = null;
	private static Usuario LoginUser;
	
	private Control() {
		misUsers= new ArrayList<>();
	}
	

	public static Control getInstance() {
		if (control == null) {
			control = new Control();
		}
		return control;
	}
	
	
	public ArrayList <Usuario> getMisUsers(){
		return misUsers;
	}

	public static Control getControl() {
		return control;
	}


	public static void setControl(Control control) {
		Control.control = control;
	}


	public static  Usuario getLoginUser() {
		return LoginUser;
	}


	public void setLoginUser(Usuario loginUser) {
		LoginUser = loginUser;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setMisUsers(ArrayList<Usuario> misUsers) {
		this.misUsers = misUsers;
	}
	
	public void setLoginUser1(Usuario loginUser) {
		Control.LoginUser = loginUser;
	}
	
	public void regUsuario (Usuario usuario) {
		misUsers.add(usuario);
	}
	
	
	public boolean confirmLogin(String text, String text2) {
		boolean login = false;
		for (Usuario usuario : misUsers) {
			if(usuario.getUsername().equals(text) && usuario.getPass().equals(text2)) {
				LoginUser = usuario;
				login = true;
			}
		}
		return login;
	}


	public boolean confirmLogin(JTextField textField, String text) {
		// TODO Auto-generated method stub
		return false;
	}



	
	
}

