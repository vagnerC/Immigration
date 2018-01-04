import java.util.Date;

public class Person {
	
	private String firstName;
	private String lastName;
	private int passportNumber;
	private String kid;
	private double kidAge;
	private Date dateOfArrival;
	private static int count = 0;
	private int id = 0;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(int passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getKid() {
		return kid;
	}

	public void setKid(String kid) {
		this.kid = kid;
	}

	public double getKidAge() {
		return kidAge;
	}

	public void setKidAge(double kidAge) {
		this.kidAge = kidAge;
	}

	public Date getDateOfArrival() {
		return dateOfArrival;
	}

	public void setDateOfArrival(Date dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Person.count = count;
	}
	
	public String toString(){
		return 	  "\n-----------------------------------------------"
				+ "\nID: "+getId()
				+ "\nName: "+getFirstName()+" "+getLastName()
				+ "\nPassport Number: "+getPassportNumber()
				+ "\nKid: "+getKid()+" | Age: "+getKidAge()
				+ "\nDate of Arrival: "+getDateOfArrival();
	}
}