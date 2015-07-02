package easy218;

// Encode logic that we want to split a string evenly. 
// If there are an odd # of characters, the middle character is ignored
public class StringSplitter {
	final private String leftSide;
	final private String rightSide;

	public StringSplitter(String word) {
		if (word.length() < 2) {
			throw new IllegalArgumentException();
		}

		// In case the word has an odd # of numbers, make sure the right side skips the middle digit
		int offset = word.length() % 2 == 0 ? 0 : 1;
		leftSide = word.substring(0, word.length() / 2);
		rightSide = word.substring((word.length() / 2) + offset, word.length());
	}
	
	public String getLeftSide() {
		return leftSide;
	}
	
	public String getRightSide() {
		return rightSide;
	}
}