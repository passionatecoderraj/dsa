/**
 * 
 */
package com.interivew.designpatterns;

/**
 * @author Raj
 *
 */

/*
 * Decorator pattern adds additional features to an existing object dynamically.
 * In this post, I will use a simple example - decorate your girlfriend - to
 * illustrate how decorator pattern works.
 * 
 * 
 * http://www.newthinktank.com/2012/09/decorator-design-pattern-tutorial/
 */
interface Pizza {
	public String getDescription();

	public int getCost();
}

class PanPizza implements Pizza {

	public PanPizza() {

	}

	@Override
	public String getDescription() {

		return "Pan Pizza";
	}

	@Override
	public int getCost() {
		// System.out.println("Pan Pizza : 5 bucks");
		return 5;
	}

}

class ThinCrust implements Pizza {

	public ThinCrust() {

	}

	@Override
	public String getDescription() {

		return "Thin Crust Pizza";
	}

	@Override
	public int getCost() {
		// System.out.println("Thin Crust Pizza : 7 bucks");
		return 7;
	}

}

class PizzaDecorator implements Pizza {

	protected Pizza pizza;

	public PizzaDecorator(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {
		return pizza.getDescription();
	}

	@Override
	public int getCost() {
		return pizza.getCost();
	}

}

class ToppingsBlackPepper extends PizzaDecorator {

	public ToppingsBlackPepper(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + " + Black Pepper";
	}

	@Override
	public int getCost() {
		// System.out.println("Black Pepper : 4 bucks");
		return pizza.getCost() + 4;
	}

}

class ToppingsOlives extends PizzaDecorator {

	public ToppingsOlives(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + " + Olives";
	}

	@Override
	public int getCost() {
		// System.out.println("Olives : 3 bucks");
		return pizza.getCost() + 3;
	}

}

class ToppingsOnions extends PizzaDecorator {

	public ToppingsOnions(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + " + Onions";
	}

	@Override
	public int getCost() {
		// System.out.println("Onions : 2 bucks");
		return pizza.getCost() + 2;
	}

}

public class DecoratorPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pizza p1 = new PanPizza();
		System.out.println(p1.getDescription() + "=" + p1.getCost());

		Pizza p2 = new ToppingsOnions(p1);
		System.out.println(p2.getDescription() + "=" + p2.getCost());

		Pizza p3 = new ToppingsOlives(p2);
		System.out.println(p3.getDescription() + "=" + p3.getCost());

		Pizza pp1 = new ThinCrust();
		System.out.println(pp1.getDescription() + "=" + pp1.getCost());

		Pizza pp2 = new ToppingsOnions(pp1);
		System.out.println(p2.getDescription() + "=" + pp2.getCost());

		Pizza pp3 = new ToppingsBlackPepper(pp2);
		System.out.println(pp3.getDescription() + "=" + pp3.getCost());

	}

}
