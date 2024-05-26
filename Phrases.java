/**
 * Phrases
 */
public class Phrases {
	private String gamePhrase;
	private StringBuffer playingPhrase;

	public Phrases() {
		gamePhrase = "";
		playingPhrase = new StringBuffer("");
	}

	public Phrases(String phrase) {
		gamePhrase = phrase;
		playingPhrase = new StringBuffer("");
	}

	public String getPhrase() {
		return gamePhrase;
	}

	public void setPhrase(String s) {
		gamePhrase = s;
	}

	public String getPlayingPhrase() {
		return playingPhrase.toString();
	}

	public void generatePhrase() {
		playingPhrase.delete(0, playingPhrase.length());
		for (int i = 0; i < gamePhrase.length(); i++) {
			if (Character.isAlphabetic(gamePhrase.charAt(i))) {
				playingPhrase.append("_");
			} else {
				playingPhrase.append(gamePhrase.charAt(i));
			}
		}
	}

	public boolean hasWon() {
		if (playingPhrase.indexOf("_") == -1) {
			System.out.println("Congratulations, you guessed the phrase!");
			return true;
		}
		return false;
	}

	/*
	 * Returns true if won, false if not
	 */
	public boolean findLetters(String s) throws MultipleLettersException {
		if (s.length() > 1) {
			throw new MultipleLettersException();
		}
		for (int i = 0; i < gamePhrase.length(); i++) {
			if (gamePhrase.toUpperCase().charAt(i) == s.toUpperCase().charAt(0)) {
				playingPhrase.replace(i, i + 1, s.toUpperCase());
			}
		}
		if (gamePhrase.contains(s.toUpperCase())) {
			return true;
		}
		return false;
	}
}
