package stack;

import util.Read;

public class App {
  public static void main(String[] args) {
    printMenu();
  }

  private static void printMenu() {
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
          ListItem item = s.pop();
          if (item == null)
            System.out.println("Pino on tyhjä");
          else
            System.out.println("Poistettu alkio: " + item.getData());
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
}