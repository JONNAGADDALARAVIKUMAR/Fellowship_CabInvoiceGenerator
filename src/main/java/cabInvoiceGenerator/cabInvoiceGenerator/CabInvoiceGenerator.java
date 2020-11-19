package cabInvoiceGenerator.cabInvoiceGenerator;

import java.util.ArrayList;
import java.util.HashMap;

public class CabInvoiceGenerator {
	private static final double MIN_COST_PER_KM = 10;
	private static final int COST_PER_MIN = 1;
	private static final double MINIMUM_COST = 5.0;

	Ride firstRider1 = new Ride(15.0, 5);
	Ride firstRider2 = new Ride(0.1, 1);
	Ride firstRider3 = new Ride(8.0, 3);
	Ride secondRider1 = new Ride(3.0, 8);
	Ride secondRider2 = new Ride(7.0, 2);
	Ride secondRider3 = new Ride(8.0, 5);
	Ride thirdRider1 = new Ride(5.0, 9);
	Ride thirdRider2 = new Ride(8.0, 10);
	Ride thirdRider3 = new Ride(15.0, 4);
	
	ArrayList<Ride> firstRider = new ArrayList<Ride>();
	ArrayList<Ride> secondRider = new ArrayList<Ride>();
	ArrayList<Ride> thirdRider = new ArrayList<Ride>();
	HashMap<Integer, ArrayList<Ride>> repository = new HashMap<Integer, ArrayList<Ride>>();
	
	public double calculateFare(double distance, int time) {
		double totalFare =  distance * MIN_COST_PER_KM + time * COST_PER_MIN;
		return Math.max(totalFare, MINIMUM_COST);
	}

	public InvoiceSummary totalFare(Ride[] rides) {
		double totalFare = 0; 
		for (Ride ride : rides) {
			totalFare += calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

	public InvoiceSummary calculateTotalFareFromRepository(int id) {
		firstRider.add(firstRider1);
		firstRider.add(firstRider2);
		firstRider.add(firstRider3);
		secondRider.add(secondRider1);
		secondRider.add(secondRider2);
		secondRider.add(secondRider3);
		thirdRider.add(thirdRider1);
		thirdRider.add(thirdRider2);
		thirdRider.add(thirdRider3);
		repository.put(1100, firstRider);
		repository.put(2200, secondRider);
		repository.put(3300, thirdRider);
		
		ArrayList<Ride> rides = repository.get(id);
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.size(), totalFare);
	}
	
}
