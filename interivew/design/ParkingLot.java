package com.interivew.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

abstract class Vehicle {

}

class Motorcycle extends Vehicle {

}

class Car extends Vehicle {

}

class Bus extends Vehicle {

}

abstract class Slot {

	private boolean isOccupied;
	private int slotNumber;

	Slot(int slotNumber) {
		isOccupied = false;
		this.slotNumber = slotNumber;
	}

	boolean isOccupied() {
		return isOccupied;
	}

	int getSlotNumber() {
		return slotNumber;
	}

	void park() {
		isOccupied = true;
	}

	void unPark() {
		isOccupied = false;
	}

	@Override
	public boolean equals(Object o) {
		return (((Slot) o).slotNumber == this.slotNumber);
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 53 * hash + this.slotNumber;
		return hash;
	}

}

class SmallSlot extends Slot {
	SmallSlot(int slotNumber) {
		super(slotNumber);
	}
}

class CompactSlot extends Slot {
	CompactSlot(int slotNumber) {
		super(slotNumber);
	}
}

class LargeSlot extends Slot {
	LargeSlot(int slotNumber) {
		super(slotNumber);
	}
}

public class ParkingLot {

	private static final int NUMBER_OF_SMALL_SLOTS = 10;
	private static final int NUMBER_OF_COMPACT_SLOTS = 10;
	private static final int NUMBER_OF_LARGE_SLOTS = 10;
	public Map<Long, Slot> occupiedSlots;
	private List<Slot> smallSlots;
	private List<Slot> compactSlots;
	private List<Slot> largeSlots;

	public ParkingLot() {
		smallSlots = new ArrayList<>(NUMBER_OF_SMALL_SLOTS);
		compactSlots = new ArrayList<>(NUMBER_OF_COMPACT_SLOTS);
		largeSlots = new ArrayList<>(NUMBER_OF_LARGE_SLOTS);
		createSlots();
		occupiedSlots = new HashMap<>();
	}

	private void createSlots() {

		for (int i = 1; i <= NUMBER_OF_SMALL_SLOTS; i++) {
			smallSlots.add(new SmallSlot(i));
		}
		for (int i = 1; i <= NUMBER_OF_COMPACT_SLOTS; i++) {
			compactSlots.add(new CompactSlot(i));
		}
		for (int i = 1; i <= NUMBER_OF_LARGE_SLOTS; i++) {
			largeSlots.add(new LargeSlot(i));
		}

	}

	public long park(Vehicle vehicle) {

		Slot slot;
		long uniqueToken = -1;

		if (vehicle instanceof Motorcycle) {
			if ((slot = getFirstEmptySlot(smallSlots)) != null) {
				uniqueToken = parkHelper(slot, vehicle);
			} else if ((slot = getFirstEmptySlot(compactSlots)) != null) {
				uniqueToken = parkHelper(slot, vehicle);
			} else if ((slot = getFirstEmptySlot(largeSlots)) != null) {
				uniqueToken = parkHelper(slot, vehicle);
			}
		} else if (vehicle instanceof Car) {
			if ((slot = getFirstEmptySlot(compactSlots)) != null) {
				uniqueToken = parkHelper(slot, vehicle);
			} else if ((slot = getFirstEmptySlot(largeSlots)) != null) {
				uniqueToken = parkHelper(slot, vehicle);
			}
		} else {
			if ((slot = getFirstEmptySlot(largeSlots)) != null) {
				uniqueToken = parkHelper(slot, vehicle);
			}
		}
		return uniqueToken;
	}

	public void unPark(long uniqueToken) {
		occupiedSlots.get(uniqueToken).unPark();
		occupiedSlots.remove(uniqueToken);
	}

	private Slot getFirstEmptySlot(List<Slot> slots) {
		Iterator<Slot> slotIterator = slots.iterator();
		boolean isSlotFound = false;
		Slot emptySlot = null;

		while (slotIterator.hasNext() && !isSlotFound) {
			emptySlot = slotIterator.next();
			if (!emptySlot.isOccupied()) {
				isSlotFound = true;
			}
		}
		return emptySlot;
	}

	private long parkHelper(Slot slot, Vehicle vehicle) {
		slot.park();
		long uniqueToken = vehicle.hashCode() * 43;
		occupiedSlots.put(uniqueToken, slot);
		return uniqueToken;
	}
}
