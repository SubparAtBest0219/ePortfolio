/*			Sources			     *
 * 								 *
 * https://www.geeksforgeeks.org *
 * /insertion-sort-algorithm/	 *
 * 								 *
 *********************************/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
	
    private static ArrayList<Dog> dogList = new ArrayList<Dog>(); // Creates an arraylist to store dogs
    
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>(); // Creates an arraylist to store monkeys
    
    // ArrayList for storing both types of available animals
    private static ArrayList<String> availableAnimalList = new ArrayList<String>();
    
    
    // Creates a species list for verification
    private static String[] speciesList = new String[] {"Capuchin","Guenon", "Macaque", "Marmoset", "Squirrel monkey", "Tamarin"};
   
    // Opens the scanner
    private static Scanner scnr = new Scanner(System.in);
    
    public static void main(String[] args) {   	
    	String command = "";
    	
        initializeDogList(); // Adds dogs to list
        
        initializeMonkeyList(); // Adds monkeys to list

        
       
        while (!command.equalsIgnoreCase("q")) {  // Loops while input is not q 
        	
        	displayMenu(); // Displays the menu
        	
        	command = scnr.nextLine(); // Accepts user input
        	
        	// Declares a switch statement executing based on input
        	switch (command) {
        	case "1":
        		System.out.println("You've selected intake a new dog.");
        		intakeNewDog(scnr); // Allows the addition of a dog to list through user input
        		break;
        		
        	case "2":
        		System.out.println("You've selected intake a new monkey.");
        		intakeNewMonkey(scnr); // Allows the addition of a monkey to list through user input
        		break;
        		
        	case "3":
        		System.out.println("You've selected to reserve an animal.");
        		reserveAnimal(scnr); // Allows the user to reserve an animal
        		break;
        		
        	case "4":
        		System.out.println("You've selected to print a list of all dogs.");
        		printAnimals(4); // Prints a list of dogs
        		break;
        		
        	case "5":
        		System.out.println("You've selected to print a list of all monkeys.");
        		printAnimals(5); // Prints a list of monkeys
        		break;
        		
        	case "6":
        		System.out.println("You've selected to print a list of all animals that are not reserved.");
        		printAnimals(6); // Prints a list of all animals not reserved
        		break;
        		
        	case "q":
        		System.out.println("You've selected quit.");
        		break;
        		
        	default:
        		System.out.println("Error: invalid input, valid choices include: '1' '2' '3' '4' '5' '6' and 'q' to quit.");
        		break;
        		
        	}
        	
        }
	}

    // This method prints the menu options.
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    // Adds dogs to dogList.
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "in service", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", true, "Canada");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", false, "United States");
        Dog dog4 = new Dog("Alex", "German Shepherd", "female", "2", "30", "09-30-2021", "China", "in service", false, "United States");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        dogList.add(dog4);
    }

    // Adds monkeys to monkeyList.
    public static void initializeMonkeyList() {
    	Monkey Monkey1 = new Monkey("Jerry", "Capuchin", "male", "5", "26.5", "06-14-2020", "Canada", "in service", false, "China", "16", "14", "8");
    	Monkey Monkey2 = new Monkey("Carlise", "Capuchin", "female", "8", "33.2", "06-18-2020", "China", "intake", false, "China", "15", "12", "7");
    	Monkey Monkey3 = new Monkey("JimBob", "Macaque", "male", "7", "22.5", "06-19-2021", "Africa", "in service", false, "Africa", "20", "18", "14");
    	Monkey Monkey4 = new Monkey("Aliza", "Macaque", "female", "6", "28.2", "04-26-2019", "Asia", "in service", false, "Africa", "16", "17", "18");
    	
    	monkeyList.add(Monkey1);
    	monkeyList.add(Monkey2);
    	monkeyList.add(Monkey3);
    	monkeyList.add(Monkey4);
    }
    
   
    public static void intakeNewDog(Scanner scanner) { // Allows the user to add a dog to list through input
    	try{
    		System.out.println();
    		System.out.println("What is the dog's name?");
    		String name = scanner.nextLine();
      
    		for(Dog dog: dogList) { // Checks list to ensure the name of dog being added is not already in database
    			if(dog.getName().equalsIgnoreCase(name)) {
    				System.out.println("\n\nThis dog is already in our system\n\n");
    				return; //returns to menu
    			}
    		}		
        			System.out.println("What's the dogs breed?");
        			String newBreed = scanner.nextLine(); // Allows the user to input breed                  
        
        			System.out.println("What's the dogs gender?");
        			String newGender = scanner.nextLine(); // Allows the user to input gender
        
        			System.out.println("What's the dogs age?");
        			String newAge = scanner.nextLine();  // Allows the user to input age               
        
        			System.out.println("What's the dogs weight?");
        			String newWeight = scanner.nextLine(); // Allows the user to input weight                  
        
        			System.out.println("What's the dogs acquisition date?");
        			String newaqcuisitionDate = scanner.nextLine();  // Allows the user to input date                
        
        			System.out.println("What's the dogs acquisition country ?");
        			String newaqcuisitionCountry = scanner.nextLine();  // Allows the user to input acquisition country                
        
        			System.out.println("What's the dogs training status?");
        			String newtrainingStatus = scanner.nextLine(); // Allows the user to input training status
                         
        			System.out.println("True or false is the dog reserved?");
        			Boolean newreservationStatus = scanner.nextBoolean(); // Allows the user to input reservation status
        			scanner.nextLine();
        
        			System.out.println("What's the dogs inservice country?");
        			String newinserviceCountry = scanner.nextLine(); // Allows the user to input in-service country
                    
        			// Instantiates the new dog
        			Dog newDog = new Dog (name, newBreed, newGender, newAge, newWeight, newaqcuisitionDate,newaqcuisitionCountry, 
        					  newtrainingStatus, newreservationStatus,newinserviceCountry); 
        
        			dogList.add(newDog); // Adds the dog to the dog list
        			
        			System.out.println("The dogs entry was successful, the list has been updated."); 
        			
    			} catch (Exception e) {
    				System.out.println("An error has occurred whjile adding the dog....");
    		}
    	}
    	
       // Allows the user to add a monkey to the monkey list 
        public static void intakeNewMonkey(Scanner scanner) {
        	try {
        		System.out.println();
        		System.out.println("What is the monkey's name?");
        		String name = scanner.nextLine(); // Allows the user to enter the monkeys name
        		
        		// For each monkey in the list, checks the name and ensures it isnt already in the database
        		for(Monkey monkey: monkeyList) {
        			if(monkey.getName().equalsIgnoreCase(name)) {
        				System.out.println("\n\nThis monkey is already in our system\n\n");
        				return; //returns to menu
        			}
        		}
                    	System.out.println("What is the monkeys species?");
                    	String newSpecies = scanner.nextLine(); // Allows the user to enter a species
                    	
                    	// Checks if entered species is valid through speciesList comparison
                    	int counter = 0;
                    		for (int i = 0; i < speciesList.length; i++) {
                    			if(newSpecies.equalsIgnoreCase(speciesList[i])) {
                    				counter++;
                    			}
                    			else {
                    				continue;
                    			}
                    		}
                    		
                    		// If it isnt a valid species, outputs an error message
                    		if (counter < 1) {
                    			System.out.println("Error: invalid species entry. Valid choices include: " + Arrays.toString(speciesList));
                    			return;
                    		}
                                                                                                    			                                                                                                               
                    		System.out.println("What's the monkeys gender?");
                    		String newGender = scanner.nextLine(); // Allows the user to enter the monkeys name
                    
                    		System.out.println("What's the monkeys age?");
                    		String newAge = scanner.nextLine();   // Allows the user to enter the monkeys age           
                    
                    		System.out.println("What's the monkeys weight?");
                    		String newWeight = scanner.nextLine();  // Allows the user to enter the monkeys weight                  
                    
                    		System.out.println("What's the monkeys acquisition date?");
                    		String newacquisitionDate = scanner.nextLine(); // Allows the user to enter the monkeys acquisition date               
                    
                    		System.out.println("What's the monkeys acquisition country ?");
                    		String newacquisitionCountry = scanner.nextLine();  // Allows the user to enter the monkeys acquisition country                
                    
                    		System.out.println("What's the monkeys training status?");
                    		String newtrainingStatus = scanner.nextLine(); // Allows the user to enter the monkeys training status
                                     
                    		System.out.println("True or false is the monkey reserved?");
                    		Boolean newreservationStatus = scanner.nextBoolean(); // Allows the user to enter the monkeys reservation status
                    		scanner.nextLine();
                    
                    		System.out.println("What's the monkeys inservice country?");
                    		String newinserviceCountry = scanner.nextLine(); // Allows the user to enter the monkeys in-service country
                                      
                    		System.out.println("What's the monkeys tail length?");
                    		String newtailLength = scanner.nextLine(); // Allows the user to enter the monkeys tail length
                                      
                    		System.out.println("What's the monkeys height?");
                    		String newHeight = scanner.nextLine(); // Allows the user to enter the monkeys height
                                      
                    		System.out.println("What's the monkeys body length?");
                    		String newbodyLength = scanner.nextLine(); // Allows the user to enter the monkeys body length
                            
                    		// Instantiates the monkey based on user input
                    		Monkey newMonkey = new Monkey (name, newSpecies, newGender, newAge, newWeight, newacquisitionDate, 
                    							   newacquisitionCountry, newtrainingStatus, newreservationStatus,
                    							   newinserviceCountry, newtailLength, newHeight, newbodyLength);
                    
                    		monkeyList.add(newMonkey); // Adds the monkey to the monkey list
                    		System.out.println("The monkeys entry was successful, the list has been updated.");  
                    		
        				} catch (Exception e){
        					System.out.println("An error has occurred while adding the monkey....");
        			}
        		}	
                   
        // Allows the user to reserve an animal
        public static void reserveAnimal(Scanner scanner) {
        	try {
        		boolean continueLoop = true; // Boolean used to continue or exit loop
        		boolean found = false; // Boolean used in validating an animal found
        		
        		System.out.println();
        		System.out.println("What type of animal would you like to reserve?");
        		String reserveType = scanner.nextLine(); // Allows the user to input the type of animal to reserve
        		
        		System.out.println("What's the in service country of the animal?");
        		String inserviceLocation = scanner.nextLine(); // Allows the user to input the in-service country of the animal to reserve
        		
        		if (reserveType.equalsIgnoreCase("Monkey")) {  // If it was a monkey                  		
        			for(Monkey monkey: monkeyList) { // For each monkey in the list
        				
        					// If the monkey matches entered criteria and not reserved
        					if (monkey.getInServiceLocation().equalsIgnoreCase(inserviceLocation) && monkey.getReserved() == false) {        			       
        						System.out.println("The monkey you've selected to reserve is named " + monkey.getName() + ".");
        						monkey.setReserved(true); // Reserves the monkey
        						found = true;
        						break;
        					}
        					else if (continueLoop == true) { // Otherwise continues checking monkeys in the list
        						continue;
        						}
        					}
        			      		
        			if (found == false) { // If no monkey found, outputs a message
        				System.out.println("Error: no monkeys available for reservation matching the in service country provided.");        		
        					}
        			return; //returns to menu
        				}
        	
        		else if (reserveType.equalsIgnoreCase("Dog")) {    // If user entered dog               		
        			for(Dog dog: dogList) { // For each dog in the list
        				
        					// If the dog matches entered criteria and not reserved
        					if (dog.getInServiceLocation().equalsIgnoreCase(inserviceLocation) && dog.getReserved() == false) {        			       
        						System.out.println("The dog you've selected to reserve is named " + dog.getName() + ".");
        						dog.setReserved(true); // Reserves the dog
        						found = true;
        						break;
        						}
        					
        					else if (continueLoop == true) { // Otherwise continues looping through dog list
        						continue;
        						}
        					}
        			
        			if (found == false) { // If no dog found, outputs a message
        				System.out.println("Error: no dogs available for reservation matching the in service country provided.");        		
        				}
        			return; //returns to menu
        			}
        		
        		else {
        			System.out.println("Error: please enter a valid name and in service country.");
        			}
        		
        		} catch (Exception e) {
        			System.out.println("An error has occurred while reserving the animal....");
        		}
        	}
        
        // Defines a method of sorting dogs alphabetically using insertion sort
        public static void insertionSortDoglist(ArrayList<Dog> dogList) {
        	for (int i = 1; i < dogList.size(); ++i) { // Begins iterating over list starting at second position
        		
        		Dog key = dogList.get(i); // Set key to dog at current position in list
        		
        		int temp = i - 1; // Sets temp to the dog at the position before key
        		
        		
        		// While there's dogs to compare and current dogs name > keys name
        		while (temp >= 0 && dogList.get(temp).getName().compareTo(key.getName()) > 0) { 
        			
        			dogList.set(temp + 1, dogList.get(temp)); // Shifts the dog at temp position to the right
        			
        			temp--; // Decrementing ensures I still check the previous dog
        		}
        		
        		dogList.set(temp + 1, key); // Sets the current dog at key position to temp + 1, effectively swapping them
        	}
        }
        
        
     // Defines a method of sorting monkeys alphabetically using insertion sort
        public static void insertionSortMonkeylist(ArrayList<Monkey> monkeyList) {
        	for (int i = 1; i < monkeyList.size(); ++i) { // Begins iterating over list starting at second position
        		
        		Monkey key = monkeyList.get(i); // Set key to monkey at current position in list
        		
        		int temp = i - 1; // Sets temp to the monkey at the position before key
        		
        		
        		// While there's monkeys to compare and current monkeys name > keys name
        		while (temp >= 0 && monkeyList.get(temp).getName().compareTo(key.getName()) > 0) { 
        			
        			monkeyList.set(temp + 1, monkeyList.get(temp)); // Shifts the monkey at temp position to the right
        			
        			temp--; // Decrementing ensures I still check the previous monkey
        		}
        		
        		monkeyList.set(temp + 1, key); // Sets the current monkey at key position to temp + 1, effectively swapping them
        	}
        }
        
        // Defines a method of sorting available animals alphabetically using insertion sort
        public static void insertionSortAvailableAnimals(ArrayList<String> availableAnimalList) {
        	for (int i = 1; i < availableAnimalList.size(); ++i) { // Begins iterating over list starting at second position
        		
        		String key = availableAnimalList.get(i); // Set key to available animal at current position in list
        		
        		int temp = i - 1; // Sets temp to the available animal at the position before key
        		
        		
        		// While there's available animals to compare and current available animals name > keys name
        		while (temp >= 0 && availableAnimalList.get(temp).compareTo(key) > 0) { 
        			
        			availableAnimalList.set(temp + 1, availableAnimalList.get(temp)); // Shifts the available animal at temp position to the right
        			
        			temp--; // Decrementing ensures I still check the previous available animal
        		}
        		
        		availableAnimalList.set(temp + 1, key); // Sets the current available animal at key position to temp + 1, effectively swapping them
        	}
        }
        
        

        // Generic print animals method based on user selection
        public static void printAnimals(int x) {
        if (x == 4) { // If input is 4 
        	System.out.println();
        	System.out.println("List of dogs:");
        	
        	insertionSortDoglist(dogList); // Sorts dog list
        	
        	// Prints each dog
        	for (Dog dog :dogList) {
        			System.out.println(dog.getName() + ", " + dog.getTrainingStatus() + ", " + dog.getAcquisitionLocation() + ", " + dog.getReserved());
        			}
        }
        
        else if (x == 5) { // If input is 5
        	System.out.println();
        	System.out.println("List of monkeys:");
        	
        	insertionSortMonkeylist(monkeyList); // Sorts monkey list
        	
        	// Prints each monkey
        	for (Monkey monkey: monkeyList) {
    			System.out.println(monkey.getName() + ", " + monkey.getTrainingStatus() + ", " + monkey.getAcquisitionLocation() + ", " + monkey.getReserved());
    			
        	}
        }
        
        else { // Default can only be 6 to print available animals
        	System.out.println();
        	System.out.println("Available animals:");
        	
        	// Add each dog in dog list not reserved and in service to available animals list
        	for (Dog dog :dogList) {
        		if (dog.getTrainingStatus().equalsIgnoreCase("In Service") && dog.getReserved() == false){        			
        			availableAnimalList.add(dog.getName() + ", " + dog.getTrainingStatus() + ", " + dog.getAcquisitionLocation() + ", " + dog.getReserved());        			
        			
        			}
        		}
        	
        	// Add each monkey in monkey list not reserved and in service to available animals list
         	for (Monkey monkey: monkeyList) {
        		if (monkey.getTrainingStatus().equalsIgnoreCase("In Service") && monkey.getReserved() == false){
        			availableAnimalList.add(monkey.getName() + ", " + monkey.getTrainingStatus() + ", " + monkey.getAcquisitionLocation() + ", " + monkey.getReserved());        			
        			
        			}
        		}
         	
         	insertionSortAvailableAnimals(availableAnimalList); // Sort the entire available animal list alphabetically
         	
         	for (String animal: availableAnimalList) { // Print each animal in available animal list
         		System.out.println(animal);
         		}
        	}
        }

	}


