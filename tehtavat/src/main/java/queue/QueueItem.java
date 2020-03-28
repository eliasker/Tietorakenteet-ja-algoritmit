package queue;

public class QueueItem {
  private String data;
  private QueueItem next;

  public QueueItem() {
    next = null;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getData() {
    return this.data;
  }

  public void setNext(QueueItem next) {
    this.next = next;
  }

  public QueueItem getNext() {
    return this.next;
  }
}