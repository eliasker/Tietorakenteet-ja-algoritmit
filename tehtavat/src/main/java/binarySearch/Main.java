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
    System.out.println("\nTesti:");
    System.out.println("1) Haku avaimella aData: " + sList.find("aData"));
    System.out.println("2) Haku avaimella kolmas: " + sList.find("eka"));
    System.out.println("3) Minimi: " + sList.getMin());
    System.out.println("4) Maksimi: " + sList.getMax());
    System.out.println("5) Listan sisältö:");
    sList.printList();  
  }
}