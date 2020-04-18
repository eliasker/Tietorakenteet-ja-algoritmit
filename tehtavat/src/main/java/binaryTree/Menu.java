package binaryTree;

import util.Read;

public class Menu {
  public static void main(String[] args) {
    printMenu();
  }

  private static void printMenu() {
    char select;
    BinaryTree tree = null;
    String data;
    do {
      System.out.println("1) Lisää avain\t2) Etsi avaimella\t3) Käy puu läpi esijärjestyksesssä\t4) Lopeta\n");
      select = Read.character();
    } while (select != '4');
  }
}