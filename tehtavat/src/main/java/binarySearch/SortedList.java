package binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedList {
  private ArrayList<String> list;

  public SortedList() {
    list = new ArrayList<>();
  }

  /**
   * Avain lisätään listalle, jos sitä ei esiinny listalla
   * eli find(key) == null
   * Lista järjestetään JAVAn Collections API:n sort() -metodilla
   * @param key Lisättävä avain
   */
  public void insert(String key) {
    System.out.println("\nLisätään avain: " + key);
    if (find(key) == null) {
      list.add(key);
      Collections.sort(list);
      System.out.println("Lisätty");
    } else {
      System.out.println("Avain löytyy jo listalta.\n");
    }
  }

  /**
   * Mikäli listalla ei ole jäseniä palauttaa nullin
   * Käynnistää rekursion
   * @param key
   * @return Rekursiivisen binäärihakufunktion tulos || null
   */
  public String find(String key) {
    if (list.size() == 0) return null;

    return findRecursion(list, key, 0, list.size() - 1);
  }

  /**
   * Binäärihaku
   * @param array Tutkittava lista
   * @param key Haettava arvo
   * @param start Lähtöindeksi
   * @param end Loppuindeksi
   * @return
   */
  private String findRecursion(List<String> array, String key, int start, int end) {
    int middle = (start + end) / 2;
    if (end < start) return null;

    String middleKey = array.get(middle);
    int comparisonValue = key.compareTo(middleKey);
    if (comparisonValue < 0) return findRecursion(array, key, start, middle - 1);
    if (comparisonValue > 0) return findRecursion(array, key, middle + 1, end);
    return middleKey;
  }

  /**
   * Tyhjä lista palauttaa nullin, muuten listan ensimmäinen eli minimi
   * @return null tai listan minimiarvo
   */
  public String getMin() {
    return list.size() == 0 ? null: list.get(0);
  }

  /**
   * Tyhjä lista palauttaa nullin, muuten listan viimeinen eli maksimi
   * @return null tai listan maksimiarvo
   */
  public String getMax() {
    return list.size() == 0 ? null : list.get(list.size() - 1);
  }

  /**
   * Tulostaa listan
  */
  public void printList() {
    if (list.size() == 0) System.out.println("Tyhjä lista");
    else for (String str : list) System.out.println(str);
  }
}