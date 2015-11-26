package gui;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CardMouseListener implements MouseListener {
	private OverlapLayout layout;

	public CardMouseListener(OverlapLayout ov) {
		layout = ov;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Component c = e.getComponent();
		Boolean constraint = layout.getConstraints(c);

		if (constraint == null || constraint == OverlapLayout.POP_DOWN)
			layout.addLayoutComponent(c, OverlapLayout.POP_UP);
		else
			layout.addLayoutComponent(c, OverlapLayout.POP_DOWN);

		c.getParent().invalidate();
		c.getParent().validate();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
