package inter223;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class EelTest {
	Eel eelSnond = new Eel("snond");
	Eel eelRrizi = new Eel("rrizi");
	
	@Test
	public void testSnondExample() {
		assertTrue(eelSnond.isOffensive("synchronized"));
		assertTrue(eelSnond.isOffensive("misfunctioned"));
		assertFalse(eelSnond.isOffensive("mispronounced"));
		assertFalse(eelSnond.isOffensive("shotgunned"));
		assertTrue(eelSnond.isOffensive("snond"));
		
		// make sure weird cases like this also don't return true!
		assertFalse(eelSnond.isOffensive("ssnnoonndd"));
	}
	
	@Test
	public void testEnable1() {
		List<String> problemSnondWords = new ArrayList<>(); 
		List<String> problemRriziWrods = new ArrayList<>();
		try (BufferedReader br = Files.newReader(new File("enable1.txt"), Charsets.UTF_8)) {
			String word;
			while ((word = br.readLine()) != null) {
				if (eelSnond.isOffensive(word)) {
					problemSnondWords.add(word);
				}
				if (eelRrizi.isOffensive(word)) {
					problemRriziWrods.add(word);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		assertEquals(6, problemSnondWords.size());
		List<String> target = new ArrayList<>();
		target.addAll(Arrays.asList("misfunctioned sanctioned snowland stanchioned synchronized synonymized".split(" ")));		
		assertEquals(target, problemSnondWords);
		assertEquals(101, problemRriziWrods.size());
		
	}
	
	@Test
	public void testGetRegexedString() {
		assertEquals("^[^a]*?a[^a]*?$", eelSnond.getRegexedString("a"));
		assertEquals("^[^ab]*?a[^ab]*?b[^ab]*?$", eelSnond.getRegexedString("ab"));
		assertEquals("^[^def]*?d[^def]*?e[^def]*?f[^def]*?$", eelSnond.getRegexedString("def"));
		
	}


	@Test
	public void regexStrategy() {
		// this is just to play with some of the regexes
		Pattern p = Pattern.compile(".*?a.*?b.*?c.*?");
		Matcher m = p.matcher("abc");
		assertTrue(m.find());
		
		m = p.matcher("def");
		assertFalse(m.find());
		
		m = p.matcher("abdf");
		assertFalse(m.find());
		
		m = p.matcher("cba");
		assertFalse(m.find());

	}

}
