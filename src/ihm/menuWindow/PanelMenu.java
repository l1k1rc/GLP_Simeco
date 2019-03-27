package ihm.menuWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ihm.fontElements.AllFont;


/**
 * <strong>Class declaring the menu of the software.
 * This one allows to start the simulation, load a previous simulation, consult the user guide and quit the software.
 * @author MATTHIEU
 *
 */
public class PanelMenu extends JPanel {
	
    private static final long serialVersionUID = 1L;
    private static JFrame frame=new JFrame();

	private JButton b1=new JButton("Nouvelle simulation");
    private JButton b3=new JButton("AIDE");
    private JButton b4=new JButton("Quitter");
            
    private GridBagConstraints gbc = new GridBagConstraints();//pour positionner les cellules

    private JPanel cell1 = new JPanel();
    private JPanel cell2 = new JPanel();
    private JPanel cell3 = new JPanel();
 
    Image img;
    /**
     * Constructors which place the different components.
     * @param img : the wallpaper
     */
    public PanelMenu(Image img){
    	
        this.img = img;
        
        b1.setPreferredSize(new Dimension(250, 60));
        b1.setFont(AllFont.getfMenu());
        b3.setPreferredSize(new Dimension(250, 60));
        b3.setFont(AllFont.getfMenu());
        b4.setPreferredSize(new Dimension(250, 60));
        b4.setFont(AllFont.getfMenu());
        //---------------------------------------------------------
       
        cell1.setBackground(Color.white);
        cell1.setPreferredSize(new Dimension(400, 100));
        cell1.setOpaque(false);
        cell2.setBackground(Color.white);
        cell2.setOpaque(false);
        cell2.setPreferredSize(new Dimension(400, 100));
        cell3.setBackground(Color.white);
        cell3.setOpaque(false);
        cell3.setPreferredSize(new Dimension(400, 100));

    	//*******************************************************
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);
        
        setLayout(new GridBagLayout());
    		
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill=GridBagConstraints.HORIZONTAL;  
        gbc.gridwidth=GridBagConstraints.REMAINDER;   
        add(b1, gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        add(b3,gbc);
        gbc.gridx = 0;
        gbc.gridy=2;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        add(b4, gbc);		

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        add(cell1,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        add(cell2,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        add(cell3,gbc);
        //-----------------------------------------------
        b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ihm.parametersWindow.Sorting();
				frame.setVisible(false);
			}
		});

        b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					UserGuide.openGuide();
			}
		});
        b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
    }
     /**
      * To draw the wallpaper.
      */
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
    /**
     * To define the frame.
     */
    public static void frameMenu(){
    	frame.setTitle("Simeco");
		frame.setIconImage(new ImageIcon("euro.png").getImage());		

        frame.setContentPane(new PanelMenu(new ImageIcon("fond2.png").getImage()));
        frame.setSize(new Dimension(980,540));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);  
        
    }
}