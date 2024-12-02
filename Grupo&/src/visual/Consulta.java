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

import com.sun.org.apache.xml.internal.serializer.ElemDesc;

import logico.Comision;
import logico.Evento;
import logico.Jurado;
import logico.Participante;
import logico.Recurso;
import logico.SPEC;
import logico.TrabajoCientifico;
import sun.misc.Cleaner;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.PrimitiveIterator.OfDouble;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
	
	private Evento eventoBuscando;
	private Jurado juradoBuscando;
	private Comision comisionBuscando;
	private Participante participanteBuscando;
	private Recurso recurBucando;
	private TrabajoCientifico trabajoBuscando;
	private JTextField txtCodRecurso;
	private JTextField txtNombreRecurso;
	private JTextField txtTipoRecurso;
	private JTextField txtCantidadRecurso;
	private JTable tableJuradosEnCom;
	private JTextField txtCodComision;
	private JTextField txtNombreComision;
	private JTextField txtCodParticipante;
	private JTextField txtNombreParticipante;
	private JTextField txtApellidoParticipante;
	private JTextField txtDireccionParticipante;
	private JTextField txtEmailParticipante;
	private JPanel panel_DescripJurado;
	private JPanel panel_DescripTc;
	private JPanel panel_DescripEvento;
	private JPanel panel_DescripRecurso;
	private JPanel panel_DescripComision;
	private JPanel panel_DescripParticipante;
	private JTextField txtCodigoJurado;
	private JTextField txtNombreJurado;
	private JTextField txtApellidoJurado;
	private JTextField txtEspecialJurado;
	private JTextField txtExperienciaJurado;
	private JTextField txtCodTrabajoCient;
	private JTextField txtTItuloTc;
	private JTextField txtContextoTc;
	private JTextField txtComisionTc;
	private JTable tableParticipantesTc;
	private JTextField txtCodigoEvento;
	private JTextField txtTituloEvento;
	private JTextField txtFechaEvento;
	private JTextField txtDuracionEvento;
	private JTextField txtTemaEvento;
	private JTextField txtCapacidadEvento;

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
		setBounds(100, 100, 501, 723);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			panel_DescripComision = new JPanel();
			panel_DescripComision.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_DescripComision.setBounds(10, 308, 455, 317);
			panel.add(panel_DescripComision);
			panel_DescripComision.setLayout(null);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(10, 34, 435, 286);
			panel_DescripComision.add(panel_2);
			panel_2.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 132, 436, 143);
			panel_2.add(scrollPane);
			
			tableJuradosEnCom = new JTable();
			scrollPane.setViewportView(tableJuradosEnCom);
			
			JLabel lblNewLabel_3 = new JLabel("Codigo comision:");
			lblNewLabel_3.setBounds(10, 27, 136, 14);
			panel_2.add(lblNewLabel_3);
			
			JLabel lblNewLabel_5 = new JLabel("Nombre Comision:");
			lblNewLabel_5.setBounds(10, 62, 108, 14);
			panel_2.add(lblNewLabel_5);
			
			txtCodComision = new JTextField();
			txtCodComision.setBounds(130, 24, 86, 20);
			panel_2.add(txtCodComision);
			txtCodComision.setColumns(10);
			
			txtNombreComision = new JTextField();
			txtNombreComision.setBounds(128, 59, 252, 20);
			panel_2.add(txtNombreComision);
			txtNombreComision.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("Jurados de la Comision:");
			lblNewLabel_6.setBounds(10, 107, 136, 14);
			panel_2.add(lblNewLabel_6);
			
			JLabel lblNewLabel_2 = new JLabel("Comision");
			lblNewLabel_2.setBounds(10, 9, 126, 14);
			panel_DescripComision.add(lblNewLabel_2);
			
			panel_DescripTc = new JPanel();
			panel_DescripTc.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_DescripTc.setBounds(10, 308, 455, 317);
			panel.add(panel_DescripTc);
			panel_DescripTc.setLayout(null);
			
			JLabel lblNewLabel_16 = new JLabel("Trabajo Cientifico");
			lblNewLabel_16.setBounds(10, 11, 154, 14);
			panel_DescripTc.add(lblNewLabel_16);
			
			JPanel panel_5 = new JPanel();
			panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_5.setBounds(10, 36, 435, 270);
			panel_DescripTc.add(panel_5);
			panel_5.setLayout(null);
			
			JLabel lblCodigoTc = new JLabel("Codigo");
			lblCodigoTc.setBounds(10, 26, 46, 14);
			panel_5.add(lblCodigoTc);
			
			JLabel lblTItuloTc = new JLabel("Titulo:");
			lblTItuloTc.setBounds(10, 70, 46, 14);
			panel_5.add(lblTItuloTc);
			
			txtCodTrabajoCient = new JTextField();
			txtCodTrabajoCient.setEditable(false);
			txtCodTrabajoCient.setBounds(55, 23, 86, 20);
			panel_5.add(txtCodTrabajoCient);
			txtCodTrabajoCient.setColumns(10);
			
			txtTItuloTc = new JTextField();
			txtTItuloTc.setEditable(false);
			txtTItuloTc.setBounds(55, 67, 86, 20);
			panel_5.add(txtTItuloTc);
			txtTItuloTc.setColumns(10);
			
			JLabel lblContexto = new JLabel("Contexto:");
			lblContexto.setBounds(175, 23, 91, 14);
			panel_5.add(lblContexto);
			
			JLabel lblComision = new JLabel("Comision:");
			lblComision.setBounds(175, 70, 46, 14);
			panel_5.add(lblComision);
			
			txtContextoTc = new JTextField();
			txtContextoTc.setEditable(false);
			txtContextoTc.setBounds(236, 23, 86, 20);
			panel_5.add(txtContextoTc);
			txtContextoTc.setColumns(10);
			
			txtComisionTc = new JTextField();
			txtComisionTc.setEditable(false);
			txtComisionTc.setBounds(236, 67, 86, 20);
			panel_5.add(txtComisionTc);
			txtComisionTc.setColumns(10);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(0, 124, 435, 146);
			panel_5.add(scrollPane_1);
			
			tableParticipantesTc = new JTable();
			scrollPane_1.setViewportView(tableParticipantesTc);
			
			JLabel lblParticipantes = new JLabel("Participantes:");
			lblParticipantes.setBounds(10, 98, 145, 14);
			panel_5.add(lblParticipantes);
			
			JPanel panel_6 = new JPanel();
			panel_6.setBounds(10, 160, 435, 146);
			panel_DescripTc.add(panel_6);
			
			panel_DescripParticipante = new JPanel();
			panel_DescripParticipante.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_DescripParticipante.setBounds(10, 308, 455, 317);
			panel.add(panel_DescripParticipante);
			panel_DescripParticipante.setLayout(null);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setBounds(10, 36, 435, 270);
			panel_DescripParticipante.add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblNewLabel_8 = new JLabel("Codigo:");
			lblNewLabel_8.setBounds(10, 35, 46, 14);
			panel_3.add(lblNewLabel_8);
			
			JLabel lblNewLabel_9 = new JLabel("Nombre:");
			lblNewLabel_9.setBounds(10, 84, 46, 14);
			panel_3.add(lblNewLabel_9);
			
			JLabel lblApellido = new JLabel("Apellido:");
			lblApellido.setBounds(10, 133, 74, 14);
			panel_3.add(lblApellido);
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBounds(10, 182, 74, 14);
			panel_3.add(lblDireccion);
			
			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setBounds(10, 231, 74, 14);
			panel_3.add(lblEmail);
			
			txtCodParticipante = new JTextField();
			txtCodParticipante.setEditable(false);
			txtCodParticipante.setBounds(64, 29, 168, 20);
			panel_3.add(txtCodParticipante);
			txtCodParticipante.setColumns(10);
			
			txtNombreParticipante = new JTextField();
			txtNombreParticipante.setEditable(false);
			txtNombreParticipante.setBounds(64, 78, 168, 20);
			panel_3.add(txtNombreParticipante);
			txtNombreParticipante.setColumns(10);
			
			txtApellidoParticipante = new JTextField();
			txtApellidoParticipante.setEditable(false);
			txtApellidoParticipante.setBounds(64, 127, 168, 20);
			panel_3.add(txtApellidoParticipante);
			txtApellidoParticipante.setColumns(10);
			
			txtDireccionParticipante = new JTextField();
			txtDireccionParticipante.setEditable(false);
			txtDireccionParticipante.setBounds(64, 176, 168, 20);
			panel_3.add(txtDireccionParticipante);
			txtDireccionParticipante.setColumns(10);
			
			txtEmailParticipante = new JTextField();
			txtEmailParticipante.setEditable(false);
			txtEmailParticipante.setBounds(64, 225, 168, 20);
			panel_3.add(txtEmailParticipante);
			txtEmailParticipante.setColumns(10);
			
			JLabel lblNewLabel_7 = new JLabel("Participante");
			lblNewLabel_7.setBounds(10, 11, 136, 14);
			panel_DescripParticipante.add(lblNewLabel_7);
			
			panel_DescripRecurso = new JPanel();
			panel_DescripRecurso.setBounds(10, 308, 455, 317);
			panel.add(panel_DescripRecurso);
			panel_DescripRecurso.setLayout(null);
			
			JPanel lblNombreDescRecurso = new JPanel();
			lblNombreDescRecurso.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			lblNombreDescRecurso.setBounds(10, 36, 435, 194);
			panel_DescripRecurso.add(lblNombreDescRecurso);
			lblNombreDescRecurso.setLayout(null);
			
			JLabel lblCodigoDesRecurso = new JLabel("Codigo:");
			lblCodigoDesRecurso.setBounds(10, 22, 46, 14);
			lblNombreDescRecurso.add(lblCodigoDesRecurso);
			
			JLabel lblNewLabel_4 = new JLabel("Nombre:");
			lblNewLabel_4.setBounds(10, 61, 46, 14);
			lblNombreDescRecurso.add(lblNewLabel_4);
			
			JLabel lblTipoRecursoDescRecurso = new JLabel("Tipo de recurso");
			lblTipoRecursoDescRecurso.setBounds(10, 100, 86, 14);
			lblNombreDescRecurso.add(lblTipoRecursoDescRecurso);
			
			JLabel lblCantidadDesRecurso = new JLabel("Cantidad");
			lblCantidadDesRecurso.setBounds(10, 139, 79, 14);
			lblNombreDescRecurso.add(lblCantidadDesRecurso);
			
			txtCodRecurso = new JTextField();
			txtCodRecurso.setEditable(false);
			txtCodRecurso.setBounds(105, 19, 154, 20);
			lblNombreDescRecurso.add(txtCodRecurso);
			txtCodRecurso.setColumns(10);
			
			txtNombreRecurso = new JTextField();
			txtNombreRecurso.setEditable(false);
			txtNombreRecurso.setBounds(105, 58, 154, 20);
			lblNombreDescRecurso.add(txtNombreRecurso);
			txtNombreRecurso.setColumns(10);
			
			txtTipoRecurso = new JTextField();
			txtTipoRecurso.setEditable(false);
			txtTipoRecurso.setBounds(105, 97, 154, 20);
			lblNombreDescRecurso.add(txtTipoRecurso);
			txtTipoRecurso.setColumns(10);
			
			txtCantidadRecurso = new JTextField();
			txtCantidadRecurso.setEditable(false);
			txtCantidadRecurso.setBounds(105, 136, 154, 20);
			lblNombreDescRecurso.add(txtCantidadRecurso);
			txtCantidadRecurso.setColumns(10);
			
			JLabel lblRecursoDescrip = new JLabel("Recurso");
			lblRecursoDescrip.setBounds(10, 11, 46, 14);
			panel_DescripRecurso.add(lblRecursoDescrip);
			
			panel_DescripJurado = new JPanel();
			panel_DescripJurado.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_DescripJurado.setBounds(10, 308, 455, 317);
			panel.add(panel_DescripJurado);
			panel_DescripJurado.setLayout(null);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBounds(10, 36, 435, 270);
			panel_DescripJurado.add(panel_4);
			panel_4.setLayout(null);
			
			JLabel lblNewLabel_11 = new JLabel("Codigo");
			lblNewLabel_11.setBounds(10, 33, 46, 14);
			panel_4.add(lblNewLabel_11);
			
			JLabel lblNewLabel_12 = new JLabel("Nombre");
			lblNewLabel_12.setBounds(10, 80, 46, 14);
			panel_4.add(lblNewLabel_12);
			
			JLabel lblNewLabel_13 = new JLabel("Apellido");
			lblNewLabel_13.setBounds(10, 127, 46, 14);
			panel_4.add(lblNewLabel_13);
			
			JLabel lblNewLabel_14 = new JLabel("Especialidad");
			lblNewLabel_14.setBounds(10, 174, 91, 14);
			panel_4.add(lblNewLabel_14);
			
			JLabel lblNewLabel_15 = new JLabel("Experiencia");
			lblNewLabel_15.setBounds(10, 221, 75, 14);
			panel_4.add(lblNewLabel_15);
			
			txtCodigoJurado = new JTextField();
			txtCodigoJurado.setEditable(false);
			txtCodigoJurado.setBounds(93, 30, 167, 20);
			panel_4.add(txtCodigoJurado);
			txtCodigoJurado.setColumns(10);
			
			txtNombreJurado = new JTextField();
			txtNombreJurado.setEditable(false);
			txtNombreJurado.setBounds(93, 77, 167, 20);
			panel_4.add(txtNombreJurado);
			txtNombreJurado.setColumns(10);
			
			txtApellidoJurado = new JTextField();
			txtApellidoJurado.setEditable(false);
			txtApellidoJurado.setBounds(93, 124, 167, 20);
			panel_4.add(txtApellidoJurado);
			txtApellidoJurado.setColumns(10);
			
			txtEspecialJurado = new JTextField();
			txtEspecialJurado.setEditable(false);
			txtEspecialJurado.setBounds(93, 171, 167, 20);
			panel_4.add(txtEspecialJurado);
			txtEspecialJurado.setColumns(10);
			
			txtExperienciaJurado = new JTextField();
			txtExperienciaJurado.setEditable(false);
			txtExperienciaJurado.setBounds(93, 218, 167, 20);
			panel_4.add(txtExperienciaJurado);
			txtExperienciaJurado.setColumns(10);
			
			JLabel lblNewLabel_10 = new JLabel("Jurado");
			lblNewLabel_10.setBounds(10, 11, 46, 14);
			panel_DescripJurado.add(lblNewLabel_10);
			
			panel_DescripEvento = new JPanel();
			panel_DescripEvento.setBorder(new EmptyBorder(0, 0, 0, 0));
			panel_DescripEvento.setBounds(10, 308, 455, 317);
			panel.add(panel_DescripEvento);
			panel_DescripEvento.setLayout(null);
			
			JLabel lblDescripEvent = new JLabel("Evento");
			lblDescripEvent.setBounds(10, 11, 46, 14);
			panel_DescripEvento.add(lblDescripEvent);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 36, 435, 270);
			panel_DescripEvento.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Codigo:");
			lblNewLabel.setBounds(10, 11, 46, 14);
			panel_1.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Titulo:");
			lblNewLabel_1.setBounds(10, 50, 46, 14);
			panel_1.add(lblNewLabel_1);
			
			JLabel lblFecha = new JLabel("Fecha:");
			lblFecha.setBounds(10, 95, 46, 14);
			panel_1.add(lblFecha);
			
			JLabel lblDuracion = new JLabel("Duracion:");
			lblDuracion.setBounds(10, 141, 69, 14);
			panel_1.add(lblDuracion);
			
			JLabel lblTema = new JLabel("Tema:");
			lblTema.setBounds(10, 185, 46, 14);
			panel_1.add(lblTema);
			
			JLabel lblCapacidad = new JLabel("Capacidad:");
			lblCapacidad.setBounds(10, 223, 69, 14);
			panel_1.add(lblCapacidad);
			
			txtCodigoEvento = new JTextField();
			txtCodigoEvento.setEditable(false);
			txtCodigoEvento.setBounds(75, 8, 132, 20);
			panel_1.add(txtCodigoEvento);
			txtCodigoEvento.setColumns(10);
			
			txtTituloEvento = new JTextField();
			txtTituloEvento.setEditable(false);
			txtTituloEvento.setBounds(75, 47, 132, 20);
			panel_1.add(txtTituloEvento);
			txtTituloEvento.setColumns(10);
			
			txtFechaEvento = new JTextField();
			txtFechaEvento.setEditable(false);
			txtFechaEvento.setBounds(75, 92, 132, 20);
			panel_1.add(txtFechaEvento);
			txtFechaEvento.setColumns(10);
			
			txtDuracionEvento = new JTextField();
			txtDuracionEvento.setEditable(false);
			txtDuracionEvento.setBounds(75, 138, 132, 20);
			panel_1.add(txtDuracionEvento);
			txtDuracionEvento.setColumns(10);
			
			txtTemaEvento = new JTextField();
			txtTemaEvento.setEditable(false);
			txtTemaEvento.setBounds(75, 182, 132, 20);
			panel_1.add(txtTemaEvento);
			txtTemaEvento.setColumns(10);
			
			txtCapacidadEvento = new JTextField();
			txtCapacidadEvento.setEditable(false);
			txtCapacidadEvento.setBounds(75, 220, 132, 20);
			panel_1.add(txtCapacidadEvento);
			txtCapacidadEvento.setColumns(10);
			
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
			{
				JButton buscarButton = new JButton("Buscar");
				buscarButton.setBounds(373, 279, 65, 23);
				panel.add(buscarButton);
				buscarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int encontrado = ObjetoBuscado();
						
						if (encontrado != -1) {
							visualizarPanelDescriptivo(encontrado);
						
							if (encontrado == 1) {
								loadEvento(eventoBuscando);
							}else if (encontrado == 2) {
								loadTc(trabajoBuscando);
							}else if (encontrado == 3) {
								loadComision(comisionBuscando);
							}else if(encontrado == 4) {
								loadJurado(juradoBuscando);
							}else if (encontrado == 5) {
								loadParticipante(participanteBuscando);
							}else if (encontrado == 6) {
								loadRecurso(recurBucando);
							}
						}
						
						clean();
					}

					
				});
				buscarButton.setActionCommand("Cancel");
			}
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
		}
	}
	protected void loadRecurso(Recurso recurBucando2) {
		// TODO Auto-generated method stub
		txtCodRecurso.setText(recurBucando2.getId());
		txtNombreRecurso.setText(recurBucando2.getNombre());
		txtCantidadRecurso.setText(recurBucando2.getCantidadTotal() + " ");
		txtTipoRecurso.setText(recurBucando2.getTiporecurso());
		
	}

	protected void loadParticipante(Participante participanteBuscando2) {
		// TODO Auto-generated method stub
		txtCodParticipante.setText(participanteBuscando2.getCodigo());
		txtNombreParticipante.setText(participanteBuscando2.getNombre());
		txtApellidoParticipante.setText(participanteBuscando2.getApellido());
		txtDireccionParticipante.setText(participanteBuscando2.getDireccion());
		txtEmailParticipante.setText(participanteBuscando2.getEmail());
	}

	protected void loadJurado(Jurado juradoBuscando2) {
		// TODO Auto-generated method stub
		txtCodigoJurado.setText(juradoBuscando2.getCodigo());
		txtNombreJurado.setText(juradoBuscando2.getNombre());
		txtApellidoJurado.setText(juradoBuscando2.getApellido());
		txtEspecialJurado.setText(juradoBuscando2.getEspecialidad());
		txtExperienciaJurado.setText(juradoBuscando2.getExperiencia());
		
	}

	protected void loadComision(Comision comisionBuscando2) {
		// TODO Auto-generated method stub
		txtCodComision.setText(comisionBuscando2.getCodigo());
		txtNombreComision.setText(comisionBuscando2.getNombreComision());
		
		//Tabla jurados
	}

	protected void loadTc(TrabajoCientifico trabajoBuscando2) {
		// TODO Auto-generated method stub
		txtCodTrabajoCient.setText(trabajoBuscando2.getCodTrabajo());
		txtTItuloTc.setText(trabajoBuscando2.getTitulo());
		txtContextoTc.setText(trabajoBuscando2.getContexto());
		txtComisionTc.setText(trabajoBuscando2.getAreacomision());
		
		//table participantes
	}

	protected void loadEvento(Evento eventoBuscando2) {
		// TODO Auto-generated method stub
		txtCodigoEvento.setText(eventoBuscando2.getIdEvento());
		txtTituloEvento.setText(eventoBuscando2.getNombre());
		txtFechaEvento.setText(eventoBuscando2.getFechaEvento().toString());
		txtDuracionEvento.setText(eventoBuscando2.getiEvento().getDuracionEvento());
		txtCapacidadEvento.setText(eventoBuscando2.getiEvento().getNumeroPersonas());
		txtTemaEvento.setText(eventoBuscando2.getiEvento().getTemaEvento());
	}

	protected void visualizarPanelDescriptivo(int encontrado) {
		// TODO Auto-generated method stub
		if (encontrado != -1) {
			
			panel_DescripComision.setVisible(false);
			panel_DescripEvento.setVisible(false);
			panel_DescripJurado.setVisible(false);
			panel_DescripParticipante.setVisible(false);
			panel_DescripRecurso.setVisible(false);
			panel_DescripTc.setVisible(false );
			
			if (encontrado == 1) {
				panel_DescripEvento.setVisible(true);
				
			}else if (encontrado == 2) {
				panel_DescripTc.setVisible(true);
				
			}else if (encontrado == 3) {
				panel_DescripComision.setVisible(true);
				
			}else if (encontrado == 4) {
				panel_DescripJurado.setVisible(true);
				
			}else if (encontrado == 5) {
				panel_DescripParticipante.setVisible(true);
				
			}else if (encontrado == 6) {
				panel_DescripRecurso.setVisible(true);
				
			}
		}
	}

	private void clean() {
		// TODO Auto-generated method stub
		panel_DescripComision.setVisible(false);
		panel_DescripEvento.setVisible(false);
		panel_DescripJurado.setVisible(false);
		panel_DescripParticipante.setVisible(false);
		panel_DescripRecurso.setVisible(false);
		panel_DescripTc.setVisible(false );
		
		eventoBuscando = null;
		recurBucando = null;
		
		//poner todoas las variables de objetosbuscando en null;
	}
	
	private int ObjetoBuscado () {
		int encontrado = -1;
		String codigo = txtCodigo.getText();
		String nombre = txtNombre.getText();
		
		
		//Evento = 1
		if (radioButtonEvento.isSelected() && rdbtnCodigo.isSelected()) {
			eventoBuscando = SPEC.getInstance().buscarEventoByCodigo(codigo);
			if(eventoBuscando != null) {
				encontrado = 1;
			}
			
		
		}else if (radioButtonEvento.isSelected() && rdbtnNombre.isSelected()) {
			eventoBuscando = SPEC.getInstance().buscarEventoByNombre(txtNombre.getText());
			if(eventoBuscando != null) {
				encontrado = 1;
			}
			
		//Trabajo = 2	
		}else if(rdbtnTC.isSelected() && rdbtnCodigo.isSelected()) {
			trabajoBuscando = SPEC.getInstance().buscarTCientificoById(codigo);
			if(trabajoBuscando != null) {
				encontrado = 2;
			}
			
		}else if (rdbtnTC.isSelected() && rdbtnNombre.isSelected()) {
			trabajoBuscando = SPEC.getInstance().buscarTCientificoByNombre(txtNombre.getText());
			if(trabajoBuscando != null) {
				encontrado = 2;
			}
			
		//Comision = 3	
		}else if(rdbtnComision.isSelected() && rdbtnCodigo.isSelected()) {
			comisionBuscando = SPEC.getInstance().buscarComisionById(codigo);
			if(comisionBuscando != null) {
				encontrado = 3;
			}
			
		}else if(rdbtnComision.isSelected() && rdbtnNombre.isSelected()) {
			comisionBuscando = SPEC.getInstance().buscarComisionByNombre(txtNombre.getText());	
			if(comisionBuscando != null) {
				encontrado = 3;
			}
			
		//Jurado = 4	
		}else if (rdbtnJurado.isSelected() && rdbtnCodigo.isSelected()) {
			juradoBuscando = SPEC.getInstance().buscarJuradoById(codigo);
			if(juradoBuscando != null){
				encontrado = 4;
			}
			
		}else if(rdbtnJurado.isSelected() && rdbtnNombre.isSelected()) {
			juradoBuscando = SPEC.getInstance().buscarJuradoByNombre(txtNombre.getText());
			if(juradoBuscando != null){
				encontrado = 4;
			}
			
		//Participante = 5
		}else if(rdbtnParticipante.isSelected() && rdbtnCodigo.isSelected()) {
			participanteBuscando = SPEC.getInstance().buscarParticipanteById(codigo);
			if (participanteBuscando != null) {
				encontrado = 5;
			}
			
		}else if(rdbtnParticipante.isSelected() && rdbtnNombre.isSelected()) {
			participanteBuscando = SPEC.getInstance().buscarParticipanteByNombre(txtNombre.getText());
			if (participanteBuscando != null) {
				encontrado = 5;
			}
		//Recurso
		}else if (rdbtnRecurso.isSelected() && rdbtnCodigo.isSelected()) {
			if(recurBucando != null){
				encontrado = 6;
			}
		}else if(rdbtnRecurso.isSelected() && rdbtnNombre.isSelected()) {
			if(recurBucando != null){
				encontrado = 6;
			}
		}
		return encontrado;
	}
}
