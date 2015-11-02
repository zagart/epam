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
		InputStream sourceStream = new FileInputStream(
				String.format("%s%sfiles%ssource.txt", appPath, File.separator, File.separator));

		/*
		 * New byte output stream for writing in file result.txt
		 */
		OutputStream resultStream = new FileOutputStream(
				String.format("%s%sfiles%sresult.txt", appPath, File.separator, File.separator));

		/*
		 * Byte array for source.txt content.
		 */
		byte[] sourceInBytes = new byte[sourceStream.available()];

		/*
		 * Reading bytes from source file until it have them and instantly
		 * closing FileInputStream for freeing resources.
		 */
		while (sourceStream.available() > 0) {
			sourceStream.read(sourceInBytes);
		}
		sourceStream.close();

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
		 * Writing result in file and closing FileOutputStream stream for
		 * freeing resources.
		 */
		resultStream.write(sourceInBytes);
		resultStream.close();

		/*
		 * Print result in console.
		 */
		System.out.println(saveKeywordsIterations(keywords).toString());

	}

}
