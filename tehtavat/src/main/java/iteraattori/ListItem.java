package iteraattori;

/**
 * @author kamaj
 */
public class ListItem {

  private String data;
  private ListItem next;

  public ListItem() {
    next = null;
  }

  public String getData() {
    return data;
  }

  public void setData(String aData) {
    data = aData;
  }

  public void setLink(ListItem aNext) {
    next = aNext;
  }

  public ListItem getLink() {
    return next;
  }
}