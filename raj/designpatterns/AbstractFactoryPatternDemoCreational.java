package com.raj.designpatterns;

abstract class Computer2 {
	abstract String getRAM();

	abstract String getHDD();

	abstract String getCPU();

	@Override
	public String toString() {
		return "RAM= " + this.getRAM() + 
				", HDD=" + this.getHDD() + ", CPU=" + this.getCPU();
	}
}

class PC2 extends Computer2 {
	private String ram;
	private String hdd;
	private String cpu;

	PC2(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	String getRAM() {
		return this.ram;
	}

	@Override
	String getHDD() {
		return this.hdd;
	}

	@Override
	String getCPU() {
		return this.cpu;
	}

}

class Server2 extends Computer2 {

	private String ram;
	private String hdd;
	private String cpu;

	Server2(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	String getRAM() {
		return this.ram;
	}

	@Override
	String getHDD() {
		return this.hdd;
	}

	@Override
	String getCPU() {
		return this.cpu;
	}

}

interface ComputerAbstractFactory {
	public Computer2 createComputer();
}

class PCFactory implements ComputerAbstractFactory {
	private String ram;
	private String hdd;
	private String cpu;

	PCFactory(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public Computer2 createComputer() {
		return new PC2(ram, hdd, cpu);
	}
}

class ServerFactory implements ComputerAbstractFactory {
	private String ram;
	private String hdd;
	private String cpu;

	ServerFactory(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public Computer2 createComputer() {
		return new Server2(ram, hdd, cpu);
	}
}

class ComputerFactory2 {
	static Computer2 getComputer(ComputerAbstractFactory factory) {
		return factory.createComputer();
	}
}

public class AbstractFactoryPatternDemoCreational {
	static void main(String[] args) {
		testAbstractFactory();
	}

	private static void testAbstractFactory() {
		Computer2 pc = ComputerFactory2.getComputer(
				new PCFactory("2 GB", "500 GB", "2.4 GHz"));
		Computer2 server = ComputerFactory2.getComputer(
				new ServerFactory("16 GB", "1 TB", "2.9 GHz"));
		System.out.println("AbstractFactory PC Config::" + pc);
		System.out.println("AbstractFactory Server Config::"
							+ server);
	}
}
