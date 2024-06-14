import javax.swing.ImageIcon;

public class Physical implements Award {

	private String[] prizes = { "goat", "car", "house", "vacation", "bike" };

	private int getRandomPrize() {
		return (int) (Math.random() * 4);
	}

	public int displayWinnings(Players player, boolean isGuessCorrect, Messages msgArea) {
		String prize = prizes[getRandomPrize()];
		if (isGuessCorrect) {
			msgArea.setMessage(String.format("We have a winner!\n%s\n" + "Your prize is a %s!\n",
					player.toString(), prize),
					new ImageIcon(String.format("res/img/%s.jpg", prize)));
		} else {
			msgArea.setMessage(String.format("WRONG! %s\n" + "You could have won a %s\n",
					player.toString(), prize));
		}
		return 0;
	}
}
