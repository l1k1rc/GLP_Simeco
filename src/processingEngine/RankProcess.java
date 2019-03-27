package processingEngine;

import java.util.Set;

import region.RegionMap;

public class RankProcess {
	private static RegionMap region;
	
	
	@SuppressWarnings("static-access")
	public RankProcess(RegionMap region) {
		this.region=region;
	}
	
	public int[] rankCountry() {
		int j = 0;
		int[] tab =new int[10];
		Set<String> keySet = region.getMapRegion().keySet();
		for (String key : keySet) {
			
			int i = 0;
			int coeff =0;
			while(i <= region.getState(key).getEconomicalFactors().getGdpValues().getGdp()) {
				if(i%10000==0) {
					coeff+=1;
				}
				i+=100000;
			}
			i = 0;
			double hidrank = (region.getState(key).getEconomicalFactors().getHidValues().getHid())*10;
			while(i<=hidrank) {
				if(i%1==0) {
					coeff+=2;
				}
				i+=1;
			}
			i=0;
			while(i <= region.getState(key).getEconomicalFactors().getTradeAgreements().getNumberGlobalOf()) {
				if(i%1==0) {
					coeff+=4;
				}
				i+=1;
			}
			i=0;
			if((region.getState(key).getEconomicalFactors().getPopulationValues().getPopulationGrowth())<0) {
				coeff+=(-7);
			}
			while(i<=region.getState(key).getEconomicalFactors().getPopulationValues().getPopulationGrowth()) {
				if(i%1==0) {
					coeff+=7;
				}
				i+=1;
			}
			i=0;
			while(i<=region.getState(key).getEconomicalFactors().getPopulationValues().getGini()) {
				if(i%15==0) {
					coeff+= (-1);
				}
				i+=15;
			}
			i=0;
			while(i<=region.getState(key).getEconomicalFactors().getPopulationValues().getReschercheSpending()) {
				if(i%1==0) {
					coeff+=2;
				}
				i+=1;
			}
			i=0;
			while(i<=region.getState(key).getEconomicalFactors().getPopulationValues().getUnemploymentRate()) {
				if(i%1==0) {
					coeff+=(-1);
				}
				i+=1;
			}
			i=0;
			while(i<=region.getState(key).getMilitarisation().getMilitaryBudget()) {
				coeff+=1;
				i+=1;
			}
			i=0;
			while(i<=region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().getGoldIndustries()) {
				coeff+=4;
				i+=3;
			}
			i=0;
			while(i<=region.getState(key).getIndustrialFactors().getFuelIndustry().getPercentageOf()) {
				coeff+=4;
				i+=3;
			}
			i=0;
			while(i<=region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().getCoalIndustries()) {
				coeff+=3;
				i+=3;
			}
			i=0;
			while(i<=region.getState(key).getIndustrialFactors().getMiningProcessingIndustries().getSteelIndustries()) {
				coeff+=3;
				i+=3;
			}
			i=0;
			while(i<=region.getState(key).getIndustrialFactors().getFoodIndustries().getAnimalIndustries()) {
				coeff+=2;
				i+=3;
			}
			i=0;
			while(i<=region.getState(key).getIndustrialFactors().getFoodIndustries().getFarmingIndustries()) {
				coeff+=2;
				i+=3;
			}
			i=0;
			while(i<=region.getState(key).getIndustrialFactors().getFoodIndustries().getFishingIndustries()) {
				coeff+=2;
				i+=3;
			}
			i=0;
			while(i<=region.getState(key).getIndustrialFactors().getWoodIndustry().getPercentageOf()) {
				coeff+=1;
				i+=3;
			}
			
			tab[j]=coeff;
			j++;
			
		}
		
		
		
		
		
		return tab;
		
	}
	
	public static RegionMap getRegion() {
		return region;
	}
	@SuppressWarnings("static-access")
	public void setRegion(RegionMap region) {
		this.region = region;
	}
	
	
}
