package easy218;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.Test;

public class SuperPalTest {
	SuperPal cut = new SuperPal();

	@Test 
	public void theLogic() {
		cut.register("24");
		cut.register("28");
		cut.register("11");
		cut.register("68");
		cut.register("123");
		cut.register("286");
		cut.register("196196871");
		cut.run();
	}
	
	
	@Test
	public void uhOhNeedBigLetItSnow() {
		assertFalse(cut.isBigIntegerAPal(new BigInteger("196196871")));
		assertFalse(cut.isBigIntegerAPal(new BigInteger("19619687111123123123123123123123123231232")));
		assertTrue(cut.isBigIntegerAPal(new BigInteger("4478555400006996000045558744")));
	}
	
	@Test
	public void uhOhNeedFlipBigInteger() {
		assertEquals(new BigInteger("21"), cut.flipBigInteger(new BigInteger("12")));
		assertEquals(new BigInteger("11"), cut.flipBigInteger(new BigInteger("11")));
		assertEquals(new BigInteger("11"), cut.flipBigInteger(new BigInteger("110")));
	}

	
	// ****************************************************************************
	// Keeping the tests here using long for now just to remember
	// that this implementation fails after the palindrome grows beyond 19 digits
	// ****************************************************************************
	@Test
	public void theseNumbersArePalindromes() {
		assertTrue(cut.isNumberAPal(6));
		assertTrue(cut.isNumberAPal(33));
		assertTrue(cut.isNumberAPal(121));
		assertTrue(cut.isNumberAPal(1221));
		assertTrue(cut.isNumberAPal(12321));
		assertTrue(cut.isNumberAPal(123321));
	}

	@Test
	public void theseNumbersAreNotPalindromes() {
		assertFalse(cut.isNumberAPal(34));
		assertFalse(cut.isNumberAPal(123));
		assertFalse(cut.isNumberAPal(1223));
		assertFalse(cut.isNumberAPal(12324));
		assertFalse(cut.isNumberAPal(123326));
	}
	
	@Test
	public void flipNumber() {
		assertEquals(21, cut.flipNumber(12));
		assertEquals(11, cut.flipNumber(11));
		assertEquals(11, cut.flipNumber(110));
	}

	
}
