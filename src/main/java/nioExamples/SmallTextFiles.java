package nioExamples;

import config.Configuration;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.function.Consumer;

public class SmallTextFiles {

    public static void main(String[] args) {
        Path file = Paths.get(Configuration.getInstance().getProperty("pathFile"));

        //List of string to store the lines of the file
        List<String> fileList;

        try {

            //Reading the whole file using java.nio
            fileList = Files.readAllLines(file);
            System.out.println(fileList);

            fileList.forEach((linea) -> {
                System.out.println(linea);});
            //Writing the whole array in a new file named output.txt using java.nio
            //The method write() ensures that the file is closed when all the bytes 
            //have been written and returns the path of written file.
            
            //Files.write(output, fileList);  //No appending

            //Adding a new line at the end
            String line="Line written with Files.write \n";
            Files.write(file, line.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException io) {
            System.err.println(io);
        }
    }

}
