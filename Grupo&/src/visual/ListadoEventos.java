package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Evento;
import logico.SPEC;
import logico.TrabajoCientifico;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoEventos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object row[];
	private static DefaultTableModel model;
	private int respuesta;
	private String codEvento;
	private int indexclick;
	private JButton eliminarBtn;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoEventos dialog = new ListadoEventos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoEventos() {
		setTitle("Listado de Eventos");
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
						model = new DefaultTableModel();
						table = new JTable();
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								indexclick = table.getSelectedRow();
								
								if (indexclick >= 0) {
									eliminarBtn.setEnabled(true);
								}
							}
						});
						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						String identificadores[] = {"Codigo","Titulo","Tipo","Fecha","Duracion","Capacidad"};
						model.setColumnIdentifiers(identificadores);
						table.setModel(model);
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
				eliminarBtn = new JButton("Eliminar evento");
				eliminarBtn.setEnabled(false);
				eliminarBtn.addActionListener(new ActionListener() {
					

					public void actionPerformed(ActionEvent e) {
						
						  respuesta = JOptionPane.showConfirmDialog(
							null, 
				           "¿Estás seguro de que quieres eliminar este evento?", 
				           "Confirmación", 
				         JOptionPane.YES_NO_OPTION
				         );
						 
						 if (respuesta == JOptionPane.YES_OPTION) {
							 
							 codEvento = table.getValueAt(indexclick, 0).toString();
							 Evento evento = SPEC.getInstance().buscarEventoByCodigo(codEvento);
							 
							 if(evento != null) {
								 
								 SPEC.getInstance().eliminarEvento(evento);
								 SPEC.getInstance().guardarDatos("SPEC.dat");
								 JOptionPane.showMessageDialog(
										 null, 
						             "El evento fue eliminado correctamente."
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
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadEventos();
	}
	
	private void loadEventos() {
		
		model.setRowCount(0);
		row = new Object[table.getColumnCount()];
		
		for (Evento evento : SPEC.getInstance().getMisEventos()){
			 
			row[0] = evento.getIdEvento();
			row[1] = evento.getNombre();
			row[2] = evento.getTipoEvento();
		    row[3] = evento.getFechaEvento();
		    row[4] = evento.getInfoEvento().getDuracionEvento();
		    row[5] = evento.getInfoEvento().getNumeroPersonas();
		    
			model.addRow(row); 
			
		}
	}

}
