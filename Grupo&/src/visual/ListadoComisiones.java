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
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Comision;
import logico.SPEC;
import logico.TrabajoCientifico;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoComisiones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;
	private int index;
	private int respuesta;
	private JButton cancelarBtn;
	private JButton eliminarBtn;
	private String idcomi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoComisiones dialog = new ListadoComisiones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoComisiones() {
		setTitle("Listado de comiciones");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
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
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					panel_1.add(scrollPane, BorderLayout.CENTER);
					{
						table = new JTable();
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								index = table.getSelectedRow();
								{
									if (index >= 0) {
										cancelarBtn.setEnabled(true);
										eliminarBtn.setEnabled(true);
									}
								}
							}
						});
						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						model = new DefaultTableModel();
						String[] identificadores = {"Codigo", "Nombre"};
						model.setColumnIdentifiers(identificadores);
						table.setModel(model);
						scrollPane.setViewportView(table);
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				eliminarBtn = new JButton("Eliminar");
				eliminarBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
	
						respuesta = JOptionPane.showConfirmDialog(
								null, 
					           "¿Estás seguro de que eliminar esta comision?", 
					           "Confirmación", 
					         JOptionPane.YES_NO_OPTION
					         );
							 
						if (respuesta == JOptionPane.YES_OPTION) {
								 
							idcomi = table.getValueAt(index, 0).toString();
							Comision comi = SPEC.getInstance().buscarComisionById(idcomi);
								 
							 if(comi != null) {
								 
								 SPEC.getInstance().eliminarComision(comi);
								 JOptionPane.showMessageDialog(
								 null, 
					             "La comision fue eliminada correctamente."
					          );
							} 
						}
					}
				});
				
				eliminarBtn.setEnabled(false);
				eliminarBtn.setActionCommand("OK");
				buttonPane.add(eliminarBtn);
				getRootPane().setDefaultButton(eliminarBtn);
			}
			{
				cancelarBtn = new JButton("Cancel");
				cancelarBtn.setActionCommand("Cancel");
				buttonPane.add(cancelarBtn);
			}
		
	}
	
	loadComisiones();

}


	private void loadComisiones() {
		model.setRowCount(0);
		row = new Object[table.getColumnCount()];
		
		for (Comision comi : SPEC.getInstance().getMisComisiones()){
			 
			row[0] = comi.getCodigo();
			row[1] = comi.getNombreComision();
			
			model.addRow(row); 
			
		}
	}
}

