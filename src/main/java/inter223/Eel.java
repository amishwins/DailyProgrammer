package inter223;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Eel {
	Pattern p;
	String offensiveWord;
	
	public Eel(String offensiveWord) {
		this.offensiveWord = offensiveWord;
		p = Pattern.compile(getRegexedString(offensiveWord));
	}
	

	public boolean isOffensive(String secretWord) {
		if (secretWord.equals(this.offensiveWord)) return true;
		
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
