package easy218;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

// Overall, does what the challenge asks, but not the bonus
// Doesn't seem to hard to do the bonus - I think here using a multimap would be the smartest
// since we want to know for which input numbers the palindrome output is identical.
// Maybe do this part with a friend!

public class SuperPal {
	List<BigInteger> bigIntsToTest;
	
	public SuperPal() {
		bigIntsToTest = new ArrayList<>();
	}
	
	public void register(String number) {
		bigIntsToTest.add(new BigInteger(number));
	}
	
	// looks like longs are no good. Have to switch to big integer!
	public void run() {
		for(BigInteger bigInt: bigIntsToTest) {
			int count = 0;
			BigInteger palindrome = new BigInteger(bigInt.toString());
			boolean error = false;
			
			while(!isBigIntegerAPal(palindrome)) {
				palindrome = palindrome.add(flipBigInteger(palindrome));

				if (count > 100) {
					error = true;
					break;
				}
				count++;
			}
			
			if (!error) {
				System.out.println(bigInt + " gets palindromic after " + count + " steps: " + palindrome);
			} else {
				System.out.println(bigInt + " results in too many steps");
			}
		}
	}	
	
	private List<Character> reverse(List<Character> characterList) {
		List<Character> result = new ArrayList<>();
		for (int i = characterList.size() - 1; i >= 0; i--) {
			result.add(characterList.get(i));
		}
		
		return result;
	}

	private List<Character> getCharacterList(String left) {
		List<Character> result = new ArrayList<>();
		for (int i = 0; i < left.length(); i++) {
			result.add(left.charAt(i));
		}
		
		return result;
	}

	public boolean isBigIntegerAPal(BigInteger i) {
		String numberAsString = i.toString();
		if (numberAsString.length() == 1) return true;
		
		StringSplitter ss = new StringSplitter(numberAsString);
		String left = ss.getLeftSide();
		String right = ss.getRightSide();
		
		// Two optimizations (necessary?)
		if (left.equals(right)) {
			return true;
		} else if (left.length() == 1) {
			return false;			
		} else {
			List<Character> leftList = getCharacterList(left);
			List<Character> rightList = reverse(getCharacterList(right));
			
			return (leftList.equals(rightList));
		}	}

	public BigInteger flipBigInteger(BigInteger bigInteger) {
		if (isBigIntegerAPal(bigInteger)) return bigInteger;
		
		String number = bigInteger.toString();
		StringBuilder sb = new StringBuilder();
		for(int index = number.length() - 1; index >= 0; index--) {
			sb.append(number.charAt(index));
		}

		return new BigInteger(sb.toString());
	}
	
	
	// ****************************************************************************
	// Keeping the implementation using long here for now just to remember
	// that this implementation fails after the palindrome grows beyond 19 digits
	// ****************************************************************************
	boolean isNumberAPal(long l) {
		String numberAsString = Long.toString(l);
		if (numberAsString.length() == 1) return true;
		
		StringSplitter ss = new StringSplitter(numberAsString);
		String left = ss.getLeftSide();
		String right = ss.getRightSide();
		
		// Two optimizations (necessary?)
		if (left.equals(right)) {
			return true;
		} else if (left.length() == 1) {
			return false;			
		} else {
			List<Character> leftList = getCharacterList(left);
			List<Character> rightList = reverse(getCharacterList(right));
			
			return (leftList.equals(rightList));
		}
	}

	
	// ****************************************************************************
	// Keeping the implementation using long here for now just to remember
	// that this implementation fails after the palindrome grows beyond 19 digits
	// ****************************************************************************
	public long flipNumber(long l) {
		if (isNumberAPal(l)) return l;
		
		String number = Long.toString(l);
		StringBuilder sb = new StringBuilder();
		for(int index = number.length() - 1; index >= 0; index--) {
			sb.append(number.charAt(index));
		}

		return Long.parseLong(sb.toString());
	}

}
