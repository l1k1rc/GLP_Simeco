package ihm.parametersWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ihm.fontElements.AllFont;

public class FenMasque extends JPanel{

private static final long serialVersionUID = 367516177890306210L;
  	
	private static ArrayList<JLabel[]> tabA=new ArrayList<JLabel[]>();//pour les sliders

  public JPanel paramRecap=new JPanel();
  private JPanel paramContainer=new JPanel();
  private JPanel paramValidate=new JPanel();
  private JPanel contentPane=new JPanel();
  
  private JPanel panAge;

  private JRadioButton low,veryLow,medium,high,veryHigh,none;
  private ButtonGroup gr1;

  private GridBagConstraints gbc = new GridBagConstraints();//pour positionner les cellules
  private GridLayout gL=new GridLayout(2, 1);
  
  int cho=-11;
  private ArrayList<Integer> stock;
  private ArrayList<JPanel> choiceContains=new ArrayList<JPanel>();

  private ArrayList<JPanel[]> tabB=new ArrayList<JPanel[]>();//pour les cellules
  private ArrayList<JSlider[]> tabC=new ArrayList<JSlider[]>();//pour les sliders

  /**
   * This frame is the most important of this package. It allows to make one of the tabs. It works like a "slide master" ( cf. PowerPoint ).
   * And so, if one tab is modified, everyone too.
   * @param color : color of the frame
   */
  public FenMasque(Color color){
   //-------------------------------------------------------------------------------------
    JPanel[] cells = {new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(), new JPanel(), new JPanel(),new JPanel()   };
    
    JLabel[] labs= {new JLabel("Nbr Lac :"),new JLabel("Nbr Terre Exploitable :"),new JLabel("Nbr Champ :"),new JLabel("Nbr Forêt :"),
    		new JLabel("Nbr Puit Pétrolier :"),new JLabel("Nbr Mine Or :"),new JLabel("Nbr Mine Fer :"),new JLabel("Nbr Mine Charbon :"),new JLabel("Statut politique :"),new JLabel("Facteurs Industriels :"),
    		new JLabel("PIB :"),new JLabel("IDH :"),new JLabel("Niveau Natalité :"),new JLabel("Gini :"),new JLabel("Dépense en recherche :"),new JLabel("Age moyen :"),new JLabel("Chômage")};
    
    JLabel[] labAnswer= {new JLabel(""),new JLabel(""),new JLabel(""),new JLabel(""),new JLabel(""),new JLabel(""),new JLabel(""),new JLabel(""),new JLabel(""),new JLabel(""),new JLabel(""),
    		new JLabel(""),new JLabel(""),new JLabel(""),new JLabel(""),new JLabel(""),new JLabel("") };
    
    JSlider[] sliders= {new JSlider(),new JSlider(),new JSlider(),new JSlider(),new JSlider(),new JSlider(),new JSlider(),new JSlider(),new JSlider(),new JSlider(),new JSlider(),new JSlider(),new JSlider(),new JSlider(),new JSlider(),new JSlider(),new JSlider()  };
    tabC.add(sliders);//passage par ArrayList pour rendre le tableau accessible en dehors du constructeur
    tabB.add(cells);
    tabA.add(labs);
  //--------------------------------------------------------------------------------------
    //Layout configuration
    this.setLayout(new BorderLayout());
	paramContainer.setLayout(new GridBagLayout());
	paramRecap.setLayout(new FlowLayout());
	gL.setHgap(50);
	gL.setVgap(50);
	paramValidate.setLayout(gL);
    contentPane.setLayout(null);
	paramRecap.setPreferredSize(new Dimension(100, 80));
//---------------------------------------------------------------------------------------
	//TEST TEST TEST TEST TEST
	for(int ind=0;ind<labs.length;ind++) {
		labs[ind].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
	}
	for(int ind=0;ind<cells.length;ind++) {
    	cells[ind].setPreferredSize(new Dimension(350, 100));
    }
	//---------------------------------------------------------------------------------------

	//---------------------------------------------------------------------------------
	//Sliders configuration
	ArrayList<Component> components=new ArrayList<Component>();
	components=new ArrayList<Component>();
	components.add(progressSlide(sliders[0], 50, 0, 25, true, true,10 , 25, labAnswer[0]));//nbr lac
	components.add(progressSlide(sliders[1], 100, 0, 50, true, true,10 , 20, labAnswer[1]));//nnbr TE
	components.add(progressSlide(sliders[2], 100, 0, 50, true, true,10 , 20, labAnswer[2]));// nbr champ
	components.add(progressSlide(sliders[3], 150, 0, 75, true, true,10 , 50, labAnswer[3]));//nbr for
	components.add(progressSlide(sliders[4], 20, 0, 10, true, true,1 , 5, labAnswer[4]));//nbr puit petr
	components.add(progressSlide(sliders[5], 20, 0, 10, true, true,1 , 5, labAnswer[5]));//nbr mine or
	components.add(progressSlide(sliders[6], 25, 0, 16, true, true,1 , 5, labAnswer[6]));//nbr fer
	components.add(progressSlide(sliders[7], 30, 0, 15, true, true,5 , 10, labAnswer[7]));//nbr charb
	components.add(progressSlide(sliders[8], 1, 0, 0, true, true,1 , 1, labAnswer[8]));//Statut politique
	components.add(progressSlide(sliders[9], 3, 0, 0, true, true,1 , 1, labAnswer[9]));//facteurs industriel
	components.add(progressSlide(sliders[10], 150000000, 150000, 200000, true, true,100000000 , 100000000, labAnswer[10]));//pib
	components.add(progressSlide(sliders[11], 950, 250, 400, true, true,100 , 200, labAnswer[11]));//IDH
	components.add(progressSlide(sliders[12], 5, -1, 2, true, true,1 , 2, labAnswer[12]));//pop up
	components.add(progressSlide(sliders[13], 80, 20, 50, true, true,10 , 20, labAnswer[13]));//gini
	components.add(progressSlide(sliders[14], 5, 0, 2, true, true,1 , 1, labAnswer[14]));//rechSpen
	components.add(progressSlide(sliders[15], 47, 15, 30, true, true,5 , 10, labAnswer[15]));//middlAge
	components.add(progressSlide(sliders[16], 15, 0, 7, true, true,5 , 5, labAnswer[16]));//chom


			//cells positioning  
			gbc.gridx=0;
			gbc.gridy=0;
			for(int ind=0;ind<cells.length;ind++) {
				paramContainer.add(components.get(ind),gbc);
				paramContainer.add(cells[ind],gbc);
				gbc.gridx++;
				if(gbc.gridx%5==0) {
					gbc.gridy++;
					gbc.gridx=0;
				}
			}
		
			//---------------------------------------------------------------------------------------------
			//borders configuration
			paramRecap.setBorder(BorderFactory.createTitledBorder("Récapitulatif des paramètres :"));
			paramContainer.setBorder(BorderFactory.createTitledBorder("Fenêtre de parametrage :"));

			for(int ind=0;ind<cells.length;ind++) {
				labs[ind].setFont(AllFont.getF2());
			}
			for(int ind = 0;ind<8;ind++) {
				cells[ind].setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),labs[ind].getText(),0,0,new Font("Times New Roman", Font.BOLD, 15),AllFont.getRessource()));
				labs[ind].setForeground(AllFont.getRessource());
			}
			cells[8].setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),labs[8].getText(),0,0,AllFont.getfMap(),AllFont.getPoliticalStatue()));
			cells[9].setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),labs[9].getText(),0,0,AllFont.getfMap(),AllFont.getIndustrialFactors()));
			cells[10].setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),labs[10].getText(),0,0,AllFont.getfMap(),AllFont.getGdh()));
			cells[11].setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),labs[11].getText(),0,0,AllFont.getfMap(),AllFont.getHid()));
			cells[12].setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),labs[12].getText(),0,0,AllFont.getfMap(),AllFont.getNatalL()));
			cells[13].setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),labs[13].getText(),0,0,AllFont.getfMap(),AllFont.getGini()));
			cells[14].setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),labs[14].getText(),0,0,AllFont.getfMap(),AllFont.getResearch()));
			cells[15].setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),labs[15].getText(),0,0,AllFont.getfMap(),AllFont.getMediumAge()));
			cells[16].setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),labs[16].getText(),0,0,AllFont.getfMap(),AllFont.getnTravel()));
			labs[8].setForeground(AllFont.getPoliticalStatue());
			labs[9].setForeground(AllFont.getIndustrialFactors());
			labs[10].setForeground(AllFont.getGdh());
			labs[11].setForeground(AllFont.getHid());
			labs[12].setForeground(AllFont.getNatalL());
			labs[13].setForeground(AllFont.getGini());
			labs[14].setForeground(AllFont.getResearch());
			labs[15].setForeground(AllFont.getMediumAge());
			labs[16].setForeground(AllFont.getnTravel());



			
	//---------------------------------------------------------------------------------
			//JLabel positioning
			for(int ind=0;ind<labs.length;ind++) {
				paramRecap.add(labs[ind]);
				paramRecap.add(labAnswer[ind]);

			}
			for(int ind=0;ind<cells.length;ind++) {
				choiceContains.add(caseChoice());
		    	cells[ind].setPreferredSize(new Dimension(450, 200));
		    	cells[ind].add(choiceContains.get(ind), gbc);
		    }
