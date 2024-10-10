
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import org.bson.Document;


public class CRUD {
	private MongoDBClient mongoClient;
	
	// Declares a constructor to initialize the Mongo Client
	public CRUD(String animalDB) {
		this.mongoClient = new MongoDBClient(animalDB);
	}
	
	// Method to reset the collection for testing
	public void resetDogs() {
		MongoDatabase DB = MongoDBClient.getMongoDB(); // Obtains the database instance
		MongoCollection<Document> dogCollection = DB.getCollection("dogs"); // Gets the dog collection
		dogCollection.drop(); // Clears the dog collection
	}
	
	// Method to add a dog to the dog collection
	public void addDog(Dog dog) {
		MongoDatabase DB = MongoDBClient.getMongoDB();
		MongoCollection<Document> dogCollection = DB.getCollection("dogs");
		
		Map<String, Object> dogInfo = new HashMap<>(); //  Declares a hash map to store dog attributes
		
		dogInfo.put("name", dog.getName());
		dogInfo.put("breed", dog.getBreed());
		dogInfo.put("gender", dog.getGender());
		dogInfo.put("age", dog.getAge());
		dogInfo.put("weight", dog.getWeight());
		dogInfo.put("acquisitionDate", dog.getAcquisitionDate());
		dogInfo.put("acquisitionCountry", dog.getAcquisitionLocation());
		dogInfo.put("trainingStatus", dog.getTrainingStatus());
		dogInfo.put("reserved", dog.getReserved());
		dogInfo.put("inServiceCountry", dog.getInServiceLocation());
		
		Document document = new Document(dogInfo); // Creates a document containing dog information
		
		dogCollection.insertOne(document); //  Adds the document into the dog collection
	}
	
	// Method to check if the dog is in the collection already
	public Boolean dogWasFound(String name) {
		long dogsFound;
		MongoDatabase DB = MongoDBClient.getMongoDB();
		MongoCollection<Document> dogCollection = DB.getCollection("dogs");
		
		dogsFound = dogCollection.countDocuments(new Document("name", name)); // Counts the number of documents containing the name entered
		
		
		if(dogsFound > 0) { // If no document found containing that name return true
			return true;
		}
		else { // Otherwise returns false
			return false;
		}
	}
	
	// Method to reserve a dog 
	public boolean dogReservation(String inserviceLocation) {
		long dogMatchFound;
		Document dogMatchName;
		
		MongoDatabase DB = MongoDBClient.getMongoDB();
		MongoCollection<Document> dogCollection = DB.getCollection("dogs");
		
		Document document = new Document("inServiceCountry", inserviceLocation).append("reserved", false); // Finds the dogs that match in service country and not reserved i.e reserved = false
		
		// Counts the number of dogs matching the entered inservice country and not reserved
		dogMatchFound = dogCollection.countDocuments(new Document("inServiceCountry", inserviceLocation).append("reserved", false)); 
		
		
		if(dogMatchFound > 0) { // If there are any dogs matching this criteria
			dogMatchName = dogCollection.find(document).first(); // Get the first dog that matches
			dogCollection.updateOne(document, new Document("$set", new Document("reserved", true))); // Reserve the dog
			System.out.println("The dog named " + dogMatchName.getString("name") + "'s reservation is successful."); // Output the results
			return true;
		}
		else{
			System.out.println("No dogs matching this criteria are available for reservation");
			return false;
		}
	}
	
	// Method designed to print out each dog in the collection using insertion sort
	public void printDogs() {
		MongoDatabase DB = MongoDBClient.getMongoDB();
		MongoCollection<Document> dogCollection = DB.getCollection("dogs");
		
		List<Document> dogList = new ArrayList<>();
		
		for(Document document : dogCollection.find()) { // For each dog in the collection add that dog to the dogList
			dogList.add(document);
		}
		
		// Insertion sort
		for (int i = 1; i < dogList.size(); i++) {
			Document key = dogList.get(i); // Selects the document key for positioning
			int temp = i - 1; // Compares to the previous document
			
			// Moves the element in the dogList that is greater one position to the right, greater = later in the alphabet
			while (temp >= 0 && key.getString("name").compareTo(dogList.get(temp).getString("name")) < 0) {
				temp--;
			}
			
			
			dogList.remove(i); // Removes the key from its current position
			dogList.add(temp + 1, key); // Inserts the key again, but in its correct spot
		}
		
		// For each dog in the dogList, print its attibutes
		for(Document document : dogList) {
			System.out.println("Dog name: " + document.getString("name") + " --- Breed: " + document.getString("breed") + " --- Gender: " + document.getString("gender")
								+ " --- Age: " + document.getString("age") + " --- Weight: " + document.getString("weight") + " --- Acquisition Date: " + document.getString("acquisitionDate")
								+ " --- Acquisition Country: " + document.getString("acquisitionCountry") + " --- Training Status: " + document.getString("trainingStatus") 
								+ " --- Reservation Status: " + document.getBoolean("reserved") + " --- In-Service Country: " + document.getString("inServiceCountry"));
		}
	}
	
