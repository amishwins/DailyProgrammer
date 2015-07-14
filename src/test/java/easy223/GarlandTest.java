package easy223;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class GarlandTest {
	
	GarlandFinder g = new GarlandFinder();

	@Test
	public void exampleChallenge() {
		assertEquals(0, g.getDegree("programmer"));
		assertEquals(1, g.getDegree("ceramic"));
		assertEquals(2, g.getDegree("onion"));
		assertEquals(4, g.getDegree("alfalfa"));
	}
	
	@Test
	public void getHigestDegreeForEnglishWords() {
		List<String> highestDegreeWords = new ArrayList<>();
		int highestDegree = 0;
		
		// better to stream it rather than read the WHOLE FILE into memory
		try (BufferedReader br = Files.newReader(new File("enable1.txt"), Charsets.UTF_8)) {
			String word;
			while ((word = br.readLine()) != null) {
				int degree = g.getDegree(word);
				if (degree > highestDegree) {
					highestDegree = degree;
					highestDegreeWords.clear();
					highestDegreeWords.add(word);
				} else if (degree == highestDegree) {
					highestDegreeWords.add(word);
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(5, highestDegree);
		assertEquals(1, highestDegreeWords.size());
		assertEquals("undergrounder", highestDegreeWords.get(0));

	}
	

}
