package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import org.omg.PortableInterceptor.USER_EXCEPTION;

//import com.sun.java.util.jar.pack.Package.File;

import logico.Control;
import logico.Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream gestion;
				FileOutputStream gestion2;
				ObjectInputStream gestionRead;
				ObjectOutputStream gestionWrite;
				
				try {
					gestion = new FileInputStream("gestion.dat");
					gestionRead = new ObjectInputStream(gestion);
					Control temp = (Control)gestionRead.readObject();
					Control.setControl(temp);
					gestion.close();
					gestionRead.close();
					
				}catch (FileNotFoundException e) {
					try {
						gestion2 = new FileOutputStream("gestion.dat");
						gestionWrite = new ObjectOutputStream(gestion2);
						Usuario aux = new Usuario("Administrador", "Admin" , "Admin");
						Control.getInstance().regUsuario(aux);
						gestionWrite.writeObject(Control.getInstance());
						gestion2.close();
						gestionWrite.close();
					}catch(FileNotFoundException e1) {
					}catch (IOException e1) {
					}
				}catch(IOException e) {
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				/*try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}*/
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setBackground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-information@2x.png")));
		setTitle("Gestion PUCMM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 400, 305);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\u00A1Bienvenido al gestor de eventos de nuestra alma mater!");
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setFont(new Font("Calisto MT", Font.ITALIC, 13));
		lblNewLabel.setBounds(40, 13, 304, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaTimeThumb.png")));
		lblNewLabel_1.setBounds(29, 75, 90, 14);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(131, 72, 152, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaTimeThumb.png")));
		lblNewLabel_2.setBounds(29, 164, 93, 14);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 161, 152, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Control.getInstance().confirmLogin(textField, textField_1.getText())) {
					Principal frame = new Principal();
					dispose();
					frame.setVisible(true);
							
				};
				
			}
		});	
				
				
				btnNewButton.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        String username = textField.getText().trim();  
				        String password = textField_1.getText().trim();  

				        if (username.isEmpty() || password.isEmpty()) {  // Verificación si los campos están vacíos
				            JOptionPane.showMessageDialog(Login.this, "Por favor, complete todos los campos.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);  // Mostrar mensaje si hay campos vacíos
				        } else {
				            if (Control.getInstance().confirmLogin(username, password)) { 
				                Principal frame = new Principal(); 
				                if (Control.getLoginUser().getTipo1().equalsIgnoreCase("comercial")) {
		                            // Bloquear el menú de administración para usuario comercial
		                            frame.desactivarMenuAdministracion();
		                        }
		                        dispose();
				                frame.setVisible(true);  // Mostrar la ventana Principal
				            } else {
				                JOptionPane.showMessageDialog(Login.this, "Usuario o contraseña incorrectos.", "Error de Login", JOptionPane.ERROR_MESSAGE);  // Mostrar mensaje si las credenciales son incorrectas
				            }
				        }
				    }
				});
	
				
				
		btnNewButton.setBounds(235, 212, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Inserte su nombre de usuario");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		lblNewLabel_3.setBounds(29, 49, 213, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Inserte su contrase\u00F1a:");
		lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		lblNewLabel_4.setBounds(29, 130, 159, 14);
		panel.add(lblNewLabel_4);
		
		
	}
}











