package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    case2();
  }

  static void case1() {
    SortedList sList = new SortedList();
    test(sList);
    sList.insert("eka");
    sList.insert("toka");
    sList.insert("kolmas");
    test(sList);

    sList.insert("aData");
    test(sList);
  }

  static void case2() {
    ArrayList<String> initialKeys = new ArrayList<String>(Arrays.asList(
      "eka", "toka", "kolmas", "neljäs"
    ));
    SortedList sList = new SortedList(initialKeys);
    test(sList);
    sList.insert("aData");
    test(sList);
  }

  static void test(SortedList sList) {
    System.out.println("\nTesti:");
    System.out.println("1) Haku avaimella aData: " + sList.find("aData"));
    System.out.println("2) Haku avaimella eka: " + sList.find("eka"));
    System.out.println("3) Minimi: " + sList.getMin());
    System.out.println("4) Maksimi: " + sList.getMax());
    System.out.println("5) Listan sisältö:");
    sList.printList();  
  }
}