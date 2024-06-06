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
			player.setMoney(player.getMoney() + a.displayWinnings(player, isGuessCorrect, msgArea));
			isGuessCorrect = host.getPhrase().hasWon();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isGuessCorrect;
	}
}
