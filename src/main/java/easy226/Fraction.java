package easy226;

public class Fraction {

	final long numerator;
	final long denominator;
	public Fraction(long numerator, long denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	// Makes debugging and printing nice :)
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	
	// generated by Eclipse - yay! 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (denominator ^ (denominator >>> 32));
		result = prime * result + (int) (numerator ^ (numerator >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Fraction))
			return false;
		Fraction other = (Fraction) obj;
		if (denominator != other.denominator)
			return false;
		if (numerator != other.numerator)
			return false;
		return true;
	}
	


}
