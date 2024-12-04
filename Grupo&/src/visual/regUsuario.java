package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class regUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			regUsuario dialog = new regUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public regUsuario() {
		setBounds(100, 100, 405, 229);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel nombre = new JLabel("Nombre Usuario:");
		nombre.setBounds(10, 11, 101, 14);
		panel.add(nombre);
		
		JLabel password = new JLabel("Password:");
		password.setBounds(203, 11, 73, 14);
		panel.add(password);
		
		JLabel tipo = new JLabel("Tipo:");
		tipo.setBounds(10, 78, 46, 14);
		panel.add(tipo);
		
		JLabel confirmpassword = new JLabel("Confirm Password:");
		confirmpassword.setBounds(203, 78, 135, 14);
		panel.add(confirmpassword);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrador", "Comercial"}));
		comboBox.setToolTipText("hola");
		comboBox.setBounds(10, 103, 135, 20);
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 135, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(203, 36, 135, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(203, 103, 135, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ingresar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						  // Obtener los valores ingresados por el usuario
		                String nombreUsuario = textField.getText().trim();
		                String password = textField_1.getText().trim();
		                String confirmPassword = textField_2.getText().trim();
		                String tipoUsuario = comboBox.getSelectedItem().toString();

		                // Validar que los campos no estén vacíos
		                if (nombreUsuario.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || "<Seleccione>".equals(tipoUsuario)) {
		                    JOptionPane.showMessageDialog(
		                        regUsuario.this,
		                        "Por favor complete todos los campos.",
		                        "Campos incompletos",
		                        JOptionPane.WARNING_MESSAGE
		                    );
		                } else if (!password.equals(confirmPassword)) {
		                    // Validar que las contraseñas coincidan
		                    JOptionPane.showMessageDialog(
		                        regUsuario.this,
		                        "Las contraseñas no coinciden.",
		                        "Error de contraseña",
		                        JOptionPane.ERROR_MESSAGE
		                    );
		                } else {
		                    // Si todo está completo, mostrar un mensaje de éxito
		                    JOptionPane.showMessageDialog(
		                        regUsuario.this,
		                        "Usuario registrado exitosamente.",
		                        "Registro completado",
		                        JOptionPane.INFORMATION_MESSAGE
		                    );
		                    // Aquí puedes agregar lógica adicional, como guardar el usuario
		                }
		            }
		        
					
				});
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	
    

	
}
