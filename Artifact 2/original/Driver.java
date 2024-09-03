import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
	// I've created the requested monkey array list using the dog array list as an example.
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    
    // I've added a species array for validation purposes.
    private static String[] speciesList = new String[] {"Capuchin","Guenon", "Macaque", "Marmoset", "Squirrel monkey", "Tamarin"};
   
    // I've added the scanner instance variable.
    private static Scanner scnr = new Scanner(System.in);
    
    public static void main(String[] args) {   	
    	String command = "";
    	
        initializeDogList();
        initializeMonkeyList();

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
        // For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
        // Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.
        
       
        /* I've created a menu loop that calls the display menu method, prompts the user for input, calls the desired method based on input, 
           and exits the loop should the user input q. */
    	// The pre-recorded 5-4 milestone video located in our classes announcement page assisted in the completion of this step. 
        while (!command.equalsIgnoreCase("q")) {  
        	displayMenu();
        	command = scnr.nextLine();        	
        	if (command.equals("1")) {
        		System.out.println("You've selected intake a new dog.");
        		intakeNewDog(scnr);
        	}
        	else if (command.equals("2")) {
        		System.out.println("You've selected intake a new monkey.");
        		intakeNewMonkey(scnr);
        	}
        	else if (command.equals("3")) {
        		System.out.println("You've selected to reserve an animal.");
        		reserveAnimal(scnr);
        	}
        	else if (command.equals("4")) {
        		System.out.println("You've selected to print a list of all dogs.");
        		printAnimals(4);
        	}
        	else if (command.equals("5")) {
        		System.out.println("You've selected to print a list of all monkeys.");
        		printAnimals(5);
        	}
        	else if (command.equals("6")) {
        		System.out.println("You've selected to print a list of all animals that are not reserved.");
        		printAnimals(6);
        	}
        	else if (command.equals("q")) {
        		System.out.println("You've selected quit.");
        		break;
        	}
        	else {
        		System.out.println("Error: invalid input, valid choices include: '1' '2' '3' '4' '5' '6' and 'q' to quit.");
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

    // Adds dogs to a list for testing.
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "in service", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", true, "Canada");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", false, "United States");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    // Adds monkeys to a list for testing.
    public static void initializeMonkeyList() {
    	Monkey Monkey1 = new Monkey("Jerry", "Capuchin", "male", "5", "26.5", "06-14-2020", "Canada", "in service", false, "China", "16", "14", "8");
    	Monkey Monkey2 = new Monkey("Carlise", "Capuchin", "female", "8", "33.2", "06-18-2020", "China", "intake", false, "China", "15", "12", "7");
    	Monkey Monkey3 = new Monkey("JimBob", "Macaque", "male", "7", "22.5", "06-19-2021", "Africa", "in service", false, "Africa", "20", "18", "14");
   
    	monkeyList.add(Monkey1);
    	monkeyList.add(Monkey2);
    	monkeyList.add(Monkey3);
    }
    
    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    
    /* When this method is called, the user is asked to input the dogs name, it then validates that input by checking 
       to see if that name is already inside the array list, if it's not then the user is asked to input the rest of 
       the information Grazioso Salvare requires, then adds that dog to the dog array list. */
    // The pre-recorded 5-4 milestone video also assisted in the completion of this step, because its mirrored after the intakenewMonkey method. 
    public static void intakeNewDog(Scanner scanner) {
    	System.out.println();
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }		
        		System.out.println("What's the dogs breed?");
        		String newBreed = scanner.nextLine();                   
        
        		System.out.println("What's the dogs gender?");
        		String newGender = scanner.nextLine();
        
        		System.out.println("What's the dogs age?");
        		String newAge = scanner.nextLine();                 
        
        		System.out.println("What's the dogs weight?");
        		String newWeight = scanner.nextLine();                    
        
        		System.out.println("What's the dogs acquisition date?");
        		String newaqcuisitionDate = scanner.nextLine();                  
        
        		System.out.println("What's the dogs acquisition country ?");
        		String newaqcuisitionCountry = scanner.nextLine();                  
        
        		System.out.println("What's the dogs training status?");
        		String newtrainingStatus = scanner.nextLine();
                         
        		System.out.println("True or false is the dog reserved?");
        		Boolean newreservationStatus = scanner.nextBoolean();
        		scanner.nextLine();
        
        		System.out.println("What's the dogs inservice country?");
        		String newinserviceCountry = scanner.nextLine();
                                                    
        Dog newDog = new Dog (name, newBreed, newGender, newAge, newWeight, newaqcuisitionDate,newaqcuisitionCountry, 
        					  newtrainingStatus, newreservationStatus,newinserviceCountry); 
        
        dogList.add(newDog);
        System.out.println("The dogs entry was successful, the list has been updated.");    
    }
    	
        // Complete intakeNewMonkey method 
		// Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
		// to make sure the monkey doesn't already exist and the species type is allowed
        	
    	/* Once the method is called, it prompts the user to enter the monkeys name, then checks the array list to see if it's there already,
    	   if it's not then it prompts the user to enter the rest of the information Grazioso Salvare requires,
    	   then adds that monkey to the monkey array list. */
    	// The pre-recorded 5-4 milestone video also assisted in the completion of this step. 
        public static void intakeNewMonkey(Scanner scanner) {
        	System.out.println();
        	System.out.println("What is the monkey's name?");
            String name = scanner.nextLine();
            for(Monkey monkey: monkeyList) {
                if(monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis monkey is already in our system\n\n");
                    return; //returns to menu
                }
            }
            		/* Species input validation that compares input to the array of valid species types I created.
            		   The idea to utilize the arrays utility class to print each element within an array comes from 
            		   https://www.java67.com/2014/03/how-to-print-array-in-java-example-tutorial.html#:~:text=You%20cannot%20print%20array%20elements,print%20a%20two%2Ddimensional%20array. */
                    System.out.println("What is the monkeys species?");
                    String newSpecies = scanner.nextLine();                                     
                    int counter = 0;
                    	for (int i = 0; i < speciesList.length; i++) {
                    		if(newSpecies.equalsIgnoreCase(speciesList[i])) {
                    			counter++;
                    		}
                    		else {
                    			continue;
                    		}
                    	}
                    if (counter < 1) {
                       	System.out.println("Error: invalid species entry. Valid choices include: " + Arrays.toString(speciesList));
                       	return;
                       }
                                                                                                    			                                                                                                               
                    System.out.println("What's the monkeys gender?");
                    String newGender = scanner.nextLine();
                    
                    System.out.println("What's the monkeys age?");
                    String newAge = scanner.nextLine();                 
                    
                    System.out.println("What's the monkeys weight?");
                    String newWeight = scanner.nextLine();                    
                    
                    System.out.println("What's the monkeys acquisition date?");
                    String newacquisitionDate = scanner.nextLine();                  
                    
                    System.out.println("What's the monkeys acquisition country ?");
                    String newacquisitionCountry = scanner.nextLine();                  
                    
                    System.out.println("What's the monkeys training status?");
                    String newtrainingStatus = scanner.nextLine();
                                     
                    System.out.println("True or false is the monkey reserved?");
                    Boolean newreservationStatus = scanner.nextBoolean();
                    scanner.nextLine();
                    
                    System.out.println("What's the monkeys inservice country?");
                    String newinserviceCountry = scanner.nextLine();
                                      
                    System.out.println("What's the monkeys tail length?");
                    String newtailLength = scanner.nextLine();
                                      
                    System.out.println("What's the monkeys height?");
                    String newHeight = scanner.nextLine();
                                      
                    System.out.println("What's the monkeys body length?");
                    String newbodyLength = scanner.nextLine();
                                                       
                    Monkey newMonkey = new Monkey (name, newSpecies, newGender, newAge, newWeight, newacquisitionDate, 
                    							   newacquisitionCountry, newtrainingStatus, newreservationStatus,
                    							   newinserviceCountry, newtailLength, newHeight, newbodyLength);
                    
                    monkeyList.add(newMonkey);
                    System.out.println("The monkeys entry was successful, the list has been updated.");                                          
            }	
                   
        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        
        // The module 7 video located in our class announcements page assisted in the completion of this step. 
        
        /* Allows the user to search for an animal by type and in service country,
           and updates the reserve status of an eligible animal if found, 
           in other words if that animal's type and in service country 
           matches what was entered and is not reserved already. */
        public static void reserveAnimal(Scanner scanner) {
        	boolean continueLoop = true;
        	boolean found = false;
        	System.out.println();
        	System.out.println("What type of animal would you like to reserve?");
        	String reserveType = scanner.nextLine();
        	System.out.println("What's the in service country of the animal?");
        	String inserviceLocation = scanner.nextLine();
        	if (reserveType.equalsIgnoreCase("Monkey")) {                    		
        		for(Monkey monkey: monkeyList) {
        				if (monkey.getInServiceLocation().equalsIgnoreCase(inserviceLocation) && monkey.getReserved() == false) {        			       
        					System.out.println("The monkey you've selected to reserve is named " + monkey.getName() + ".");
        					monkey.setReserved(true);
        					found = true;
        					break;
        				}
        				else if (continueLoop == true) {
        					continue;
        					}
        				}
        		if (found == false) {
        			System.out.println("Error: no monkeys available for reservation matching the in service country provided.");        		
        				}
        		return; //returns to menu
        			}
        	
        	else if (reserveType.equalsIgnoreCase("Dog")) {                    		
        		for(Dog dog: dogList) {
        				if (dog.getInServiceLocation().equalsIgnoreCase(inserviceLocation) && dog.getReserved() == false) {        			       
        					System.out.println("The dog you've selected to reserve is named " + dog.getName() + ".");
        					dog.setReserved(true);
        					found = true;
        					break;
        						}
        				else if (continueLoop == true) {
        					continue;
        					}
        				}
        		if (found == false) {
        			System.out.println("Error: no dogs available for reservation matching the in service country provided.");        		
        			}
        		return; //returns to menu
        		}
        	else {
        		System.out.println("Error: please enter a valid name and in service country.");
        	}
        }
        

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
        // Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
        // Remember that you only have to fully implement ONE of these lists. 
        // The other lists can have a print statement saying "This option needs to be implemented".
        // To score "exemplary" you must correctly implement the "available" list.
       
        /* The module 7 video located in our announcements page assisted in the completion of this step
           by explaining we should be passing a parameter from our menu to this method to output the desired information.*/
        
        /* When the method is called and the parameter is passed from the menu a branch initiates printing the requested list of animals. 
           I've implemented all three conditions, I understand only one was required. */
        public static void printAnimals(int x) {
        if (x == 4) {
        	System.out.println();
        	System.out.println("List of dogs:");
        	for (Dog dog :dogList) {
        			System.out.println(dog.getName() + ", " + dog.getTrainingStatus() + ", " + dog.getAcquisitionLocation() + ", " + dog.getReserved());
        			
        	}
        }
        else if (x == 5) {
        	System.out.println();
        	System.out.println("List of monkeys:");
        	for (Monkey monkey: monkeyList) {
    			System.out.println(monkey.getName() + ", " + monkey.getTrainingStatus() + ", " + monkey.getAcquisitionLocation() + ", " + monkey.getReserved());
    			
        	}
        }
        else {
        	System.out.println();
        	System.out.println("Available animals:");
        	for (Dog dog :dogList) {
        		if (dog.getTrainingStatus().equalsIgnoreCase("In Service") && dog.getReserved() == false){        			
        			System.out.println(dog.getName() + ", " + dog.getTrainingStatus() + ", " + dog.getAcquisitionLocation() + ", " + dog.getReserved());        			
        			
        			}
        		}
         	for (Monkey monkey: monkeyList) {
        		if (monkey.getTrainingStatus().equalsIgnoreCase("In Service") && monkey.getReserved() == false){
        			System.out.println(monkey.getName() + ", " + monkey.getTrainingStatus() + ", " + monkey.getAcquisitionLocation() + ", " + monkey.getReserved());        			
        			
        			}
        		}      	
        	}
        }

	}


