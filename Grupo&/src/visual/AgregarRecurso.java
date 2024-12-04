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
		setTitle("Agregar recurso");
		setBounds(100, 100, 458, 255);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblCodigo = new JLabel("Codigo:");
				lblCodigo.setBounds(10, 24, 78, 14);
				panel.add(lblCodigo);
			}
			{
				txtCodigoRecurso = new JTextField();
				txtCodigoRecurso.setText("R-" + SPEC.getInstance().codRecurso);
				txtCodigoRecurso.setEditable(false);
				txtCodigoRecurso.setEnabled(false);
				txtCodigoRecurso.setBounds(101, 21, 117, 20);
				panel.add(txtCodigoRecurso);
				txtCodigoRecurso.setColumns(10);
			}
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(10, 76, 46, 14);
				panel.add(lblNombre);
			}
			{
				JLabel lblTIpoRecurso = new JLabel("Tipo de recurso:");
				lblTIpoRecurso.setBounds(10, 126, 78, 14);
				panel.add(lblTIpoRecurso);
			}
			{
				txtNombreRecurso = new JTextField();
				txtNombreRecurso.setColumns(10);
				txtNombreRecurso.setBounds(101, 73, 309, 20);
				panel.add(txtNombreRecurso);
			}
			{
				JLabel lblCantidad = new JLabel("Cantidad:");
				lblCantidad.setBounds(237, 126, 72, 14);
				panel.add(lblCantidad);
			}
			{
				spnCantidadRecurso = new JSpinner();
				spnCantidadRecurso.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
				spnCantidadRecurso.setBounds(293, 123, 117, 20);
				panel.add(spnCantidadRecurso);
			}
			{
				cbxTIpoRecurso = new JComboBox();
				cbxTIpoRecurso.setModel(new DefaultComboBoxModel(new String[] {"<seleccione>", "Visual", "Audio"}));
				cbxTIpoRecurso.setBounds(101, 123, 117, 20);
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
						nuevoRecurso = new Recurso(txtCodigoRecurso.getText(),cbxTIpoRecurso.getSelectedItem().toString(),txtNombreRecurso.getText(), (int) spnCantidadRecurso.getValue());
						SPEC.getInstance().insertarRecurso(nuevoRecurso);
						clean();
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
