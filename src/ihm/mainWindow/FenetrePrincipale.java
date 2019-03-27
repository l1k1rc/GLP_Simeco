package ihm.mainWindow; 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ihm.fontElements.AllFont;
import ihm.menuWindow.UserGuide;
import ihm.parametersWindow.Sorting;
import processingEngine.ProcessingAlgorithm;
import processingEngine.RankProcess;
import processingEngine.RegionProcess;
import processingEngine.SmartAdvicesAlgorithm;
/**
 * Main window which will display every economical factors, a map of the region and each pie/line chart associated to their factors.
 * @author MATTHIEU
 */
public class FenetrePrincipale extends JFrame { 

	@SuppressWarnings("unused")
	private static final long serialVersionUID2 = -4216493798047216296L;
	private static final long serialVersionUID = 1L;
	/*
	 * Objects and components declaration/initialization.
	 */
	private static HashMap<String, double[]> hmGraph=new HashMap<String,double[]>();
	private static HashMap<String, int[]> hmGlobalPower=new HashMap<String,int[]>();
	private static ArrayList<JButton[]> buttonRegion=new ArrayList<JButton[]>();
    private static ArrayList<JButton[]> allButtonCountry=new ArrayList<JButton[]>();
	private static JButton rank=new JButton(new ImageIcon("ranking.png"));
	private static JPanel container=new JPanel(); 
	
	private JPanel panelAccesCountry=new JPanel(); 
	private JPanel panelModifCountry=new JPanel(); 
	private JPanel allEast=new JPanel(); 
	private JPanel panelLabelCountry=new JPanel();
	private JPanel mapCountries=new JPanel();
	private JPanel panelRegionInfo=new JPanel();
	private JPanel countryRanking=new JPanel(); 
	
	private JMenuBar menuBar= new JMenuBar();
	private JMenu first = new JMenu("Fichier");
	private JMenuItem item2=new JMenuItem("Help");
	private JMenuItem item3=new JMenuItem("Activer IA");
	
	private boolean activeIA=false;
	
	private JButton stop=new JButton(new ImageIcon("pause.png"));
	private JButton go=new JButton(new ImageIcon("play.png"));
	private JTextArea jtaF=new JTextArea(2,2); 

	private JInternalFrame jif= new JInternalFrame("Fenetre");
    	 
    private JLabel lab = new JLabel(new ImageIcon("map3.png"));

	private GridLayout g1 = new GridLayout(27, 1); 
	private GridLayout g2 = new GridLayout(10, 1); 
    private GridBagConstraints gbc = new GridBagConstraints();
    
    private ArrayList<JLabel[]> labsMain=new ArrayList<JLabel[]>();
    private ArrayList<JLabel[]> labRanking=new ArrayList<JLabel[]>();
    
	private Timer time=new Timer();
	private ActionButton act=new ActionButton();

	 /**
	  * This constructor is the main IHM which allows to start the simulation with any economical factors and their evolution.
	  */
	public FenetrePrincipale() { 
		
		//------------------------Set the frame------------------------------------------------------
		this.setTitle("Simeco"); 
		this.setResizable(true); 
		this.setBackground(Color.WHITE);
		this.setSize(new Dimension(1920, 1080));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setLocationRelativeTo(null); 
		this.setIconImage(new ImageIcon("euro.png").getImage());
		
		//------------------------Instance of the repeating components-------------------------------
		JLabel[] tabResult= {new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),
				new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel()  };
		labsMain.add(tabResult);
		
