package logico;

import java.io.Serializable;
import java.util.ArrayList;

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
	
	
	
}

