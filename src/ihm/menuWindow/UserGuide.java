package ihm.menuWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ihm.fontElements.AllFont;


/**
 * Allows to display the user guide.
 * @author MATTHIEU
 *
 */
public class UserGuide extends JPanel{
	
	private static final long serialVersionUID = 1L;

	private static JFrame frame=new JFrame();

	private JLabel j1=new JLabel(new ImageIcon("paramWindowGuide.png"));
	private JLabel j2=new JLabel(new ImageIcon("schemaWindowPr.png"));
	private GridLayout grid=new GridLayout(2, 1);
	public UserGuide() {
		this.setLayout(grid);
	    this.setBackground(Color.WHITE);

	    j1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Partie fenêtre paramétrage",0,0,AllFont.getfMap(),Color.BLACK));
	    j2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Partie fenêtre principale",0,0,AllFont.getfMap(),Color.BLACK));
		add(j1);
		add(j2);
	}
	public static JScrollPane set() {
		JScrollPane scrollPane = new JScrollPane(new UserGuide());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 30, 400, 700);	
        
        return scrollPane;
	}
	public static void openGuide() {
		frame.setTitle("Simeco");
		frame.setIconImage(new ImageIcon("euro.png").getImage());		
		frame.setBackground(Color.WHITE);
        frame.setContentPane(set());
        frame.setSize(new Dimension(980,540));
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(true);  
	}
	
}
