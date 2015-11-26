package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SpringLayout;
import javax.swing.JTextField;

import java.awt.Font;
import java.net.URL;
import java.util.List;
import java.util.Random;

public class PokerGUI {

	private JFrame frame;
	private JTextField name1;
	private JTextField name2;
	private JTextField name3;
	private JTextField name4;
	private MyCardPanel upPanel;
	private MyCardPanel downPanel;
	private MyCardPanel leftPanel;
	private MyCardPanel rightPanel;
	private CenterPanel centerPanel;
	private Game game;
	private int waitTime;
	private boolean AItime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PokerGUI window = new PokerGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PokerGUI() {
		waitTime = 1000;
		AItime = false;
		createFrame();

	}

	public void createFrame() {
		frame = new JFrame();
		frame.setBackground(SystemColor.control);
		URL url = PokerGUI.class.getResource("/resources/spades2.jpg");
		ImageIcon icon = new ImageIcon(url);
		frame.setIconImage(icon.getImage());

		frame.setTitle("ShengShiPoker");
		frame.setBounds(100, 100, 950, 840);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPanel = frame.getContentPane();
		frame.getContentPane().setLayout(
				new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		
		URL url2 = PokerGUI.class.getResource("/resources/backGround.jpg");
		ImageIcon icon2 = new ImageIcon(url2);
		JLabel contentPanel2 = new JLabel(icon2);

		frame.setContentPane(contentPanel2);

		// add JMenubar
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);

		JMenu mnFff = new JMenu("Game");
		menubar.add(mnFff);

		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mntmNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPanel.removeAll();
				contentPanel.revalidate();
				contentPanel.repaint();
				initialize();
			}
		});
		mnFff.add(mntmNewGame);

		JMenu mnHelp = new JMenu("Help");
		menubar.add(mnHelp);

		JMenuItem mntmNewMenuItem = new JMenuItem("No Help");
		mnHelp.add(mntmNewMenuItem);
	}

	public boolean isAITime() {
		return AItime;
	}

	public void initialize() {
		SpringLayout springLayout = new SpringLayout();
		// background
		URL url = PokerGUI.class.getResource("/resources/backGround.jpg");
		ImageIcon icon = new ImageIcon(url);
		JLabel contentPanel = new JLabel(icon);

		frame.setContentPane(contentPanel);
		// Container contentPanel = frame.getContentPane();
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setLayout(springLayout);
		JLabel lblPlayersName = new JLabel("Player 1's name :");
		lblPlayersName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.NORTH, lblPlayersName, 270,
				SpringLayout.NORTH, contentPanel);
		springLayout.putConstraint(SpringLayout.WEST, lblPlayersName, 300,
				SpringLayout.WEST, contentPanel);
		contentPanel.add(lblPlayersName);

		name1 = new JTextField();
		name1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, name1, 0,
				SpringLayout.NORTH, lblPlayersName);
		springLayout.putConstraint(SpringLayout.WEST, name1, 27,
				SpringLayout.EAST, lblPlayersName);
		contentPanel.add(name1);
		name1.setColumns(10);

		JLabel lblPlayersName_1 = new JLabel("Player 2's name :");
		springLayout.putConstraint(SpringLayout.NORTH, lblPlayersName_1, 20,
				SpringLayout.SOUTH, lblPlayersName);
		springLayout.putConstraint(SpringLayout.WEST, lblPlayersName_1, 0,
				SpringLayout.WEST, lblPlayersName);
		lblPlayersName_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPanel.add(lblPlayersName_1);

		name2 = new JTextField();
		name2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, name2, 0,
				SpringLayout.NORTH, lblPlayersName_1);
		springLayout.putConstraint(SpringLayout.WEST, name2, 0,
				SpringLayout.WEST, name1);
		contentPanel.add(name2);
		name2.setColumns(10);

		JLabel lblPlayersName_2 = new JLabel("Player 3's name :");
		springLayout.putConstraint(SpringLayout.NORTH, lblPlayersName_2, 20,
				SpringLayout.SOUTH, lblPlayersName_1);
		springLayout.putConstraint(SpringLayout.WEST, lblPlayersName_2, 0,
				SpringLayout.WEST, lblPlayersName);
		lblPlayersName_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPanel.add(lblPlayersName_2);

		name3 = new JTextField();
		name3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, name3, 0,
				SpringLayout.NORTH, lblPlayersName_2);
		springLayout.putConstraint(SpringLayout.WEST, name3, 0,
				SpringLayout.WEST, name1);
		contentPanel.add(name3);
		name3.setColumns(10);

		JLabel lblYourName = new JLabel("Your name :");
		lblYourName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.NORTH, lblYourName, 20,
				SpringLayout.SOUTH, lblPlayersName_2);
		springLayout.putConstraint(SpringLayout.EAST, lblYourName, 0,
				SpringLayout.EAST, lblPlayersName);
		contentPanel.add(lblYourName);

		name4 = new JTextField();
		name4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, name4, 0,
				SpringLayout.NORTH, lblYourName);
		springLayout.putConstraint(SpringLayout.WEST, name4, 0,
				SpringLayout.WEST, name1);
		contentPanel.add(name4);
		name4.setColumns(10);

		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] names = new String[] { name1.getText(),
						name2.getText(), name3.getText(), name4.getText() };
				start(names);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnStart, 42,
				SpringLayout.SOUTH, name4);
		springLayout.putConstraint(SpringLayout.WEST, btnStart, 70,
				SpringLayout.WEST, lblYourName);
		contentPanel.add(btnStart);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void start(String[] names) {
		AItime = false;
		game = new Game(names);
		game.initialize();
		run();
	}

	public void upDate() {
		AItime = true;
		int delay = waitTime; // milliseconds
		Act listener = new Act(this);
		Timer t = new Timer(delay, listener);
		t.start();
		run();
	}

	public Game getGame() {
		return game;
	}

	public void runAI(int times) {
		if (game.isOver() == null) {
			int i = game.getCurrentPlayer().getPossibleCardAtRandom(
					game.getBoard().getMissingCards());
			if (i != -1) {
				Card valid = game.getCurrentPlayer().getCard(i);
				if (valid.getValue() == 0) {
					Random ran = new Random();
					List<Card> missing = game.getBoard().getMissingCards();
					Card as = missing.get(ran.nextInt(missing.size()));
					game.makeMove(new Move(game.getCurrentPlayer(), null, i,
							game.getBoard(), as));
				} else {
					game.makeMove(new Move(game.getCurrentPlayer(), null, i,
							game.getBoard(), null));
				}
			} else {
				Random ran = new Random();
				Player target = game.playerWithMostCardsExceptSelf();
				int cardIndex = ran.nextInt(target.getNumCards());
				game.makeMove(new Move(game.getCurrentPlayer(), target,
						cardIndex, game.getBoard(), null));
			}
			if (times == 2) {
				AItime = false;
			}
			Container contentPanel = frame.getContentPane();
			contentPanel.setLayout(new BorderLayout());
			contentPanel.removeAll();
			contentPanel.revalidate();
			contentPanel.repaint();
			paintUp();
			paintLeft();
			paintRight();
			paintDown();
			paintCenter();

		}
	}

	public void run() {
		URL url = PokerGUI.class.getResource("/resources/backGround.jpg");
		ImageIcon icon = new ImageIcon(url);
		JLabel contentPanel = new JLabel(icon);

		frame.setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout());
		contentPanel.removeAll();
		contentPanel.revalidate();
		contentPanel.repaint();
		paintUp();
		paintLeft();
		paintRight();
		paintDown();
		paintCenter();
		if (game.isOver() != null) {
			Object[] options = { "Okey" };
			int n = JOptionPane.showOptionDialog(frame, "The Winner is "
					+ game.isOver().getName() + " !!!", "Congratulation!",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, options, options[0]);
			if (n == JOptionPane.OK_OPTION) {
				contentPanel.removeAll();
				contentPanel.revalidate();
				contentPanel.repaint();
				initialize();
			}
		}
	}

	public void paintCenter() {
		centerPanel = new CenterPanel(game, this);
		frame.getContentPane()
				.add((Component) centerPanel, BorderLayout.CENTER);
	}

	public void checkSuper(Component c) {
		MyCardPanel parent = (MyCardPanel) c.getParent().getParent();
		int index = c.getParent().getComponentZOrder(c);
		int realIndex = game.getPlayerInOrder(parent.playerOffset())
				.getNumCards() - 1 - index;
		Card card = game.getPlayerInOrder(parent.playerOffset()).getCard(
				realIndex);
		if (card.equals(new Card("Joker", 0))) {
			unable();
			centerPanel.setSpaceLighted();
		} else {
			uncheckSuper();
			able();
		}
	}

	public void able() {
		((DownPanel) downPanel).letEnable();
	}

	public void unable() {
		((DownPanel) downPanel).letUnable();
	}

	public void uncheckSuper() {
		centerPanel.spaceReset();
	}

	public Move getMovement() {
		Component c = null;
		if (rightPanel.getSandUp() != null) {
			c = rightPanel.getSandUp();
		} else if (leftPanel.getSandUp() != null) {
			c = leftPanel.getSandUp();
		} else if (downPanel.getSandUp() != null) {
			c = downPanel.getSandUp();
		} else if (upPanel.getSandUp() != null) {
			c = upPanel.getSandUp();
		}
		Card card = centerPanel.getAsCard();
		if (c != null) {
			int index = c.getParent().getComponentZOrder(c);
			int src = ((MyCardPanel) c.getParent().getParent()).playerOffset();
			if (src != 0) {
				return new Move(game.getPlayerInOrder(0),
						game.getPlayerInOrder(src), game.getPlayerInOrder(src)
								.getNumCards() - 1 - index, game.getBoard(),
						card);
			} else {
				return new Move(game.getPlayerInOrder(0), null, game
						.getPlayerInOrder(0).getNumCards() - 1 - index,
						game.getBoard(), card);
			}
		}
		return null;
	}

	public void setUnpop() {
		rightPanel.reset();
		leftPanel.reset();
		downPanel.reset();
		upPanel.reset();
	}

	public void ableToClick() {
		((DownPanel) downPanel).letEnable();
	}

	public void unableToClick() {
		((DownPanel) downPanel).letUnable();
	}

	private void paintDown() {
		downPanel = new DownPanel(game, this);
		frame.getContentPane().add((Component) downPanel, BorderLayout.SOUTH);
	}

	private void paintUp() {
		upPanel = new UpPanel(game, this);
		frame.getContentPane().add((Component) upPanel, BorderLayout.NORTH);
	}

	private void paintRight() {
		rightPanel = new RightPanel(game, this);
		frame.getContentPane().add((Component) rightPanel, BorderLayout.EAST);
	}

	private void paintLeft() {
		leftPanel = new LeftPanel(game, this);
		frame.getContentPane().add((Component) leftPanel, BorderLayout.WEST);
	}
}
