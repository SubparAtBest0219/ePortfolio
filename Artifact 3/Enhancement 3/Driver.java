 /**********************Sources**********************\
 * 		     										 *
 * Insertion sort:								 	 *
 * https://www.geeksforgeeks.org 					 *
 * /insertion-sort-algorithm/	 					 *
 * 													 *
 * Mongo DB creation:								 *
 * https://stackoverflow.com/						 *
 * questions/45285368/								 *
 * how-can-i-create-mongodb-database-from-java		 *
 * 
 * Mongo Filters:
 * https://www.mongodb.com/docs/drivers/java
 * /sync/v5.2/fundamentals/builders/filters/
 * 
 * Hash Map:
 * https://www.w3schools.com/java/java_hashmap.asp
 * 
 * Mongo Driver and collections
 * https://www.mongodb.com/docs/drivers/java
 * /sync/v5.2/fundamentals/databases-collections/
 * 
 * Document counting
 * https://www.mongodb.com/docs/manual
 * /reference/method/db.collection.countDocuments/	
 * 
 * Ternary operator
 * https://www.geeksforgeeks.org
 * /java-ternary-operator-with-examples/								 *
 \***************************************************/


//import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
	
	private static CRUD crud;
       
    // Creates a species list for verification
    private static String[] speciesList = new String[] {"Capuchin","Guenon", "Macaque", "Marmoset", "Squirrel monkey", "Tamarin"};
   
    // Opens the scanner
    private static Scanner scnr = new Scanner(System.in);
    
    public static void main(String[] args) {   	
    	String command = "";
    	String animalDB = "animalDatabase";
    	crud = new CRUD(animalDB);
    	
        initializeDogDB(); // Adds dogs to database
        
        initializeMonkeyDB(); // Adds monkeys to database

        
       
        while (!command.equalsIgnoreCase("q")) {  // Loops while input is not q 
        	
        	displayMenu(); // Displays the menu
        	
        	command = scnr.nextLine(); // Accepts user input
        	
        	// Declares a switch statement executing based on input
        	switch (command) {
        	case "1":
        		System.out.println("You've selected intake a new dog.");
        		System.out.println();
        		intakeNewDog(scnr); // Allows the addition of a dog to DB through user input
        		break;
        		
        	case "2":
        		System.out.println("You've selected intake a new monkey.");
        		System.out.println();
        		intakeNewMonkey(scnr); // Allows the addition of a monkey to DB through user input
        		break;
        		
        	case "3":
        		System.out.println("You've selected to reserve an animal.");
        		System.out.println();
        		reserveAnimal(scnr); // Allows the user to reserve an animal
        		break;
        		
        	case "4":
        		System.out.println("You've selected to print a list of all dogs.");
        		System.out.println();
        		crud.printDogs(); // Prints a list of dogs
        		break;
        		
        	case "5":
        		System.out.println("You've selected to print a list of all monkeys.");
        		System.out.println();
        		crud.printMonkeys(); // Prints a list of monkeys
        		break;
        		
        	case "6":
        		System.out.println("You've selected to print a list of all animals that are not reserved.");
        		System.out.println(); 
        		crud.printAnimals(); // Prints a list of all animals not reserved
        		break;
        		
        	case "q":
        		System.out.println("You've selected quit... Goodbye!");
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

    // Adds dogs to dog collection.
    public static void initializeDogDB() {
    	crud.resetDogs();
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "in service", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", true, "Canada");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", false, "United States");
        Dog dog4 = new Dog("Alex", "German Shepherd", "female", "2", "30", "09-30-2021", "China", "in service", false, "United States");

        crud.addDog(dog1);
        crud.addDog(dog2);
        crud.addDog(dog3);
        crud.addDog(dog4);
    }

    // Adds monkeys to monkey collection.
    public static void initializeMonkeyDB() {
    	crud.resetMonkeys();
    	Monkey Monkey1 = new Monkey("Jerry", "Capuchin", "male", "5", "26.5", "06-14-2020", "Canada", "in service", false, "China", "16", "14", "8");
    	Monkey Monkey2 = new Monkey("Carlise", "Capuchin", "female", "8", "33.2", "06-18-2020", "China", "intake", false, "China", "15", "12", "7");
    	Monkey Monkey3 = new Monkey("JimBob", "Macaque", "male", "7", "22.5", "06-19-2021", "Africa", "in service", false, "Africa", "20", "18", "14");
    	Monkey Monkey4 = new Monkey("Aliza", "Macaque", "female", "6", "28.2", "04-26-2019", "Asia", "in service", true, "Africa", "16", "17", "18");
    	
    	crud.addMonkey(Monkey1);
    	crud.addMonkey(Monkey2);
    	crud.addMonkey(Monkey3);
    	crud.addMonkey(Monkey4);
    }
    
   
    public static void intakeNewDog(Scanner scanner) { // Allows the user to add a dog to collection through input
    	try{
    		System.out.println();
    		System.out.println("What is the dog's name?");
    		String name = scanner.nextLine();
      
    		 // Checks if true by default
    			if(crud.dogWasFound(name)) {
    				System.out.println("\n\nThis dog is already in our system\n\n");
    				return; //returns to menu
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
        
        		crud.addDog(newDog); // Adds the dog to the dog collection
        			
        		System.out.println("The dog named " + name + "'s entry was successful, the DB has been updated."); 
        			
    		} catch (Exception e) {
    			System.out.println("An error has occurred while adding the dog....");
    	}
    }
    	
       // Allows the user to add a monkey to the monkey collection
        public static void intakeNewMonkey(Scanner scanner) {
        	try {
        		System.out.println();
        		System.out.println("What is the monkey's name?");
        		String name = scanner.nextLine(); // Allows the user to enter the monkeys name
        		
        		
        		
        		// Checks if true by default
    			if(crud.monkeyWasFound(name)) {
    				System.out.println("\n\nThis dog is already in our system\n\n");
    				return; //returns to menu
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
                    		
                    	// If it isn't a valid species, outputs an error message
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
                    
                    	crud.addMonkey(newMonkey); // Adds the monkey to the monkey collection
                    	System.out.println("The monkey named " + name + "'s entry was successful, the DB has been updated.");  
                    		
        			} catch (Exception e){
        				System.out.println("An error has occurred while adding the monkey....");
        		}
        	}	
                   
        // Allows the user to reserve an animal
        public static void reserveAnimal(Scanner scanner) {
        	try {	
        		System.out.println();
        		System.out.println("What type of animal would you like to reserve?");
        		String reserveType = scanner.nextLine(); // Allows the user to input the type of animal to reserve
        		
        		System.out.println("What's the in service country of the animal?");
        		String inserviceLocation = scanner.nextLine(); // Allows the user to input the in-service country of the animal to reserve
        		
        		if (reserveType.equalsIgnoreCase("Monkey")) {  // If it was a monkey    
        			
        				// If the monkey matches entered criteria and not reserved  inservicelocation matches and not reserved i.e reserved = false
        				if (crud.monkeyReservation(inserviceLocation)) {        			       
        					System.out.println("The monkey has been reserved");
        					//break;
        				}
        				else {
        					System.out.println("No monkey available for reservation matching the criteria entered....");
        				}
        			return; //returns to menu
        		}
        	
        		else if (reserveType.equalsIgnoreCase("Dog")) {    // If user entered dog               		
        			       				
        					// If the dog matches entered criteria and not reserved
        					if (crud.dogReservation(inserviceLocation)) {        			       
        						System.out.println("The dog has been reserved.");
        						
        						//break;
        						}
        					else {
        						System.out.println("No dog available for reservation matching the criteria entered....");
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
	}


