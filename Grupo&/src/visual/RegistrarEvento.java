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
	private JTextField textField;
	private JTextField textField_1;

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
				JLabel lblNewLabel = new JLabel("Evento codigo:");
				lblNewLabel.setBounds(10, 26, 79, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setBounds(10, 77, 46, 14);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Fecha:");
				lblNewLabel_2.setBounds(244, 120, 46, 14);
				panel.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Tipo de evento: ");
				lblNewLabel_3.setBounds(10, 120, 79, 14);
				panel.add(lblNewLabel_3);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Capacidad:");
				lblNewLabel_4.setBounds(10, 163, 119, 14);
				panel.add(lblNewLabel_4);
			}
			
			textField = new JTextField();
			textField.setBounds(66, 74, 350, 20);
			panel.add(textField);
			textField.setColumns(10);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(99, 116, 119, 20);
			panel.add(comboBox);
			
			JSpinner spinner = new JSpinner();
			spinner.setBounds(289, 117, 127, 20);
			panel.add(spinner);
			{
				JSpinner spinner_1 = new JSpinner();
				spinner_1.setBounds(99, 160, 119, 20);
				panel.add(spinner_1);
			}
			{
				JLabel lblDuracion = new JLabel("Duracion:");
				lblDuracion.setBounds(244, 163, 46, 14);
				panel.add(lblDuracion);
			}
			{
				JSpinner spinner_1 = new JSpinner();
				spinner_1.setBounds(299, 160, 117, 20);
				panel.add(spinner_1);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(88, 23, 120, 20);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Cancelar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Registrar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