	// Method to clear the monkey collection for testing
	public void resetMonkeys() {
		MongoDatabase DB = MongoDBClient.getMongoDB();
		MongoCollection<Document> monkeyCollection = DB.getCollection("monkeys");
		
		monkeyCollection.drop(); // Clears the monkey collection
	}
	
	// Method to add a monkey
	public void addMonkey(Monkey monkey) {
		MongoDatabase DB = MongoDBClient.getMongoDB();
		MongoCollection<Document> monkeyCollection = DB.getCollection("monkeys");
		
		Map<String, Object> monkeyInfo = new HashMap<>(); // Declares a hashmap to store monkey attributes
		
		monkeyInfo.put("name", monkey.getName());
		monkeyInfo.put("species", monkey.getSpecies());
		monkeyInfo.put("gender", monkey.getGender());
		monkeyInfo.put("age", monkey.getAge());
		monkeyInfo.put("weight", monkey.getWeight());
		monkeyInfo.put("acquisitionDate", monkey.getAcquisitionDate());
		monkeyInfo.put("acquisitionCountry", monkey.getAcquisitionLocation());
		monkeyInfo.put("trainingStatus", monkey.getTrainingStatus());
		monkeyInfo.put("reserved", monkey.getReserved());
		monkeyInfo.put("inServiceCountry", monkey.getInServiceLocation());
		monkeyInfo.put("tailLength", monkey.getTailLength());
		monkeyInfo.put("height", monkey.getHeight());
		monkeyInfo.put("bodyLength", monkey.getBodyLength());
		
		Document document = new Document(monkeyInfo); // Creates a document storing the monkey information
		
		monkeyCollection.insertOne(document); // Inserts the document into the monkey collection
	}
	
	// Method to check if the monkeys name is already in the collection
	public Boolean monkeyWasFound(String name) {
		long monkeysFound;
		MongoDatabase DB = MongoDBClient.getMongoDB();
		MongoCollection<Document> monkeyCollection = DB.getCollection("monkeys");
		
		monkeysFound = monkeyCollection.countDocuments(new Document("name", name)); // Counts the number of documents with the entered name
		
		if(monkeysFound > 0) { // If any matches are found returns true
			return true;
		}
		else {
			return false;
		}
	}
	
	// Allows the user to reserve a monkey
	public boolean monkeyReservation(String inserviceLocation) {
		long monkeyMatchFound;
		Document monkeyMatchName;
		
		MongoDatabase DB = MongoDBClient.getMongoDB();
		MongoCollection<Document> monkeyCollection = DB.getCollection("monkeys");
		
		// Queries documents matching the inservice Country entered and not reserved
		Document document = new Document("inServiceCountry", inserviceLocation).append("reserved", false);
		
		monkeyMatchFound = monkeyCollection.countDocuments(new Document("inServiceCountry", inserviceLocation).append("reserved", false)); // Counts the number of occurrences
		
		if(monkeyMatchFound > 0) { // If any monkeys match the inservice country and not reserved
			monkeyMatchName = monkeyCollection.find(document).first(); // Finds the first monkey
			monkeyCollection.updateOne(document, new Document("$set", new Document("reserved", true))); // Reserves the monkey
			System.out.println("The monkey named " + monkeyMatchName.getString("name") + " reservation was successful."); // Ouputs the result
			return true;
		}
		else{
			System.out.println("No monkeys matching this criteria are available for reservation");
			return false;
		}
	}
	
