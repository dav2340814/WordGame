public class Physical implements Award {

	private String[] prizes = { "goat", "car", "house", "vacation", "bike" };

	private int getRandomPrize() {
		return (int) (Math.random() * 4);
	}

	public int displayWinnings(Players player, boolean isGuessCorrect, Messages msgArea) {
		if (isGuessCorrect) {
			msgArea.setMessage(String.format("We have a winner!\n%s\n" + "Your prize is a %s!\n",
					player.toString(), prizes[getRandomPrize()]));
		} else {
			msgArea.setMessage(String.format("WRONG! %s\n" + "You could have won a %s\n",
					player.toString(), prizes[getRandomPrize()]));
		}
		return 0;
	}
}
