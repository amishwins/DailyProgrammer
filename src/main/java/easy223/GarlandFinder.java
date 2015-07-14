package easy223;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GarlandFinder {	
	
	public int getDegree(String word) {
		
		int maxFound = 0;
		
		// check every substring except containing the last letter
		for(int i = 1; i < word.length(); i++) {
			// I didn't want to use string compare here. Go go power of regex! 
			// https://xkcd.com/208/
			Pattern p = Pattern.compile(word.substring(0, i) + "$");
			Matcher m = p.matcher(word);
			if (m.find()) {
				maxFound = i;
			}
		}
		
		return maxFound;
	}
}
