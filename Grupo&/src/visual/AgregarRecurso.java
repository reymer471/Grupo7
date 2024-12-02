package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarRecurso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigoRecurso;
	private JTextField txtNombre;

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
		setTitle("Agregar Recurso");
		setBounds(100, 100, 458, 276);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblCodigo = new JLabel("Codigo:");
				lblCodigo.setBounds(10, 24, 78, 14);
				panel.add(lblCodigo);
			}
			{
				txtCodigoRecurso = new JTextField();
				txtCodigoRecurso.setEnabled(false);
				txtCodigoRecurso.setBounds(101, 21, 117, 20);
				panel.add(txtCodigoRecurso);
				txtCodigoRecurso.setColumns(10);
			}
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(10, 99, 46, 14);
				panel.add(lblNombre);
			}
			{
				JLabel lblTIpoRecurso = new JLabel("Tipo de recurso:");
				lblTIpoRecurso.setBounds(10, 143, 78, 14);
				panel.add(lblTIpoRecurso);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setColumns(10);
				txtNombre.setBounds(101, 96, 321, 20);
				panel.add(txtNombre);
			}
			{
				JLabel lblCantidad = new JLabel("Cantidad:");
				lblCantidad.setBounds(240, 143, 72, 14);
				panel.add(lblCantidad);
			}
			{
				JSpinner spnCantidad = new JSpinner();
				spnCantidad.setBounds(305, 140, 117, 20);
				panel.add(spnCantidad);
			}
			{
				JComboBox cbxTIpoRecurso = new JComboBox();
				cbxTIpoRecurso.setBounds(101, 140, 117, 20);
				panel.add(cbxTIpoRecurso);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton RegistrarButton = new JButton("Registrar");
				RegistrarButton.setActionCommand("OK");
				buttonPane.add(RegistrarButton);
				getRootPane().setDefaultButton(RegistrarButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
