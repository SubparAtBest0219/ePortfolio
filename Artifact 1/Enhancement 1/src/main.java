package clock;

/*******************************************************\
 *						Sources							*
 ********************************************************
 * Date time and formatter								*
 * https://docs.oracle.com/javase/8/docs/api			*
 * /java/time/format/DateTimeFormatter.html				*
 *  													*
 * Ternary operators									*
 * https://www.geeksforgeeks.org						*
 * /java-ternary-operator-with-examples/				*
 * 														*
 * Returning multiple values							*
 * https://www.geeksforgeeks.org						*
 * /returning-multiple-values-in-java/					*
 * 														*
 * Clearscreen method									*
 * https://stackoverflow.com/questions/2979383			*
 * /how-to-clear-the-console-using-java					*
 * 														*
 * Sleep method											*
 * https://stackoverflow.com/questions/9439110			*
 * /make-a-java-program-sleep-without-threading			*
 * 														*
 * Zero padding											*	
 * https://stackoverflow.com/questions/473282			*
 * /how-can-i-pad-an-integer-with-zeros-on-the-left		*
 \******************************************************/

import java.time.LocalDateTime; // Pulls local time
import java.util.InputMismatchException; // Used in error handling
import java.util.Scanner; // Used to process user input
import java.util.concurrent.TimeUnit;

public class main {
	static int userInput; // Handles user input
	static boolean endProgram = false; // Boolean controlling loop termination
	static int hour24, hour12, minute, second; // Stores local time in separate variables
	static String amPm;
	private static Scanner scnr = new Scanner(System.in); // Allows for user input
	
	// Displays the time
	private static void displayTime(int hour24, int hour12, int minute, int second) {
		// Handles AM/PM adjustments for 12 hour time
		if (hour24 > 12){ 
			amPm = "P M";
		}
		else{
			amPm = "A M";
		}
		
		// Prints out 24 and 12 hour times in a format of my choosing
		System.out.println("************************    ********************");
		System.out.println("*     24-hour time     *" + "    *   12-hour time   *");
		System.out.printf("*        %02d:%02d:%02d      *    *      %02d:%02d:%02d    *\n", // %02d specifies the format, essentially padding 0's
						hour24, minute, second, hour12, minute, second, amPm );
		System.out.println("************************    ********************");
	}
	
	// Displays a menu with corresponding user choices
	private static void displayMenu() {
		System.out.println("\t\t***********************");
		System.out.println("\t\t*   Menu Options:     *");
		System.out.println("\t\t*   1: Add one hour   *");
		System.out.println("\t\t*   2. Add one minute *");
		System.out.println("\t\t*   3. Add one second *");
		System.out.println("\t\t*   4. Exit program   *");
		System.out.println("\t\t***********************");
	}
	
	// Increments the hour
	private static void addHour() {
		hour24 = (hour24 + 1) % 24; // Increments the hour but also wraps at 24
		hour12 = hour24 % 12; // Calculates 12 hour time using wrapping
		
		// Use-case where hour12 should become zero formatting 12 hour time
		if(hour12 == 0){
			hour12 = 12;
		}
	}
	
	// Increments the minute
	private static void addMinute() {
		minute++;
		if (minute >=60 ){ // Use-case when minutes equal to or go over 60, adds an hour instead and resets
			minute = 0;
			addHour();
		}
	}
	
	// Adds a second
	private static void addSecond() {
		second++;
		if (second >= 60){ // Use-case when seconds equal to or go over 60, adds a minute instead
			second = 0;
			addMinute();
		}
	}
	
	// Terminates the main loop
	private static void terminate() {

		try {
			System.out.println("Teminating the program... Goodbye!");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		endProgram = true; // Sets boolean field to terminate main loop
	}
	
	// Handles menu input 
	private static void menuInput(int choice) {
		switch(choice) {
		case 1 -> addHour(); // Adds an hour
		case 2 -> addMinute(); // Adds a minute
		case 3 -> addSecond(); // Adds a second
		case 4 -> terminate(); // Breaks the loop
		default -> {
                    System.out.println("Invalid user input"); // Handles invalid input
                    try{
                        TimeUnit.SECONDS.sleep(1);
                    }
                    catch(InterruptedException e){
                        Thread.currentThread().interrupt();
                    }
                }
		}
	}
	
	
	public static void main(String[] args) {
		LocalDateTime today = LocalDateTime.now(); // Utilized to pull local time
		hour24 = today.getHour(); // Sets localtime in 24 hour format
		hour12 = hour24 % 12; // Sets localtime in 12 hour format
		minute = today.getMinute(); // Sets the current local minute
		second = today.getSecond(); // Sets the current local second

		while (!endProgram) { // While boolean set to false, continue
		displayTime(hour24, hour12, minute, second);
		displayMenu(); // Shows user choices
		try{
		userInput = scnr.nextInt(); // Accepts user input
		menuInput(userInput); // Processes user input
			}
		catch(InputMismatchException e){
			clearScreen.CLS();
			System.out.println(" Invalid input, please use a number");
			scnr.next();
			}
			clearScreen.CLS();
		}
	}
}

