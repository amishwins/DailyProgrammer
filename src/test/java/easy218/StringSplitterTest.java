package easy218;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringSplitterTest {

	StringSplitter cut;
	
	@Test
	public void splitIndecesEvenLength() {
		cut = new StringSplitter("12");
		assertEquals("1", cut.getLeftSide());
		assertEquals("2", cut.getRightSide());
	}

	@Test
	public void splitIndecesOddLength() {
		cut = new StringSplitter("132");
		assertEquals("1", cut.getLeftSide());
		assertEquals("2", cut.getRightSide());
	}

	@Test
	public void splitIndecesOddLengthLonger() {
		cut = new StringSplitter("13232");
		assertEquals("13", cut.getLeftSide());
		assertEquals("32", cut.getRightSide());		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void badLengthThrowsException() {
		cut = new StringSplitter("1");
		assertTrue(false); // should not arrive here!
	}

}
