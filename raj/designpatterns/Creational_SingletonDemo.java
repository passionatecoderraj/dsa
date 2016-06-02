package com.raj.designpatterns;

public class Creational_SingletonDemo {

}

class Singleton1 {
	private static Singleton1 instance = new Singleton1();

	private Singleton1() {

	}

	public static Singleton1 getInstance() {
		return instance;
	}
}

class Singleton2 {
	private static Singleton2 instance;

	private Singleton2() {

	}

	public static Singleton2 getInstance() {
		if (null == instance) {
			instance = new Singleton2();
		}
		return instance;
	}
}

class Singleton3 {
	private static Singleton3 instance;

	private Singleton3() {

	}

	public synchronized static Singleton3 getInstance() {
		if (null == instance) {
			instance = new Singleton3();
		}
		return instance;
	}
}

class Singleton4 {
	private static Singleton4 instance;
	private static Object lock = new Object();

	private Singleton4() {

	}

	public static Singleton4 getInstance() {
		if (null == instance) {
			synchronized (lock) {
				if (null == instance)
					instance = new Singleton4();
			}
		}
		return instance;
	}
}