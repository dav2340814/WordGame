import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class GUI {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Word Game");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		Container pane = frame.getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));

		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("Game");
		menuBar.add(gameMenu);
		gameMenu.setMnemonic('G');

		Messages msgArea = new Messages();

		JLabel playersLabel = new JLabel("Players: ");
		pane.add(playersLabel);

		JMenuItem newPlayerMenuItem = new JMenuItem("Add Player");

		newPlayerMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GamePlay.currentPlayers
						.add(new Players(JOptionPane.showInputDialog("New Player Name: ")));
				String oldPlayers = playersLabel.getText();
				playersLabel.setText(
						oldPlayers + GamePlay.currentPlayers.getLast().getFirstName()
								+ GamePlay.currentPlayers.getLast().getLastName()
								+ ", ");
				frame.pack();

			}
		});

		gameMenu.add(newPlayerMenuItem);

		JLabel hostLabel = new JLabel("Host: ");
		pane.add(hostLabel);

		JMenuItem hostNameMenuItem = new JMenuItem("Change Host Name");
		gameMenu.add(hostNameMenuItem);

		hostNameMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GamePlay.host.setFirstName(JOptionPane.showInputDialog("New Host Name: "));
				GamePlay.host.getPhrase().setPhrase(JOptionPane.showInputDialog("New Phrase: "));
				GamePlay.host.getPhrase().generatePhrase();
				hostLabel.setText("Host: " + GamePlay.host.getFirstName());
				frame.pack();
			}
		});

		JLabel playingPhraseLabel = new JLabel(
				"Playing Phrase: " + GamePlay.host.getPhrase().getPlayingPhrase());
		pane.add(playingPhraseLabel);

		GamePlay.host.getPhrase().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				if ("playingPhrase".equals(e.getPropertyName())) {

					playingPhraseLabel.setText("Playing Phrase: "
							+ GamePlay.host.getPhrase().getPlayingPhrase());
					frame.pack();
				}
			}
		});

		JButton startTurnBtn = new JButton("Start Turn");
		pane.add(startTurnBtn);

		startTurnBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (GamePlay.nextTurn(msgArea)) {
					if (JOptionPane.showConfirmDialog(frame,
							"Would you like to play again?") == JOptionPane.NO_OPTION) {
						frame.dispose();
					}
					GamePlay.host.getPhrase()
							.setPhrase(JOptionPane.showInputDialog("New Phrase: "));
					GamePlay.host.getPhrase().generatePhrase();
				}
				frame.pack();
			}
		});

		JScrollPane msgPane = new JScrollPane(msgArea.textArea,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pane.add(msgPane);

		pane.add(msgArea.imgPanel);

		JMenu aboutMenu = new JMenu("About");
		aboutMenu.setMnemonic('a');
		menuBar.add(aboutMenu);

		JMenuItem layoutMenuItem = new JMenuItem("Layout");
		aboutMenu.add(layoutMenuItem);

		layoutMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				msgArea.setMessage(
						"I chose BoxLayout because it formats everything nicely and needs minimal configuration.");
				frame.pack();
			}
		});

		JMenuItem attributionMenuItem = new JMenuItem("Attribution");
		aboutMenu.add(attributionMenuItem);

		attributionMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				msgArea.setMessage(
						"All images are taken from unsplash, all sounds are copyright-free from youtube.");
			}
		});

		JCheckBox saveMsgs = new JCheckBox("Save Messages", true);
		saveMsgs.setToolTipText("Keep old messages when a new one is sent");
		pane.add(saveMsgs);

		saveMsgs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				msgArea.saveMessages = !msgArea.saveMessages;

			}
		});

		frame.setJMenuBar(menuBar);
		frame.pack();
		frame.setVisible(true);
	}

}
