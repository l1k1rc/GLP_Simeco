package economy;

public class Education {
	private double averageDurationOfSchooling;
	private double expectationSchoolingDuration;
	
	
	public Education(double averageDurationOfSchooling, double expectationSchoolingDuration) {
		this.averageDurationOfSchooling = averageDurationOfSchooling;
		this.expectationSchoolingDuration = expectationSchoolingDuration;
	}


	public double getAverageDurationOfSchooling() {
		return averageDurationOfSchooling;
	}


	public void setAverageDurationOfSchooling(double averageDurationOfSchooling) {
		this.averageDurationOfSchooling = averageDurationOfSchooling;
	}


	public double getExpectationSchoolingDuration() {
		return expectationSchoolingDuration;
	}


	public void setExpectationSchoolingDuration(double expectationSchoolingDuration) {
		this.expectationSchoolingDuration = expectationSchoolingDuration;
	}
	
	

}
