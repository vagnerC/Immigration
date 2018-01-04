import java.util.Date;

public class Main {

	LinkedList<Person> queue = new LinkedList<Person>();

	public Main() {

		System.out.println();
		System.out.println("Welcome to Visitor List in Immigration Department ");
		menu();

	}
	// ----------------------------------------------------------------------------------------------------------------------
	// Menu
	public void menu() {

		System.out.println();
		System.out.println("============================= MENU =============================");
		System.out.println("Select one of the following options:");
		System.out.println();
		System.out.println("1) Add a new Candidate");
		System.out.println("2) Update a Candidate");
		System.out.println("3) Show List");
		System.out.println("4) Check Position");
		System.out.println("5) Remove a Candidate(s)");
		System.out.println("6) Auto add 3 new candidates");
		System.out.println("7) Exit");
		System.out.print("» ");
		int menuNumber = UserInput.getData(7);

		switch (menuNumber) {
		case 1:
			addPerson();
			break;
		case 2:
			editPerson();
			break;
		case 3:
			showList();
			break;
		case 4:
			checkPosition();
			break;
		case 5:
			removePerson();
			break;
		case 6:
			autoPopulate();
			break;
		case 7:
			quit();
			break;
		}
	}
	// ----------------------------------------------------------------------------------------------------------------------
	// Add Person
	public void addPerson() {

		System.out.println();

		showLine();
		System.out.println("Information: ");
		System.out.println("If there are no persons on the list or the candidate has a child less than 1 year old then this candidate will be added to the start of the list.");
		System.out.println("If the Candidate has a child less than 3 years old but greater than 1 year old this Candidate will be added to the middle of the list.");
		System.out.println("If the Candidate doesn't qualify for any of the above criteria it will be possible to add the Candidate to a chosen position or at the end of the list.");
		showLine();

		System.out.println("First Name: ");
		System.out.print("» ");
		String fn = UserInput.getData();

		System.out.println("Last Name: ");
		System.out.print("» ");
		String ln = UserInput.getData();

		System.out.println("Passport Number: ");
		System.out.print("» ");
		int pn = UserInput.getData(999999999);

		System.out.println("Child (Y or N): ");
		System.out.print("» ");
		String k = UserInput.getData();

		double ka = 0;
		if (k.equalsIgnoreCase("Y")) {
			System.out.println("Child Age: (For children under 1 year old use 0 followed by a decimal point and the month. E.g.: 0.8)");
			System.out.print("» ");
			ka = UserInput.getData(15.0);
		}

		// Show the data to the user
		System.out.println();
		System.out.println("Is the below data correct?");
		System.out.println();

		System.out.println("- First Name: " + fn);
		System.out.println("- Last Name: " + ln);
		System.out.println("- Passport Number: " + pn);
		System.out.println("- Child: " + k);
		System.out.println("- Child Age: " + ka);

		// Ask user if its correct
		System.out.println();
		System.out.println("1 - Yes (Add \"" + fn + "\" to the list.)");
		System.out.println("2 - No (Delete \"" + fn + "\" and start again.)");
		System.out.println("3 - No (Delete \"" + fn + "\" and go back to the Menu.)");
		System.out.print("» ");
		int menuConfirm = UserInput.getData(3);

		if (menuConfirm == 1) {
			Person person = new Person();

			Person.setCount(Person.getCount() + 1);

			person.setId(Person.getCount());
			person.setDateOfArrival(new Date());
			person.setFirstName(fn);
			person.setLastName(ln);
			person.setPassportNumber(pn);
			person.setKid(k);
			person.setKidAge(ka);

			if (queue.size() == 0) {
				// add person to first position because the list is empty
				queue.add(person);
			} else if (k.equalsIgnoreCase("Y") && ka < 1) {
				// first position
				queue.insertAtFirstPosition(person);
			} else if (k.equalsIgnoreCase("Y") && ka < 3) {
				// middle of list position
				int middle = (queue.size() + 1) / 2;
				queue.insert(person, middle);
			} else {
				// Ask if the person want to be added in a specific position

				System.out.println();
				System.out.println("Do you want to add \"" + fn + "\" into a specific position?");
				System.out.println("1 - Yes, add \"" + fn + "\" to an specific position.");
				System.out.println("2 - No, add \"" + fn + "\" into the end of the list.");
				System.out.print("» ");
				int menuSpecificPosition = UserInput.getData(2);

				if (menuSpecificPosition == 1) {
					System.out.println();
					System.out.println(
							"What position do you want to add \"" + fn + "\"? (1 - " + (queue.size() + 1) + ")");
					System.out.print("» ");
					int specificPosition = UserInput.getData((queue.size() + 1));
					if (specificPosition == 1) {
						// insert into first position
						queue.insertAtFirstPosition(person);
					} else {
						// insert into specific position
						queue.insert(person, (specificPosition - 1));
					}
				} else if (menuSpecificPosition == 2) {
					queue.add(person);
				}
			}
			System.out.println();
			showLine();
			System.out.println(fn + " successfully added. ID: " + person.getId());
			showLine();
			menu();

		} else if (menuConfirm == 2) {
			addPerson();
		} else if (menuConfirm == 3) {
			menu();
		}

	}
	// ----------------------------------------------------------------------------------------------------------------------
	//Update Person
	public void editPerson(){
		
		System.out.println();
		System.out.println("Type the Candidate's ID to update their information: (1 - " + Person.getCount() + ")");
		System.out.print("» ");
		int personID = UserInput.getData(Person.getCount());
		System.out.println();
		showLine();
		Person p = new Person();
		int position = 0;
		for (int i = 1; i <= queue.size(); i++) {
			p = queue.get(i);
			if (p.getId() == personID) {
				position = i;
			}
		}
		
		if(position > 0){
			p = queue.get(position);
			
			System.out.println("First Name: ");
			System.out.println("  Old » "+p.getFirstName());
			System.out.print("  New » ");
			String fn = UserInput.getData();

			System.out.println("Last Name: ");
			System.out.println("  Old » "+p.getLastName());
			System.out.print("  New » ");
			String ln = UserInput.getData();

			System.out.println("Passport Number: ");
			System.out.println("  Old » "+p.getPassportNumber());
			System.out.print("  New » ");
			int pn = UserInput.getData(999999999);

			System.out.println("Child (Y or N): ");
			System.out.println("  Old » "+p.getKid());
			System.out.print("  New » ");
			String k = UserInput.getData();
			
			double ka = 0;
			if (k.equalsIgnoreCase("Y")) {
				System.out.println("Child Age: (For children under 1 year old use 0 followed by a decimal point and the month. E.g.: 0.8)");
				System.out.println("  Old » "+p.getKidAge());
				System.out.print("  New » ");
				ka = UserInput.getData(15.0);
			}

			// Show the data to the user
			System.out.println();
			System.out.println("Is the below data correct?");
			System.out.println();

			System.out.println("- First Name: " + fn);
			System.out.println("- Last Name: " + ln);
			System.out.println("- Passport Number: " + pn);
			System.out.println("- Child: " + k);
			System.out.println("- Child Age: " + ka);
			
			// Ask user if its correct
			System.out.println();
			System.out.println("1 - Yes (Update \"" + fn + "\".)");
			System.out.println("2 - No (Keep old information  and go back to the Menu.)");
			System.out.print("» ");
			int menuConfirm = UserInput.getData(2);			
			
			if(menuConfirm == 1){
				p.setDateOfArrival(new Date());
				p.setFirstName(fn);
				p.setLastName(ln);
				p.setPassportNumber(pn);
				p.setKid(k);
				p.setKidAge(ka);
				
				System.out.println();
				showLine();
				System.out.println(fn + " successfully updated.");
				showLine();
				menu();
			} else if (menuConfirm == 2){
				menu();
			}
			
		} else {
			System.out.println("Candidate not found;");
		}
		
	}
	// ----------------------------------------------------------------------------------------------------------------------
	// Show list
	public void showList() {
		
		System.out.println(queue);
		showLine();
		menu();
	}
	// ----------------------------------------------------------------------------------------------------------------------
	// Check Position
	public void checkPosition() {
	
		System.out.println();
		System.out.println("How do you want to check the Candidate position?");
		System.out.println("1 - by ID");
		System.out.println("2 - by Name");
		System.out.print("» ");
		int menuList = UserInput.getData(2);

		if (menuList == 1) {

			System.out.println();
			System.out.println("Type the Candidate's ID to check their corresponding position: (1 - " + Person.getCount() + ")");
			System.out.print("» ");
			int personID = UserInput.getData(Person.getCount());
			System.out.println();
			showLine();
			Person p = new Person();
			for (int i = 1; i <= queue.size(); i++) {
				p = queue.get(i);
				if (p.getId() == personID) {
					System.out.println(p.getFirstName() + " is at position number " + i + ".");
				}
			}

		} else if (menuList == 2) {

			System.out.println();
			System.out.println("Type the Candidate's First Name to check their corresponding position:");
			System.out.print("» ");
			String personFirstName = UserInput.getData();
			System.out.println();
			showLine();
			Person p = new Person();
			for (int i = 1; i <= queue.size(); i++) {
				p = queue.get(i);
				if (p.getFirstName().equalsIgnoreCase(personFirstName)) {
					System.out.println(p.getFirstName() + " is at position number " + i + ".");
				}
			}

		}

		showLine();
		menu();
	}
	// ----------------------------------------------------------------------------------------------------------------------
	// Remove Person
	public void removePerson() {

		System.out.println();
		System.out.println("How do you want to remove a candidate: ");
		System.out.println("1 - from the First Position");
		System.out.println("2 - from a Specific Position");
		System.out.println("3 - by Candidate ID");
		System.out.println("4 - the last N numbers");
		System.out.print("» ");
		int menuPosition = UserInput.getData(4);

		if (menuPosition == 1) {
			queue.remove();
		} else if (menuPosition == 2) {
			System.out.println();
			System.out.println("What position do you want to remove a candidate? (1 - " + queue.size() + ")");
			System.out.print("» ");
			int specificPosition = UserInput.getData(queue.size());
			// remove the First Position
			if (specificPosition == 1) {
				queue.remove();
			} else {
				queue.removeAt(specificPosition);
			}
		} else if (menuPosition == 3) {
			System.out.println();
			System.out.println("What Candidate ID do you want to remove? (1 - " + Person.getCount() + ")");
			System.out.print("» ");
			int personID = UserInput.getData(Person.getCount());
			System.out.println();

			Person p = new Person();
			for (int i = 1; i <= queue.size(); i++) {
				p = queue.get(i);
				if (p.getId() == personID) {
					if (i == 1) {
						// delete the head
						queue.remove();
					} else {
						queue.removeAt(i);
					}
				}
			}
		} else if (menuPosition == 4) {
			System.out.println();
			System.out.println("How many people do you want to remove from the end of the list? (1 - " + queue.size() + ")");
			System.out.print("» ");
			int menuRemove = UserInput.getData(queue.size());

			for (int i = 1; i <= menuRemove; i++) {
				if (queue.size() == 1) {
					// delete the head
					queue.remove();
				} else {
					// delete the last position
					queue.removeAt(queue.size());
				}
			}
		}
		System.out.println();
		showLine();
		System.out.println("Candidate successfully removed.");
		showLine();
		menu();
	}
	// ----------------------------------------------------------------------------------------------------------------------
	// Auto populate the program
	public void autoPopulate() {

		Person person0 = new Person();
		Person.setCount(Person.getCount() + 1);
		person0.setId(Person.getCount());
		person0.setDateOfArrival(new Date());
		person0.setFirstName("Vagner");
		person0.setLastName("Costa");
		person0.setPassportNumber(2015155);
		person0.setKid("n");
		person0.setKidAge(0);
		queue.add(person0);
		Person person1 = new Person();
		Person.setCount(Person.getCount() + 1);
		person1.setId(Person.getCount());
		person1.setDateOfArrival(new Date());
		person1.setFirstName("Bruno");
		person1.setLastName("Santos");
		person1.setPassportNumber(2015192);
		person1.setKid("n");
		person1.setKidAge(0);
		queue.add(person1);
		Person person3 = new Person();
		Person.setCount(Person.getCount() + 1);
		person3.setId(Person.getCount());
		person3.setDateOfArrival(new Date());
		person3.setFirstName("Kevin");
		person3.setLastName("McCormack");
		person3.setPassportNumber(789);
		person3.setKid("n");
		person3.setKidAge(0);
		queue.add(person3);
		menu();
	}
	// ----------------------------------------------------------------------------------------------------------------------
	// Quit the program
	public void quit() {

		System.out.println();
		System.out.println("Are you sure you want to quit the program?");
		System.out.println("1) Yes :(");
		System.out.println("2) No :)");
		System.out.print("» ");
		int menuFinish = UserInput.getData(2);
		if (menuFinish == 2) {
			System.out.println("\nWelcome back!!!");
			menu();
		} else {
			System.out.println("\nBye.");
			System.exit(1);
		}
	}
	// ----------------------------------------------------------------------------------------------------------------------
	public void showLine() {
		System.out.println("----------------------------------------------------------------");
	}
	// ----------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		new Main();
	}
}