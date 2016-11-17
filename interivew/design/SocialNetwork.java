package com.interivew.design;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
	public static void main(String args[]) {
		int bitField = 0xFFFFFFF;
		System.out.println(bitField);
	}
}

class Person {
	List<Person> friends = new ArrayList<>();
	Server server = new Server();
	int id;
	int machineId;
	int info;

	public void addFriend(Person p) {
		friends.add(p);
	}

	public int[] FriendIds() {
		int[] ids = new int[friends.size()];
		for (int i = 0; i < ids.length; i++) {
			ids[i] = friends.get(i).getId();
		}
		return ids;
	}

	public Person lookUpFriend(int machineId, int id) {
		Machine m = lookUpMachine(machineId);
		if (m != null) {
			for (Person p : m.persons) {
				if (p.getId() == id) {
					return p;
				}
			}
		}
		return null;
	}

	public Machine lookUpMachine(int machineId) {
		for (Machine m : server.machines) {
			if (m.getMachineId() == machineId) {
				return m;
			}
		}
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}
}

class Machine {
	int machineId;
	List<Person> persons = new ArrayList<>();

	public void addPerson(Person p) {
		persons.add(p);
	}

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

}

class Server {
	List<Machine> machines = new ArrayList<>();
}
