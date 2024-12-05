package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.sun.org.apache.bcel.internal.generic.NEW;

import logico.Recurso;
import logico.SPEC;
import sun.misc.Cleaner;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class AgregarRecurso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigoRecurso;
	private JTextField txtNombreRecurso;
	private Recurso nuevoRecurso;
	private JSpinner spnCantidadRecurso;
	private JComboBox cbxTIpoRecurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarRecurso dialog = new AgregarRecurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarRecurso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarRecurso.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaVolumeThumb.png")));
		setTitle("Agregar recurso");
		setBounds(100, 100, 458, 255);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.menu);
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblCodigo = new JLabel("Codigo:");
				lblCodigo.setIcon(new ImageIcon(AgregarRecurso.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
				lblCodigo.setBounds(10, 24, 78, 14);
				panel.add(lblCodigo);
			}
			{
				txtCodigoRecurso = new JTextField();
				txtCodigoRecurso.setText("R-" + SPEC.getInstance().codRecurso);
				txtCodigoRecurso.setEditable(false);
				txtCodigoRecurso.setEnabled(false);
				txtCodigoRecurso.setBounds(141, 21, 117, 20);
				panel.add(txtCodigoRecurso);
				txtCodigoRecurso.setColumns(10);
			}
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setIcon(new ImageIcon(AgregarRecurso.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
				lblNombre.setBounds(10, 76, 78, 14);
				panel.add(lblNombre);
			}
			{
				JLabel lblTIpoRecurso = new JLabel("Tipo de recurso:");
				lblTIpoRecurso.setIcon(new ImageIcon(AgregarRecurso.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
				lblTIpoRecurso.setBounds(10, 126, 117, 14);
				panel.add(lblTIpoRecurso);
			}
			{
				txtNombreRecurso = new JTextField();
				txtNombreRecurso.setColumns(10);
				txtNombreRecurso.setBounds(141, 73, 117, 20);
				panel.add(txtNombreRecurso);
			}
			{
				JLabel lblCantidad = new JLabel("Cantidad:");
				lblCantidad.setIcon(new ImageIcon(AgregarRecurso.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
				lblCantidad.setBounds(270, 24, 84, 14);
				panel.add(lblCantidad);
			}
			{
				spnCantidadRecurso = new JSpinner();
				spnCantidadRecurso.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
				spnCantidadRecurso.setBounds(346, 21, 78, 20);
				panel.add(spnCantidadRecurso);
			}
			{
				cbxTIpoRecurso = new JComboBox();
				cbxTIpoRecurso.setModel(new DefaultComboBoxModel(new String[] {"<seleccione>", "Visual", "Audio"}));
				cbxTIpoRecurso.setBounds(141, 123, 117, 20);
				panel.add(cbxTIpoRecurso);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton RegistrarButton = new JButton("Registrar");
				RegistrarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Validar si algún campo está vacío o no seleccionado
						if (txtNombreRecurso.getText().trim().isEmpty()) {
							javax.swing.JOptionPane.showMessageDialog(
								null,
								"El campo 'Nombre' es obligatorio.",
								"Error",
								javax.swing.JOptionPane.ERROR_MESSAGE
							);
						} else if (cbxTIpoRecurso.getSelectedIndex() == 0) {
							javax.swing.JOptionPane.showMessageDialog(
								null,
								"Debe seleccionar un tipo de recurso.",
								"Error",
								javax.swing.JOptionPane.ERROR_MESSAGE
							);
						} else if ((int) spnCantidadRecurso.getValue() == 0) {
							javax.swing.JOptionPane.showMessageDialog(
								null,
								"La cantidad debe ser mayor a 0.",
								"Error",
								javax.swing.JOptionPane.ERROR_MESSAGE
							);
						} else {
							// Si pasa las validaciones, se registra el recurso
							nuevoRecurso = new Recurso(
								txtCodigoRecurso.getText(),
								cbxTIpoRecurso.getSelectedItem().toString(),
								txtNombreRecurso.getText(),
								(int) spnCantidadRecurso.getValue()
							);
							SPEC.getInstance().insertarRecurso(nuevoRecurso);
							javax.swing.JOptionPane.showMessageDialog(
								null,
								"Recurso registrado exitosamente.",
								"Información",
								javax.swing.JOptionPane.INFORMATION_MESSAGE
							);
							clean();
						}
					}
				});
						
				RegistrarButton.setActionCommand("OK");
				buttonPane.add(RegistrarButton);
				getRootPane().setDefaultButton(RegistrarButton);
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

	protected void clean() {
		// TODO Auto-generated method stub
		txtCodigoRecurso.setText("R-" + SPEC.getInstance().codRecurso);
		txtNombreRecurso.setText(" ");
		spnCantidadRecurso.setValue(new Integer(0));
	}

}
