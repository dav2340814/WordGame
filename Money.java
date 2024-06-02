import javax.swing.JOptionPane;
import javax.swing.FocusManager;

public class Money implements Award {

	private int winMoney = 100;
	private int loseMoney = -50;

	public int displayWinnings(Players player, boolean isGuessCorrect) {
		if (isGuessCorrect) {
			JOptionPane.showMessageDialog(
					FocusManager.getCurrentManager().getActiveWindow().getOwner(),
					String.format("We have a winner!\n%s\n", player.toString(), "You win!"));
			return winMoney;
		} else {
			System.out.printf("WRONG! %s\n", player.toString());
			JOptionPane.showMessageDialog(FocusManager.getCurrentManager().getActiveWindow().getOwner(),
					String.format("WRONG! %s\n", player.toString()));
			return loseMoney;
		}
	}
}
