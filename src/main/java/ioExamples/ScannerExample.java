/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioExamples;
import config.Configuration;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lucia
 */
public class ScannerExample {
   
// Java Program to illustrate reading from Text File 
// using Scanner Class 
  public static void main(String[] args)
  { 
    // pass the path to the file as a parameter 
    File file = 
      new File(Configuration.getInstance().getProperty("pathFile"));
    Scanner sc; 
      try {
          sc = new Scanner(file);
          while (sc.hasNextLine()) 
                System.out.println(sc.nextLine()); 
      } catch (FileNotFoundException ex) {
          Logger.getLogger(ScannerExample.class.getName()).log(Level.SEVERE, null, ex);
      }
  
    
  } 
}     
