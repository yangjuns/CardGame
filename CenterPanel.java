package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class CenterPanel extends JPanel {
	private Game game;
	private JPanel hearts;
	private JPanel spades;
	private JPanel diamonds;
	private JPanel clubs;
	private List<Card> heartCards;
	private List<Card> spadeCards;
	private List<Card> diamondCards;
	private List<Card> clubCards;
	private List<JPanel> spaces;
	private PokerGUI gui;
	Border blackline, raisedetched, loweredetched, raisedbevel, loweredbevel, empty;

	public CenterPanel(Game g, PokerGUI pp) {
		setOpaque(false);
		game = g;
		gui = pp;
		// set border
		
		blackline = BorderFactory.createLineBorder(Color.black);
		raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		empty = BorderFactory.createEmptyBorder(10, 40, 5, 40);
		setBorder(loweredbevel);

		hearts = new JPanel();
		hearts.setPreferredSize(new Dimension(500, 120));
		OverlapLayout ov1 = new OverlapLayout(new Point(15, 0));
		hearts.setLayout(ov1);
		hearts.setBorder(BorderFactory.createTitledBorder(loweredetched,
				"Heart"));
		hearts.setOpaque(false);
		heartCards = game.getBoard().getListOfCard("heart");
		for (int i = 0; i < heartCards.size(); i++) {
			Card c = heartCards.get(i);
			String kind = c.getKind();
			int value = c.getValue();
			String fileName = "/resources/";
			switch (value) {
			case 13:
				fileName += kind + "K.png";
				break;
			case 12:
				fileName += kind + "Q.png";
				break;
			case 11:
				fileName += kind + "J.png";
				break;
			case 1:
				fileName += kind + "A.png";
				break;
			case 0:
				fileName += kind + "_Plus.png";
				break;
			case -1:
				fileName += kind + "_Minus.png";
				break;
			default:
				fileName += kind + value + ".png";
				break;
			}
			JLabel card = new JLabel();
			URL url = CenterPanel.class.getResource(fileName);
			ImageIcon icon = new ImageIcon(url);
			card.setIcon(icon);
			hearts.add(card);
		}
		spades = new JPanel();
		spades.setPreferredSize(new Dimension(500, 120));
		OverlapLayout ov2 = new OverlapLayout(new Point(15, 0));
		spades.setLayout(ov2);
		spades.setBorder(BorderFactory.createTitledBorder(loweredetched,
				"Spade"));
		spades.setOpaque(false);
		spadeCards = game.getBoard().getListOfCard("spade");
		for (int i = 0; i < spadeCards.size(); i++) {
			Card c = spadeCards.get(i);
			String kind = c.getKind();
			int value = c.getValue();
			String fileName = "/resources/";
			switch (value) {
			case 13:
				fileName += kind + "K.png";
				break;
			case 12:
				fileName += kind + "Q.png";
				break;
			case 11:
				fileName += kind + "J.png";
				break;
			case 1:
				fileName += kind + "A.png";
				break;
			case 0:
				fileName += kind + "_Plus.png";
				break;
			case -1:
				fileName += kind + "_Minus.png";
				break;
			default:
				fileName += kind + value + ".png";
				break;
			}
			JLabel card = new JLabel();
			URL url = CenterPanel.class.getResource(fileName);
			ImageIcon icon = new ImageIcon(url);
			card.setIcon(icon);
			spades.add(card);
		}

		diamonds = new JPanel();
		diamonds.setPreferredSize(new Dimension(500, 120));
		OverlapLayout ov3 = new OverlapLayout(new Point(15, 0));
		diamonds.setLayout(ov3);
		diamonds.setOpaque(false);
		diamonds.setBorder(BorderFactory.createTitledBorder(loweredetched,
				"Diamond"));
		diamondCards = game.getBoard().getListOfCard("diamond");
		for (int i = 0; i < diamondCards.size(); i++) {
			Card c = diamondCards.get(i);
			String kind = c.getKind();
			int value = c.getValue();
			String fileName = "/resources/";
			switch (value) {
			case 13:
				fileName += kind + "K.png";
				break;
			case 12:
				fileName += kind + "Q.png";
				break;
			case 11:
				fileName += kind + "J.png";
				break;
			case 1:
				fileName += kind + "A.png";
				break;
			case 0:
				fileName += kind + "_Plus.png";
				break;
			case -1:
				fileName += kind + "_Minus.png";
				break;
			default:
				fileName += kind + value + ".png";
				break;
			}
			JLabel card = new JLabel();
			URL url = CenterPanel.class.getResource(fileName);
			ImageIcon icon = new ImageIcon(url);
			card.setIcon(icon);
			diamonds.add(card);
		}

		clubs = new JPanel();
		clubs.setPreferredSize(new Dimension(500, 120));
		OverlapLayout ov4 = new OverlapLayout(new Point(15, 0));
		clubs.setLayout(ov4);
		clubs.setOpaque(false);
		clubs.setBorder(BorderFactory.createTitledBorder(loweredetched, "Club"));
		clubCards = game.getBoard().getListOfCard("club");
		for (int i = 0; i < clubCards.size(); i++) {
			Card c = clubCards.get(i);
			String kind = c.getKind();
			int value = c.getValue();
			String fileName = "/resources/";
			switch (value) {
			case 13:
				fileName += kind + "K.png";
				break;
			case 12:
				fileName += kind + "Q.png";
				break;
			case 11:
				fileName += kind + "J.png";
				break;
			case 1:
				fileName += kind + "A.png";
				break;
			case 0:
				fileName += kind + "_Plus.png";
				break;
			case -1:
				fileName += kind + "_Minus.png";
				break;
			default:
				fileName += kind + value + ".png";
				break;
			}
			JLabel card = new JLabel();
			URL url = CenterPanel.class.getResource(fileName);
			ImageIcon icon = new ImageIcon(url);
			card.setIcon(icon);
			clubs.add(card);
		}

		spaces = new ArrayList<JPanel>(8);
		for (int i = 0; i < 8; i++) {
			JPanel space = new JPanel();
			space.setOpaque(false);
			space.setBackground(Color.cyan);
			space.setPreferredSize(new Dimension(80, 100));
			spaces.add(space);
		}

		add(spaces.get(0));
		add(spades);
		add(spaces.get(1));

		add(spaces.get(2));
		add(hearts);
		add(spaces.get(3));

		add(spaces.get(4));
		add(clubs);
		add(spaces.get(5));

		add(spaces.get(6));
		add(diamonds);
		add(spaces.get(7));

	}

	public void setSpaceLighted() {
		for (int i = 0; i < spaces.size(); i++) {
			JPanel space = spaces.get(i);
			space.setBorder(raisedbevel);
			space.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					gui.able();
					spaceReset();
					space.setBackground(new Color(255,102,102));
					space.setBorder(loweredbevel);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					space.setBorder(raisedbevel);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					space.setBorder(loweredbevel);
				}
			});
		}
	}

	public void spaceReset() {
		for (int i = 0; i < spaces.size(); i++) {
			JPanel space = spaces.get(i);
			space.setBorder(null);
			space.setBackground(Color.cyan);
			MouseListener[] ml = space.getMouseListeners();
			for (int j = 0; j < ml.length; j++) {
				space.removeMouseListener(ml[j]);
			}
		}
	}

	private Card getAsCardHelper(int i) {
		switch (i) {
		case 0:
			return game.getBoard().getMissingHead(heartCards, "Heart");
		case 1:
			return game.getBoard().getMissingTail(heartCards, "Heart");
		case 2:
			return game.getBoard().getMissingHead(spadeCards, "Spade");
		case 3:
			return game.getBoard().getMissingHead(spadeCards, "Spade");
		case 4:
			return game.getBoard().getMissingHead(clubCards, "Club");
		case 5:
			return game.getBoard().getMissingTail(clubCards, "Club");
		case 6:
			return game.getBoard().getMissingHead(diamondCards, "Diamond");
		default:
			return game.getBoard().getMissingHead(diamondCards, "Diamond");
		}
	}

	public Card getAsCard() {
		for (int i = 0; i < spaces.size(); i++) {
			if (spaces.get(i).getBackground().equals(new Color(255,102,102)))
				return getAsCardHelper(i);
		}
		return null;
	}
}
