package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Logger class that can be used to write and read lines to/from a log -file
 * @author Elias Keränen
 */
public class Logger {
  private String PATH;
  private static Logger INSTANCE;

  /**
   * Private Logger constructor. Tries to find or create "logs.txt" -file by
   * comparing temp -file exists in same directory as Logger.java. If not
   * "logs.txt" -file is created
   */
  private Logger() {
    String filename = "logs.txt";
    PATH = System.getProperty("user.dir") + "\\logs\\" + filename;
    File temp = new File(PATH);
    if (temp.exists()) {
      System.out.println("Found logs.txt -file");
    } else {
      System.out.println("Couldn't find path to resource, creating new log file");
      try {
        temp.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static Logger getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Logger();
    }
    return INSTANCE;
  }

  public void write(String log) {
    System.out.println("Writing to logs.txt: " + log);
    BufferedWriter writer;
    try {
      writer = new BufferedWriter(new FileWriter(PATH, true));
      writer.write(log);
      writer.newLine();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void read() {
    System.out.println("Content of logs.txt:");
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader(PATH));
      String line = reader.readLine();
      while (line != null) {
        System.out.println(line);
        line = reader.readLine();
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}