package iteraattori;

interface Iterator {
  boolean hasNext();

  Object next();
}

public class StackIterator implements Iterator {
  private ListItem current;
  private Stack container;

  StackIterator(Stack c) {
    container = c;
    current = container.top;
  }

  public boolean hasNext() {
    if (current == null)
      return false;
    else
      return true;
  }

  public ListItem next() {
    ListItem oldCurrent = current;
    current = current.getLink();
    return oldCurrent;
  }
}