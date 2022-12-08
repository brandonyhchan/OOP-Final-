package org.example;// Java program for implementation of Bubble Sort

class BubbleSort {

  /*
  bubble sort sorts by two nums
  e.g. 54231, (45)231, 4(25)31, 42(35)1, 423(15)
  (24)315, 2(34)15, 23(14)5, 231(45)
  (23)145, 2(13)45, 21(34)5, 213(45)
  (12)345, 1(23)45, 12(34)5, 123(45)
   */

  void bubbleSort(int arr[])
  {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++)
      for (int j = 0; j < n - i - 1; j++)
        if (arr[j] > arr[j + 1]) {
          // swap arr[j+1] and arr[j]
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
  }

  /* Prints the array */
  void printArray(int arr[])
  {
    int n = arr.length;
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  // Driver method to test above
  public static void main(String args[])
  {
    BubbleSort ob = new BubbleSort();
    int arr[] = { 5, 1, 4, 2, 8 };
    ob.bubbleSort(arr);
    System.out.println("Sorted array");
    ob.printArray(arr);
  }
}
/* This code is contributed by Rajat Mishra and commented by Caroline Lin */
