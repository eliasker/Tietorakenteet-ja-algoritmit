package queue;

import util.Read;

public class App {
  public static void main(String[] args) {
    printMenu();
  }

  private static void printMenu() {
    char select;
    Queue q = new Queue();
    String data;
    do {
      System.out.println("1\tLisää alkio");
      System.out.println("2\tPoista alkio");
      System.out.println("3\tJonon sisältö");
      System.out.println("4\tAlkioiden lukumäärä");
      System.out.println("5\tLopeta");
      System.out.println("\n");
      select = Read.character();
      switch (select) {
        case '1':
          System.out.println("Annan alkion sisältö (merkkijono)");
          data = new String(Read.line());
          q.enqueue(data);
          break;
        case '2':
          QueueItem item = q.dequeue();
          if (item == null)
            System.out.println("Jono on tyhjä");
          else
            System.out.println("Poistettu alkio: " + item.getData());
          break;
        case '3':
          q.printItems();
          break;
        case '4':
          System.out.println("Lukumäärä = " + q.getSize());
          break;
        case '5':
          break;
      }
    } while (select != '5');
  }
}