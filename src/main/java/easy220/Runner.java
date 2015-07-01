package easy220;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
	
	public static void main(String[] args) {
		List<String> sentences = new ArrayList<>();
		sentences.add("This is a sentence.");
		sentences.add("This challenge doesn't seem so hard.");
		sentences.add("There are more things between heaven and earth, Horatio, than are dreamt of in your philosophy.");
		sentences.add("Eye of Newt, and Toe of Frog, Wool of Bat, and Tongue of Dog.");
		
		Runner r = new Runner();
		
		for(String sentence: sentences) {
			r.run(sentence);
		}
	}	
	
	
	public void run(String sentence) {
		String result = mangle(sentence);
		System.out.println(result);		
	}
	
		
	public String mangle(String input) {
		List<String> words = new ArrayList<>();
		words.addAll(Arrays.asList(input.split("\\s")));
		StringBuilder sb = new StringBuilder();
		
		for (String word: words) {
			sb.append(superAlphaSort(word));
			sb.append(" ");
		}
		
		return sb.toString().trim();
	}

	String superAlphaSort(String word) {
		String result = word;
		Pattern p = Pattern.compile("([a-zA-Z]+)");
		Matcher m = p.matcher(word);
		
		while(m.find()) {
			// needed to replaceFirst and not replaceAll
			result = result.replaceFirst(m.group(), alphabeticSort(m.group()));
		}
		
		return result;
	}

	private String alphabeticSort(String word) {
		List<Character> letters = new ArrayList<>();
		boolean hasCapital = hasCapitalFirstLetter(word);
		String lowerCaseWord = word.toLowerCase();
		
		for(int i = 0; i < lowerCaseWord.length(); i++) {
			letters.add(lowerCaseWord.charAt(i));
		}
		Collections.sort(letters);
		return join(letters, hasCapital);
	}
	
	private String join(List<Character> letters, boolean hasCapital) {
		StringBuilder sb = new StringBuilder();
		
		if (hasCapital) {
			sb.append(letters.remove(0).toString().toUpperCase());
		}
		
		for(Character letter: letters) {
			sb.append(letter);
		}
		
		return sb.toString();
	}
	
	boolean hasCapitalFirstLetter(String word) {
		String firstLetter = word.substring(0, 1);
		Pattern p = Pattern.compile("[A-Z]");
		Matcher m = p.matcher(firstLetter);
		
		return m.find();
	}
}
