package com.raj.designpatterns;

abstract class Computer1 {
	protected abstract String getRAM();

	protected abstract String getHDD();

	protected abstract String getCPU();

	@Override
	public String toString() {
		return "RAM= " + this.getRAM() + ", HDD=" + this.getHDD() + ", CPU=" + this.getCPU();
	}
}

class PC extends Computer1 {
	private String ram;
	private String hdd;
	private String cpu;

	PC(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	protected String getRAM() {
		return this.ram;
	}

	@Override
	protected String getHDD() {
		return this.hdd;
	}

	@Override
	protected String getCPU() {
		return this.cpu;
	}

}

class Server extends Computer1 {

	private String ram;
	private String hdd;
	private String cpu;

	Server(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	protected String getRAM() {
		return this.ram;
	}

	@Override
	protected String getHDD() {
		return this.hdd;
	}

	@Override
	protected String getCPU() {
		return this.cpu;
	}

}

class ComputerFactory {
	static Computer1 getComputer(String type, String ram, String hdd, String cpu) {
		if ("PC".equalsIgnoreCase(type))
			return new PC(ram, hdd, cpu);
		else if ("Server".equalsIgnoreCase(type))
			return new Server(ram, hdd, cpu);

		return null;
	}
}

public class Creational_FactoryMethodPattern {
	public static void main(String[] args) {
		Computer1 pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");
		Computer1 server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");
		System.out.println("Factory PC Config::" + pc);
		System.out.println("Factory Server Config::" + server);
	}
}
