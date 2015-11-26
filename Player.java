package gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
	private String name;
	private List<Card> hand;

	public Player(String n) {
		name = n;
		hand = new ArrayList<Card>();
	}

	public String getName() {
		return name;
	}

	public int getNumCards() {
		return hand.size();
	}

	public int getPossibleCardAtRandom(List<Card> validCards) {
		List<Integer> allIndex = new ArrayList<Integer>();
		for (int j = 0; j < hand.size(); j++) {
			if (validCards.contains(hand.get(j))|| hand.get(j).equals(new Card("Joker", 0)))
				allIndex.add(j);
		}
		if (allIndex.isEmpty())
			return -1;
		Random ran = new Random();
		return allIndex.get(ran.nextInt(allIndex.size()));
	}

	public boolean isWinner() {
		return hand.isEmpty();
	}

	public Card getCard(int index) {
		return hand.get(index);
	}

	public Move getNextMove() {
		return null;
	}

	public void removeCard(int i) {
		hand.remove(i);
	}

	public void addCard(Card c) {
		hand.add(c);
	}
}
