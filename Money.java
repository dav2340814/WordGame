public class Money implements Award {

	private int winMoney = 100;
	private int loseMoney = -50;

	public int displayWinnings(Players player, boolean isGuessCorrect) {
		if (isGuessCorrect) {
			System.out.printf("We have a winner!\n%s\n", player.toString());
			return winMoney;
		} else {
			System.out.printf("WRONG! %s\n", player.toString());
			return loseMoney;
		}
	}
}
