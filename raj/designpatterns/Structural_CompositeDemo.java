package com.raj.designpatterns;

import java.util.ArrayList;
import java.util.List;

// Component
interface Component {
	void display();
}

// Leaf
class Employee implements Component {
	private String name;
	private double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public void display() {
		System.out.println(name + "'s salary is :" + salary);
	}
}

// Composite
class Composite implements Component {
	List<Component> list = new ArrayList<>();

	public void add(Component emp) {
		list.add(emp);
	}

	public void remove(Component emp) {
		list.remove(emp);
	}

	public void display() {
		for (Component emp : list) {
			emp.display();
		}
	}
}

public class Structural_CompositeDemo {
	public static void main(String args[]) {
		Employee e1 = new Employee("Raj", 12);
		Employee e2 = new Employee("Prithvi", 34);
		Employee e3 = new Employee("Kumar", 56);
		Employee e4 = new Employee("Dasari", 78);

		Composite c1 = new Composite();
		Composite c2 = new Composite();
		Composite c3 = new Composite();

		c2.add(e1);
		c2.add(e2);
		c2.add(e3);
		c3.add(e4);
		c1.add(c2);
		c1.add(c3);

		c1.display();
	}
}
