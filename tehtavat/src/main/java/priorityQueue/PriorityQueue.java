package priorityQueue;

public class PriorityQueue {
  private Item min = null;

  public PriorityQueue() {

  }

  public void insert(Item item) {
    if (min == null)
      min = item;
    else {
      Item current = min;
      if (current.getPriority() > item.getPriority()) {
        item.setNext(current);
        min = item;
      } else {
        current = min;
        while (current != null) {
          if (current.getNext() == null) {
            current.setNext(item);
            break;
          }
          if (current.getNext().getPriority() >= item.getPriority()) {
            item.setNext(current.getNext());            
            current.setNext(item);
            break;
          }
          current = current.getNext();
        }
      }
    }
  }

  public void deleteMin() {
    System.out.println("Deleting minimum item");
    if (min.getNext() == null) min = null;
    else min = min.getNext();
  }

  public void printPriorityQueue() {

    if (min == null)
      System.out.println("Priority queue is empty");
    else {
      Item current = min;
      String listed = "\nPriority queue min -> max: ";
      while (current != null) {
        listed += current.getName() + ", ";
        current = current.getNext();
      }
      System.out.println(listed);
    }
  }
}