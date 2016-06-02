package com.raj.designpatterns;

//Adaptee; default it gives '0' volts
class Volt {
	private int volts;

	public Volt(int v) {
		this.volts = v;
	}

	public int getVolts() {
		return volts;
	}

	public void setVolts(int volts) {
		this.volts = volts;
	}

}

class Socket {
	public Volt getVolt() {
		return new Volt(120);
	}
}

interface SocketAdapter {

	public Volt get120Volt();

	public Volt get12Volt();

	public Volt get3Volt();
}

// adapting to return as many volts as we need
class SocketObjectAdapterImpl implements SocketAdapter {

	// Using Composition for adapter pattern
	private Socket sock = new Socket();

	@Override
	public Volt get120Volt() {
		return sock.getVolt();
	}

	@Override
	public Volt get12Volt() {
		Volt v = sock.getVolt();
		return convertVolt(v, 10);
	}

	@Override
	public Volt get3Volt() {
		Volt v = sock.getVolt();
		return convertVolt(v, 40);
	}

	private Volt convertVolt(Volt v, int i) {
		return new Volt(v.getVolts() / i);
	}
}

public class Structural_AdapterPatternDemo {
	public static void main(String[] args) {
		SocketAdapter sockAdapter = new SocketObjectAdapterImpl();
		Volt v3 = getVolt(sockAdapter, 3);
		Volt v12 = getVolt(sockAdapter, 12);
		Volt v120 = getVolt(sockAdapter, 120);
		System.out.println("v3 volts using Object Adapter=" 
						+ v3.getVolts());
		System.out.println("v12 volts using Object Adapter=" 
						+ v12.getVolts());
		System.out.println("v120 volts using Object Adapter=" 
						+ v120.getVolts());

	}

	private static Volt getVolt(SocketAdapter sockAdapter, int i) {
		switch (i) {
		case 3:
			return sockAdapter.get3Volt();
		case 12:
			return sockAdapter.get12Volt();
		case 120:
			return sockAdapter.get120Volt();
		default:
			return sockAdapter.get120Volt();
		}
	}

}
