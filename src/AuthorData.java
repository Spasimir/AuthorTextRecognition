import java.util.HashMap;
import java.util.Iterator;

/**********************************************************
 * This is the container class for the Data of a text file
 * @author Spasimir
 ***********************************************************/

public class AuthorData {

	/**********************************************************
	 * Constructor with no arguments.
	 *********************************************************/
	public AuthorData() {
		this.data = new HashMap<>();
	}

	/**********************************************************
	 * The constructor for the container.
	 * @param data_rhs - Constructs the element by this argument
	 **********************************************************/
	public AuthorData(HashMap<String, Integer> data_rhs) {
		super();
		this.data = data_rhs;
	}

	/************************************************************
	 * Loads the container with words from a string array of words
	 * @param words -  string array of words to be added to the container
	 ***********************************************************/
	@SuppressWarnings("boxing")
	public void LoadData(String[] words) {
		for (String token : words) {
			if (this.data.containsKey(token)) {
				this.data.put(token, Integer.valueOf(this.data.get(token) + 1));
			} else {
				this.data.put(token, 1);
			}
		}
	}

	/*************************************************************
	 * Returns the number of unique words in the container
	 ***********************************************************/
	public Integer uniqueWords() {
		return Integer.valueOf(this.data.size());
	}

	/************************************************************
	 * Returns the number of all words in the container (including repeating words)
	 ***********************************************************/
	public Integer allWordsInData() {
		Iterator<String> iterCount = this.data.keySet().iterator();
		Integer size = new Integer(0);
		while (iterCount.hasNext()) {
			String key = iterCount.next();
			size += this.data.get(key);
		}
		return size;
	}

	/************************************************************
	 * Returns the number of occurrences of word in the container.
	 * @param word - word we want to the number of times it is in the text which the container holds
	 ***********************************************************/
	public Integer occurrencesOfWord(String word) {
		return data.get(word);
	}

	/************************************************************
	 * Returns the number of occurrences of word in the container if it is in the container.
	 * @param word - word we want to the number of times it is in the text which the container holds
	 ***********************************************************/
	public Integer occurrencesOfWordIfExists(String word) {
		if (data.containsKey(word)) {
			return data.get(word);
		}
		return 0;
	}

	/************************************************************
	 * Returns an iterator to iterate the container
	 ***********************************************************/
	public Iterator<String> keySetIterator() {
		return data.keySet().iterator();
	}

	private HashMap<String, Integer> data;
}
