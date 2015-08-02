package easy225;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TextReaderTest {


	@Test
	public void removeLeftFeatures() {
		String leftSideFeatureRegex = "^([+|].*?[+|])";
		
		// handle start and end of feature
		String originalString = "+-------------+ One hundred and fifty quadrillion,";		
		assertEquals("One hundred and fifty quadrillion,", originalString.replaceAll(leftSideFeatureRegex, "").trim());
		
		// handle inside feature, empty contents
		originalString = "|             | seventy-two trillion, six hundred";
		assertEquals("seventy-two trillion, six hundred", originalString.replaceAll(leftSideFeatureRegex, "").trim());
		
		// handle inside feature, something inside
		originalString = "| 150 072 626 | and twenty-six billion, eight hun-";
		assertEquals("and twenty-six billion, eight hun-", originalString.replaceAll(leftSideFeatureRegex, "").trim());
	}

	@Test
	public void removeRightFeatures() {
		String rightSideFeatureRegex = "([+|].*?[+|])$";
		
		// handle start and end of feature
		String originalString = "However, one other rather more in- +-------------+";		
		assertEquals("However, one other rather more in-", originalString.replaceAll(rightSideFeatureRegex, "").trim());
		
		// handle inside feature, empty contents
		originalString = "teresting number is two hundred    |             |";
		assertEquals("teresting number is two hundred", originalString.replaceAll(rightSideFeatureRegex, "").trim());
		
		// handle inside feature, something inside
		originalString = "and twenty-one quadrillion, eight  | 221 806 434 |";
		assertEquals("and twenty-one quadrillion, eight", originalString.replaceAll(rightSideFeatureRegex, "").trim());
	}
	
	@Test
	public void removeMixedSizeFeature() {
		// need to do these first!
		String leftMixedRegex = "^([|].*?[+].*?[+])";
		String originalString = "|       +--------+ nim veniam, quis nostrud ex-";
		assertEquals("nim veniam, quis nostrud ex-", originalString.replaceAll(leftMixedRegex, "").trim());	

		// left doesn't break others
		originalString = "+-------------+ One hundred and fifty quadrillion,";		
		assertEquals("+-------------+ One hundred and fifty quadrillion,", originalString.replaceAll(leftMixedRegex, "").trim());
		
		originalString = "|             | seventy-two trillion, six hundred";
		assertEquals("|             | seventy-two trillion, six hundred", originalString.replaceAll(leftMixedRegex, "").trim());
		
		originalString = "| 150 072 626 | and twenty-six billion, eight hun-";
		assertEquals("| 150 072 626 | and twenty-six billion, eight hun-", originalString.replaceAll(leftMixedRegex, "").trim());
		

		String rightMixedRegex = "([+].*?[+].*?[|])$";
		originalString = "nim veniam, quis nostrud ex- +--------+       |";
		assertEquals("nim veniam, quis nostrud ex-", originalString.replaceAll(rightMixedRegex, "").trim());
		
		// right doesn't break others
		originalString = "However, one other rather more in- +-------------+";		
		assertEquals("However, one other rather more in- +-------------+", originalString.replaceAll(rightMixedRegex, "").trim());
		
		originalString = "teresting number is two hundred    |             |";
		assertEquals("teresting number is two hundred    |             |", originalString.replaceAll(rightMixedRegex, "").trim());
		
		originalString = "and twenty-one quadrillion, eight  | 221 806 434 |";
		assertEquals("and twenty-one quadrillion, eight  | 221 806 434 |", originalString.replaceAll(rightMixedRegex, "").trim());
	}
	
	@Test
	public void processAll() {
		TextReader cut = new TextReader();

		// left hand features
		assertEquals("One hundred and fifty quadrillion,", cut.processAll("+-------------+ One hundred and fifty quadrillion,"));
		assertEquals("seventy-two trillion, six hundred", cut.processAll("|             | seventy-two trillion, six hundred"));
		assertEquals("and twenty-six billion, eight hun-", cut.processAll("| 150 072 626 | and twenty-six billion, eight hun-"));

		// right hand features
		assertEquals("However, one other rather more in-", cut.processAll("However, one other rather more in- +-------------+"));
		assertEquals("teresting number is two hundred", cut.processAll("teresting number is two hundred    |             |"));
		assertEquals("and twenty-one quadrillion, eight", cut.processAll("and twenty-one quadrillion, eight  | 221 806 434 |"));		
		
		// mixed features
		assertEquals("nim veniam, quis nostrud ex-", cut.processAll("|       +--------+ nim veniam, quis nostrud ex-"));
		assertEquals("nim veniam, quis nostrud ex-", cut.processAll("nim veniam, quis nostrud ex- +--------+       |"));
	}
	
	@Test
	public void readTheFile() {
		TextReader cut = new TextReader();
		cut.registerText("easy225_1.txt");
		cut.processText();
	}
	
}
