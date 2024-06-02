import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Phrases
 */
public class Phrases {
	private String gamePhrase;
	private StringBuffer playingPhrase;
	private PropertyChangeSupport support = new PropertyChangeSupport(this);

	public Phrases() {
		gamePhrase = "";
		playingPhrase = new StringBuffer("");
	}

	public Phrases(String phrase) {
		gamePhrase = phrase.toUpperCase();
		playingPhrase = new StringBuffer("");
	}

	public String getPhrase() {
		return gamePhrase;
	}

	public void setPhrase(String s) {
		gamePhrase = s.toUpperCase();
	}

	public String getPlayingPhrase() {
		return playingPhrase.toString();
	}

	public void generatePhrase() {
		String oldPlayingPhrase = playingPhrase.toString();
		playingPhrase.delete(0, playingPhrase.length());
		for (int i = 0; i < gamePhrase.length(); i++) {
			if (Character.isAlphabetic(gamePhrase.charAt(i))) {
				playingPhrase.append("_");
			} else {
				playingPhrase.append(gamePhrase.charAt(i));
			}
		}
		support.firePropertyChange("playingPhrase", oldPlayingPhrase, playingPhrase.toString());
	}

	public boolean hasWon() {
		if (playingPhrase.indexOf("_") == -1) {
			return true;
		}
		return false;
	}

	/*
	 * Returns true if won, false if not
	 */
	public boolean findLetters(String s) throws MultipleLettersException {
		String oldPlayingPhrase = playingPhrase.toString();
		if (s.length() > 1) {
			throw new MultipleLettersException();
		}
		for (int i = 0; i < gamePhrase.length(); i++) {
			if (gamePhrase.toUpperCase().charAt(i) == s.toUpperCase().charAt(0)) {
				playingPhrase.replace(i, i + 1, s.toUpperCase());
				support.firePropertyChange("playingPhrase", oldPlayingPhrase, playingPhrase.toString());
			}
		}
		if (gamePhrase.contains(s.toUpperCase())) {
			return true;
		}
		return false;
	}

	// Add property change support
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}
}
