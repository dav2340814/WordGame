public class Hosts extends Person {

	private Numbers number;

	public Hosts(String fname) {
		super(fname);
		number = new Numbers();
	}

	public Hosts(String fname, String lname) {
		super(fname, lname);
		number = new Numbers();
	}

	public Numbers getNumber() {
		return number;
	}

	public void randomizeNum() {
		number.generateNumber();
	}
}
