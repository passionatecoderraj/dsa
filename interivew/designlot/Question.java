package com.interivew.designlot;

import java.util.Random;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ParkingLot lot = new ParkingLot();

		Vehicle v = null;
		int min = 0, max = 10;
		Random rand = new Random();
		while (v == null || lot.parkVehicle(v)) {
			lot.print();

			int r = rand.nextInt(max - min + 1) + min;
			//System.out.println("r="+r);
			if (r < 2) {
				v = new Bus();
			} else if (r < 4) {
				v = new Motorcycle();
			} else {
				v = new Car();
			}
			System.out.print("\nParking a ");
			v.print();
			System.out.println("");
		}
		System.out.println("Parking Failed. Final state: ");
		lot.print();
	}

}
