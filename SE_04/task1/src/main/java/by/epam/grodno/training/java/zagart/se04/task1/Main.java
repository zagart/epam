package by.epam.grodno.training.java.zagart.se04.task1;

import static by.epam.grodno.training.java.zagart.se04.task1.Util.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * Main class which contains enter point.
 */
public class Main {

	/**
	 * Enter point of the application.
	 */
	public static void main(String[] args) throws IOException {

		InputStream sourceFile = new FileInputStream("D:\\source.txt");
		OutputStream resultFile = new FileOutputStream("D:\\result.txt");
		byte[] sourceInBytes = new byte[sourceFile.available()];
		HashMap<String, Integer> keywords = new HashMap<String, Integer>(); 

		/*
		 * Reading bytes from source file until it have them.
		 */
		int count = 0;
		while (sourceFile.available() > 0) {
			sourceFile.read(sourceInBytes);
			count++;
		}
		resultFile.write(sourceInBytes); // Writing result to result file.
		String fileContent = new String(sourceInBytes, StandardCharsets.UTF_8); // Source file in String.
		
		keywords = findKeywordsIterations(fileContent);
		printKeywordsIterations(keywords);		
		byte[] resultInBytes = new byte[keywords.size()];
		
	}

}
