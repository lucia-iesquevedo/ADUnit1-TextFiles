package nioExamples;

import config.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SmallBinaryFiles {

	public static void main(String[] args) {
		Path file = Paths.get(Configuration.getInstance().getProperty("pathFile"));

		//Array of bytes for storing all the bytes from the file
		byte[] fileArray;
		try {
                    //Reading the whole file using java.nio
                    fileArray = Files.readAllBytes(file);
                    System.out.println(fileArray);

                    //Writing the whole array in a new file named output.txt using java.nio
                    //The method write() ensures that the file is closed when all the bytes 
                    //have been written and returns the path of written file.
                    // Files.write(file, fileArray);
                    //Adding a new line at the end
                    String line="Line written with Files.write \n";
                    Files.write(file, line.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException io) {
			System.err.println(io);
		}
	}

}