		JLabel[] tabName= {new JLabel("Nbr Lac"),new JLabel("Nbr Terre Exploitable"),new JLabel("Nbr Champs"),new JLabel("Nbr Forêt"),new JLabel("Puits pétrolier"),new JLabel("Mine d'or"),new JLabel("Mine de fer"),new JLabel("Mine Charbon"),new JLabel("Ind Poisson (%)"),new JLabel("Ind Animal (%)"),new JLabel("Ind Ferme (%)"),new JLabel("Ind Fer (%)"),new JLabel("Ind gold (%)"),new JLabel("Ind Charbon (%)"),
				new JLabel("Ind Bois (%)"),new JLabel("Ind Pétrolière (%)"),new JLabel("Soldats"),new JLabel("Bdgt Militaire (%PIB)"),new JLabel("Cr. Démo. (%pop)"),new JLabel("Gini"),new JLabel("Budget Dev (%PIB)"),new JLabel("Age moyen"),new JLabel("Chômage (%)"),new JLabel("PIB (M$)"),new JLabel("IDH"),new JLabel("Pouvoir d'achat ($)"),new JLabel("Population")  };
		
		JLabel[] nLabs= {new JLabel("n°1"),new JLabel("n°2"),new JLabel("n°3"),new JLabel("n°4"),new JLabel("n°5"),new JLabel("n°6"),new JLabel("n°7"),new JLabel("n°8"),new JLabel("n°9"),new JLabel("n°10") };
		labRanking.add(nLabs);
		
		JPanel[] tabCells= { new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(),new JPanel(),
				new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel()};
		
		JButton[] tabButtonRegion= {new JButton(new ImageIcon("tree.png")),new JButton(new ImageIcon("industries.png")),new JButton(new ImageIcon("gdp.png")),new JButton(new ImageIcon("hid.png")),new JButton(new ImageIcon("population.png")),
				new JButton(new ImageIcon("ageMoyen.png")), new JButton(new ImageIcon("rechDepense.png")), new JButton(new ImageIcon("gini.png")), new JButton(new ImageIcon("military.png")), new JButton(new ImageIcon("ecoPower.png")) };
		buttonRegion.add(tabButtonRegion);
		
		JButton[] buttonCountry= {new JButton("hs"),new JButton("hs"),new JButton("hs"),new JButton("hs"),new JButton("hs"),
				new JButton("hs"),new JButton("hs"),new JButton("hs"),new JButton("hs"),new JButton("hs")
		};
		allButtonCountry.add(buttonCountry);
		
		//-----------------------Top menu placement--------------------------------------------------
		this.first.add(item2);
		this.first.add(item3);
		this.menuBar.add(first);
		this.setJMenuBar(menuBar);		
		
		//----------------------Setting of the different JLayout-------------------------------------
		g1.setVgap(5); 
		 
		container.setLayout(new BorderLayout()); 
		allEast.setLayout(new BorderLayout()); 
		panelAccesCountry.setLayout(new FlowLayout()); 
		panelModifCountry.setLayout(g1); 
		panelLabelCountry.setLayout(g1); 
		panelRegionInfo.setLayout(new GridBagLayout());
		countryRanking.setLayout(g2); 
		
		//-----------------------------Setting of the different JButton------------------------------ 

		go.setBackground(Color.DARK_GRAY);
		stop.setBackground(Color.DARK_GRAY);
		panelAccesCountry.add(go);
		panelAccesCountry.add(stop);
		//--------------------------Adding colors to the coefficients--------------------------------
		for(int ind=0;ind<8;ind++) {
			tabResult[ind].setForeground(AllFont.getRessource());
		}
		for(int ind=8;ind<16;ind++) {
			tabResult[ind].setForeground(AllFont.getIndustrialFactors());
		}
		tabResult[16].setForeground(AllFont.getSoldier());
		tabResult[17].setForeground(AllFont.getSoldier());
		tabResult[18].setForeground(AllFont.getNatalL());
		tabResult[19].setForeground(AllFont.getGini());
		tabResult[20].setForeground(AllFont.getResearch());
		tabResult[21].setForeground(AllFont.getMediumAge());
		tabResult[22].setForeground(AllFont.getUnChom());
		tabResult[23].setForeground(AllFont.getGdh());
		tabResult[24].setForeground(AllFont.getHid());
		tabResult[25].setForeground(AllFont.getPowerMon());
		tabResult[26].setForeground(AllFont.getPop());

		

