import java.util.Scanner;

public class Turn {

	public boolean takeTurn(Players player, Hosts host) {
		Scanner sc = new Scanner(System.console().reader());
		String guess = "";
		System.out.printf("%s: %s, Enter a letter: ", host.getFirstName() + host.getLastName(),
				player.getFirstName() + player.getLastName());
		guess += sc.next().strip().charAt(0);
		// Consume newline
		sc.nextLine();
		sc.close();
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
			player.setMoney(player.getMoney() + a.displayWinnings(player, isGuessCorrect));
			isGuessCorrect = host.getPhrase().hasWon();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Phrase: " + host.getPhrase().getPlayingPhrase());
		return isGuessCorrect;
	}
}
