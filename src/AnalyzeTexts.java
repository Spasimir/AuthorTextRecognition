import java.util.Iterator;

/************************************************************
 * The class that analyzes the Texts and returns the probability
 * using naive Bayse algorithm.
 * @author Spasimir
 ************************************************************/
public class AnalyzeTexts {

	/**********************************************************
	 * The function to analyze who is the author of the text.
	 * 
	 * @param authorOne - data of the first author
	 * @param authorTwo - data of the second author
	 * @param testData - data to be analyzed
	 **********************************************************/
	public static int whoIsTheAuthor(AuthorData authorOne, AuthorData authorTwo, AuthorData testData) {
		Integer vocabularySize = authorOne.uniqueWords() + authorTwo.uniqueWords();
		Double authorOneProbability = AnalyzeTexts.probabilityForAuthorAndtext(authorOne, testData, vocabularySize);
		Double authorTwoProbability = AnalyzeTexts.probabilityForAuthorAndtext(authorTwo, testData, vocabularySize);

		if (authorOneProbability < authorTwoProbability) {
			return 2;
		} else {
			return 1;
		}
	}

	/******************************************************************************
	 * This function is the implementation of the naive Bayse algorithm for text
	 * classification
	 * 
	 * @param author - one of the authors who may be the creator of the text
	 * @param textToAnalyze - the text to be analyzed
	 * @param vocabularySize - the number of all different words from both authors
	 * 
	 * the variable - probability is 0.5 because we are working with two 
	 * authors only, if one modifies the code to work with more than two authors
	 * one should adjust this probability to 1/numberOfAuthors 
	 ******************************************************************************/
	private static Double probabilityForAuthorAndtext(AuthorData author, AuthorData textToAnalyze,
			Integer vocabularySize) {
		Double result = Double.valueOf(1.0);
		Double numerator;
		Double denumerator;
		Integer allWordsAuthor = author.allWordsInData();
		Iterator<String> iter = textToAnalyze.keySetIterator();
		while (iter.hasNext()) {
			String key = iter.next();
			Double timesInDocumentTest = Double.valueOf(textToAnalyze.occurrencesOfWord(key));
			numerator = Double.valueOf(author.occurrencesOfWordIfExists(key) + 1.0);
			denumerator = Double.valueOf(vocabularySize + allWordsAuthor);
			result *= 10000.0;
			result *= timesInDocumentTest;
			result *= numerator / denumerator;
		}
		Double probability = 0.5;
		result *= probability;
		return result;
	}

}
