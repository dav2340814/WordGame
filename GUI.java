import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class GUI {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		// frame.setSize(1080, 740);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		Container pane = frame.getContentPane();
		pane.setLayout(new FlowLayout());

		JLabel playersLabel = new JLabel("Players: ");
		pane.add(playersLabel);

		JButton newPlayerBtn = new JButton("Add Player");
		pane.add(newPlayerBtn);

		newPlayerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GamePlay.currentPlayers
						.add(new Players(JOptionPane.showInputDialog("New Player Name: ")));
				String oldPlayers = playersLabel.getText();
				playersLabel.setText(
						oldPlayers + GamePlay.currentPlayers.getLast().getFirstName()
								+ GamePlay.currentPlayers.getLast().getLastName());
				frame.pack();

			}
		});

		JLabel hostLabel = new JLabel("Host: ");
		pane.add(hostLabel);

		JButton hostNameBtn = new JButton("Change Host Name");
		pane.add(hostNameBtn);

		hostNameBtn.addActionListener(new ActionListener() {
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
				if (GamePlay.nextTurn()) {
					if (JOptionPane.showConfirmDialog(frame,
							"Would you like to play again?") == JOptionPane.NO_OPTION) {
						frame.dispose();
					}
				}
			}
		});

		frame.pack();
		frame.setVisible(true);
	}

}