	// Allows the user to print out a list of monkeys using insertion sort to alphabetize
	public void printMonkeys() {
		MongoDatabase DB = MongoDBClient.getMongoDB();
		MongoCollection<Document> monkeyCollection = DB.getCollection("monkeys");
		
		List<Document> monkeyList = new ArrayList<>();
		
		for(Document document : monkeyCollection.find()) { // Takes each document in the monkey collection
			monkeyList.add(document); // Adds them to the monkeyList
		}
		
		// Insertion sort to alphabetize the list
		for (int i = 1; i < monkeyList.size(); i++) {
			Document key = monkeyList.get(i); // Gets the current monkey document
			int temp = i - 1; // Compares this to the previous index
			
			// Moves the monkey that has a greater name one position to the right, effectively alphabetizing the list 
			while (temp >= 0 && key.getString("name").compareTo(monkeyList.get(temp).getString("name")) < 0) {
				temp--;
			}
			
			monkeyList.remove(i); // Removes the monkey from its current position
			monkeyList.add(temp + 1, key); // Adds that monkey back switching positions to its correct placement
		}
		
		// Prints each monkey out from the alphabetized list
		for(Document document : monkeyList) {
			System.out.println("Monkey name: " + document.getString("name") + " --- Species: " + document.getString("species") + " --- Gender: " + document.getString("gender")
								+ " --- Age: " + document.getString("age") + " --- Weight: " + document.getString("weight") + " --- Acquisition Date: " + document.getString("acquisitionDate")
								+ " --- Acquisition Country: " + document.getString("acquisitionCountry") + " --- Training Status: " + document.getString("trainingStatus") 
								+ " --- Reservation Status: " + document.getBoolean("reserved") + " --- In-Service Country: " + document.getString("inServiceCountry")
								+ " --- Tail Length: " + document.getString("tailLength") + " --- Height: " + document.getString("height") + " --- Body Length: " + document.getString("bodyLength"));
		}
	}
	
	// Prints a list of all the animals in service and not reserved
	public void printAnimals() {
		MongoDatabase DB = MongoDBClient.getMongoDB();
		MongoCollection<Document> availableAnimalCollection = DB.getCollection("availableAnimals");
		MongoCollection<Document> dogCollection = DB.getCollection("dogs");
		MongoCollection<Document> monkeyCollection = DB.getCollection("monkeys");
		
		availableAnimalCollection.deleteMany(new Document()); // Clears the list of available animals from prior testing 
		
		// For each dog in service AND not reserved i.e reserved = false, adds that document to availableAnimalCollection
		for(Document document : dogCollection.find(and(eq("trainingStatus", "in service"), eq("reserved", false)))){
			availableAnimalCollection.insertOne(document);
		}
		
		// For each monkey in service AND not reserved i.e reserved = false
		for(Document document : monkeyCollection.find(and(eq("trainingStatus", "in service"), eq("reserved", false)))){
			availableAnimalCollection.insertOne(document);
		}
		
		
		List<Document> availableAnimals = new ArrayList<>(); // Creates an arraylist for insertion sort
		
		// Adds each animals in service and reserved = false to arrayList
		for(Document document : availableAnimalCollection.find()) {
			availableAnimals.add(document);
		}
		
		// Insertion sort to alphabetize available animals 
		for(int i = 1; i < availableAnimals.size(); i++) {
			Document key = availableAnimals.get(i); // Gets the current animal key
			int temp = i - 1; // Compares to the previous element in the list
			
			// While the animal at keys name is greater than the animal at temp, meaning key comes later in the alphabet, swap them one position to the right
			while(temp >= 0 && key.getString("name").compareTo(availableAnimals.get(temp).getString("name")) < 0) {
				temp--;
			}
			availableAnimals.remove(i); // Remove the animal from its current position
			availableAnimals.add(temp + 1, key); // Swap it one place to the right and add it back
		}
		
		// Prints each animal in the list
		for(Document document : availableAnimals) {
			String animalType = document.containsKey("species") ? "Monkey" : "Dog"; // Determines the type of animal based on the attribute species
			
			System.out.println(animalType + " name: " + document.getString("name") + " --- Species: " + document.getString("species") + " --- Gender: " + document.getString("gender")
			+ " --- Age: " + document.getString("age") + " --- Weight: " + document.getString("weight") + " --- Acquisition Date: " + document.getString("acquisitionDate")
			+ " --- Acquisition Country: " + document.getString("acquisitionCountry") + " --- Training Status: " + document.getString("trainingStatus") 
			+ " --- Reservation Status: " + document.getBoolean("reserved") + " --- In-Service Country: " + document.getString("inServiceCountry"));
		}	
	}
	
	
}
