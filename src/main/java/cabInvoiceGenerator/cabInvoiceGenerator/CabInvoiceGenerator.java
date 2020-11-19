package cabInvoiceGenerator.cabInvoiceGenerator;

public class CabInvoiceGenerator {
	private static final double MIN_COST_PER_KM = 10;
	private static final int COST_PER_MIN = 1;
	private static final double MINIMUM_COST = 5.0;

	public double calculateFare(double distance, int time) {
		double totalFare =  distance * MIN_COST_PER_KM + time * COST_PER_MIN;
		if(totalFare < MINIMUM_COST)
			totalFare = MINIMUM_COST;
		return totalFare;
	}
}
