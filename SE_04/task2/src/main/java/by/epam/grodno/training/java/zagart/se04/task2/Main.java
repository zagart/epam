package by.epam.grodno.training.java.zagart.se04.task2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
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
		 * New symbol reader for reading from file source.txt
		 */
		Reader sourceReader = new FileReader(
				String.format("%s%sfiles%ssource.txt", appPath, File.separator, File.separator));

		/*
		 * New symbol writer for writing in file result.txt
		 */
		Writer resultWriter = new FileWriter(
				String.format("%s%sfiles%sresult.txt", appPath, File.separator, File.separator));

		/*
		 * Reading chars from source file and saving them in StringBuilder
		 * object until it have them. Closing FileReader stream for freeing
		 * resources.
		 */
		StringBuilder charsList = new StringBuilder();
		while (sourceReader.ready()) {
			charsList.append((char) sourceReader.read());
		}
		sourceReader.close();

		/*
		 * Search Java's keywords in charList and writing them in result file
		 * using Util's methods. Closing FileWriter stream for freeing
		 * resources.
		 */
		HashMap<String, Integer> keywords = Util.findKeywordsIterations(charsList.toString());
		resultWriter.write(Util.saveKeywordsIterations(keywords).toString());
		resultWriter.close();

	}

}
