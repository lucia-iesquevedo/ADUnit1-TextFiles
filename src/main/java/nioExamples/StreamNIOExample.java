package nioExamples;

import config.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StreamNIOExample {
	
	public static void main(String[] args) {
		Path input = Paths.get(Configuration.getInstance().getProperty("pathFile"));
		Path output = Paths.get(Configuration.getInstance().getProperty("outputFile"));
		
		InputStream istream=null;
		OutputStream ostream=null;
		int c;
		try {
			//InputStream y OutputStream from java.io works with the file byte by byte
			//java.nio allows to work with these classes in a more efficient way
			istream = Files.newInputStream(input);
			ostream = Files.newOutputStream(output);
			
                        while ((c = istream.read()) != -1) {
				//Writing all bytes in a new file named output3.txt
				ostream.write(c);
			}
			istream.close();
			ostream.close();
		} catch (IOException io) {
			System.err.println(io);
		}
	}

}
