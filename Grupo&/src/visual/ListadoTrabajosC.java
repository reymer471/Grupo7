package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.SPEC;
import logico.TrabajoCientifico;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoTrabajosC extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableListadoTc;
	private DefaultTableModel model;
	private Object[] row;
	private JButton cancelarBtn;
	private JButton eliminarBtn;
	private int index;
	private String idTcientifico;
	private int respuesta;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoTrabajosC dialog = new ListadoTrabajosC();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoTrabajosC() {
		setTitle("Listado de Trabajos Cientificos");
		setBounds(100, 100, 494, 332);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			panel.add(scrollPane, BorderLayout.CENTER);
			{
				tableListadoTc = new JTable();
				tableListadoTc.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						index = tableListadoTc.getSelectedRow();
						{
							if (index >= 0) {
								cancelarBtn.setEnabled(true);
								eliminarBtn.setEnabled(true);
							}
						}
					}
				});
				tableListadoTc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				model = new DefaultTableModel();
				String[] identificadores = {"Codigo", "Titulo","Comision","Representante"};
				model.setColumnIdentifiers(identificadores);
				tableListadoTc.setModel(model);
				scrollPane.setViewportView(tableListadoTc);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				eliminarBtn = new JButton("Eliminar");
				eliminarBtn.setEnabled(false);
				eliminarBtn.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						  respuesta = JOptionPane.showConfirmDialog(
							null, 
				           "¿Estás seguro de que quieres continuar?", 
				           "Confirmación", 
				         JOptionPane.YES_NO_OPTION
				         );
						 
						 if (respuesta == JOptionPane.YES_OPTION) {
							 
							 idTcientifico = tableListadoTc.getValueAt(index, 0).toString();
							 TrabajoCientifico tCi = SPEC.getInstance().buscarTCientificoById(idTcientifico);
							 
							 if(tCi != null) {
								 
								 SPEC.getInstance().eliminarTrabajoCientifico(tCi);
								 JOptionPane.showMessageDialog(
										 null, 
						             "El trabajo científico fue eliminado correctamente."
						          );
							 } 
						 }
					}
				});
				eliminarBtn.setActionCommand("OK");
				buttonPane.add(eliminarBtn);
				getRootPane().setDefaultButton(eliminarBtn);
			}
			{
				cancelarBtn = new JButton("Cancelar");
				cancelarBtn.setEnabled(false);
				cancelarBtn.setActionCommand("Cancel");
				buttonPane.add(cancelarBtn);
			}
		}
		loadTrabajosCientificos();
	}
	
	private void loadTrabajosCientificos() {
		
		model.setRowCount(0);
		row = new Object[tableListadoTc.getColumnCount()];
		
		for (TrabajoCientifico tc : SPEC.getInstance().getMistrabajosCientificos()){
			 
			row[0] = tc.getCodTrabajo();
			row[1] = tc.getTitulo();
			row[2] = tc.getComisiontc().getNombreComision();
			
			if (!tc.getParticiantes().isEmpty()) {
			    row[3] = tc.getParticiantes().get(0).getNombre();
			} else {
			    row[3] = "Sin representante";
			}
			model.addRow(row); 
			
		}
	}
}
