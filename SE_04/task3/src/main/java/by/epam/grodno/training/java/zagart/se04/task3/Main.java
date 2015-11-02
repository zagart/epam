package by.epam.grodno.training.java.zagart.se04.task3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.io.FileUtils;

/*
 * Main class with enter point.
 */
public class Main {

	/*
	 * Enter point of the application.
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * Get application path.
		 */
		String appPath = new File(".").getCanonicalPath();

		/*
		 * Binding file source.txt to File object.
		 */
		File sourceFile = new File(String.format("%s%sfiles%ssource.txt", appPath, File.separator, File.separator));

		/*
		 * Reading file and saving it in String format. After we convert it to
		 * bytes and again into String, but using UTF-8 (just in case it was not
		 * UTF-8). All done with help of Apache's libraries.
		 */
		String sourceUTF8 = FileUtils.readFileToString(sourceFile);
		StringUtils.newStringUtf8(sourceUTF8.getBytes("UTF-8"));

		/*
		 * New output stream for writing in file result.txt
		 */
		@SuppressWarnings("resource")
		OutputStream resultFile = new FileOutputStream(
				String.format("%s%sfiles%sresult.txt", appPath, File.separator, File.separator));
		
		/*
		 * Saving result to file in UTF-16.
		 */
		resultFile.write(sourceUTF8.getBytes("UTF-16"));

	}

}
