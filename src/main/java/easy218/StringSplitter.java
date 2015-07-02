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
		
		// even # of digits
		if (word.length() % 2 == 0) {
			leftSide = word.substring(0, word.length() / 2);
			rightSide = word.substring((word.length() / 2), word.length());
		} else { // odd # of digits
			leftSide = word.substring(0, word.length() / 2);
			rightSide = word.substring((word.length() / 2) + 1, word.length());
		}
	}
	
	public String getLeftSide() {
		return leftSide;
	}
	
	public String getRightSide() {
		return rightSide;
	}
}