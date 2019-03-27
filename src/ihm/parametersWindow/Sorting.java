package ihm.parametersWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import engine.AlgorithmData;
import ihm.menuWindow.UserGuide;
import ihm.saveAndRestore.SelectionFichier;
import region.RegionMap;

/**
 * Windows menu for parameters. Allows for the user, to choose the economical factors values.
 * @author MATTHIEU
 * 
 */
public class Sorting extends JFrame{
	
		private static final long serialVersionUID = 1L;
		
		private static RegionMap region;
	    private static ArrayList<FenMasque[]> thumbIndex=new ArrayList<FenMasque[]>(); // Important : allows to access to different thumb index called "FenMasque"
	    private static ArrayList<String> nameCountries=new ArrayList<String>();
	    private static ArrayList<Integer> ressources;
		private static JComboBox<String> timing=new JComboBox<String>();

		private JPanel mainContainer=new JPanel();
		private JPanel paramContainer=new JPanel();
		private JPanel paramNorthContainer=new JPanel();
		private JPanel paramNorthContainer2=new JPanel();
		private JPanel valideSouthContainer=new JPanel();

		private JLabel timingLab=new JLabel("Temps Simulation (y)");
		private JRadioButton one,two;
		private ButtonGroup gr1;
		
		private JTextField jtaTitle=new JTextField();
		private JButton valideCountry=new JButton("OK");
		private JButton valide=new JButton("Passer à la simulation");	    

		private JMenuBar menuBar= new JMenuBar();
		private JMenu first = new JMenu("Fichier");
		private JMenuItem item1= new JMenuItem("Sauvegarder");
		private JMenuItem item2=new JMenuItem("Charger");
		private JMenuItem item3=new JMenuItem("Aide");
		
	    private boolean caseCoch;
	         	
	    private JTabbedPane onglet;
	    
	    private String textGetter;
	    private int i=0;
	    	    
