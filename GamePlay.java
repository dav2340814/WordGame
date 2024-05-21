import java.util.Scanner;

public class GamePlay {

	private static Players[] currentPlayers = new Players[3];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.console().reader());

		Hosts host = new Hosts("Mettaton");
		host.randomizeNum();

		for (int i = 0; i < 3; i++) {

			System.out.printf("%s: Player %d, What's your first name? ",
					host.getFirstName() + host.getLastName(), i + 1);
			String fname = sc.nextLine();
			System.out.print("What's your last name (leave empty if you want)? ");
			String lname = sc.nextLine().strip();
			currentPlayers[i] = new Players(fname, lname);
		}

		char continueAns;
		// Game loop
		while (true) {
			// Player loop
			playerloop: while (true) {
				for (Players p : currentPlayers) {

					Turn turn = new Turn();
					if (turn.takeTurn(p, host)) {
						break playerloop;
					}
				}
			}
			do {
				System.out.printf("%s: Do you want to quit (y/n)? ",
						host.getFirstName() + host.getLastName());
				continueAns = sc.next().strip().charAt(0);
			} while (continueAns != 'y' && continueAns != 'n');
			if (continueAns == 'y') {
				break;
			}
			host.randomizeNum();
		}
		sc.close();
	}
}
