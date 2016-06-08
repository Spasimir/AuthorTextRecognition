import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*************************************************************
 * The class that reads the data from the files, removes the not needed
 * punctuation and loads the modified data to a container
 * 
 * @author Spasimir
 ***********************************************************/
public class PrepareDataFromFile {

	/************************************************************
	 * Reads the data from a file, modifies it and sills the container
	 * AuthorData
	 * 
	 * @param fileName
	 *            - file from which data will be read
	 * @param authorData
	 *            - container in which the data will be stored
	 * @throws FileNotFoundException
	 *             - if there is no such file, throws an exception which is
	 *             dealt with in the main class
	 ***********************************************************/
	public static void readDataFromFile(String fileName, AuthorData authorData) throws FileNotFoundException {
		File file = new File(fileName);
		try {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				String line = input.nextLine();
				line = modifyString(line);
				String[] tokens = line.split("\\s+");
				authorData.LoadData(tokens);
			}
		} catch (FileNotFoundException ex) {
			throw ex;
		}
	}

	/************************************************************
	 * Method that makes all words upper case and if there is a punctuation
	 * symbol replaces it with a single space
	 * 
	 * @param input - string of which we want to modify the data
	 * @return
	 ***********************************************************/
	private static String modifyString(String input) {
		StringBuilder builder = new StringBuilder();
		for (char c : input.toCharArray())
			if (Character.isLetterOrDigit(c)) {
				builder.append(Character.isUpperCase(c) ? c : Character.toUpperCase(c));
			} else {
				builder.append(" ");
			}
		return builder.toString();
	}

}