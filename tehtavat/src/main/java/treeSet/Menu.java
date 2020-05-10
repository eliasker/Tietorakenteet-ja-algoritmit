package treeSet;

import util.Read;
import java.util.TreeSet;
import java.util.Iterator;

public class Menu {
  public static void main(String[] args) {
    char select;
    TreeSet<Integer> tree = new TreeSet<Integer>();
    String data;
    do {
      System.out.println(
          "1) Lisää avain\t2) Etsi avaimella\t3) Esijärjestys\n" + "4) Poista avain\t5) Lopeta");
      select = Read.character();

      switch (select) {
        case '1':
          System.out.println("1) Lisää uusi avain");
          data = Read.line();
          tree.add(Integer.parseInt(data));
          break;
        case '2':
          System.out.println("2) Anna etsittävä avain");
          data = Read.line();
          if (tree.contains(Integer.parseInt(data)))
            System.out.println("Avain löytyi");
          else {
            System.out.println("Ei löytynyt mitään avaimella: " + data);
          }
          break;
        case '3':
          System.out.println("3) Puu esijärjestyksessä:");
          Iterator<Integer> iterator = tree.iterator();
          while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
          }
          break;
        case '4':
          System.out.println("5) Syötä poistettava:");
          data = Read.line();
          tree.remove(Integer.parseInt(data));
          break;
      }
      System.out.println();
    } while (select != '5');
  }
}