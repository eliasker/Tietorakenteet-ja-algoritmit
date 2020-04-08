package sorting;

import java.util.Random;

public class Main {
  final static int SAMPLE_SIZE = 50;

  public static void main(String[] args) {
    int[] numbers = generateSample();

    printList(numbers);

    System.out.println("\n\n");
    int[] sortedNumbers = selectSort(numbers);
    printList(sortedNumbers);
  }

  public static int[] generateSample() {
    int[] numbers = new int[SAMPLE_SIZE];
    Random r = new Random();
    for (int i = 0; i < SAMPLE_SIZE; i++) {
      numbers[i] = r.nextInt(1000);
    }
    return numbers;
  }

  public static void printList(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      System.out.print(numbers[i] + " ");
      if (i > 0 && i % 20 == 0)
        System.out.println();
    }
  }

  public static int[] selectSort(int[] numbers) {
    int[] sortedNumbers = new int[SAMPLE_SIZE];
    int i, j, k, temp, smallest;
    for (k = 0; k < SAMPLE_SIZE; k++)
      sortedNumbers[k] = numbers[k];

    int[] sorted = numbers;
    for (i = 0; i < SAMPLE_SIZE; i++) {
      smallest = i;
      for (j = i + 1; j < SAMPLE_SIZE; j++) {
        if (sorted[j] < sorted[smallest]) {
          smallest = j;
        }
      }
      if (smallest != i) {
        temp = sorted[smallest];
        sorted[smallest] = sorted[i];
        sorted[i] = temp;
      }
    }
    return sorted;
  }
}