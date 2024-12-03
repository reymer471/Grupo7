package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class Principal extends JFrame {
    
    private JPanel contentPane;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
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
        setBounds(50, 100, 521, 363);
        Dimension dim = getToolkit().getScreenSize();
        //setSize(dim.width+10,dim.height-40);
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
        
        JMenu mnNewMenu_1 = new JMenu("Administracion");
        menuBar1.add(mnNewMenu_1);
        
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
        panelCentral.setBounds(0, 0, 505, 303);
        panelCentral.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
        contentPane.add(panelCentral);
        panelCentral.setLayout(null);

        // Mensaje de bienvenida
        JLabel lblNewLabel = new JLabel("Bienvenidos al sistema de Eventos de la PUCMM  ");
        lblNewLabel.setBounds(117, 8, 271, 32);
        lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/com/sun/java/swing/plaf/windows/icons/Inform.gif")));
        panelCentral.add(lblNewLabel);
        
        ImageIcon ico = new ImageIcon(getClass().getResource("Marca PUCMM (Color).png"));
        ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
    }
}