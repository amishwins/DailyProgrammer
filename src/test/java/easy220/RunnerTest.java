package easy220;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RunnerTest {

	Runner cut = new Runner();
	
	@Test
	public void testTwoSegmentsWithSingleQuote() {
		String input = "ba'da";
		
		String result = cut.superAlphaSort(input);
		assertEquals("ab'ad", result);
	}
	
	@Test
	public void oneSegmentWithSingleExclamation() {
		String input = "bam!";
		String result = cut.superAlphaSort(input);
		assertEquals("abm!", result);
	}
	
	@Test
	public void threeSegmentsWithSpecialCharacters() {
		String input = "ha'lshal'al";
		String result = cut.superAlphaSort(input);
		assertEquals("ah'ahlls'al", result);
	}
	
	@Test
	public void ifCapitalizedPutBackFirstCapital() {
		String input = "Why";
		String result = cut.superAlphaSort(input);
		assertEquals("Hwy", result);
	}
	
	@Test
	public void doesItHasCapital() {
		String input = "Yes";
		assertTrue(cut.hasCapitalFirstLetter(input));
		
		input = "no";
		assertFalse(cut.hasCapitalFirstLetter(input));
	}
	
	@Test
	public void lowerCaseThisWord() {
		String input = "Yes";
		String result = input.toLowerCase();
		assertEquals("yes", result);
	}
	
}
