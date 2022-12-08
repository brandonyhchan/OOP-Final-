package org.example;

/* Java program for Merge Sort */
// https://www.geeksforgeeks.org/merge-sort/
public class MergeSort {
  // Merges two subarrays of arr[].
  // First subarray is arr[l..m]
  // Second subarray is arr[m+1..r]
  public void merge(int arr[], int l, int m, int r)
  {
    // Find sizes of two subarrays to be merged
    int sub1Len = m - l + 1; //2-4, 4-2+1=3
    int sub2Len = r - (m + 1) + 1;

    /* Create temp arrays */
    int[] left = new int[sub1Len];
    int[] right = new int[sub2Len];

    /*Copy data to temp arrays*/
    for (int i = 0; i < sub1Len; i++) {
      left[i] = arr[i + l];//+ l because that's the start of this piece of array
    }

    for (int i = 0; i < sub2Len; i++) {
      right[i] = arr[i + (m + 1)];
    }


    /* Merge the temp arrays */

    // Initial indexes of first and second subarrays
    // TODO: fill this in
    //if left[0] < right[0], add left[0] to arr[0]
    //move left[0] to [1], arr[0] to [1]
    //compare left[1] to right[0].....
    int leftI = 0;
    int rightI = 0;
    int arrI = l;//set to l because that's the start of this piece of array

    while (leftI < sub1Len && rightI < sub2Len) {
      if (left[leftI] < right[rightI]) {
        arr[arrI] = left[leftI];
        leftI++;
      } else {
        arr[arrI] = right[rightI];
        rightI++;
      }
      arrI++;
    }

    // Initial index of merged subarray array
    // TODO: fill this in

    /* Copy remaining elements of L[] if any */
    while (leftI < sub1Len) {
      arr[arrI] = left[leftI];
      leftI++;
      arrI++;
    }

    /* Copy remaining elements of R[] if any */
    while (rightI < sub2Len) {
      arr[arrI] = right[rightI];
      rightI++;
      arrI++;
    }
  }



  // Main function that sorts arr[l..r] using
  // merge()
  void sort(int arr[], int l, int r)
  {
    if (l < r) {
      // Find the middle point
      int mid = (l + r) / 2;

      // Sort first and second halves
      //recursive on the left
      //recursive on the right
      sort(arr, l, mid);
      sort(arr, mid + 1, r);

      // Merge the sorted halves
      merge(arr, l, mid, r);
    }
  }

  /* A utility function to print array of size n */
  static void printArray(int arr[])
  {
    int n = arr.length;
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  // Driver code
  public static void main(String args[])
  {
    int arr[] = { 12, 11, 13, 5, 6, 7 };

    System.out.println("Given Array");
    printArray(arr);

    MergeSort ob = new MergeSort();
    ob.sort(arr, 0, arr.length - 1);

    System.out.println("\nSorted array");
    printArray(arr);
  }
}
/* This code is contributed by Rajat Mishra and commented by Caroline Lin */