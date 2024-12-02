package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class RegistrarEvento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtEventoCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarEvento dialog = new RegistrarEvento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarEvento() {
		setTitle("Registrar Evento");
		setBounds(100, 100, 452, 309);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblCodEvento = new JLabel("Evento codigo:");
				lblCodEvento.setBounds(10, 26, 79, 14);
				panel.add(lblCodEvento);
			}
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(10, 77, 46, 14);
				panel.add(lblNombre);
			}
			{
				JLabel lblFechas = new JLabel("Fecha:");
				lblFechas.setBounds(244, 120, 46, 14);
				panel.add(lblFechas);
			}
			{
				JLabel lblTipoEvento = new JLabel("Tipo de evento: ");
				lblTipoEvento.setBounds(10, 120, 79, 14);
				panel.add(lblTipoEvento);
			}
			{
				JLabel lblCapacidad = new JLabel("Capacidad:");
				lblCapacidad.setBounds(10, 163, 119, 14);
				panel.add(lblCapacidad);
			}
			
			txtNombre = new JTextField();
			txtNombre.setBounds(66, 74, 350, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JComboBox cbxTipoEvento = new JComboBox();
			cbxTipoEvento.setBounds(99, 116, 119, 20);
			panel.add(cbxTipoEvento);
			
			JSpinner spnFecha = new JSpinner();
			spnFecha.setBounds(289, 117, 127, 20);
			panel.add(spnFecha);
			{
				JSpinner spnCapacidad = new JSpinner();
				spnCapacidad.setBounds(99, 160, 119, 20);
				panel.add(spnCapacidad);
			}
			{
				JLabel lblDuracion = new JLabel("Duracion:");
				lblDuracion.setBounds(244, 163, 46, 14);
				panel.add(lblDuracion);
			}
			{
				JSpinner spnDuracion = new JSpinner();
				spnDuracion.setBounds(299, 160, 117, 20);
				panel.add(spnDuracion);
			}
			{
				txtEventoCodigo = new JTextField();
				txtEventoCodigo.setBounds(88, 23, 120, 20);
				panel.add(txtEventoCodigo);
				txtEventoCodigo.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelarButton = new JButton("Cancelar");
				cancelarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelarButton.setActionCommand("OK");
				buttonPane.add(cancelarButton);
				getRootPane().setDefaultButton(cancelarButton);
			}
			{
				JButton registrarButton = new JButton("Registrar");
				registrarButton.setActionCommand("Cancel");
				buttonPane.add(registrarButton);
			}
		}
	}
}
