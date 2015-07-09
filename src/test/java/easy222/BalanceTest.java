package easy222;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BalanceTest {

	Balance bal;
	enum Dog { SAMMY, FLUFFY };

	@Test
	public void sampleWord() {
		bal = new Balance("STEAD");
		assertTrue(bal.isBalanced());
		assertTrue(bal.getPivot().equals("T"));
		assertTrue(bal.getLeftSide().equals("S"));
		assertTrue(bal.getRightSide().equals("EAD"));
		assertEquals(19, bal.getScore());
		assertTrue(bal.print().equals("S T EAD - 19"));
	}
	
	@Test
	public void challengeInput() {
		System.out.println((new Balance("STEAD")).print());
		System.out.println((new Balance("CONSUBSTANTIATION")).print());
		System.out.println((new Balance("WRONGHEADED")).print());
		System.out.println((new Balance("UNINTELLIGIBILITY")).print());
		System.out.println((new Balance("SUPERGLUE")).print());
	}

	
}
