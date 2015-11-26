package gui;

import java.util.List;

public class Move {
	private Player self;
	private Player target;
	private Board board;
	private int index;
	private Card as;

	public Move(Player s, Player t, int i, Board b, Card c) {
		self = s;
		target = t;
		index = i;
		board = b;
		as = c;
	}
	public Card getAs(){
		return as;
	}
	public boolean isValidMove() {
		if (self == null || board == null)
			return false;
		if (target == null) {
			if (self.getNumCards() < index)
				return false;
			List<Card> missing = board.getMissingCards();
			if(as == null)
				return missing.contains(self.getCard(index));
			return missing.contains(as);
		} else {
			return target.getNumCards() > index;
		}
	}

	public Player getTarget() {
		return target;
	}

	public Player getSelf() {
		return self;
	}

	public int getIndex() {
		return index;
	}
}
