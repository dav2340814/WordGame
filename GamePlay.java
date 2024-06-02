import java.util.ArrayList;

public class GamePlay {

	public static ArrayList<Players> currentPlayers = new ArrayList<Players>();

	public static Hosts host = new Hosts("Mettaton");

	public static int currPlayer = 0;

	private static Turn turn = new Turn();

	public static boolean nextTurn() {
		if (currPlayer >= currentPlayers.size())
			currPlayer = 0;
		if (turn.takeTurn(currentPlayers.get(currPlayer), host)) {
			currPlayer++;
			return true;
		}
		currPlayer++;
		return false;
	}
}
