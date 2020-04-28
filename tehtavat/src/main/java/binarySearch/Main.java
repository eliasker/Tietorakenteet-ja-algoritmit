package binarySearch;

public class Main {
  public static void main(String[] args) {
    SortedList sList = new SortedList();

    test(sList);
    sList.insert("eka");
    sList.insert("toka");
    sList.insert("kolmas");
    test(sList);

    sList.insert("aData");
    test(sList);
  }

  static void test(SortedList sList) {
    System.out.println("\nTestit:");
    System.out.println("Haku avaimella aData: " + sList.find("aData"));
    System.out.println("Haku avaimella kolmas: " + sList.find("eka"));
    System.out.println("Minimi: " + sList.getMin());
    System.out.println("Maksimi: " + sList.getMax());
    System.out.println("Listan sisältö:");
    for (String str : sList.getSortedList()) System.out.println(str);
  }
}