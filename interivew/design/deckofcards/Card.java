package com.interivew.design.deckofcards;

abstract class Card {
	private boolean available = true;

	/*
	 * number or face that's on card - a number 2 through 10, or 11 for Jack, 12
	 * for Queen, 13 for King, or 1 for Ace
	 */
	protected int faceValue;
	protected Suit suit;

	public Card(int c, Suit s) {
		faceValue = c;
		suit = s;
	}

	public abstract int value();

	public Suit suit() {
		return suit;
	}

	/*
	 * returns whether or not the card is available to be given out to someone
	 */
	public boolean isAvailable() {
		return available;
	}

	public void markUnavailable() {
		available = false;
	}

	public void markAvailable() {
		available = true;
	}

	public void print() {
		String[] faceValues = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		System.out.print(faceValues[faceValue - 1]);
		switch (suit) {
		case Club:
			System.out.print("c");
			break;
		case Heart:
			System.out.print("h");
			break;
		case Diamond:
			System.out.print("d");
			break;
		case Spade:
			System.out.print("s");
			break;
		}
		System.out.print(" ");
	}
}



class BlackJackCard extends Card {
	public BlackJackCard(int c, Suit s) {
		super(c, s);
	}

	public int value() {
		if (isAce()) { // Ace
			return 1;
		} else if (faceValue >= 11 && faceValue <= 13) { // Face card
			return 10;
		} else { // Number card
			return faceValue;
		}
	}

	public int minValue() {
		if (isAce()) { // Ace
			return 1;
		} else {
			return value();
		}
	}

	public int maxValue() {
		if (isAce()) { // Ace
			return 11;
		} else {
			return value();
		}
	}

	public boolean isAce() {
		return faceValue == 1;
	}

	public boolean isFaceCard() {
		return faceValue >= 11 && faceValue <= 13;
	}
}