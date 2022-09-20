/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioExamples;
import config.Configuration;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lucia
 */
public class StreamIOExample {
    public static void main(String[] args) {
        File file = new File(Configuration.getInstance().getProperty("pathFile"));

        //Read from a file
        try (InputStream in = new FileInputStream(file)) {
                int content;
                while ((content = in.read()) != -1) {
                        System.out.print((char)content);
                }
        } catch (Exception ex) {
                Logger.getLogger(ScannerExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Write into a file (Appending)
       try (OutputStream os = new FileOutputStream(file, true)){
            String s = "Line written with a FileOutputStream\n"; 
            // Writes bytes from the specified byte array to this file output stream 
            os.write(s.getBytes());
 
        }
        catch (IOException ioe) {
            System.out.println("Exception while writing file " + ioe);
        }
    }
}
