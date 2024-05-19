public class Players extends Person {

	private int money;

	public Players(String fname) {
		super(fname);
		money = 1000;
	}

	public Players(String fname, String lname) {
		super(fname, lname);
		money = 1000;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int num) {
		money = num;
	}

	public void increaseMoney() {
		money += 100;
	}

	public void decreaseMoney() {
		money -= 50;
	}

	@Override
	public String toString() {
		return String.format("Name: %s, Money: %d", getFirstName() + getLastName(), money);
	}
}
