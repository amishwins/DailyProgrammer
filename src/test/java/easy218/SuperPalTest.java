package easy218;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SuperPalTest {
	SuperPal cut = new SuperPal();

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
	
}
