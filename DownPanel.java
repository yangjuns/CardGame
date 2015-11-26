package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class DownPanel extends JPanel implements MyCardPanel {
	private Game game;
	private JPanel cardPanel;
	private PokerGUI gui;
	private OverlapLayout ov;
	private JButton confirm;

	public DownPanel(Game g, PokerGUI pp) {
		setOpaque(false);
		game = g;
		gui = pp;
		Border blackline, raisedetched, loweredetched, raisedbevel, loweredbevel, empty;
		blackline = BorderFactory.createLineBorder(Color.black);
		raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		empty = BorderFactory.createEmptyBorder(0, 0, 0, 0);

		Border compound1 = BorderFactory.createCompoundBorder(raisedbevel,
				loweredbevel);

		setBorder(empty);
		setPreferredSize(new Dimension(500, 130));
		Player p = game.getPlayer(3);

		confirm = new JButton();
		confirm.setEnabled(false);
		confirm.setBackground(Color.gray);

		cardPanel = new JPanel();
		cardPanel.setOpaque(false);
		JLabel lblPlayer = new JLabel(p.getName() + " (" + p.getNumCards()
				+ ")");
		lblPlayer.setAlignmentX(JComponent.CENTER_ALIGNMENT);

		add(cardPanel);
		add(lblPlayer);
		add(confirm);
		URL url_confirm = DownPanel.class.getResource("/resources/confirm-button.png");
		ImageIcon icon_confirm = new ImageIcon(url_confirm);
		confirm.setIcon(icon_confirm);
		confirm.setOpaque(false);
		confirm.setPreferredSize(new Dimension(150,50));
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Move m = gui.getMovement();

				if (m.isValidMove()) {
					game.makeMove(m);
					gui.upDate();
					gui.uncheckSuper();
				} else {
					gui.setUnpop();
					gui.unableToClick();
				}

			}
		});

		// set up card panel

		ov = new OverlapLayout(new Point(15, 0));
		ov.setPopupInsets(new Insets(20, 0, 0, 0));
		cardPanel.setLayout(ov);
		for (int i = 0; i < p.getNumCards(); i++) {
			Card c = p.getCard(i);
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
			URL url = DownPanel.class.getResource(fileName);
			ImageIcon icon = new ImageIcon(url);
			card.setIcon(icon);
			if (!gui.isAITime()) {
				card.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						Component c = e.getComponent();
						Boolean constraint = ov.getConstraints(c);

						if (constraint == null
								|| constraint == OverlapLayout.POP_DOWN) {
							gui.setUnpop();
							ov.addLayoutComponent(c, OverlapLayout.POP_UP);
							gui.checkSuper(c);
						} else {
							ov.addLayoutComponent(c, OverlapLayout.POP_DOWN);
							gui.uncheckSuper();
							gui.unable();
						}

						c.getParent().invalidate();
						c.getParent().validate();
					}
				});
			}
			cardPanel.add(card);
		}
	}

	@Override
	public void reset() {
		List<Component> cs = Arrays.asList(cardPanel.getComponents());
		for (int i = 0; i < cs.size(); i++) {
			Component c = cs.get(i);
			ov.addLayoutComponent(c, ov.POP_DOWN);
			c.getParent().invalidate();
			c.getParent().validate();
		}
	}

	public void letEnable() {
		confirm.setEnabled(true);
		confirm.setBackground(Color.white);
	}

	public void letUnable() {
		confirm.setEnabled(false);
		confirm.setBackground(Color.GRAY);
	}

	@Override
	public Component getSandUp() {
		// TODO Auto-generated method stub
		List<Component> cs = Arrays.asList(cardPanel.getComponents());
		for (int i = 0; i < cs.size(); i++) {
			if (ov.getConstraints(cs.get(i)) == ov.POP_UP)
				return cs.get(i);
		}
		return null;
	}

	@Override
	public int playerOffset() {
		// TODO Auto-generated method stub
		return 0;
	}

}
