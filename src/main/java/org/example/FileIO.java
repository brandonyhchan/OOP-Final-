package org.example;

import java.io.*;
import java.util.ArrayList;

public class FileIO {

  //reads a text file character by character and returns a string of all characters.
  public String readFile(String path) {
    FileInputStream inFile;
    try {
      ArrayList<Byte> contents = new ArrayList<Byte>();
      inFile = new FileInputStream(path);
      int character;
      //inFile.read() extracts a single character at a time, like fgetc in c
      while ((character = inFile.read()) != -1) {
        contents.add((byte) character);
      }
      inFile.close();

      //saves all the characters of content arraylist into an array
      byte[] byteArray = new byte[contents.size()];
      int i = 0;
      for (Byte b : contents) {
        byteArray[i] = b;
        i++;
      }
      // turns array into a string
      String s = new String(byteArray);
      System.out.println(s);

      //returns the string
      return s;
    } catch (FileNotFoundException e) {
      System.out.println(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return null;
  }

  // writes each character (byte) from the contents arraylist into the outfile
  public void writeFile(String path, String content) {
    try {
      FileOutputStream outFile = new FileOutputStream(path);
      for (Byte b : content.getBytes()) {
        outFile.write(b);
      }
      outFile.close();
    } catch (FileNotFoundException e) {
      System.out.println(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
