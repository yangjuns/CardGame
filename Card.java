package gui;

public class Card {
	private String kind;
	private int value;
	private Card as;

	public Card(String k, int v) {
		kind = k;
		value = v;
		as = null;
	}

	public Card(String k, int v, Card c) {
		kind = k;
		value = v;
		as = c;
	}

	public void setAs(Card c) {
		as = c;
	}
	public Card getAs(){
		return as;
	}
	public String getKind() {
		return kind;
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Card))
			return false;
		Card c = (Card) o;
		return c.kind.equals(this.kind) && c.value == this.value;
	}

	@Override
	public String toString() {
		return kind + value;
	}
}
