package org.example;

public class QuickSort {

  // A utility function to swap two elements
  public void swap(int[] arr, int i, int j)
  {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  /* This function takes last element as pivot, places
     the pivot element at its correct position in sorted
     array, and places all smaller (smaller than pivot)
     to left of pivot and all greater elements to right
     of pivot
            arr[] --> Array to be sorted,
            low --> Starting index,
            high --> Ending index
     */
  public int partition(int[] arr, int low, int high)
  {
    // pivot
    int pivot = arr[high]; //choose the last num as the pivot

    /*
    points to the index before the starting index
     */
    int i = low - 1; //
    //loop thru index from low(starting index) to high(ending index)
    for (int j = low; j <= high - 1; j++) {
      // If current element is smaller than the pivot
      if (arr[j] < pivot) {
        // Increment index of smaller element
        i++;
        swap(arr, i, j);//swap the starting index value with the current index val
      }
    }
    swap(arr, i + 1, high);
    return (i + 1);
  }

  /* The main function that implements QuickSort
            arr[] --> Array to be sorted,
            low --> Starting index,
            high --> Ending index
   */
  public void quickSort(int[] arr, int low, int high)
  {
    if (low < high) {

      // pi is partitioning index, arr[p]
      // is now at right place
      int mid = partition(arr, low, high);

      // Separately sort elements before
      // partition and after partition
      //recursive
      quickSort(arr, low, mid -1);
      quickSort(arr, mid + 1, high);
    }
  }

  // Function to print an array
  static void printArray(int[] arr, int size)
  {
    for (int i = 0; i < size; i++)
      System.out.print(arr[i] + " ");

    System.out.println();
  }

  // Driver Code
  public static void main(String[] args)
  {
    QuickSort qs = new QuickSort();
//    int[] arr = { 10, 7, 8, 9, 1, 5 };
    int[] arr = {12, 11, 13, 5, 6, 7};
    int n = arr.length;

    qs.quickSort(arr, 0, n - 1);
    System.out.println("Sorted array: ");
    printArray(arr, n);
  }
}

// This code is contributed by Ayush Choudhary and commented by Caroline Lin