package easy222;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Balance {
	final String word;
	final int wordLength;
	final List<Character> letters;
	String pivot;
	String leftSide;
	String rightSide;
	boolean isBalanced;
	int score;
	LetterScore ls;

	enum DirectionFromPivot { LEFT, RIGHT };	
	
	public Balance(String string) {
		word = string;
		ls = new LetterScore();
		wordLength = word.length();
		letters = new ArrayList<>();
		for(int i = 0; i < wordLength; i++) {
			letters.add(word.charAt(i));
		}
		process();
	}

	private void process() {
		int pivotIndex = 1;
		
		while(pivotIndex < wordLength - 1) {
			if(leftScore(pivotIndex) == rightScore(pivotIndex)) {
				score = leftScore(pivotIndex);
				leftSide = word.substring(0, pivotIndex);
				rightSide = word.substring(pivotIndex + 1);
				pivot = word.substring(pivotIndex, pivotIndex + 1);
				isBalanced = true;
				return;
			}
			pivotIndex++;
		}		
		isBalanced = false;
	}

	private int rightScore(int pivotIndex) {
		return getScore(pivotIndex, DirectionFromPivot.RIGHT);
	}

	private int leftScore(int pivotIndex) {
		return getScore(pivotIndex, DirectionFromPivot.LEFT);
	}
	
	private int getScore(int pivotIndex, DirectionFromPivot s) {
		int score = 0;
		int multiplier;
		switch (s) {
			case LEFT:
				// all letters from the beginning until the index
				multiplier = pivotIndex;
				for (int i = 0; i < pivotIndex; i++) { 
					score += (multiplier * ls.scores.get(letters.get(i)));
					multiplier--;
				}
				break;
			case RIGHT:
				// all letters from the end until the end
				multiplier = wordLength - (pivotIndex + 1);
				for (int i = wordLength - 1; i > pivotIndex; i--) { 
					score += (multiplier * ls.scores.get(letters.get(i)));
					multiplier--;
				}
				break;
		}
		
		return score;
	}
	

	public boolean isBalanced() {
		return isBalanced;
	}

	public String getPivot() {
		return pivot;
	}

	public String getLeftSide() {
		return leftSide;
	}

	public String getRightSide() {
		return rightSide;
	}

	public int getScore() {
		return score;
	}

	public String print() {
		if (isBalanced) {
			return getLeftSide() + " " + getPivot() + " " + getRightSide() + " - " + getScore();
		} else {
			return word + " DOES NOT BALANCE";
		}
		
	}

}

class LetterScore {
	Map<Character, Integer> scores;
	public LetterScore() {
		scores = new HashMap<>();		
		scores.put('A', 1);
		scores.put('B', 2);
		scores.put('C', 3);
		scores.put('D', 4);
		scores.put('E', 5);
		scores.put('F', 6);
		scores.put('G', 7);
		scores.put('H', 8);
		scores.put('I', 9);
		scores.put('J', 10);
		scores.put('K', 11);
		scores.put('L', 12);
		scores.put('M', 13);
		scores.put('N', 14);
		scores.put('O', 15);
		scores.put('P', 16);
		scores.put('Q', 17);
		scores.put('R', 18);
		scores.put('S', 19);
		scores.put('T', 20);
		scores.put('U', 21);
		scores.put('V', 22);
		scores.put('W', 23);
		scores.put('X', 24);
		scores.put('Y', 25);
		scores.put('Z', 26);		
	}
}
