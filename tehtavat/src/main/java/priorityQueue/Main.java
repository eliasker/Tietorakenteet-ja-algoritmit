package priorityQueue;

import util.Read;

public class Main {
  public static void main(String[] args) {
    PriorityQueue pq = new PriorityQueue();
    String name;
    int priority;
    char input;
    do {
      System.out.println("1) Add item\t2) Print\t3) Remove min\t4) Quit");
      input = Read.character();

      switch (input) {
        case '1':
          System.out.print("Item name: ");
          name = Read.line();
          System.out.print("Item priority: ");
          priority = Read.readInteger();
          pq.insert(new Item(name, priority));
          pq.printPriorityQueue();
          break;
        case '2':
          pq.printPriorityQueue();
          break;
        case '3':
          pq.deleteMin();
          pq.printPriorityQueue();
          break;
      }
      System.out.println();
    } while (input != '4');
  }
}