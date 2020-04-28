package binarySearch;

import java.util.ArrayList;

public class SortedList {
  private ArrayList<String> list;

  public SortedList() {
    list = new ArrayList<>();
  }

  public void insert(String aData) {
    // TODO: löytyykö avain jo listalta
    list.add(aData);
  }

  public void update(String aData) {
    // TODO: päivitys?
  }

  public String find(String aData) {
    String found = null;
    // TODO: etsintä
    return found;
  }

  public ArrayList<String> getSortedList() {
    return list;
  }
}