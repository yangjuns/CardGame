package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Act implements ActionListener {
	private int count = 0;
	private PokerGUI gui;

	public Act(PokerGUI g) {
		count = 0;
		gui = g;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (count < 3 && gui.getGame().isOver() == null) {
			gui.runAI(count);
			count++;
		} else {
			((Timer) e.getSource()).stop();
			if (gui.getGame().isOver() != null) {
				gui.run();
			}
		}
	}
}
