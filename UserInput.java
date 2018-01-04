import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInput {
	
	// Reading in text - STRING
	public static String getData() {
		String text = null;
		boolean correct = false;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			try {
				text = br.readLine();
				
				if (text.matches("[a-zA-Z ]+")) {
					correct = true;
				} else {
					System.out.println("»»»»» Type just letters. «««««");
					System.out.print("» ");
					correct = false;
				}
				
			} catch (Exception e) {
				correct = false;
			}
		} while (correct != true);
		
		return text;
	}

	// Reading in numbers - INTEGER
	public static int getData(int numberOfElements) {
		
		int number = 0;
		boolean correct = false;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			try {
				number = Integer.parseInt(br.readLine());
				
				if (number == 0) {
					System.out.println("»»»»» Type a valid number. «««««");
					System.out.print("» ");
					correct = false;
				} else if (number > numberOfElements) {
					System.out.println("»»»»» Type a number between 1 and " + numberOfElements + ". «««««");
					System.out.print("» ");
					correct = false;
				} else {
					correct = true;
				}
			} catch (Exception e) {
				System.out.println("»»»»» Type a NUMBER. «««««");
				System.out.print("» ");
				correct = false;
			}
			
		} while (correct != true);
		
		return number;
	}
	
	// Reading in numbers - DOUBLE
	public static double getData(double numberOfElements) {
		
		double number = 0;
		boolean correct = false;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			try {
				number = Double.parseDouble(br.readLine());
				
				if (number == 0) {
					System.out.println("»»»»» Type a valid number. «««««");
					System.out.print("» ");
					correct = false;
				} else if (number > numberOfElements) {
					System.out.println("»»»»» Type a number between 0 and " + numberOfElements + ". «««««");
					System.out.print("» ");
					correct = false;
				} else {
					correct = true;
				}
			} catch (Exception e) {
				System.out.println("»»»»» Type a NUMBER. «««««");
				System.out.print("» ");
				correct = false;
			}
			
		} while (correct != true);
		
		return number;
	}
}