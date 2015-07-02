package easy218;

import java.util.ArrayList;
import java.util.List;

public class SuperPal {

	// Given a number, is it a palindrome? 
	boolean isNumberAPal(int i) {
		String numberAsString = Integer.toString(i);
		if (numberAsString.length() == 1) return true;
		
		StringSplitter ss = new StringSplitter(numberAsString);
		String left = ss.getLeftSide();
		String right = ss.getRightSide();
		
		// Two optimizations (necessary?)
		if (left.equals(right)) {
			return true;
		} else if (left.length() == 1) {
			return false;			
		} else {
			List<Character> leftList = getCharacterList(left);
			List<Character> rightList = reverse(getCharacterList(right));
			
			return (leftList.equals(rightList));
		}
	}
	

	private List<Character> reverse(List<Character> characterList) {
		List<Character> result = new ArrayList<>();
		for (int i = characterList.size() - 1; i >= 0; i--) {
			result.add(characterList.get(i));
		}
		
		return result;
	}


	private List<Character> getCharacterList(String left) {
		List<Character> result = new ArrayList<>();
		for (int i = 0; i < left.length(); i++) {
			result.add(left.charAt(i));
		}
		
		return result;
	}

}
