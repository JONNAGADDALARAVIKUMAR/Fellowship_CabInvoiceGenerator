package cabInvoiceGenerator.cabInvoiceGenerator;

import org.junit.Test;
import junit.framework.Assert;

public class CabInvoiceGeneratorTest {
	
	@Test
	public void thisTestWillBePassedWhenReturnTotalFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		double distance = 15.0;
		int time = 5; 
		double result = cabInvoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(155, result, 0.0);
	}
}
