package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Recurso;
import logico.SPEC;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoRecursos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private int respuesta;
	private String codRecurso;
	private int indexclick;
	private JButton eliminarBTn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoRecursos dialog = new ListadoRecursos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoRecursos() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					panel_1.add(scrollPane, BorderLayout.CENTER);
					{
						table = new JTable();
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								indexclick = table.getSelectedRow();
								
								if (indexclick >= 0) {
									eliminarBTn.setEnabled(true);
								}
							}
						});
						scrollPane.setViewportView(table);
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				eliminarBTn = new JButton("Eliminar Recurso");
				eliminarBTn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						respuesta = JOptionPane.showConfirmDialog(
								null, 
					           "¿Estás seguro de que quieres eliminar este recurso?", 
					           "Confirmación", 
					         JOptionPane.YES_NO_OPTION
					         );
							 
						if (respuesta == JOptionPane.YES_OPTION) { 
						
							if(indexclick >= 0)
							{
								codRecurso = (String) table.getValueAt(indexclick, 0);
								eliminarRecurso(codRecurso);
							}
						}
					}
				});
				eliminarBTn.setActionCommand("OK");
				buttonPane.add(eliminarBTn);
				getRootPane().setDefaultButton(eliminarBTn);
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

	protected void eliminarRecurso(String codRecurso2) {
		// TODO Auto-generated method stub
		Recurso recurso = SPEC.getInstance().buscarRecursoById(codRecurso2);
		
		if (recurso != null) {
		
			SPEC.getInstance().eliminarRecurso(recurso);
			
			JOptionPane.showMessageDialog(
					 null, 
	             "El evento fue eliminado correctamente."
	         );
		}else {
			javax.swing.JOptionPane.showMessageDialog(
					null,
					"No pudo eliminarse este recurso",
					"Error",
					javax.swing.JOptionPane.ERROR_MESSAGE
				);
		}
		
	}

}
