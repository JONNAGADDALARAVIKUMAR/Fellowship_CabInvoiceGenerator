package cabInvoiceGenerator.cabInvoiceGenerator;

public class CabInvoiceGenerator {
	private static final double MIN_COST_PER_KM = 10;
	private static final int COST_PER_MIN = 1;

	public double calculateFare(double distance, int time) {
		return distance * MIN_COST_PER_KM + time * COST_PER_MIN;
	}
}
