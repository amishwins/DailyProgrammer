package easy226;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FractionAdderTest {

	FractionAdder fa;

	@Test
	public void sampleInput1() {
		List<Fraction> inputFractions = new ArrayList<>();
		inputFractions.add(new Fraction(1, 6));
		inputFractions.add(new Fraction(3, 10));
		
		fa = new FractionAdder();
		Fraction result = fa.addAndReduce(inputFractions);
		
		assertEquals(new Fraction(7, 15), result);
		
	}

	@Test
	public void sampleInput2() {
		List<Fraction> inputFractions = new ArrayList<>();
		inputFractions.add(new Fraction(1, 3));
		inputFractions.add(new Fraction(1, 4));
		inputFractions.add(new Fraction(1, 12));
		
		fa = new FractionAdder();
		Fraction result = fa.addAndReduce(inputFractions);
		
		assertEquals(new Fraction(2, 3), result);
		
	}

	@Test
	public void challengeInput1() {
		List<Fraction> inputFractions = new ArrayList<>();
		inputFractions.add(new Fraction(2, 9));
		inputFractions.add(new Fraction(4, 35));
		inputFractions.add(new Fraction(7, 34));
		inputFractions.add(new Fraction(1, 2));
		inputFractions.add(new Fraction(16, 33));
		
		fa = new FractionAdder();
		Fraction result = fa.addAndReduce(inputFractions);
		
		assertEquals(new Fraction(89962, 58905), result);
	}
	
	@Test
	public void challengeInput2() {
		List<Fraction> inputFractions = new ArrayList<>();
		inputFractions.add(new Fraction(1, 7));
		inputFractions.add(new Fraction(35, 192));
		inputFractions.add(new Fraction(61, 124));
		inputFractions.add(new Fraction(90, 31));
		inputFractions.add(new Fraction(5, 168));
		inputFractions.add(new Fraction(31, 51));		
		inputFractions.add(new Fraction(69, 179));
		inputFractions.add(new Fraction(32, 5));
		inputFractions.add(new Fraction(15, 188));
		inputFractions.add(new Fraction(10, 17));
		
		fa = new FractionAdder();
		assertEquals(new Fraction(351910816163l, 29794134720l), fa.addAndReduce(inputFractions));
	}

	

}