//---------------------------------------------------------------------------------
			JScrollPane scrollPane = new JScrollPane(paramContainer);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	        scrollPane.setBounds(50, 30, 1710, 700);//règle la taille du Panel JScroll
	        contentPane.add(scrollPane);
		
    this.add(paramValidate, BorderLayout.EAST);
	this.add(paramRecap,BorderLayout.SOUTH);
    this.add(contentPane,BorderLayout.CENTER);
    
  }

  /**
   * Allows to declare a JSlider with its parameters. Avoid to repeat the code.
   * 
   * @param nom : slider's name
   * @param max : maximum to reach on the slider
   * @param min : minimum to reach on the slider
   * @param val : value displayed at the start
   * @param paintTick : small bar representation
   * @param paintLabel : big bar representation
   * @param tickSpacing : minimal spacing
   * @param tickSpacingHigh : maximum spacing
   * @param label : accurate display next to the slider
   * @return nom : the component to put in the required container
   */
  public Component progressSlide(JSlider nom, int max, int min, int val, boolean paintTick, boolean paintLabel, int tickSpacing, int tickSpacingHigh, final JLabel label) {
		nom.setMaximum(max);
		nom.setMinimum(min);
		nom.setValue(val);
		nom.setPaintTicks(paintTick);
		nom.setPaintLabels(paintLabel);
		nom.setMinorTickSpacing(tickSpacing);
		nom.setMajorTickSpacing(tickSpacingHigh);
		nom.setPreferredSize(new Dimension(150, 50));
		nom.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				label.setText(""+((JSlider)e.getSource()).getValue());
			}
		});
		return nom;
	}
  public JPanel caseChoice() {
	  	panAge=new JPanel();
	    panAge.setBorder(BorderFactory.createTitledBorder("Intensité du choix aléatoire :"));
	    panAge.setPreferredSize(new Dimension(400,50));
	    none=new JRadioButton("None");//-6
	    veryLow=new JRadioButton("Very Low"); //-5
	    low=new JRadioButton("Low");//-4
	    medium=new JRadioButton("Medium"); // -3
	    high=new JRadioButton("High");//-2
	    veryHigh=new JRadioButton("Very High");//-1
	    
	    none.setToolTipText("Valeur aléatoire ");
	    veryLow.setToolTipText("Choisir ses paramètres");
	    low.setToolTipText("Valeur aléatoire ");
	    medium.setToolTipText("Valeur aléatoire ");
	    high.setToolTipText("Valeur aléatoire ");
	    veryHigh.setToolTipText("Valeur aléatoire ");
	    
	    gr1=new ButtonGroup();
	    gr1.add(none);
	    gr1.add(veryLow);
	    gr1.add(low);
	    gr1.add(medium);
	    gr1.add(high);
	    gr1.add(veryHigh);
	    none.setSelected(true);

	    panAge.add(none);
	    panAge.add(veryLow);
	    panAge.add(low);
	    panAge.add(medium);
	    panAge.add(high);
	    panAge.add(veryHigh);
	
	    return panAge;
}


  public ArrayList<JPanel> getCaseChoice() {
	return choiceContains;
}

