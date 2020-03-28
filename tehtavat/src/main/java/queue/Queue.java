package queue;

public class Queue {
  QueueItem first;
  QueueItem last;
  int length;

  public void enqueue(String aData) {
    QueueItem newItem = new QueueItem();
    newItem.setData(aData);
    if (first == null) {
      first = newItem;
      last = newItem;
    } else {
      last.setNext(newItem);
      last = newItem;
    }
    length++;
  }

  public QueueItem dequeue() {
    if (first == null)
      return null;
    QueueItem next = first.getNext();
    QueueItem current = first;
    first = next;
    length--;
    return current;
  }

  public void printItems() {
    QueueItem curr = first;
    while (curr != null) {
      System.out.println(curr.getData());
      curr = curr.getNext();
    }
  }

  public int getSize() {
    return this.length;
  }
}