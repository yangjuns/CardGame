package gui;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<Card> diamonds;
	private List<Card> clubs;
	private List<Card> hearts;
	private List<Card> spades;

	public List<Card> getListOfCard(String kind) {
		switch (kind) {
		case "diamond":
			return diamonds;
		case "club":
			return clubs;
		case "heart":
			return hearts;
		default:
			return spades;
		}
	}

	public Board() {
		diamonds = new ArrayList<Card>();
		clubs = new ArrayList<Card>();
		hearts = new ArrayList<Card>();
		spades = new ArrayList<Card>();
	}

	private void listAdd(List<Card> l, Card c) {
		if (l.isEmpty()) {
			l.add(c);
		} else {
			int hd ;
			if(l.get(0).getAs() == null){
				hd = l.get(0).getValue();
			}else{
				hd = l.get(0).getAs().getValue();
			}
			int value = 0;
			if (c.getAs() == null) {
				value = c.getValue();
			} else {
				value = c.getAs().getValue();
			}
			if (value < hd) {
				l.add(0, c);
			} else {
				l.add(c);
			}
		}
	}

	public Card getMissingHead(List<Card> l, String s) {
		if (l.isEmpty()) {
			return new Card(s, 7);
		} else {
			Card head = l.get(0);
			int headValue;
			if (head.getAs() == null) {
				headValue = head.getValue();
			} else {
				headValue = head.getAs().getValue();
			}
			if (headValue != 1)
				return new Card(s, headValue - 1);
		}
		return null;
	}

	public Card getMissingTail(List<Card> l, String s) {
		if (l.isEmpty()) {
			return new Card(s, 7);
		} else {
			Card tail = l.get(l.size() - 1);
			int tailValue;
			if (tail.getAs() == null) {
				tailValue = tail.getValue();
			} else {
				tailValue = tail.getAs().getValue();
			}
			if (tailValue != 13)
				return new Card(s, tailValue + 1);
		}
		return null;
	}

	public List<Card> getMissCardsList(List<Card> l, String s) {
		List<Card> missing = new ArrayList<Card>();
		Card missingHead = getMissingHead(l, s);
		if (missingHead != null)
			missing.add(missingHead);
		Card missingTail = getMissingTail(l, s);
		if (missingTail != null)
			missing.add(missingTail);
		return missing;
	}

	public List<Card> getMissingCards() {
		List<Card> d = getMissCardsList(diamonds, "Diamond");
		List<Card> s = getMissCardsList(spades, "Spade");
		List<Card> h = getMissCardsList(hearts, "Heart");
		List<Card> c = getMissCardsList(clubs, "Club");
		d.addAll(s);
		d.addAll(h);
		d.addAll(c);
		return d;
	}

	public void add(Card c) {
		String kind = null;
		if (c.getAs() == null) {
			kind = c.getKind();
		} else {
			kind = c.getAs().getKind();
		}
		switch (kind) {
		case "Diamond":
			listAdd(diamonds, c);
			break;
		case "Spade":
			listAdd(spades, c);
			break;
		case "Heart":
			listAdd(hearts, c);
			break;
		default:
			listAdd(clubs, c);
			break;
		}
	}
}
