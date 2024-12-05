package visual;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import logico.Control;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class Principal extends JFrame {
    
    private JPanel contentPane;
	private Object mnAdministracion;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            	
            	 FileInputStream empresa;
                 FileOutputStream empresa2;
                 ObjectInputStream empresaRead;
                 ObjectOutputStream empresaWrite;
            	
            	
            	
                try {
     
                    Principal frame = new Principal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Principal() {
    	setTitle("Gestor de eventos");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/javax/swing/plaf/metal/icons/ocean/paletteClose-pressed.gif")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 100, 521, 335);
        Dimension dim = getToolkit().getScreenSize();
        setSize(dim.width+10,dim.height-40);
        setLocationRelativeTo(null);
        JMenuBar menuBar= new JMenuBar();
        setJMenuBar(menuBar);
        
        // Panel principal
        contentPane = new JPanel();
        contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
        setContentPane(contentPane);
        
        
        
        // Barra de menú
        JMenuBar menuBar1 = new JMenuBar();
        menuBar1.setBackground(UIManager.getColor("Button.darkShadow"));
        setJMenuBar(menuBar1);
        
        JMenu mnNewMenu = new JMenu("Clientes");
        menuBar1.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Registrar cliente");
        mntmNewMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		regUsuario dialog = new regUsuario();
        		dialog.setVisible(true);
        		
        	}
        });
        mnNewMenu.add(mntmNewMenuItem);
        
        JMenuItem mntmNewMenuItem_7 = new JMenuItem("Agregar persona");
        mntmNewMenuItem_7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		AgregarPersona dialog = new AgregarPersona();
        		dialog.setVisible(true);
        	}
        });
        mnNewMenu.add(mntmNewMenuItem_7);
        
        JMenu mnNewMenu_2 = new JMenu("Gestion eventos");
        menuBar1.add(mnNewMenu_2);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Registrar evento");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		RegistrarEvento dialog = new RegistrarEvento();
        		dialog.setVisible(true);
        	}
        });
        mnNewMenu_2.add(mntmNewMenuItem_1);
        
        JMenuItem mntmNewMenuItem_8 = new JMenuItem("Listar eventos");
        mntmNewMenuItem_8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ListadoEventos listadoE = new ListadoEventos();
        		listadoE.setVisible(true);
        	}
        });
        
        JMenuItem mntmNewMenuItem_10 = new JMenuItem("Registrar trabajo cientifico");
        mntmNewMenuItem_10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		RegistrarTC dialog = new RegistrarTC();
        		dialog.setVisible(true);
        		
        	}
        });
        mnNewMenu_2.add(mntmNewMenuItem_10);
        mnNewMenu_2.add(mntmNewMenuItem_8);
        
        JMenu mnNewMenu_5 = new JMenu("Gestion recursos");
        menuBar1.add(mnNewMenu_5);
        
        JMenuItem mntmNewMenuItem_6 = new JMenuItem("Registrar recursos");
        mntmNewMenuItem_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		AgregarRecurso dialog = new AgregarRecurso();
        		dialog.setVisible(true);
        		
        	}
        });
        mnNewMenu_5.add(mntmNewMenuItem_6);
        
        JMenuItem mntmNewMenuItem_9 = new JMenuItem("Listar recursos");
        mntmNewMenuItem_9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		ListadoRecursos dialog = new ListadoRecursos();
        		dialog.setVisible(true);
        		
        	}
        });
        mnNewMenu_5.add(mntmNewMenuItem_9);
        
        JMenu mnNewMenu_3 = new JMenu("Consultas");
        menuBar1.add(mnNewMenu_3);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Hacer consulta");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		Consulta dialog = new Consulta();
        		dialog.setVisible(true);
        	}
        });
        mnNewMenu_3.add(mntmNewMenuItem_2);
        
        JMenu mnNewMenu_1 = new JMenu("Administracion");
        menuBar1.add(mnNewMenu_1);
        
        JMenu mnNewMenu_4 = new JMenu("Tablas");
        mnNewMenu_1.add(mnNewMenu_4);
        
        JMenuItem mntmNewMenuItem_3 = new JMenuItem("Jurado");
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		TablaJurado frame = new TablaJurado();
        		frame.setVisible(true);
        	}
        });
        mnNewMenu_4.add(mntmNewMenuItem_3);
        
        JMenuItem mntmNewMenuItem_4 = new JMenuItem("Participantes");
        mntmNewMenuItem_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		TablaParticipante frame = new TablaParticipante();
        		frame.setVisible(true);
        	}
        });
        mnNewMenu_4.add(mntmNewMenuItem_4);
        
        JMenuItem mntmNewMenuItem_5 = new JMenuItem("Trabajo cientifico");
        mntmNewMenuItem_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		ListadoTrabajosC frame = new ListadoTrabajosC();
        		frame.setVisible(true);
        	}
        });
        mnNewMenu_4.add(mntmNewMenuItem_5);
        
        // Menú Archivo
        JMenu mnArchivo = new JMenu("Emergencia");
        mnArchivo.setIcon(new ImageIcon(Principal.class.getResource("/javax/swing/plaf/metal/icons/sortDown.png")));
        menuBar1.add(mnArchivo);
        
        JMenuItem mntmSalir = new JMenuItem("Salir");
        mntmSalir.setIcon(new ImageIcon(Principal.class.getResource("/javax/swing/plaf/metal/icons/Error.gif")));
        mntmSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnArchivo.add(mntmSalir);
        contentPane.setLayout(null);
   
        
     // Panel central con mensaje de bienvenida
        JPanel panelCentral = new JPanel();
        panelCentral.setBounds(0, 0, 1360, 668);
        panelCentral.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
        contentPane.add(panelCentral);
        panelCentral.setLayout(null);

        // Mensaje de bienvenida
        JLabel lblNewLabel = new JLabel("Bienvenidos al sistema de Eventos de la PUCMM  ");
        lblNewLabel.setBounds(572, 11, 410, 32);
        lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/com/sun/java/swing/plaf/windows/icons/Inform.gif")));
        panelCentral.add(lblNewLabel);
        
     
        JLabel lblImagen = new JLabel();
        lblImagen.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive - Pontificia Universidad Cat\u00F3lica Madre y Maestra\\Escritorio\\Marca PUCMM (Color).png"));
        lblImagen.setBounds(71, 123, 1279, 405); 
        panelCentral.add(lblImagen);

       
        //ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/visual/Marca PUCMM (Color).png"));
       // Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
       // lblImagen.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive - Pontificia Universidad Cat\u00F3lica Madre y Maestra\\Escritorio\\Logo PUCMM (L\u00EDneas1).png"));
    }

	public void desactivarMenuAdministracion(Component mnNewMenu_1) {
		 mnNewMenu_1.setEnabled(false);
		
	}

	public void desactivarMenuAdministracion() {
		// TODO Auto-generated method stub
		
	}
}