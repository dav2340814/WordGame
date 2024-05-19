import java.util.Scanner;

public class Turn {

	public boolean takeTurn(Players player, Hosts host) {
		Scanner sc = new Scanner(System.console().reader());
		// sc.useDelimiter(System.lineSeparator());
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
		if (host.getNumber().compareNumber(guess)) {
			player.increaseMoney();
			System.out.printf("%s: We have a winner!\n%s\n", host.getFirstName() + host.getLastName(),
					player.toString());
			return true;
		} else {
			player.decreaseMoney();
			System.out.println(player.toString());
			return false;
		}
	}
}
