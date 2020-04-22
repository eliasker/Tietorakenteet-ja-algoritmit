package iteraattori;

import java.util.*;
import util.Read;

public class Main {
  public static void main(String[] args) {
    printMenu();
  }

  private static void printMenu() {
    char select;
    // Stack s = new Stack();
    LinkedList<ListItem> s = new LinkedList<>();
    String data;
    do {
      System.out.println("\n\t\t\t1. Alkion lisääminen.");
      System.out.println("\t\t\t2. Alkion poistaminen.");
      System.out.println("\t\t\t3. Pinon sisältö.");
      System.out.println("\t\t\t4. Alkioiden lukumäärä.");
      System.out.println("\t\t\t5. Pinon sisältö iteraattorilla selattuna.");
      System.out.println("\t\t\t6. lopetus ");
      System.out.print("\n\n");
      select = Read.character();
      switch (select) {
        case '1':
          System.out.println("Anna alkion sisältö (merkkijono)");
          data = new String(Read.line());
          s.push(new ListItem(data));
          break;
        case '2':
          ListItem item = s.pop();
          if (item == null)
            System.out.println("Pino on tyhjä");
          else
            System.out.println("Poistettu alkio: " + item.getData());
          break;
        case '3':
          for (ListItem i : s) {
            System.out.println(i.getData());
          }
          break;
        case '4':
          System.out.println("Lukumäärä = " + s.size());
          break;
        case '5':
          System.out.println("Iteroidaan");
          ListIterator<ListItem> listIter = s.listIterator();
          while (listIter.hasNext()) {
            String temp = listIter.next().getData();
            System.out.println(temp);
          }
          break;
        case '6':
          break;
      }
    } while (select != '6');
  }
}
