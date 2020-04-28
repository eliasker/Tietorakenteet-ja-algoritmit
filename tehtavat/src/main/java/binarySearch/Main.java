package binarySearch;

public class Main {
  public static void main(String[] args) {
    SortedList sList = new SortedList();

    sList.insert("eka");
    sList.insert("toka");
    sList.insert("kolmas");
    sList.insert("neljäs");

    for (String str : sList.getSortedList()) System.out.println(str);
  }
}