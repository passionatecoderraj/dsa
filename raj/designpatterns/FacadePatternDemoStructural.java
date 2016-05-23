package com.raj.designpatterns;

interface Shape {
	void draw();
}

class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Rectangle::draw()");
	}
}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Circle::draw()");
	}
}

class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Square::draw()");
	}
}

class ShapeMaker {
	private Shape circle;
	private Shape rectangle;
	private Shape square;

	public ShapeMaker() {
		circle = new Circle();
		rectangle = new Rectangle();
		square = new Square();
	}

	public void drawCircle() {
		circle.draw();
	}

	public void drawRectangle() {
		rectangle.draw();
	}

	public void drawSquare() {
		square.draw();
	}
}

/*
 * Facade pattern hides the complexities of the system and provides an interface
 * to the client using which the client can access the system. This type of
 * design pattern comes under structural pattern as this pattern adds an
 * interface to existing system to hide its complexities.
 * 
 */
public class FacadePatternDemoStructural {
	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMaker();

		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}
}