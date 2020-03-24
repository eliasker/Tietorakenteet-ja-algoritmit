package stack;

import java.io.*;

public class Read {
  static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

  public static String line() {
    String value = null;
    boolean ok;
    do {
      try {
        value = stdin.readLine();
        ok = true;
      } catch (Exception e) {
        System.out.println("Virhe rivin lukemisessa. Yritä uudestaan.");
        ok = false;
      }
    } while (!ok);
    return value;
  }

  public static int readInteger() {
    int value = -1;
    boolean ok;
    do {
      try {
        value = Integer.parseInt(stdin.readLine());
        ok = true;
      } catch (Exception e) {
        System.out.println("Ei kokonaisluku. Yritä uudestaan.");
        ok = false;
      }
    } while (!ok);
    return value;
  }

  public static double readDouble() {
    double value = -1;
    boolean ok;
    do {
      try {
        value = new Double(stdin.readLine()).doubleValue();
        ok = true;
      } catch (Exception e) {
        System.out.println("Ei desimaaliluku. Yritä uudestaan.");
        ok = false;
      }
    } while (!ok);
    return value;
  }

  public static char character() {
    String line = line();
    try {
      return line.charAt(0);
    } catch (Exception e) {
      return ' ';
    }
  }
}
