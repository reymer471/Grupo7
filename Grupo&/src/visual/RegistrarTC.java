package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import logico.Comision;
import logico.Participante;
import logico.SPEC;
import logico.TrabajoCientifico;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RegistrarTC extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTItuloTc;
	private JTextField txtCodigoTc;
	private JTextField txtEntradaParticipante;
	private ArrayList<String> opcionescomision = new ArrayList<>();
	private JComboBox cbxComision;
	
	private ArrayList<Participante> participantesAux;
	private JTextField txtDescripTc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarTC dialog = new RegistrarTC();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarTC() {
		setTitle("Registrar trabajo cientifico");
		setBounds(100, 100, 494, 334);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(null);
				
				JLabel lblCodigoTc = new JLabel("Codigo:");
				lblCodigoTc.setBounds(10, 24, 46, 14);
				panel_1.add(lblCodigoTc);
				
				JLabel lblTituloTc = new JLabel("Titulo:");
				lblTituloTc.setBounds(10, 64, 46, 14);
				panel_1.add(lblTituloTc);
				
				JLabel lblComision = new JLabel("Comision:");
				lblComision.setBounds(10, 153, 46, 14);
				panel_1.add(lblComision);
				
				cbxComision = new JComboBox();		
				cbxComision.setBounds(87, 150, 348, 20);
				panel_1.add(cbxComision);
				
				txtTItuloTc = new JTextField();
				txtTItuloTc.setBounds(87, 61, 348, 20);
				panel_1.add(txtTItuloTc);
				txtTItuloTc.setColumns(10);
				
				txtCodigoTc = new JTextField();
				txtCodigoTc.setText("TC-" + SPEC.getInstance().codTrajCientifico);
				txtCodigoTc.setEditable(false);
				txtCodigoTc.setBounds(87, 21, 86, 20);
				panel_1.add(txtCodigoTc);
				txtCodigoTc.setColumns(10);
				
				JLabel lblNewLabel = new JLabel("Participantes:");
				lblNewLabel.setBounds(10, 194, 116, 14);
				panel_1.add(lblNewLabel);
				
				JButton btnAgregar = new JButton("Agregar");
				btnAgregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!txtEntradaParticipante.getText().isEmpty()) {
							Participante participante = SPEC.getInstance().buscarParticipanteById(txtEntradaParticipante.getText());
							if(participante != null) {
								anadirParticipanteAAux(participante);
								
								javax.swing.JOptionPane.showMessageDialog(
										null,
										"Participante agregado exitosamente.",
										"Información",
										javax.swing.JOptionPane.INFORMATION_MESSAGE
									);
								 cleanEntrada();
							}
							
						}
					}
				});
				btnAgregar.setBounds(325, 190, 89, 23);
				panel_1.add(btnAgregar);
				
				txtEntradaParticipante = new JTextField();
				txtEntradaParticipante.setBounds(87, 191, 224, 20);
				panel_1.add(txtEntradaParticipante);
				txtEntradaParticipante.setColumns(10);
				
				JLabel lblDescrip = new JLabel("Descripcion:");
				lblDescrip.setBounds(10, 108, 59, 14);
				panel_1.add(lblDescrip);
				
				txtDescripTc = new JTextField();
				txtDescripTc.setBounds(87, 105, 348, 20);
				panel_1.add(txtDescripTc);
				txtDescripTc.setColumns(10);
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
						agregarTc();
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
		cleanOpciones();
		anadirOpcionesComisiones();
		actualizarComboBox();
	}
	
   

	protected void agregarTc() {
		// TODO Auto-generated method stub
		
		if (txtCodigoTc.getText().isEmpty() || txtDescripTc.getText().isEmpty() || participantesAux.isEmpty() || cbxComision.getSelectedIndex() == 0) {
			javax.swing.JOptionPane.showMessageDialog(
				null,
				"Debe completar todos los campos antes de continuar.",
				"Error",
				javax.swing.JOptionPane.ERROR_MESSAGE
			);
		
		}else {
			Comision comision = SPEC.getInstance().buscarComisionByNombre((String) cbxComision.getSelectedItem());
			TrabajoCientifico trabajoCientifico = new TrabajoCientifico(
					txtCodigoTc.getText(), 
					txtTItuloTc.getText(), 
					txtDescripTc.getText(), 
					comision
			);
			SPEC.getInstance().insertarTrabajoCientifico(trabajoCientifico);
			javax.swing.JOptionPane.showMessageDialog(
					null,
					"Trabajo Cientifico registrado exitosamente.",
					"Información",
					javax.swing.JOptionPane.INFORMATION_MESSAGE
				);
		}
		
		
	}

	protected void cleanEntrada() {
		// TODO Auto-generated method stub
		txtEntradaParticipante.setText(" ");
	}

	protected void anadirParticipanteAAux(Participante participante) {
		// TODO Auto-generated method stub
		participantesAux.add(participante);
	}

	private void anadirOpcionesComisiones() {
        if (!SPEC.getInstance().getMisComisiones().isEmpty()) {
            for (Comision comision : SPEC.getInstance().getMisComisiones()) {
                opcionescomision.add(comision.getNombreComision());
            }
        } else {
            opcionescomision.add("No elegida");
        }
    }

    private void cleanOpciones() {
        opcionescomision.clear();
        opcionescomision.add("<Seleccione>");
    }

    private void actualizarComboBox() {
        cbxComision.setModel(new DefaultComboBoxModel<>(new Vector<>(opcionescomision)));
    }
    
   
}
