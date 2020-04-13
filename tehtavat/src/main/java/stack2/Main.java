package stack2;

import java.util.*;
import util.Read;

public class Main {
  public static void main(String[] args) {
    char select;
    Stack s = new Stack();
    String data;
    do {
      System.out.println("1 Lisää alkio \t 2 Poista alkio \t 3 Pinon sisältö \t 4 Alkioiden lkm \t 5 Lopeta");
      System.out.println("\n");
      select = Read.character();
      switch (select) {
        case '1':
          System.out.println("Annan alkion sisältö (merkkijono)");
          data = new String(Read.line());
          s.push(data);
          break;
        case '2':
          String item = s.pop();
          if (item == null)
            System.out.println("Pino on tyhjä");
          else
            System.out.println("Poistettu alkio: " + item);
          break;
        case '3':
          s.printItems();
          break;
        case '4':
          System.out.println("Lukumäärä = " + s.getSize());
          break;
        case '5':
          break;
      }
    } while (select != '5');
  }

  public static class Stack {
    private LinkedList<String> list;

    public Stack() {
      list = new LinkedList<String>();
    }

    public void push(String data) {
      list.addFirst(data);
    }

    public String pop() {
      return list.pop();
    }

    public void printItems() {
      Iterator<String> iter = list.iterator();
      while (iter.hasNext()) {
        System.out.println(iter.next());
      }
    }

    public int getSize() {
      return list.size();
    }
  }
}