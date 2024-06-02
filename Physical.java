import javax.swing.FocusManager;
import javax.swing.JOptionPane;

public class Physical implements Award {

	private String[] prizes = { "goat", "car", "house", "vacation", "bike" };

	private int getRandomPrize() {
		return (int) (Math.random() * 4);
	}

	public int displayWinnings(Players player, boolean isGuessCorrect) {
		if (isGuessCorrect) {
			JOptionPane.showMessageDialog(FocusManager.getCurrentManager().getActiveWindow().getOwner(),
					String.format("We have a winner!\n%s\n" + "Your prize is a %s!\n",
							player.toString(), prizes[getRandomPrize()]));
		} else {
			JOptionPane.showMessageDialog(FocusManager.getCurrentManager().getActiveWindow().getOwner(),
					String.format("WRONG! %s\n" + "You could have won a %s\n",
							player.toString(), prizes[getRandomPrize()]));
		}
		return 0;
	}
}
