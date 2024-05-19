import java.util.Scanner;

public class GamePlay {

	private static Players player;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.console().reader());

		Hosts host = new Hosts("Mettaton");
		host.randomizeNum();

		System.out.print("What's your first name? ");
		String fname = sc.next();

		char lnameAns;
		do {
			System.out.print("Do you want to enter your last name? (y/n) ");
			lnameAns = sc.next().strip().charAt(0);
		} while (lnameAns != 'y' && lnameAns != 'n');

		if (lnameAns == 'y') {
			System.out.print("What's your last name? ");
			String lname = sc.next();
			player = new Players(fname, lname);
		} else {
			player = new Players(fname);
		}
		char continueAns;
		while (true) {
			Turn turn = new Turn();
			while (!turn.takeTurn(player, host)) {
				continue;
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
