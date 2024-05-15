
import java.util.Scanner;

public class GamePlay {

	private static Person player;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

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
			player = new Person(fname, lname);
		} else {
			player = new Person(fname);
		}

		Numbers numbers = new Numbers();
		numbers.generateNumber();

		int guess = -1;
		do {
			System.out.printf("%s, Enter a number 0-100: ",
					lnameAns == 'y' ? player.getFirstName() + " " + player.getLastName()
							: player.getFirstName());
			// If the user doesn't input an int,
			while (!sc.hasNextInt()) {
				System.out.printf("%s, Enter a number 0-100: ",
						lnameAns == 'y' ? player.getFirstName() + " " + player.getLastName()
								: player.getFirstName());
				// Throw away input until he does
				sc.next();
			}
			guess = sc.nextInt();
		} while (!numbers.compareNumber(guess));

		sc.close();
	}
}
