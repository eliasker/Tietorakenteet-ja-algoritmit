package binarySearch;

public class Main {
  public static void main(String[] args) {
    SortedList sList = new SortedList();

    sList.insert("eka");
    sList.insert("toka");
    sList.insert("kolmas");
    sList.insert("neljäs");
    sList.insert("viides");
    sList.insert("kuudes");
    sList.insert("seitsemäs");
    sList.insert("seitsemäs"); // duplikaatti avainten lisäys ei onnistu

    System.out.println("Etsitään avaimella aData, tulos: " + sList.find("aData"));
    System.out.println("Etsitään avaimella kolmas, tulos: " + sList.find("eka"));
  }
}