/**
   * 
   * @param cb1 : Initialize a JComboBox which will allows to produce some ComboBox with 3 choices each time.
   * @param choice1 : first choice in the box
   * @param choice2 : second choice in the box
   * @param choice3 : third choice in the box
   * @return cb1 : the component to put in the required container
   */
  public Component comboBoxChoice(JComboBox<String> cb1,String choice1, String choice2, String choice3) {
	  cb1=new JComboBox<String>();
		cb1.addItem(choice1);
		cb1.addItem(choice2);
		cb1.addItem(choice3);
		
		return cb1;
  }
  /**
   * Allows to send SlidersValue of the actual tab.
   * @return ArrayList<Integer>
   */
  public ArrayList<Integer> getValSlide() {
	  stock=new ArrayList<Integer>();// on créé une AL à chaque fois 
	  for(int ind=0;ind<tabC.get(0).length;ind++) {
		  stock.add(tabC.get(0)[ind].getValue());//stocke toutes les valeurs des Sliders PAR onglet
	  }
	  return stock;
  }
  public static void getValChoices(){
  }

  public JSlider[] getJsliders() {
	  return tabC.get(0);
  }
  public JPanel[] getCells() {
	  return tabB.get(0);
  }
  public JPanel getPanParam() {
	  return paramContainer;
  }

}