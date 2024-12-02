package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Consulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JRadioButton radioButtonEvento;
	private JRadioButton rdbtnTC;
	private JRadioButton rdbtnJurado;
	private JRadioButton rdbtnParticipante;
	private JRadioButton rdbtnComision;
	private JRadioButton rdbtnRecurso;
	private JRadioButton rdbtnCodigo;
	private JRadioButton rdbtnNombre;
	private JLabel lblNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Consulta dialog = new Consulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Consulta() {
		setTitle("Hacer Consulta");
		setBounds(100, 100, 501, 369);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_IngreseCodigo = new JPanel();
			panel_IngreseCodigo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_IngreseCodigo.setBounds(10, 216, 455, 60);
			panel.add(panel_IngreseCodigo);
			panel_IngreseCodigo.setLayout(null);
			
			JLabel lblCodigo = new JLabel("Codigo:");
			lblCodigo.setBounds(10, 22, 46, 14);
			panel_IngreseCodigo.add(lblCodigo);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(66, 19, 379, 20);
			panel_IngreseCodigo.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JPanel panel_IngreseNombre = new JPanel();
			panel_IngreseNombre.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_IngreseNombre.setBounds(10, 216, 455, 60);
			panel.add(panel_IngreseNombre);
			panel_IngreseNombre.setLayout(null);
			
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 22, 80, 14);
			panel_IngreseNombre.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(80, 19, 365, 20);
			panel_IngreseNombre.add(txtNombre);
			txtNombre.setColumns(10);
			
			JPanel panelByEvento = new JPanel();
			panelByEvento.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panelByEvento.setBounds(10, 142, 455, 38);
			panel.add(panelByEvento);
			panelByEvento.setLayout(null);
			
			rdbtnCodigo = new JRadioButton("Codigo");
			rdbtnCodigo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_IngreseCodigo.setVisible(true);
					panel_IngreseNombre.setVisible(false);
				}
			});
			rdbtnCodigo.setBounds(6, 7, 109, 23);
			panelByEvento.add(rdbtnCodigo);
			
			rdbtnNombre = new JRadioButton("Nombre");
			rdbtnNombre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_IngreseCodigo.setVisible(false);
					panel_IngreseNombre.setVisible(true);
				}
			});
			rdbtnNombre.setBounds(132, 7, 109, 23);
			panelByEvento.add(rdbtnNombre);
			
			ButtonGroup group1 = new ButtonGroup();
	        group1.add(rdbtnCodigo);
	        group1.add(rdbtnNombre);
	       
	        
			{
				JPanel panel_Buscar = new JPanel();
				panel_Buscar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel_Buscar.setBounds(10, 34, 455, 79);
				panel.add(panel_Buscar);
				panel_Buscar.setLayout(null);
				
				radioButtonEvento = new JRadioButton("Evento");
				radioButtonEvento.setBounds(6, 13, 109, 23);
				panel_Buscar.add(radioButtonEvento);
				
				rdbtnTC = new JRadioButton("Trabajo Cientifico");
				rdbtnTC.setBounds(6, 39, 133, 23);
				panel_Buscar.add(rdbtnTC);
				
				rdbtnJurado = new JRadioButton("Jurado");
				rdbtnJurado.setBounds(168, 13, 133, 23);
				panel_Buscar.add(rdbtnJurado);
				
				rdbtnParticipante = new JRadioButton("Participante");
				rdbtnParticipante.setBounds(168, 39, 133, 23);
				panel_Buscar.add(rdbtnParticipante);
				
				rdbtnComision = new JRadioButton("Comision");
				rdbtnComision.setBounds(316, 13, 133, 23);
				panel_Buscar.add(rdbtnComision);
				
				rdbtnRecurso = new JRadioButton("Recurso");
				rdbtnRecurso.setBounds(316, 39, 133, 23);
				panel_Buscar.add(rdbtnRecurso);
				
				ButtonGroup group = new ButtonGroup();
		        group.add(rdbtnJurado);
		        group.add(rdbtnComision);
		       
		        group.add(rdbtnParticipante);
		        group.add(rdbtnRecurso);
		        
		        group.add(rdbtnTC);
		        group.add(radioButtonEvento);
			}
			
			JLabel lblBy = new JLabel("By:");
			lblBy.setBounds(10, 122, 46, 14);
			panel.add(lblBy);
			
			JLabel lblBuscar = new JLabel("Buscar");
			lblBuscar.setBounds(10, 10, 46, 14);
			panel.add(lblBuscar);
			
			JPanel panel_ByTrajCienti = new JPanel();
			panel_ByTrajCienti.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_ByTrajCienti.setBounds(10, 142, 455, 38);
			panel.add(panel_ByTrajCienti);
			
			JPanel panel_ByJurado = new JPanel();
			panel_ByJurado.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_ByJurado.setBounds(10, 142, 455, 38);
			panel.add(panel_ByJurado);
			
			JLabel lblIngrese = new JLabel("Ingrese:");
			lblIngrese.setBounds(10, 191, 46, 14);
			panel.add(lblIngrese);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("OK");
				buttonPane.add(cancelButton);
				getRootPane().setDefaultButton(cancelButton);
			}
			{
				JButton buscarButton = new JButton("Buscar");
				buscarButton.setActionCommand("Cancel");
				buttonPane.add(buscarButton);
			}
		}
	}
}
