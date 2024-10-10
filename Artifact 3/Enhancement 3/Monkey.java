// The pre-recorded 5-4 milestone video located in our classes announcement page assisted in the completion of this class. 

public class Monkey extends RescueAnimal {
	// Instance variables
	private String tailLength;
	private String height;
	private String bodyLength;
	private String species;
	
	// Parameterized constructor that includes arguments for the requested monkey specific attributes.
	// The term parameterized constructor came from https://beginnersbook.com/2014/01/parameterized-constructor-in-java-example/
	public Monkey(String name, String species, String gender, String age,
		    String weight, String acquisitionDate, String acquisitionCountry,
			String trainingStatus, boolean reserved, String inServiceCountry, 
			String tailLength, String height, String bodyLength)
	{
		setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
	}
	// Mutator and accessor methods for the newly requested monkey specific attributes.
	public void setTailLength(String TailLength) {
		tailLength = TailLength;
	}
	
	public String getTailLength() {
		return tailLength;
	} 
	
	public void setHeight(String Height) {
		height = Height;
	}

	public String getHeight() {
		return height;
	}
	
	public void setBodyLength(String Bodylength) {
		bodyLength = Bodylength;
	}
	
	public String getBodyLength() {
		return bodyLength;
	}
	
	public void setSpecies(String Species) {
		species = Species;
	}
	
	public String getSpecies() {
		return species;
	}
	
}
