import java.lang.Math;

public class Numbers {

	private int randomNum;

	// Getter and Setter for randomNum
	public int getRandomNum() {
		return randomNum;
	}

	public void setRandomNum(int num) {
		randomNum = num;
		return;
	}

	public void generateNumber() {
		randomNum = (int) Math.random() * 100;
	}

	public Boolean compareNumber(int guess) {
		if (guess > randomNum) {
			System.out.println("I'm sorry. That guess was too high.");
			return false;
		} else if (guess < randomNum) {
			System.out.println("I'm sorry. That guess was too low.");
			return false;
		}

		// guess must be the same as randomNum
		System.out.println("Congratulations, you guessed the number!");
		return true;
	}
}
