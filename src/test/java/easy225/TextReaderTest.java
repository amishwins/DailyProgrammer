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
		assertEquals("One hundred and fifty quadrillion,", cut.processLine("+-------------+ One hundred and fifty quadrillion,"));
		assertEquals("seventy-two trillion, six hundred", cut.processLine("|             | seventy-two trillion, six hundred"));
		assertEquals("and twenty-six billion, eight hun-", cut.processLine("| 150 072 626 | and twenty-six billion, eight hun-"));

		// right hand features
		assertEquals("However, one other rather more in-", cut.processLine("However, one other rather more in- +-------------+"));
		assertEquals("teresting number is two hundred", cut.processLine("teresting number is two hundred    |             |"));
		assertEquals("and twenty-one quadrillion, eight", cut.processLine("and twenty-one quadrillion, eight  | 221 806 434 |"));		
		
		// mixed features
		assertEquals("nim veniam, quis nostrud ex-", cut.processLine("|       +--------+ nim veniam, quis nostrud ex-"));
		assertEquals("nim veniam, quis nostrud ex-", cut.processLine("nim veniam, quis nostrud ex- +--------+       |"));
		
		// Complicated case (example 3)
		assertEquals("Duis aute irure dolor", cut.processLine("+-------+ Duis aute irure dolor |             |"));
	}
	
	@Test
	public void readTheFile() {
		TextReader cut = new TextReader();
		cut.registerText("easy225_1.txt");
		assertEquals("This is an example piece of text. This is an example piece of text. This is an example piece of text. This is an example piece of text. This is a sample for a challenge. Lorum ipsum dolor sit amet and other words. The proper word for a layout like this would be typesetting, or so I would imagine, but for now let's carry on calling it an example piece of text. Hold up - the end of the paragraph is approaching - notice the double line break for a paragraph. \nAnd so begins the start of the second paragraph but as you can see it's only marginally better than the other one so you've not really gained much - sorry. I am certainly not a budding author as you can see from this example input. Perhaps I need to work on my writing skills.", cut.processText());

		cut = new TextReader();
		cut.registerText("easy225_2.txt");
		assertEquals("One hundred and fifty quadrillion, seventy-two trillion, six hundred and twenty-six billion, eight hundred and fourty million, three hundred and thirteen thousand subtract one is a rather large prime number which equals one to five if calculated modulo two to six respectively. \nHowever, one other rather more interesting number is two hundred and twenty-one quadrillion, eight hundred and six trillion, four hundred and thirty-four billion, five hundred and thirty-seven milmillion, nine hundred and seventy-eight thousand, six hundred and seventy nine, which isn't prime but is the 83rd Lucas number.", cut.processText());

		cut = new TextReader();
		cut.registerText("easy225_3.txt");
		assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex. \nDuis aute irure dolor in repre-henderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", cut.processText());
	}
	
}
