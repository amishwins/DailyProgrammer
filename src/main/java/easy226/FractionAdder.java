package easy226;

import java.util.List;

public class FractionAdder {

	// should these be static? 
	public Fraction addAndReduce(List<Fraction> inputFractions) {
		System.out.println("Starting adding of: " + inputFractions);

		Fraction firstFraction = inputFractions.remove(0);
		long currentNumerator = firstFraction.numerator;
		long currentDenominator = firstFraction.denominator;

		if (inputFractions.size() == 0) {
			return new Fraction(currentDenominator, currentDenominator);
		} 

		for(Fraction f: inputFractions) {
			System.out.println("  DEBUG: " + currentNumerator + "/" + currentDenominator + " + " + f);
			if (f.denominator == currentDenominator) {
				currentNumerator += f.numerator; 
				continue;
			} else {
				currentNumerator = (currentNumerator * f.denominator) + (f.numerator * currentDenominator);
				currentDenominator *= f.denominator;
				
				// keep a running optimization
				long gcd = findGCDEuclidian(currentNumerator, currentDenominator);
				currentNumerator = currentNumerator / gcd;
				currentDenominator = currentDenominator / gcd;
			}
		}

		Fraction result = tryToReduce(new Fraction(currentNumerator, currentDenominator));

		System.out.println("Finished: " + result + "\n");
		return result;
	}

	private Fraction tryToReduce(Fraction fraction) {
		
		long gcd = findGCDEuclidian(fraction.numerator, fraction.denominator);
	
		if (gcd == 1) {
			return fraction;
		} else {
			return tryToReduce(new Fraction(fraction.numerator / gcd, fraction.denominator / gcd));
		}
		
	}


	// My improved algorithm after reading: https://en.wikipedia.org/wiki/Euclidean_algorithm
	private long findGCDEuclidian(long first, long second) {
		if (first == 0) {
			return second;
		} else if (second == 0) {
			return first;
		} else if (first < 0 || second < 0) {
			throw new IllegalStateException("Not sure what happened, but you subtracted bad. First: " + first + ". Second: " + second);
		} else {
			long larger = Math.max(first, second);
			long smaller = Math.min(first, second);
			return findGCDEuclidian(smaller, larger - smaller);
		}
		
	}
	
	// My janky attempt at findGCD, without using Euclidian algorithm. This is fine for the first 3 inputs
	// but fails miserably on challenge 2 (it can do the first 7 or so numbers, but then runs (a looooooong time) for 8+.
	// kept for historical reasons!
	@SuppressWarnings("unused")
	private long findGCD(Fraction fraction) {
		long gcd = 1;
		for(long attempt = 2; attempt <= fraction.numerator / 2; attempt++) {
			if (fraction.numerator % attempt == 0 && fraction.denominator % attempt == 0) {
				gcd = attempt;
			}
		}		
		return gcd;
	}

}
