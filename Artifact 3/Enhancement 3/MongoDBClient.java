

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBClient {
private MongoClient mongoClient; // Declares MongoDB client
private static MongoDatabase animalDataBase; // Declares a db instance for my animal database

// Constructor to initialize my client with my animal database
public  MongoDBClient(String animalDB){
	mongoClient = MongoClients.create("mongodb://localhost:27017"); // Connects to my local MongoDB server at default port
	animalDataBase = mongoClient.getDatabase(animalDB); // Gets my animal database from the server
	}

// Getter method allows me to access the database from outside the client file
public static MongoDatabase getMongoDB() {
	return animalDataBase;
}

// Allows me to close the connection with the client when I'm done
public void close() {
	mongoClient.close();
	}

}
