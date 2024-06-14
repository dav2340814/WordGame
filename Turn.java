import java.io.File;

import javax.sound.sampled.*;
import javax.swing.JOptionPane;

public class Turn {

	public boolean takeTurn(Players player, Hosts host, Messages msgArea) {
		String guess = "" + JOptionPane.showInputDialog("Enter a letter:").strip().charAt(0);
		Award a;
		if (Math.round(Math.random()) == 0) {
			// Money
			a = new Money();
		} else {
			// Physical prize
			a = new Physical();
		}
		boolean isGuessCorrect = false;
		try {
			isGuessCorrect = host.getPhrase().findLetters(guess);

			// Sounds
			File sndFile;
			if (isGuessCorrect) {
				sndFile = new File("./res/sfx/right.wav");
			} else {
				sndFile = new File("./res/sfx/wrong.wav");
			}
			try {
				Clip c = AudioSystem.getClip();
				AudioInputStream aIn = AudioSystem
						.getAudioInputStream(sndFile);
				c.open(aIn);
				c.start();
				c.addLineListener(new LineListener() {
					@Override
					public void update(LineEvent e) {
						if (e.getType() == LineEvent.Type.STOP) {
							c.close();
						}
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}

			player.setMoney(player.getMoney() + a.displayWinnings(player, isGuessCorrect, msgArea));
			isGuessCorrect = host.getPhrase().hasWon();

		} catch (

		Exception e) {
			System.out.println(e.getMessage());
		}
		return isGuessCorrect;
	}
}
