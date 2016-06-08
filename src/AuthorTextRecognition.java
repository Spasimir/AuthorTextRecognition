import java.io.FileNotFoundException;
import java.util.Scanner;

/*****************************************************************************
 * The main class from which the project starts and these are example test
 * cases for the two authors Yovkov and Vazov Albena-Yovkov.txt
 * Borqna-Yovkov.txt Edin Esenen Den-Yovkov.txt Nora-Vazov.txt
 * Radecki-Vazov.txt Levski-Vazov.txt
 * @author Spasimir
 *****************************************************************************/
public class AuthorTextRecognition {

	public static void main(String[] args) throws FileNotFoundException {

		/**************************************************************************
		 * Preparing 3 containers for the data of the two authors (training
		 * data) and the test data which will be given trough the console * as a
		 * name of a file in the directory of the project *
		 *************************************************************************/
		AuthorData authorOne = new AuthorData();
		AuthorData authorTwo = new AuthorData();
		AuthorData dataToAnalyze = new AuthorData();

		/**********************************************************************
		 * Loading the data for the two authors from two previously filled text
		 * files - Vazov.txt Yovkov.txt.
		 **********************************************************************/
		PrepareDataFromFile.readDataFromFile("Vazov.txt", authorOne);
		PrepareDataFromFile.readDataFromFile("Yovkov.txt", authorTwo);

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String authorText;

		System.out.println("Enter the name of the text file which has to be "
				+ "analyzed ( with its extension NameOfFile.txt ).\n"
				+ "The text file should be in the same directory as this project");

		boolean noFile = true;

		/******************************************************************
		 * While we are given a file which is not in the current directory we
		 * ask for another filename
		 ******************************************************************/
		while (noFile) {
			authorText = scan.nextLine();
			System.out.println("\nYou entered: " + authorText);
			try {
				noFile = false;
				PrepareDataFromFile.readDataFromFile(authorText, dataToAnalyze);
			} catch (FileNotFoundException e) {
				noFile = true;
				System.out.println("A file with this name does not exist in the directory of the project."
						+ "\nPlease enter a file which is in the directory of the project! ");
			}
		}

		/********************************************************
		 * Starting the process of analyzing the text.
		 ********************************************************/
		System.out.println("Analyzing!");
		int result = AnalyzeTexts.whoIsTheAuthor(authorOne, authorTwo, dataToAnalyze);
		if (result == 1) {
			System.out.println("The data is part of the work of Vazov!");
		} else if (result == 2) {
			System.out.println("The data is part of the work of Yovkov!");
		}

	}
}
