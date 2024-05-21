public class Physical implements Award {

	private String[] prizes = { "goat", "car", "house", "vacation", "bike" };

	private int getRandomPrize() {
		return (int) (Math.random() * 4);
	}

	public int displayWinnings(Players player, boolean isGuessCorrect) {
		if (isGuessCorrect) {
			System.out.printf("We have a winner!\n%s\n", player.toString());
			System.out.printf("Your prize is a %s!\n", prizes[getRandomPrize()]);
		} else {
			System.out.printf("WRONG! %s\n", player.toString());
			System.out.printf("You could have won a %s\n", prizes[getRandomPrize()]);
		}
		return 0;
	}
}
