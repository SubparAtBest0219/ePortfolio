package clock;
import java.io.IOException;

public class clearScreen {

	public static void CLS() {
		//Clears Screen in java
		try {
		    if (System.getProperty("os.name").contains("Windows"))
		        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		    else
		        Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {}
	}
}


