package easy226;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FractionTest {
	
	Fraction f;

	@Test
	public void test() {
		f = new Fraction(1, 2);
		assertEquals(f.numerator, 1);
		assertEquals(f.denominator, 2);
	}

}
