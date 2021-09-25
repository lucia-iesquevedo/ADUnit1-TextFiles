/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioExamples;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lucia
 */
public class BufferedIOExample {
  // Java Program to illustrate reading from FileReader 
// using BufferedReader 
 
  public static void main(String[] args)
  { 
  
    File file = new File("TxtFiles/test.txt"); 
  
    // Read from the file
    try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) 
              System.out.println(st); 
    } catch (IOException ex) {
        Logger.getLogger(BufferedIOExample.class.getName()).log(Level.SEVERE, null, ex);
    }

    // Write into the file (Appending)
    try (FileWriter writer = new FileWriter(file, true);  //the true will append the new data
           BufferedWriter bw = new BufferedWriter(writer)) {
        String content = "Line written with a BufferedWriter\n";
        bw.write(content);

      } catch (IOException e) {
              System.err.format("IOException: %s%n", e);
      }
  } 
}   