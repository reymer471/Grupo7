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
	private JTextField textField;
	private JTextField textField_1;

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
				JLabel lblNewLabel = new JLabel("Codigo:");
				lblNewLabel.setBounds(10, 24, 78, 14);
				panel.add(lblNewLabel);
			}
			{
				textField = new JTextField();
				textField.setEnabled(false);
				textField.setBounds(101, 21, 117, 20);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setBounds(10, 99, 46, 14);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Tipo de recurso:");
				lblNewLabel_2.setBounds(10, 143, 78, 14);
				panel.add(lblNewLabel_2);
			}
			{
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(101, 96, 321, 20);
				panel.add(textField_1);
			}
			{
				JLabel lblCantidad = new JLabel("Cantidad:");
				lblCantidad.setBounds(240, 143, 72, 14);
				panel.add(lblCantidad);
			}
			{
				JSpinner spinner = new JSpinner();
				spinner.setBounds(305, 140, 117, 20);
				panel.add(spinner);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(101, 140, 117, 20);
				panel.add(comboBox);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
