public class Money implements Award {

	private int winMoney = 100;
	private int loseMoney = -50;

	public int displayWinnings(Players player, boolean isGuessCorrect, Messages msgArea) {
		if (isGuessCorrect) {
			msgArea.setMessage(String.format("We have a winner!\n%s\n", player.toString()));
			return winMoney;
		} else {
			System.out.printf("WRONG! %s\n", player.toString());
			msgArea.setMessage(String.format("WRONG! %s\n", player.toString()));
			return loseMoney;
		}
	}
}
