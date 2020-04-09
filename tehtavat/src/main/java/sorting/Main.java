package sorting;

import util.Logger;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
  final static int SAMPLE_SIZE = 10000;
  final static String[] algorithmNames = { "Select sort", "Merge sort", "Quick Sort" };
  static int counter = 0;

  public static void main(String[] args) {
    Logger.getInstance().write("\n******************************");
    for (int USE_ALGORITHM = 0; USE_ALGORITHM < algorithmNames.length; USE_ALGORITHM++) {
      counter = 0;
      int[] numbers = generateSample();
      System.out.println("\nInitial array generated");
      long startTime = 0;
      long elapsedTime = 0;
      switch (USE_ALGORITHM) {
        case 0:
          startTime = System.nanoTime();
          selectSort(numbers);
          elapsedTime = System.nanoTime() - startTime;
          break;
        case 1:
          startTime = System.nanoTime();
          mergeSort(numbers, 0, numbers.length - 1);
          elapsedTime = System.nanoTime() - startTime;
          break;
        case 2:
          startTime = System.nanoTime();
          quickSort(numbers, 0, numbers.length - 1);
          elapsedTime = System.nanoTime() - startTime;
          break;
      }
      System.out.println("Sorting done with: " + algorithmNames[USE_ALGORITHM]);

      
      Logger.getInstance().write("Sample size: " + SAMPLE_SIZE);
      Logger.getInstance().write("Used algorithm: " + algorithmNames[USE_ALGORITHM]);
      Logger.getInstance().write("It took: " + TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + "ms");
      Logger.getInstance().write("Counter: " + counter);
      Logger.getInstance().write("------------------------------");
    }
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

  public static void selectSort(int[] numbers) {
    int i, j, temp, smallest;

    for (i = 0; i < SAMPLE_SIZE; i++) {
      smallest = i;
      counter++;
      for (j = i + 1; j < SAMPLE_SIZE; j++) {
        counter++;
        if (numbers[j] < numbers[smallest]) {
          smallest = j;
        }
        counter++;
      }
      counter++;
      if (smallest != i) {
        temp = numbers[smallest];
        numbers[smallest] = numbers[i];
        numbers[i] = temp;
      }
    }
  }

  public static void mergeSort(int[] numbers, int low, int high) {
    counter++;
    if (high <= low) {
      return;
    }

    int mid = (low + high) / 2;
    mergeSort(numbers, low, mid);
    mergeSort(numbers, mid + 1, high);
    merge(numbers, low, mid, high);
  }

  public static void merge(int[] numbers, int low, int mid, int high) {
    int leftArray[] = new int[mid - low + 1];
    int rightArray[] = new int[high - mid];

    for (int i = 0; i < leftArray.length; i++) {
      counter++;
      leftArray[i] = numbers[low + i];
    }
    for (int i = 0; i < rightArray.length; i++) {
      counter++;
      rightArray[i] = numbers[mid + i + 1];
    }

    int leftIndex = 0;
    int rightIndex = 0;

    for (int i = low; i < high + 1; i++) {
      counter++;
      if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
        counter++;
        if (leftArray[leftIndex] < rightArray[rightIndex]) {
          numbers[i] = leftArray[leftIndex];
          leftIndex++;
        } else {
          numbers[i] = rightArray[rightIndex];
          rightIndex++;
        }
      } else if (leftIndex < leftArray.length) {
        counter++;
        numbers[i] = leftArray[leftIndex];
        leftIndex++;
      } else if (rightIndex < rightArray.length) {
        counter++;
        numbers[i] = rightArray[rightIndex];
        rightIndex++;
      }
    }
  }

  public static void quickSort(int[] numbers, int start, int end) {
    counter++;
    if (start < end) {
      int partitionIndex = partition(numbers, start, end);
      quickSort(numbers, start, partitionIndex - 1);
      quickSort(numbers, partitionIndex + 1, end);
    }
  }

  public static int partition(int[] numbers, int start, int end) {
    int pivot = numbers[end];
    for (int i = start; i < end; i++) {
      counter++;
      if (numbers[i] < pivot) {
        int temp = numbers[start];
        numbers[start] = numbers[i];
        numbers[i] = temp;
        start++;
      }
    }
    int temp = numbers[start];
    numbers[start] = pivot;
    numbers[end] = temp;

    return start;
  }
}