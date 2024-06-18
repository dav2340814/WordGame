import java.io.File;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

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

			// Sounds and animations
			File snd;
			Image img;
			if (isGuessCorrect) {
				snd = new File("./res/sfx/right.wav");
				img = new ImageIcon("./res/img/correct.png").getImage();
			} else {
				snd = new File("./res/sfx/wrong.wav");
				img = new ImageIcon("./res/img/incorrect.png").getImage();
			}
			// Sound
			try {
				Clip c = AudioSystem.getClip();
				AudioInputStream aIn = AudioSystem
						.getAudioInputStream(snd);
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

			JFrame animationFrame = new JFrame();
			AnimationPanel animationPanel = new AnimationPanel(img);
			animationFrame.add(animationPanel);
			animationFrame.setSize(300, 300);
			animationFrame.setLocationRelativeTo(null);
			animationFrame.setUndecorated(true);
			animationFrame.setVisible(true);

			Timer timer = new Timer(45, new ActionListener() {
				float scale = 1.0f;
				boolean zoomIn = true;

				@Override
				public void actionPerformed(ActionEvent e) {
					if (zoomIn) {
						scale += 0.05f;
						if (scale >= 1.5f) {
							zoomIn = false;
						}
					} else {
						scale -= 0.05f;
						if (scale <= 1.0f) {
							((Timer) e.getSource()).stop();
							animationFrame.dispose();
						}
					}
					animationPanel.setScale(scale);
				}
			});

			timer.start();

			player.setMoney(player.getMoney() + a.displayWinnings(player, isGuessCorrect, msgArea));
			isGuessCorrect = host.getPhrase().hasWon();

		} catch (

		Exception e) {
			System.out.println(e.getMessage());
		}
		return isGuessCorrect;
	}
}
