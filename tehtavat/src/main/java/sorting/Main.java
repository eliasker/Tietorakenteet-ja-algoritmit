package sorting;

import java.util.Random;

public class Main {
  final static int SAMPLE_SIZE = 1000;
  final static int USE_ALGORITHM = 3; // 1, 2, 3

  public static void main(String[] args) {
    int[] numbers = generateSample();
    System.out.println("Initial array");

    switch (USE_ALGORITHM) {
      case 1:
        System.out.println("Select sort");
        selectSort(numbers);
        break;
      case 2:
        System.out.println("Merge sort");
        mergeSort(numbers, 0, numbers.length - 1);
        break;
      case 3:
        System.out.println("Quick sort");
        quickSort(numbers, 0, numbers.length - 1);

        break;
    }

    System.out.println("Done");
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
      for (j = i + 1; j < SAMPLE_SIZE; j++) {
        if (numbers[j] < numbers[smallest]) {
          smallest = j;
        }
      }
      if (smallest != i) {
        temp = numbers[smallest];
        numbers[smallest] = numbers[i];
        numbers[i] = temp;
      }
    }
  }

  public static void mergeSort(int[] numbers, int low, int high) {
    if (high <= low)
      return;

    int mid = (low + high) / 2;
    mergeSort(numbers, low, mid);
    mergeSort(numbers, mid + 1, high);
    merge(numbers, low, mid, high);
  }

  public static void merge(int[] numbers, int low, int mid, int high) {
    int leftArray[] = new int[mid - low + 1];
    int rightArray[] = new int[high - mid];

    for (int i = 0; i < leftArray.length; i++)
      leftArray[i] = numbers[low + i];
    for (int i = 0; i < rightArray.length; i++)
      rightArray[i] = numbers[mid + i + 1];

    int leftIndex = 0;
    int rightIndex = 0;

    for (int i = low; i < high + 1; i++) {
      if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
        if (leftArray[leftIndex] < rightArray[rightIndex]) {
          numbers[i] = leftArray[leftIndex];
          leftIndex++;
        } else {
          numbers[i] = rightArray[rightIndex];
          rightIndex++;
        }
      } else if (leftIndex < leftArray.length) {
        numbers[i] = leftArray[leftIndex];
        leftIndex++;
      } else if (rightIndex < rightArray.length) {
        numbers[i] = rightArray[rightIndex];
        rightIndex++;
      }
    }
  }

  public static void quickSort(int[] numbers, int start, int end) {
    if (start < end) {
      int partitionIndex = partition(numbers, start, end);
      quickSort(numbers, start, partitionIndex - 1);
      quickSort(numbers, partitionIndex + 1, end);
    }
  }

  public static int partition(int[] numbers, int start, int end) {
    int pivot = numbers[end];
    for (int i = start; i < end; i++) {
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