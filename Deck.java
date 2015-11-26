package gui;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Deck {
	public Set<Card> allCards;

	public Deck() {
		allCards = new HashSet<Card>(54);
		for (int i = 1; i < 14; i++) {
			allCards.add(new Card("Club", i));
			allCards.add(new Card("Spade", i));
			allCards.add(new Card("Diamond", i));
			allCards.add(new Card("Heart", i));
		}
		allCards.add(new Card("Joker", 0));
		allCards.add(new Card("Joker", -1));
	}

	public boolean isEmpty() {
		return allCards.isEmpty();
	}

	public Card next() {
		Iterator<Card> it = allCards.iterator();
		if (it.hasNext()) {
			Card c = it.next();
			it.remove();
			return c;
		}
		return null;
	}

}
