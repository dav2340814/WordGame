import java.util.Scanner;

public class Turn {

	public boolean takeTurn(Players player, Hosts host) {
		Scanner sc = new Scanner(System.console().reader());
		int guess = -1;
		System.out.printf("%s: %s, Enter a number 0-100: ", host.getFirstName() + host.getLastName(),
				player.getFirstName() + player.getLastName());
		// If the user doesn't input an int,
		while (!sc.hasNextInt()) {
			System.out.printf("%s: %s, Enter a number 0-100: ", host.getFirstName() + host.getLastName(),
					player.getFirstName() + player.getLastName());
			// Throw away input until he does
			if (sc.hasNextLine()) {
				sc.nextLine();
			}
		}
		guess = sc.nextInt();
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
		boolean isGuessCorrect = host.getNumber().compareNumber(guess);
		player.setMoney(player.getMoney() + a.displayWinnings(player, isGuessCorrect));
		return isGuessCorrect;
	}
}
