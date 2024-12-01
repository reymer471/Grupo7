package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

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
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/javax/swing/plaf/metal/icons/ocean/paletteClose-pressed.gif")));
   
        setTitle("Sistema de Quesos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        Dimension dim = getToolkit().getScreenSize();
        setSize(dim.width+10,dim.height-40);
        setLocationRelativeTo(null);
        JMenuBar menuBar= new JMenuBar();
        setJMenuBar(menuBar);
        
        // Panel principal
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        // Barra de menú
        JMenuBar menuBar1 = new JMenuBar();
        menuBar1.setBackground(UIManager.getColor("Button.darkShadow"));
        setJMenuBar(menuBar1);
        
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
        

      
        
     // Panel central con mensaje de bienvenida
        JPanel panelCentral = new JPanel();
        panelCentral.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER));  
        contentPane.add(panelCentral, BorderLayout.CENTER);

        // Mensaje de bienvenida
        JLabel lblNewLabel = new JLabel("Bienvenidos al sistema de Eventos  ");
        lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/com/sun/java/swing/plaf/windows/icons/Inform.gif")));
        panelCentral.add(lblNewLabel); 
    }
}