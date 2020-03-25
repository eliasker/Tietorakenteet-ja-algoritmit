package stack;

public class Stack {
  private ListItem top;
  private int size;

  public void push(String aData) {
    ListItem newItem = new ListItem();
    newItem.setData(aData);
    newItem.setNext(top);
    top = newItem;
    size++;
  }

  public ListItem pop() {
    if (top == null)
      return null;
    ListItem newTop = top.getNext();
    ListItem currItem = top;
    top = newTop;
    size--;
    return currItem;
  }

  public void printItems() {
    ListItem curr = top;
    while (curr != null) {
      System.out.println(curr.getData());
      curr = curr.getNext();
    }
  }

  public int getSize() {
    return size;
  }
}
