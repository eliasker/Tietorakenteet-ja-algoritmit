package sorting;

import java.util.Random;

public class Main {
  final static int SAMPLE_SIZE = 30000;

  public static void main(String[] args) {
    int[] numbers = generateSample();
  }

  public static int[] generateSample() {
    int[] numbers = new int[SAMPLE_SIZE];
    Random r = new Random();
    for (int i = 0; i < SAMPLE_SIZE; i++) {
      numbers[i] = r.nextInt(1000);
      System.out.print(numbers[i] + " ");
      if (i > 0 && i % 20 == 0)
        System.out.println();
    }

    return numbers;
  }

  // TODO: implement
  public static void selectSort() {

  }
}