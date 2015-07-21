package inter223;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Eel {
	Pattern p;
	String offensiveWord;
	int lengthOfOffensiveWord;
	Set<Character> offensiveLetterSet;
	
	public Eel(String offensiveWord) {
		this.offensiveWord = offensiveWord;
		p = Pattern.compile(getRegexedString(offensiveWord));
		lengthOfOffensiveWord = offensiveWord.length();
		offensiveLetterSet = new TreeSet<>();
		String offensiveLetters = removeDuplicates(offensiveWord);
		for(int i = 0; i < offensiveLetters.length(); i++ ) {
			offensiveLetterSet.add(offensiveLetters.charAt(i));
		}
		
	}
	

	public boolean isOffensive(String secretWord) {
		if (secretWord.equals(this.offensiveWord)) return true;

		// this brought it down slightly - maybe 10ms or so
		if (secretWord.length() < this.lengthOfOffensiveWord) return false;
		
		// this brought it down by half - from 150ms to 70ms for all 180K words
		for(Character c: offensiveLetterSet) {
			if (!secretWord.contains(String.valueOf(c))) return false;
			// Identical performance to the indexOf method
			// if (secretWord.indexOf(String.valueOf(c)) == -1 ) return false;
		}
		
		Matcher m = p.matcher(secretWord);
		return m.find();
	}

	String getRegexedString(String offensiveWord) {
		StringBuilder sb = new StringBuilder();
		sb.append("^[^" + offensiveWord + "]*?");
		
		String uniqueOffensiveWord = removeDuplicates(offensiveWord);
		
		for(int i = 0; i < offensiveWord.length(); i++) {
			sb.append(offensiveWord.charAt(i));
			String restOfLetters = uniqueOffensiveWord;
			if (restOfLetters.length() > 0) {
				sb.append("[^" + restOfLetters + "]*?");
			} else {
				sb.append(".*?");
			}
		}
		sb.append("$");
		return sb.toString();
	}

	private String removeDuplicates(String ow) {
	    StringBuilder noDupes = new StringBuilder();
	    for (int i = 0; i < ow.length(); i++) {
	        String si = ow.substring(i, i + 1);
	        if (noDupes.indexOf(si) == -1) {
	            noDupes.append(si);
	        }
	    }
	    return noDupes.toString();
	}
}
