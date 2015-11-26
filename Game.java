package gui;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Player> players;
	private Board board;
	private Deck deck;
	private int currentPlayer;

	public Game(String[] names) {
		players = new ArrayList<Player>(4);
		for (int i = 0; i < 4; i++) {
			players.add(new Player(names[i]));
		}
		board = new Board();
		deck = new Deck();
		currentPlayer = 3;
	}

	// initialize the game
	public void initialize() {
		int i = 0;
		while (!deck.isEmpty()) {
			Card c = deck.next();
			players.get(i).addCard(c);
			i = (i + 1) % 4;
		}
	}

	// check if game is over
	public Player isOver() {
		for (int i = 0; i < 4; i++) {
			if (players.get(i).isWinner())
				return players.get(i);
		}
		return null;
	}

	public Player getPlayer(int index) {
		return players.get(index);
	}

	public Player getCurrentPlayer() {
		return players.get(currentPlayer);
	}

	public Player getPlayerInOrder(int index) {
		return players.get((currentPlayer + index) % 4);
	}

	public Board getBoard() {
		return board;
	}

	public void makeMove(Move v) {
		if (v.getTarget() == null) {
			Card c = v.getSelf().getCard(v.getIndex());
			v.getSelf().removeCard(v.getIndex());
			c.setAs(v.getAs());
			board.add(c);
		} else {
			Card c = v.getTarget().getCard(v.getIndex());
			v.getTarget().removeCard(v.getIndex());
			v.getSelf().addCard(c);
		}
		currentPlayer = (currentPlayer + 1) % 4;
	}
	public Player playerWithMostCards(){
		int max = -1;
		int maxIndex = -1;
		for (int i = 0; i < players.size(); i++) {		
			if(players.get(i).getNumCards() > max){
				max = players.get(i).getNumCards();
				maxIndex = i;
			}
		}
		return players.get(maxIndex);
	}
	
	public Player playerWithMostCardsExceptSelf(){
		int max = -1;
		int maxIndex = -1;
		for (int i = 0; i < players.size(); i++) {		
			if(!players.get(i).equals(getCurrentPlayer()) && players.get(i).getNumCards() > max){
				max = players.get(i).getNumCards();
				maxIndex = i;
			}
		}
		return players.get(maxIndex);
	}
	public boolean allPlayerHasOneLeft() {
		for (int i = 0; i < players.size(); i++) {
			if(players.get(i).getNumCards() != 1)
				return false;
		}
		return true;
	}
}
