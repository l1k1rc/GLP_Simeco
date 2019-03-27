package ihm.mainWindow;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

import ihm.graphChart.BuildChart;
import ihm.graphChart.LineChartBasic;
import ihm.graphChart.LineChartForTwoFactors;
import ihm.graphChart.LineChartIndustries;
import ihm.graphChart.LineChartRessources;
/**
 * Class which allows to set all "ActionListener" to JButton from "FenetrePrincipale"
 */
public class ActionButton extends JInternalFrame{

	private static final long serialVersionUID = 1828122916925297853L;
	  
	public ActionButton() {
		FenetrePrincipale.getContainer().add(this);// ajout de la fenêtre interne au container de la fenêtre principal via le constructeur de la classe ( obligatoire )

	}
	/*
	 * JButton for each country in the map.
	 */
	public void country1() {
		FenetrePrincipale.getAllButtonCountry().get(0)[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new AnnexWindow("0"));
				
			}
		});
	}
	public void country2() {
		FenetrePrincipale.getAllButtonCountry().get(0)[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new AnnexWindow("1"));
				
			}
		});
	}
	public void country3() {
		FenetrePrincipale.getAllButtonCountry().get(0)[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new AnnexWindow("2"));
				
			}
		});
	}
	public void country4() {
		FenetrePrincipale.getAllButtonCountry().get(0)[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new AnnexWindow("3"));
				
			}
		});
	}
	public void country5() {
		FenetrePrincipale.getAllButtonCountry().get(0)[4].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new AnnexWindow("4"));
				
			}
		});
	}
	public void country6() {
		FenetrePrincipale.getAllButtonCountry().get(0)[5].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new AnnexWindow("5"));
				
			}
		});
	}
	public void country7() {
		FenetrePrincipale.getAllButtonCountry().get(0)[6].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new AnnexWindow("6"));
				
			}
		});
	}
	public void country8() {
		FenetrePrincipale.getAllButtonCountry().get(0)[7].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new AnnexWindow("7"));
				
			}
		});
	}
	public void country9() {
		FenetrePrincipale.getAllButtonCountry().get(0)[8].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new AnnexWindow("8"));
				
			}
		});
	}
	public void country10() {
		FenetrePrincipale.getAllButtonCountry().get(0)[9].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new AnnexWindow("9"));
				
			}
		});
	}
	/*
	 * JButton for each graphButton in the inferior panel.
	 */
	public void rankButtonItHappens() {
		FenetrePrincipale.getRank().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new BuildChart(FenetrePrincipale.getHmGlobalPower()).getContentPane());
			}
		});
	}
	public void but1ItHappens() {
		FenetrePrincipale.getAllButton().get(0)[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new LineChartRessources(FenetrePrincipale.getHmGraph()).getContentPane());
			}
		});
	}
	public void but2ItHappens() {
		FenetrePrincipale.getAllButton().get(0)[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new LineChartIndustries(FenetrePrincipale.getHmGraph()).getContentPane());
			}
		});
	}
	public void but3ItHappens() {
		FenetrePrincipale.getAllButton().get(0)[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new LineChartBasic(FenetrePrincipale.getHmGraph(),23,"PIB","Produit Interieur Brut").getContentPane());
			}
		});
	}
	public void but4ItHappens() {
		FenetrePrincipale.getAllButton().get(0)[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new LineChartBasic(FenetrePrincipale.getHmGraph(), 24, "IDH", "Indice de développement humain").getContentPane());
			}
		});
	}
	public void but5ItHappens() {
		FenetrePrincipale.getAllButton().get(0)[4].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new LineChartBasic(FenetrePrincipale.getHmGraph(), 18, "Croissance démographique", "Evolution de la croissance démographique").getContentPane());
			}
		});
	}
	public void but6ItHappens() {
		FenetrePrincipale.getAllButton().get(0)[5].addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new LineChartForTwoFactors(FenetrePrincipale.getHmGraph(),22,21,"Chômage","Age moyen","Age moyen et chômage").getContentPane());
			}
		});
	}
	public void but7ItHappens() {
		FenetrePrincipale.getAllButton().get(0)[6].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new LineChartBasic(FenetrePrincipale.getHmGraph(), 20, "Budget R&D", "Budget recherche et développement").getContentPane());
			}
		});
	}
	public void but8ItHappens() {
		FenetrePrincipale.getAllButton().get(0)[7].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new LineChartBasic(FenetrePrincipale.getHmGraph(),19,"GINI","Evolution du GINI").getContentPane());
			}
		});
	}

	public void but9ItHappens() {
		FenetrePrincipale.getAllButton().get(0)[8].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new LineChartForTwoFactors(FenetrePrincipale.getHmGraph(), 16, 17, "Soldats", "Budget Militaire", "Economie Militaire").getContentPane());
			}
		});
	}

	public void but10ItHappens() {
		FenetrePrincipale.getAllButton().get(0)[9].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayJif(new LineChartBasic(FenetrePrincipale.getHmGraph(), 25, "Pouvoir d'achat", "Evolution du pouvoir d'achat par année.").getContentPane());
			}
		});
	}

	/**
	 * Allows to limit our lines of code.
	 * @param content : Container to send
	 * @see graphChart.BuildChart
	 * @see graphChart.LineChart_AWT 
	 */
	public void displayJif(Container content) {
		setTitle("Simeco");
		setSize(800, 590);
		setVisible(true);
		setClosable(true);
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		toFront();
		setContentPane(content);
	}

}
