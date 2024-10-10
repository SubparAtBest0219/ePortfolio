package clock;

/******************************************************
 *						Sources							*
 *														*
 * Date time and formatter								*
 * https://docs.oracle.com/javase/8/docs/api			*
 * /java/time/format/DateTimeFormatter.html				*
 *  													
 * 
 * */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class main {
	static int userInput;
	static boolean endProgram = false;
	private static Scanner scnr = new Scanner(System.in);
	
	
	private static void displayTime() {
		LocalDateTime today = LocalDateTime.now(); // Utilized to pull standard 12 hour time
		int hour = today.getHour();
		int minute = today.getMinute();
		int second = today.getSecond();
		
		
		
	}
	
	private static void displayMenu() {
		System.out.println("Menu Options: ");
		System.out.println("1: Add one hour");
		System.out.println("2. Add one minute");
		System.out.println("3. Add one second");
		System.out.println("4. Exit program");
		
	}
	
	private static void addHour() {
		
	}
	
	private static void addMinute() {
		
	}
	
	private static void addSecond() {
		
	}
	
	private static void terminate() {
		System.out.println("Teminating the program... Goodbye!");
		endProgram = true;
		
	}
	
	private static void menuInput(int choice) {
		switch(choice) {
		case 1:
			addHour();
			break;
		case 2:
			addMinute();
			break;
		case 3:
			addSecond();
			break;
		case 4:
			terminate();
			break;
		default:
			System.out.println("Invalid user input");
			break;
		}
	}
	
	
	public static void main(String[] args) {
		while (!endProgram) {
		clearScreen.CLS();
		displayTime();
		displayMenu();
		userInput = scnr.nextInt();
		menuInput(userInput);
		System.out.flush();
		
		
		
		}

	}

}
