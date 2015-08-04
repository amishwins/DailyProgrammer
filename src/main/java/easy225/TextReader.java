package easy225;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class TextReader {
	
	List<String> regexesToProcess;
	String filename;
	String resultingText;
	
	public TextReader() {
		populateRegexes();
	}
	
	// I don't like this design. poo
	public void registerText(String filename) {
		this.filename = filename;
	}

	private void populateRegexes() {
		// must process in this order
		regexesToProcess = new ArrayList<>();
		regexesToProcess.add("([|]\\s+?[|])"); // remove empty
		regexesToProcess.add("^([|].*?[+].*?[+])"); // left mixed
		regexesToProcess.add("([+].*?[+].*?[|])$"); // right mixed
		regexesToProcess.add("^([+|].*?[+|])"); // left feature
		regexesToProcess.add("([+|].*?[+|])$"); // right feature
	}

	
	String processLine(String input) {
		String result = input;
		for(String regex: regexesToProcess) {
			result = result.replaceAll(regex, "").trim();
		}
		return result.trim();
	}
	
	
	String processText() {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = Files.newReader(new File(filename), Charsets.UTF_8)) {
			String line;
			
			// why need this? Just read it so we don't process it
			int numberOfLinesToRead = Integer.valueOf(br.readLine());
			
			while ((line = br.readLine()) != null) {
				// store this and then process later!
				// System.out.println(processLine(line));
				line = processLine(line);
				if (line.trim().isEmpty()) {
					sb.append("\n");

				} else {
					sb.append(
							line.endsWith("-") ? line.substring(0, line.length() - 1) : line  + " "
					);
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return sb.toString().trim();
	}
	
	
}
