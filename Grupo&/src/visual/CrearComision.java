package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import logico.Comision;
import logico.Jurado;
import logico.Recurso;
import logico.SPEC;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class CrearComision extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreComision;
	private JTextField txtCodigoComision;
	private JTextField txtJurado1;
	private JTextField txtJurado2;
	private JTextField txtJurado3;
	private JTextField txtJurado4;
	private JTextField txtJurado5;
	private int response;
	private ArrayList<Jurado> newjurados = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearComision dialog = new CrearComision();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearComision() {
		setResizable(false);
		setTitle("Registrar comision");
		setBounds(100, 100, 450, 340);
		
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(null);
				{
					JLabel lblCodcomision = new JLabel("Codigo:");
					lblCodcomision.setBounds(31, 21, 90, 14);
					panel_1.add(lblCodcomision);
				}
				{
					JLabel lblNombre = new JLabel("Nombre: ");
					lblNombre.setBounds(31, 53, 79, 14);
					panel_1.add(lblNombre);
				}
				{
					txtNombreComision = new JTextField();
					txtNombreComision.setBounds(110, 50, 227, 20);
					panel_1.add(txtNombreComision);
					txtNombreComision.setColumns(10);
				}
				
				JPanel panel_2 = new JPanel();
				panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_2.setBounds(10, 81, 404, 166);
				panel_1.add(panel_2);
				panel_2.setLayout(null);
				{
					JPanel panel_3 = new JPanel();
					panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					panel_3.setBounds(10, 36, 384, 119);
					panel_2.add(panel_3);
					panel_3.setLayout(null);
					{
						JLabel lbljurado1 = new JLabel("Jurado 1:");
						lbljurado1.setBounds(10, 11, 62, 14);
						panel_3.add(lbljurado1);
					}
					{
						JLabel lblJurado2 = new JLabel("Jurado 2:");
						lblJurado2.setBounds(10, 46, 62, 14);
						panel_3.add(lblJurado2);
					}
					{
						JLabel lblJurado3 = new JLabel("Jurado 3:");
						lblJurado3.setBounds(10, 82, 62, 14);
						panel_3.add(lblJurado3);
					}
					{
						JLabel lblJurado4 = new JLabel("Jurado 4:");
						lblJurado4.setBounds(202, 11, 62, 14);
						panel_3.add(lblJurado4);
					}
					{
						JLabel lblJurado5 = new JLabel("Jurado 5:");
						lblJurado5.setBounds(202, 46, 62, 14);
						panel_3.add(lblJurado5);
					}
					{
						txtJurado1 = new JTextField();
						txtJurado1.setColumns(10);
						txtJurado1.setBounds(66, 8, 116, 20);
						panel_3.add(txtJurado1);
					}
					{
						txtJurado2 = new JTextField();
						txtJurado2.setColumns(10);
						txtJurado2.setBounds(66, 43, 116, 20);
						panel_3.add(txtJurado2);
					}
					{
						txtJurado3 = new JTextField();
						txtJurado3.setColumns(10);
						txtJurado3.setBounds(66, 79, 116, 20);
						panel_3.add(txtJurado3);
					}
					{
						txtJurado4 = new JTextField();
						txtJurado4.setColumns(10);
						txtJurado4.setBounds(258, 8, 116, 20);
						panel_3.add(txtJurado4);
					}
					{
						txtJurado5 = new JTextField();
						txtJurado5.setColumns(10);
						txtJurado5.setBounds(258, 43, 116, 20);
						panel_3.add(txtJurado5);
					}
				}
				{
					JLabel lblNewLabel = new JLabel("Agregue los jurados:");
					lblNewLabel.setBounds(10, 11, 143, 14);
					panel_2.add(lblNewLabel);
				}
				
				txtCodigoComision = new JTextField();
				txtCodigoComision.setEditable(false);
				txtCodigoComision.setText("C-" + SPEC.getInstance().codComision);
				txtCodigoComision.setColumns(10);
				txtCodigoComision.setBounds(110, 18, 136, 20);
				panel_1.add(txtCodigoComision);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				
					        if (txtNombreComision.getText().trim().isEmpty()) {
					            JOptionPane.showMessageDialog(
					                null,
					                "El campo 'Nombre' es obligatorio.",
					                "Error",
					                JOptionPane.ERROR_MESSAGE
					            );
					        } else if (cantJurados() < 3) {
					            JOptionPane.showMessageDialog(
					                null,
					                "Debe incluir al menos 3 jurados en la comisión.",
					                "Error",
					                JOptionPane.ERROR_MESSAGE
					            );
					        } else {
					            boolean todosValidos = true;

					            // Verificar jurado 1
					            if (!verificarJurado(txtJurado1.getText(), txtJurado1, "1")) {
					                todosValidos = false;
					            }

					            // Verificar jurado 2
					            if (!verificarJurado(txtJurado2.getText(), txtJurado2, "2")) {
					                todosValidos = false;
					            }

					            // Verificar jurado 3
					            if (!verificarJurado(txtJurado3.getText(), txtJurado3, "3")) {
					                todosValidos = false;
					            }
					            
					            // Verificar jurado 4
					            if (!verificarJurado(txtJurado3.getText(), txtJurado3, "4")) {
					                todosValidos = false;
					            }
					            
					            // Verificar jurado 5
					            if (!verificarJurado(txtJurado3.getText(), txtJurado3, "5")) {
					                todosValidos = false;
					            }
					        
					            if (todosValidos) {
						        	agregarcomision();
					                JOptionPane.showMessageDialog(
					                    null,
					                    "Comisión registrada exitosamente.",
					                    "Éxito",
					                    JOptionPane.INFORMATION_MESSAGE
					                );
					                
					                cleancomision();
						        }
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

	private void agregarcomision() {
		// TODO Auto-generated method stub
		Comision nueva = new Comision(txtNombreComision.getText(), txtCodigoComision.getText());
		nueva.setLosJurados(newjurados);
		
		SPEC.getInstance().insertarComision(nueva);
	}

	private void cleancomision() {
		// TODO Auto-generated method stub
		txtCodigoComision.setText("C-" + SPEC.getInstance().codComision );
		txtNombreComision.setText("");
		txtJurado1.setText("");
		txtJurado2.setText("");
		txtJurado3.setText("");
		txtJurado4.setText("");
		txtJurado5.setText("");
	}

	private int cantJurados() {
		// TODO Auto-generated method stub
		int cantjurados = 0;
		
		if(!txtJurado1.getText().isEmpty()) {
			cantjurados++;
		}
		if (!txtJurado2.getText().isEmpty()) {
			cantjurados++;
		}
		if (!txtJurado3.getText().isEmpty()) {
			cantjurados++;
		}
		if (!txtJurado4.getText().isEmpty()) {
			cantjurados++;
		}
		if (!txtJurado5.getText().isEmpty()) {
			cantjurados++;
		}
				
		return cantjurados;
	}
	
	private boolean juradoencontrado(String jurado) {
		boolean encontrado = false;
		
		Jurado jurado2 = SPEC.getInstance().buscarJuradoById(jurado);
		if(jurado2 != null) {
			encontrado = true;
		}
		
		return encontrado;
	}
	
	private boolean verificarJurado(String jurado, JTextField campoJurado, String numeroJurado) {
		
		 if (jurado.trim().isEmpty()) {
		        return true;
		   }
	
	    if (!juradoencontrado(jurado)) {
	        int response = JOptionPane.showConfirmDialog(
	            null,
	            "El jurado No. " + numeroJurado + " no existe. ¿Deseas volver a intentar?",
	            "Confirmación",
	            JOptionPane.YES_NO_OPTION,
	            JOptionPane.QUESTION_MESSAGE
	        );
	        

	        if (response == JOptionPane.YES_OPTION) {
	            campoJurado.setText(" ");
	            return false; 
	        } else {
	            JOptionPane.showMessageDialog(
	                null,
	                "No hemos podido crear la comisión.",
	                "Error",
	                JOptionPane.ERROR_MESSAGE
	            );
	            cleancomision();
	            return false; 
	        }
	    }else {
	    	
	    Jurado jurado2 = SPEC.getInstance().buscarJuradoById(jurado);
	    	newjurados.add(jurado2);
	    }
	    
	    return true; 
	}
}