		//------------------------Setting the different components-----------------------------------
		for(int index=0;index<tabName.length;index++) {
			tabName[index].setFont(AllFont.getF2());
			panelLabelCountry.add(tabName[index]);
		}
		for(JLabel ind : tabResult) {
			panelModifCountry.add(ind);
			ind.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		}

		//--------------------Adding JLabel for the ranking-------------------------------------------
		for(JLabel n : nLabs) {
			countryRanking.add(n);
		}
		rank.setSize(new Dimension(80, 80));
		rank.setBackground(Color.DARK_GRAY);
		countryRanking.add(rank);

		//-------------------------Setting map--------------------------------------------------------
		mapCountries.setLayout(null);
        lab.setBounds(100, 80, 1060, 850);
        for(JButton b : buttonCountry ) {
            b.setContentAreaFilled(false);
        }
        buttonCountry[0].setBounds(613, 330, 103, 50);
        buttonCountry[1].setBounds(464, 406, 100, 50);
        buttonCountry[2].setBounds(564, 406, 100, 50);
        buttonCountry[3].setBounds(664, 406, 100, 50);
        buttonCountry[4].setBounds(410, 483, 102, 50);
        buttonCountry[5].setBounds(512, 483, 102, 50);
        buttonCountry[6].setBounds(614, 483, 102, 50);
        buttonCountry[7].setBounds(718, 483, 102, 50);
        buttonCountry[8].setBounds(662, 560, 102, 50);
        buttonCountry[9].setBounds(361, 560, 102, 50);
        for(int ind=0;ind<Sorting.getText().size();ind++) {
        	buttonCountry[ind].setText(Sorting.getText().get(ind));
        	buttonCountry[ind].setFont(AllFont.getfMapCountries());
        }

        mapCountries.add(buttonCountry[0]);
        mapCountries.add(buttonCountry[1]);
        mapCountries.add(buttonCountry[2]);
        mapCountries.add(buttonCountry[3]);
        mapCountries.add(buttonCountry[4]);
        mapCountries.add(buttonCountry[5]);
        mapCountries.add(buttonCountry[6]);
        mapCountries.add(buttonCountry[7]);
        mapCountries.add(buttonCountry[8]);
        mapCountries.add(buttonCountry[9]);


        mapCountries.add(lab);
		//---------------------------Setting and placement of the cells from the GridBagLayout---------
		for(int index=0;index<tabCells.length;index++) {
			tabCells[index].setPreferredSize(new Dimension(120, 55));
		}
		gbc.gridx=0;
		gbc.gridy=0;
		
		for(int index=0;index<tabButtonRegion.length;index++) {
			panelRegionInfo.add(tabButtonRegion[index],gbc);
			panelRegionInfo.add(tabCells[index],gbc);

			gbc.gridx++;
			if(gbc.gridx%12==0) {
				gbc.gridy++;
				gbc.gridx=0;
			}
		}
		//------------------------Setting JButton with a special font and toolTipPex--------------------
		for(int index=0;index<tabButtonRegion.length;index++) {
			tabButtonRegion[index].setPreferredSize(new Dimension(100, 40));
			tabButtonRegion[index].setFont(AllFont.getF2());
		}
		tabButtonRegion[0].setToolTipText("Les ressources de la région");
		tabButtonRegion[1].setToolTipText("Les industries de la région");
		tabButtonRegion[2].setToolTipText("Le produit intérieur brut (PIB) de la région");
		tabButtonRegion[3].setToolTipText("L'indice de développement humain (IDH) de la région");
		tabButtonRegion[4].setToolTipText("Démographie de la région");
		tabButtonRegion[5].setToolTipText("Age moyen de la région");
		tabButtonRegion[6].setToolTipText("Dépenses en recherche de la région");
		tabButtonRegion[7].setToolTipText("GINI : indicateur synthétique d'inégalités de salaires (de revenus, de niveaux de vie...");
		tabButtonRegion[8].setToolTipText("Economie militaire de la région");
		tabButtonRegion[9].setToolTipText("Pouvoir d'achat global");


