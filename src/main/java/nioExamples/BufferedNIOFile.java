package nioExamples;

import config.Configuration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;

public class BufferedNIOFile {

	public static void main(String[] args) throws IOException{
            Path file= Paths.get(Configuration.getInstance().getProperty("pathFile"));
           
            //Read the file
            //Charset charset = Charset.forName("UTF-8");
            BufferedReader reader=null;

            try{
                //Creates a BufferedReader (java.io) in a more efficient way using Files from java.nio
                reader = Files.newBufferedReader(file);
                //reader = Files.newBufferedReader(file, charset);		
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException x) {
                System.err.format("IOException: %s%n", x);
            }finally {
                if (reader != null) {
                    reader.close();
                }
            }
            // Write into the file    
            String s = "Line written using Files.newBufferedWriter \n" ;
            OpenOption[] options = new OpenOption[2];
            options[0] = TRUNCATE_EXISTING;
            options[1] = WRITE;

            //Creates a BufferedWriter (java.io) in a more efficient way using Files from java.nio
            //try (BufferedWriter writer = Files.newBufferedWriter(file, charset,options)) {
            try (BufferedWriter writer = Files.newBufferedWriter(file, options)) {
                writer.newLine();
                writer.write(s, 0, s.length());
                writer.close();

            } catch (IOException x) {
                    System.err.format("IOException: %s%n", x);
            }
	}

}
