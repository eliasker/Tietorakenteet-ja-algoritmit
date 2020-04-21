package binaryTree;

import util.Read;

public class Menu {
  public static void main(String[] args) {
    char select;
    BinaryTree tree = new BinaryTree();
    String data;
    do {
      System.out.println("1) Lisää avain\t2) Etsi avaimella\t3) Käy puu läpi esijärjestyksesssä\t4) Lopeta\n");
      select = Read.character();

      switch (select) {
        case '1':
          System.out.println("Lisää uusi avain");
          data = Read.line();
          tree.insert(data);
          break;
        case '2':
          System.out.println("Anna etsittävä avain");
          data = Read.line();
          BinaryTree found = tree.find(data);
          if (found != null)
            System.out.println("Avain löytyi: " + found.getRoot().getData());
          else {
            System.out.println("Ei löytynyt mitään avaimella: " + data);
          }
          break;
        case '3':
          System.out.println("Puu esijärjestyksessä");
          tree.preOrder();
          break;
      }
      System.out.println();
    } while (select != '4');
  }
}