    public Sorting() {
    	this.setTitle("-Simeco-Paramétrage-"); 
		this.setResizable(true); 
		this.setBackground(Color.WHITE); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setSize(new Dimension(1900, 1080));
		this.setIconImage(new ImageIcon("euro.png").getImage());		

		
//-----------------------Setting layout----------------------------------------------------------
		mainContainer.setLayout(new BorderLayout());
		paramContainer.setLayout(new GridBagLayout());
		valideSouthContainer.setLayout(new FlowLayout());
	

//-------------------------Adding and setting components------------------------------------------------------
		this.first.add(item1);
		this.first.add(item2);
		this.first.add(item3);
		this.menuBar.add(first);
		this.setJMenuBar(menuBar);

		paramNorthContainer2.setPreferredSize(new Dimension(200, 100));
        paramNorthContainer2.setBorder(BorderFactory.createTitledBorder("Pays"));
        jtaTitle.setFont(new Font("Arial", Font.BOLD, 25));
        paramNorthContainer2.add(jtaTitle);
        paramNorthContainer2.add(valideCountry);
		JPanel panAge=new JPanel();
        panAge.setBorder(BorderFactory.createTitledBorder("Choix :"));
        panAge.setPreferredSize(new Dimension(200,50));
        
        one=new JRadioButton("Auto");
        two=new JRadioButton("Custom");
        one.setToolTipText("Donner des paramètres aléatoires à l'onglet suivant.");
        two.setToolTipText("Choisir ses paramètres");
        gr1=new ButtonGroup();
        gr1.add(one);
        gr1.add(two);
        two.setSelected(true);
        jtaTitle.setPreferredSize(new Dimension(150, 30));
        
        for(int index=1;index<31;index++) {
        	timing.addItem(Integer.toString(index));
        }
        timing.setSelectedIndex(9);
        timingLab.setToolTipText("Durée de la simulation en année, lors de la simulation, 1 an correspond à 2 secondes.");
        paramNorthContainer.add(timingLab);
        paramNorthContainer.add(timing);
//--------------------------------Calls actions--------------
        itHappensForOne();
        itHappensForTwo();
        itHappensForButtonMain();
        itHappensForJta();
        itHappensForButtonPass();
        itHappensForMenu1();
        itHappensForMenu2();
        itHappensForMenu3();
        
//----------------------------------adding choice pan-------------
        panAge.add(one);
        panAge.add(two);
        paramNorthContainer.add(paramNorthContainer2);
        paramNorthContainer.add(panAge);

		FenMasque tPan[] = {   new FenMasque(Color.white), new FenMasque(Color.DARK_GRAY), new FenMasque(Color.BLUE), new FenMasque(Color.GREEN), new FenMasque(Color.BLACK), new FenMasque(Color.BLACK), new FenMasque(Color.BLACK),
				new FenMasque(Color.BLACK),new FenMasque(Color.BLACK),new FenMasque(Color.BLACK)};
		onglet=new JTabbedPane();
		int i=0;
		for(FenMasque pan : tPan) {
			onglet.add(textGetter+" n° "+(++i), pan);
		}
//---------------------------------Adding panel------------
		thumbIndex.add(tPan);
		paramContainer.setBorder(BorderFactory.createTitledBorder("Parametrage des Pays"));
		valideSouthContainer.add(valide);

		valideSouthContainer.setBackground(Color.GRAY);
		mainContainer.add(paramNorthContainer,BorderLayout.NORTH);
		mainContainer.add(onglet, BorderLayout.CENTER);
		mainContainer.add(valideSouthContainer, BorderLayout.SOUTH);
		
//----------------------------------------------------------------------------------
		this.setContentPane(mainContainer);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.validate();
    }
    /**
     * Allows to get SlidersValue back and put it in a stockage object.
     */
    public static HashMap<String,ArrayList<Integer>> getArraySlideValues() {
    	HashMap<String,ArrayList<Integer>> stock = new HashMap<String,ArrayList<Integer>>();
    	for(int index=0;index<thumbIndex.get(0).length;index++) {
    		ressources=new ArrayList<Integer>();
    		for(int ind=0;ind<thumbIndex.get(0)[index].getJsliders().length;ind++) {
    			ressources.add(thumbIndex.get(0)[index].getValSlide().get(ind));
    		}
    		stock.put(Integer.toString(index), ressources);
    	}
    	return stock;
    }
    /**
     * Allows to restore another "Parameters window" previously saved.
     * <em>The user have to save a "Parameters window" one time, and after, in another simulation, he/she can save his/her previously test with a ".ser" file.</em>
     * @see testGraph.SelectionFichier;
     * @param result
     */
    public void restaureAllParam(HashMap<String, ArrayList<Integer>> result) {
    	int i=0;
    	for(int index=0;index<thumbIndex.get(0).length;index++) {//cross the tab
    		for(int ind=0;ind<thumbIndex.get(0)[index].getJsliders().length;ind++) {//cross the Jsliders
    			thumbIndex.get(0)[index].getJsliders()[ind].setValue(result.get(Integer.toString(i)).get(ind));
    		}
    		i++;//allows to cross the save of the HashMap
    	}
    }
	/**
     * Allows to open a dialogBox to confirm and open the main window.
     */
    public void itHappensForButtonPass() {
    	valide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AlgorithmData data=new AlgorithmData(getArraySlideValues(), two.isSelected());
				try {
					region=data.regionCreator();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      int option = JOptionPane.showConfirmDialog(null, 
			        "Voulez-vous lancer la simulation avec ces paramètres ?", 
			        "Simuler avec ces paramètres.", 
			        JOptionPane.YES_NO_OPTION, 
			        JOptionPane.QUESTION_MESSAGE);
			      if(option == JOptionPane.OK_OPTION){
			    	  new ihm.mainWindow.Progress();
			    	  setVisible(false);
			      }
			}
		});
    }
    /**
     * Allows to darken or not JSliders.
     */
    public void itHappensForOne() {
    	one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				caseCoch=false;
				for(int indexx=0;indexx<10;indexx++) {
					for(int index=0;index<thumbIndex.get(0)[0].getJsliders().length;index++) {
						thumbIndex.get(0)[indexx].getJsliders()[index].setEnabled(false);     
						thumbIndex.get(0)[indexx].getCells()[index].setEnabled(false);
					}
				}
				greyChoices(false);				
			}
		});
    }
    public void itHappensForTwo() {
    	two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				caseCoch=true;
				for(int indexx=0;indexx<10;indexx++) {
					for(int index=0;index<thumbIndex.get(0)[0].getJsliders().length;index++) {
						thumbIndex.get(0)[indexx].getJsliders()[index].setEnabled(true);      
						thumbIndex.get(0)[indexx].getCells()[index].setEnabled(true);
					}
				}	
				greyChoices(true);
			}
		});
    }
  /**
   * Methods which allows to darken the JRadioButton in the ButtonGroup.
   * @param grey : choose if Yes or No, you want to darken the different cases.
   */
   public void greyChoices(boolean grey) {
    	for(int indexx=0;indexx<10;indexx++) {
    		for(int index=0;index<thumbIndex.get(0)[0].getCaseChoice().size();index++) {
    			thumbIndex.get(0)[indexx].getCaseChoice().get(index).getComponent(0).setEnabled(grey);
    			thumbIndex.get(0)[indexx].getCaseChoice().get(index).getComponent(1).setEnabled(grey);
    			thumbIndex.get(0)[indexx].getCaseChoice().get(index).getComponent(2).setEnabled(grey);
    			thumbIndex.get(0)[indexx].getCaseChoice().get(index).getComponent(3).setEnabled(grey);
    			thumbIndex.get(0)[indexx].getCaseChoice().get(index).getComponent(4).setEnabled(grey);
    			thumbIndex.get(0)[indexx].getCaseChoice().get(index).getComponent(5).setEnabled(grey);
    		}
    	}
    }
    
    public void itHappensForButtonMain() {
    	valideCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textGetter=jtaTitle.getText();
				onglet.setTitleAt(i, textGetter);
				jtaTitle.setText("");
				i++;
			}
		});
    }
    /**
     * For the JtextField, allows to press a key, here it's "ENTER".
     */
    public void itHappensForJta() {
    	jtaTitle.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) {}
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
					textGetter=jtaTitle.getText();
					onglet.setTitleAt(i, textGetter);
					jtaTitle.setText("");
					i++;
					nameCountries.add(textGetter);
				}
			}
		});
    }

    /**
     * Button "Sauvegarder" to save all the "Parameters Window".
     */
    public void itHappensForMenu1() {
    	item1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SaveParam(getArraySlideValues());
			}
		});
    }
    /**
     * Button "Charger" to restore the ancient parameters previously saved.
     */
    public void itHappensForMenu2() {
    	item2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SelectionFichier();
				restaureAllParam(SelectionFichier.getResult());
			}
		});
    }
    /**
     * Access to User Guide.
     */
    public void itHappensForMenu3() {
    	item3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserGuide.openGuide();
			}
		});
    }
    public boolean getCaseUser() {
    	return caseCoch;
    }
    /**
     * To get name of countries.
     * @return
     */
    public static ArrayList<String> getText() {
    		if(nameCountries.isEmpty()==true) {
    			nameCountries.clear();
    			for(int i=0;i<10;i++) {
    				nameCountries.add("Pays n°"+Integer.toString(i));
    			}
    		}
    	return nameCountries;
    }
    public static int getTiming() {
    	return timing.getSelectedIndex()+1;
    }
    public static RegionMap getRegion() {
    	return region;
    }
    public static void setRegion(RegionMap reg) {
    	region=reg;
    }
    
}