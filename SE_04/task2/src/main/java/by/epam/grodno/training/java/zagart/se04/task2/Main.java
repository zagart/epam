package by.epam.grodno.training.java.zagart.se04.task2;

import static by.epam.grodno.training.java.zagart.se04.task2.Util.findKeywordsIterations;
import static by.epam.grodno.training.java.zagart.se04.task2.Util.saveKeywordsIterations;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
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
		 * New symbol reader for reading from file source.txt
		 */
		Reader sourceReader = new FileReader(
				String.format("%s%sfiles%ssource.txt", appPath, File.separator, File.separator));

		/*
		 * New symbol output stream for writing in file result.txt
		 */
		Writer resultWriter = new FileWriter(
				String.format("%s%sfiles%sresult.txt", appPath, File.separator, File.separator));

		/*
		 * Reading bytes from source file until it have them.
		 */
		
		resultWriter.write('1');
		resultWriter.close();


	}

}
