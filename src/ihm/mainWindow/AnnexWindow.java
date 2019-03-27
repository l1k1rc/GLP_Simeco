package ihm.mainWindow;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.JTable;

import ihm.parametersWindow.Sorting;
import processingEngine.RankProcess;

public class AnnexWindow extends JPanel {

	private static final long serialVersionUID = -6168709182394085987L;
	/**
	 * Allows to build an internal frame which will display each economic factors for the country selected.
	 * @param whichCountry : send the key of the country
	 */
	public AnnexWindow(String whichCountry) {
		ArrayList<Object[][]> ar=new ArrayList<Object[][]>();
		setLayout(new BorderLayout());
		
		setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		Set<String> keySet = Sorting.getRegion().getMapRegion().keySet();
		for (@SuppressWarnings("unused") String key : keySet) {
			Object[][] donnees ={
	                {"Produit intérieur brut (M$)", RankProcess.getRegion().getState(whichCountry).getEconomicalFactors().getGdpValues().getGdp()},
	                {"Indice de développement humain", RankProcess.getRegion().getState(whichCountry).getEconomicalFactors().getHidValues().getHid()},
	                {"Lac", RankProcess.getRegion().getState(whichCountry).getRessources().getLakes().getNumberOf()},
	                {"Terre exploitable", RankProcess.getRegion().getState(whichCountry).getRessources().getSuitablesLands().getNumberOf()},
	                {"Champs", RankProcess.getRegion().getState(whichCountry).getRessources().getFields().getNumberOf()},
	                {"Forêt",  RankProcess.getRegion().getState(whichCountry).getRessources().getForests().getNumberOf()},
	                {"Mine d'or",  RankProcess.getRegion().getState(whichCountry).getRessources().getIronMines().getNumberOf()},
	                {"Mine de Fer",  RankProcess.getRegion().getState(whichCountry).getRessources().getIronMines().getNumberOf()},
	                {"Mine de charbon",  RankProcess.getRegion().getState(whichCountry).getRessources().getCoalMines().getNumberOf()},
	                {"Soldats", RankProcess.getRegion().getState(whichCountry).getMilitarisation().getNbSoldiers()},
	                {"Budget Militaire (% PIB)", RankProcess.getRegion().getState(whichCountry).getMilitarisation().getMilitaryBudget()},
	                {"Croissance démographique (% Popu)", RankProcess.getRegion().getState(whichCountry).getEconomicalFactors().getPopulationValues().getPopulationGrowth()},
	                {"GINI", RankProcess.getRegion().getState(whichCountry).getEconomicalFactors().getPopulationValues().getGini()},
	                {"Budget R&D (% PIB)", RankProcess.getRegion().getState(whichCountry).getEconomicalFactors().getPopulationValues().getReschercheSpending()},
	                {"Age moyen (Ans)", RankProcess.getRegion().getState(whichCountry).getEconomicalFactors().getPopulationValues().getMiddleAge()},
	                {"Taux de chômage (% Popu)", RankProcess.getRegion().getState(whichCountry).getEconomicalFactors().getPopulationValues().getUnemploymentRate()},
	                {"Pouvoir d'achat ($)", RankProcess.getRegion().getState(whichCountry).getEconomicalFactors().getHidValues().getPerCapitaIncome().getPerCapitaIncome()},
	                {"Population (M)", RankProcess.getRegion().getState(whichCountry).getEconomicalFactors().getHidValues().getPerCapitaIncome().getPopulation()},
	                {"Accords commerciaux", RankProcess.getRegion().getState(whichCountry).getEconomicalFactors().getTradeAgreements().getCommAgr().getNumberOf()},
	                {"Partenaires commerciaux", RankProcess.getRegion().getState(whichCountry).getEconomicalFactors().getTradeAgreements().getCommAgr().getPartners()},
	                {"Accords industriels", RankProcess.getRegion().getState(whichCountry).getEconomicalFactors().getTradeAgreements().getInduAgr().getNumberOf()},
	                {"Partenaires industriels", RankProcess.getRegion().getState(whichCountry).getEconomicalFactors().getTradeAgreements().getInduAgr().getPartners()},
	                {"Accords militaires", RankProcess.getRegion().getState(whichCountry).getEconomicalFactors().getTradeAgreements().getMilitaryAgr().getNumberOf()},
	                {"Partenaires militaires", RankProcess.getRegion().getState(whichCountry).getEconomicalFactors().getTradeAgreements().getMilitaryAgr().getPartners()},         
	        };
			ar.add(donnees);
			break;
		}
 
        String[] entetes = {"Facteur Economique", "Valeur"};
 
        JTable tableau = new JTable(ar.get(0), entetes);
        
        add(tableau.getTableHeader(),BorderLayout.NORTH);
        add(tableau,BorderLayout.CENTER);
		
	}
}
