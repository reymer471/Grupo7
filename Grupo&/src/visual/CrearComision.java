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
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class CrearComision extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCodigoComision;
	private JTextField txtJurado1;
	private JTextField txtJurado2;
	private JTextField txtJurado3;
	private JTextField txtJurado4;
	private JTextField txtJurado5;

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
		setTitle("Registrar Comision");
		setBounds(100, 100, 450, 340);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(null);
				{
					JLabel lblCodcomision = new JLabel("Codigo:");
					lblCodcomision.setBounds(10, 11, 90, 14);
					panel_1.add(lblCodcomision);
				}
				{
					JLabel lblNombre = new JLabel("Nombre: ");
					lblNombre.setBounds(10, 53, 79, 14);
					panel_1.add(lblNombre);
				}
				{
					txtNombre = new JTextField();
					txtNombre.setBounds(110, 50, 227, 20);
					panel_1.add(txtNombre);
					txtNombre.setColumns(10);
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
						JLabel lbljurado1 = new JLabel("Jurado 1");
						lbljurado1.setBounds(10, 11, 62, 14);
						panel_3.add(lbljurado1);
					}
					{
						JLabel lblJurado2 = new JLabel("Jurado 2");
						lblJurado2.setBounds(10, 46, 62, 14);
						panel_3.add(lblJurado2);
					}
					{
						JLabel lblJurado3 = new JLabel("Jurado 3");
						lblJurado3.setBounds(10, 82, 62, 14);
						panel_3.add(lblJurado3);
					}
					{
						JLabel lblJurado4 = new JLabel("Jurado 4");
						lblJurado4.setBounds(202, 11, 62, 14);
						panel_3.add(lblJurado4);
					}
					{
						JLabel lblJurado5 = new JLabel("Jurado 5");
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
					JLabel lblNewLabel = new JLabel("Agregue los jurados");
					lblNewLabel.setBounds(10, 11, 143, 14);
					panel_2.add(lblNewLabel);
				}
				
				txtCodigoComision = new JTextField();
				txtCodigoComision.setEnabled(false);
				txtCodigoComision.setColumns(10);
				txtCodigoComision.setBounds(110, 8, 136, 20);
				panel_1.add(txtCodigoComision);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