		//--------------------------------Setting of the JScrollPane for the right Panel----------------
		JScrollPane scrollPane = new JScrollPane(allEast);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 30, 400, 700);
        
		//-----------------------------Call the actions-------------------------------------------------
				item2ItHappens();
				item3ItHappens();
				act.but1ItHappens();
				act.but2ItHappens();
				act.but3ItHappens();
				act.but4ItHappens();
				act.but5ItHappens();
				act.but6ItHappens();
				act.but7ItHappens();
				act.but8ItHappens();
				act.but9ItHappens();
				act.but10ItHappens();
				act.rankButtonItHappens();
				act.country1();
				act.country2();
				act.country3();
				act.country4();
				act.country5();
				act.country6();
				act.country7();
				act.country8();
				act.country9();
				act.country10();

				time.start();//call the thread of the internal class
		//-------------------------------Positioning and setting of the different panel------------------
		
		allEast.setPreferredSize(new Dimension(300, 1900));
	    panelAccesCountry.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Options Région",0,0,AllFont.getfMap(),Color.BLACK));
		lab.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Carte",0,0,AllFont.getfMap(),Color.WHITE));
	    countryRanking.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Classement des pays",0,0,AllFont.getfMap(),Color.BLACK));
		mapCountries.setBorder(javax.swing.BorderFactory.createLoweredBevelBorder());
		panelLabelCountry.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		panelRegionInfo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Informations graphiques de la région",0,0,AllFont.getfMap(),Color.BLACK));
		allEast.setBorder(BorderFactory.createLineBorder(Color.black)); 
		jtaF.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); 
		mapCountries.setBackground(Color.DARK_GRAY);
		
		allEast.add(panelAccesCountry,BorderLayout.NORTH); 
		allEast.add(panelModifCountry, BorderLayout.CENTER); 
		allEast.add(panelLabelCountry, BorderLayout.WEST); 
		container.add(jif);
		container.add(countryRanking, BorderLayout.WEST); 
		container.add(scrollPane,BorderLayout.EAST); 
		container.add(mapCountries, BorderLayout.CENTER); 
		container.add(panelRegionInfo,BorderLayout.SOUTH);
		container.validate();
		
		//-------------------------------Last setting for the JFrame--------------------------------------
		this.setContentPane(container); 
		this.setVisible(true); 
	} 
	public void item3ItHappens() {
		item3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(activeIA==false) {
					activeIA=true;
					JOptionPane.showMessageDialog(null, "IA Activée.", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					activeIA=false;
					JOptionPane.showMessageDialog(null, "IA désactivée.", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
	public void item2ItHappens() {
		item2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserGuide.openGuide();
			}
		});
	}

	/**
	 * Allows to stop the simulation.
	 */
	boolean stopp;
	public void stopItHappens() {
		stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stopp=true;
			}
		});
	}
	/**
	 * Allows to get simulation back.
	 */
	public void goItHappens() {
		go.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stopp=false;
			}
		});
		
	}
	/**
	 * <strong>Internal Class.</strong>
	 * <br /><em>It does the junction between Core part and IHM part.
	 * Allows to change the economical factors of the region.
	 * This class use especially a Thread.
	 * Here, the main Thread isn't interrupted thanks to the Thread class.
	 * It call each calculation methods form the core.
	 */
	class Timer extends Thread{
		private RegionProcess values;
		private RankProcess rankProcess;
		private HashMap<String, Integer> hmGlobalPowerToSort=new HashMap<String,Integer>();
		public Timer() {
				super();
    		}
		public void run() {
			try
			{
				int finished = 0;
				ProcessingAlgorithm processingAlgorithm=new ProcessingAlgorithm();
				stopItHappens();
				countryRanking.add(new ProgressForIHM());
				ProgressForIHM.setMaximumBar(Sorting.getTiming());
				while (finished!=Sorting.getTiming())
				{         
					rankProcess=new RankProcess(Sorting.getRegion());
					int[] globalPower=rankProcess.rankCountry();
					hmGlobalPower.put(Integer.toString(finished), globalPower);
					for(int index=0;index<globalPower.length;index++) {
						hmGlobalPowerToSort.put(Integer.toString(index),globalPower[index]);
					}
					sortHashMap(hmGlobalPowerToSort);
					values=new RegionProcess(Sorting.getRegion());// call to regionProcess with the region variable in each iteration
					double[] allValues=values.moyenneRegion();//stock every values to get in the JLabel
					hmGraph.put(Integer.toString(finished),allValues);
					
					for(int index=0;index<labsMain.get(0).length;index++) {
						labsMain.get(0)[index].setFont(AllFont.getF3());
						}
					for(int ind=0;ind<27;ind++) {
						labsMain.get(0)[ind].setText(String.valueOf(allValues[ind]));
					}
					Sorting.setRegion(processingAlgorithm.engineProcess(Sorting.getRegion()));// reload values
					//Set the progression bar which allows to know where the simulation is
					ProgressForIHM.incrementBar(finished);
					
					// Set the IA help
					SmartAdvicesAlgorithm smartAdvicesAlgorithm=new SmartAdvicesAlgorithm(Sorting.getRegion());
					Sorting.setRegion(smartAdvicesAlgorithm.crisisDetector());
					boolean[] helpArray=smartAdvicesAlgorithm.helpNeededDetector();
					if(activeIA==true) {
					for(int i=0;i<10;i++) {
						if(helpArray[i]==true) {
							int option = JOptionPane.showConfirmDialog(null, 
							        "Pays en crise: Pays n°-"+i+"\nVoulez-vous réguler les industries de ce pays ?", 
							        "Crise", 
							        JOptionPane.YES_NO_OPTION, 
							        JOptionPane.QUESTION_MESSAGE);
							      if(option == JOptionPane.OK_OPTION){
							    	  Sorting.setRegion(smartAdvicesAlgorithm.helpProcess(i, true));
							      }
							      else {
										Sorting.setRegion(smartAdvicesAlgorithm.helpProcess(i, false));


							      }
						}
					}
					}
					Thread.sleep (2000); 
					
					while(stopp==true) {
						goItHappens();
						if(stopp==false) {
							break;
						}
					} 
					finished++;
				}
				//End of the simulation
				sortHashMap(hmGlobalPowerToSort);
				ProgressForIHM.setEndBar();
				JOptionPane.showMessageDialog(null, "Fin de simulation", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
			catch (InterruptedException exception){}
		}
		
	}
	/**
	 * Allows to sort the HashMap.
	 * @param map : contains each global power values of each country.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void sortHashMap(HashMap<String, Integer> map) {
		int i=0,j=1;
		Object[] a = map.entrySet().toArray();
		Arrays.sort(a, new Comparator() {
		    public int compare(Object o1, Object o2) {
		        return ((Map.Entry<String, Integer>) o2).getValue()
		                   .compareTo(((Map.Entry<String, Integer>) o1).getValue());
		    }
		});
		
		for(Object e: a) {
			labRanking.get(0)[i].setFont(AllFont.getfMap());
			labRanking.get(0)[i].setBorder(javax.swing.BorderFactory.createLoweredBevelBorder());
			labRanking.get(0)[i].setText("n°"+j+": Pays n°-"+((Map.Entry<String, Integer>) e).getKey());
			i++;
			j++;
		}
	}

    public ArrayList<JLabel[]> getLabs() {
    	return labsMain;
    }
    public static ArrayList<JButton[]> getAllButton(){
    	return buttonRegion;
    }
    public static JPanel getContainer() {
    	return container;
    }
	public static HashMap<String, double[]> getHmGraph() {
		return hmGraph;
	}
	public static HashMap<String, int[]> getHmGlobalPower() {
		return hmGlobalPower;
	}
	public static JButton getRank() {
		return rank;
	}
	public static ArrayList<JButton[]> getAllButtonCountry() {
		return allButtonCountry;
	}
	
    
} 