public class Person {
	private String firstName;
	private String lastName = "";

	public Person(String fname) {
		firstName = fname;
	}

	public Person(String fname, String lname) {
		firstName = fname;
		if (!lname.isEmpty())
			lastName = " " + lname;
	}

	// Getter and Setter for firstName
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		firstName = name;
		return;
	}

	// Getter and Setter for lastName
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String name) {
		lastName = name;
		return;
	}

}
