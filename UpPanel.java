package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class UpPanel extends JPanel implements MyCardPanel {
	private Game game;
	private JPanel cardPanel;
	private PokerGUI gui;
	private OverlapLayout ov;

	public UpPanel(Game g, PokerGUI pp) {
		setOpaque(false);
		game = g;
		gui = pp;
		setBorder(new EmptyBorder(5, 0, 0, 0));
		setPreferredSize(new Dimension(500, 130));
		Player p = game.getPlayer(1);
		cardPanel = new JPanel();
		cardPanel.setOpaque(false);
		JLabel lblPlayer = new JLabel(p.getName() + " (" + p.getNumCards()
				+ ")");
		lblPlayer.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		add(cardPanel);
		add(lblPlayer);

		// set up card panel

		ov = new OverlapLayout(new Point(15, 0));
		ov.setPopupInsets(new Insets(0, 0, 20, 0));
		cardPanel.setLayout(ov);
		for (int i = 0; i < p.getNumCards(); i++) {
			JLabel card = new JLabel();
			URL url = UpPanel.class.getResource("/resources/b1fv.png");
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
							gui.uncheckSuper();
							gui.able();
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
		return 2;
	}
}
