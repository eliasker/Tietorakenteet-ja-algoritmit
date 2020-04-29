package priorityQueue;

public class Item {
  private Item next = null;
  private Item prev = null;
  private String name;
  private int priority;

  public Item(String name, int priority) {
    this.name = name;
    this.priority = priority;
  }

  public void setNext(Item next) {
    this.next = next;
  }

  public void setPrev(Item prev) {
    this.prev = prev;
  }

  public Item getNext() {
    return next;
  }

  public Item getPrev() {
    return prev;
  }

  public String getName() {
    return name;
  }

  public int getPriority() {
    return priority;
  }
}