package by.epam.grodno.training.java.zagart.se04.task1;

import static by.epam.grodno.training.java.zagart.se04.task1.Util.findKeywordsIterations;
import static by.epam.grodno.training.java.zagart.se04.task1.Util.saveKeywordsIterations;

import java.io.File;
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

		/*
		 * Get application path.
		 */
		String appPath = new File(".").getCanonicalPath();

		/*
		 * New byte input stream for reading from file source.txt
		 */
		InputStream sourceFile = new FileInputStream(
				String.format("%s%sfiles%ssource.txt", appPath, File.separator, File.separator));

		/*
		 * New byte output stream for writing in file result.txt
		 */
		OutputStream resultFile = new FileOutputStream(
				String.format("%s%sfiles%sresult.txt", appPath, File.separator, File.separator));

		/*
		 * Byte array for source.txt content.
		 */
		byte[] sourceInBytes = new byte[sourceFile.available()];

		/*
		 * Reading bytes from source file until it have them.
		 */
		while (sourceFile.available() > 0) {
			sourceFile.read(sourceInBytes);
		}

		/*
		 * Creating new String objects from bytes using UTF-8.
		 */
		String fileContent = new String(sourceInBytes, StandardCharsets.UTF_8);

		/*
		 * Creating new HashMap object which will contain founded in source.txt
		 * file Java's keywords.
		 */
		HashMap<String, Integer> keywords = new HashMap<String, Integer>();

		/*
		 * Using class Util's methods to find keywords.
		 */
		keywords = findKeywordsIterations(fileContent);
		sourceInBytes = saveKeywordsIterations(keywords).toString().getBytes();

		/*
		 * Writing result in file.
		 */
		resultFile.write(sourceInBytes);

		/*
		 * Print result in console.
		 */
		System.out.println(saveKeywordsIterations(keywords).toString());

	}

}
