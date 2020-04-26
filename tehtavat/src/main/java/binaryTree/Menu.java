package binaryTree;

import util.Read;

public class Menu {
  public static void main(String[] args) {
    char select;
    BinaryTree tree = new BinaryTree();
    String data;
    do {
      System.out.println("1) Lisää avain\t2) Etsi avaimella\t3) Esijärjestys\n"+
      "4) Poista avain\t5) Korkeus avaimesta alkaen\t6) Lopeta");
      select = Read.character();

      switch (select) {
        case '1':
          System.out.println("1) Lisää uusi avain");
          data = Read.line();
          tree.insert(data);
          break;
        case '2':
          System.out.println("2) Anna etsittävä avain");
          data = Read.line();
          BinaryTree found = tree.find(data);
          if (found != null)
            System.out.println("Avain löytyi: " + found.getRoot().getData());
          else {
            System.out.println("Ei löytynyt mitään avaimella: " + data);
          }
          break;
        case '3':
          System.out.println("3) Puu esijärjestyksessä:");
          tree.preOrder();
          break;
        case '4':
          System.out.println("4) Syötä poistettava:");
          data = Read.line();
          tree.deleteNode(data);
          break;
        case '5':
          System.out.println("5) Syötä aloitussolmu:");
          data = Read.line();
          tree.getHeight(data);
          break;
      }
      System.out.println();
    } while (select != '6');
  }
}