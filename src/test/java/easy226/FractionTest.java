package easy226;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FractionTest {
	
	Fraction f;

	@Test
	public void test() {
		f = new Fraction(1, 2);
		assertEquals(f.numerator, 1);
		assertEquals(f.denominator, 2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void illegalDenominator() {
		f = new Fraction(1, 0);
	}

}
