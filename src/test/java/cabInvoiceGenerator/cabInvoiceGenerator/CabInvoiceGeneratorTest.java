package cabInvoiceGenerator.cabInvoiceGenerator;

import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;

public class CabInvoiceGeneratorTest {
	
	CabInvoiceGenerator cabInvoiceGenerator = null;
	
	@Before
	public void setUp() {
		cabInvoiceGenerator = new CabInvoiceGenerator();
	}
	
	@Test
	public void thisTestWillBePassedWhenReturnTotalFare() {
		double distance = 15.0;
		int time = 5; 
		double result = cabInvoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(155, result, 0.0);
	}
	
	@Test
	public void thisTestWillBePassedWhenReturnMinimumFare() {
		double distance = 0.1;
		int time = 1; 
		double result = cabInvoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5, result, 0.0);
	}
	
	@Test
	public void thisTestWillBePassedWhenReturnFareForMultipleRides() {
		Ride[] ride = { new Ride(15.0, 5),
						new Ride(0.1, 1),
						new Ride(8.0, 3) 
		};
		InvoiceSummary summary = cabInvoiceGenerator.totalFare(ride);
		InvoiceSummary expectedSummary = new InvoiceSummary(3, 243.0);
		Assert.assertEquals(expectedSummary, summary);
	}
	
	@Test
	public void thisTestWillBePassedWhenIdPassedAndReturnSummaryEquals() { 
		InvoiceSummary summary = cabInvoiceGenerator.calculateTotalFareFromRepository(3300);
		InvoiceSummary expectedSummary = new InvoiceSummary(3, 303.0);
		Assert.assertEquals(expectedSummary, summary);
	}
	
	@Test
	public void thisTestWillBePassedWhenIdAndTypePassedAndReturnSummaryEquals() { 
		InvoiceSummary summary = cabInvoiceGenerator.calculateTotalFareFromRepositoryAndType(3300, "Premium");
		InvoiceSummary expectedSummary = new InvoiceSummary(3, 466.0);
		Assert.assertEquals(expectedSummary, summary);
	}
}
