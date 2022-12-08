package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MapReduce {

    public static void main(String[] args) {
      // example1();
      // example2();
      // example3();
      // example4();
      // example5();
      // example6();
      // example7();
      // example8();
      // example9(); - .map() ex.
      // example10(); - .map() ex.
    }

    static void example1() {
      // Create an ArrayList
      List<Integer> myList = new ArrayList<Integer>();
      myList.add(1);
      myList.add(5);
      myList.add(8);

      // Convert it into a Stream
      Stream<Integer> myStream = myList.stream();

      // Print the contents of the stream
      myStream.forEach(e -> System.out.println(e));
    }

    static void example2() {
      // Create an array
      Integer[] myArray = {1, 5, 8};

      // Convert it into a Stream
      Stream<Integer> myStream = Arrays.stream(myArray);

      // Print the contents of the stream
      myStream.forEach(e -> System.out.println(e));
    }

    static void example3() {
      String[] myArray = new String[]{"bob", "alice", "paul", "ellie"};
      Stream<String> myStream = Arrays.stream(myArray);

      Stream<String> myNewStream =
              myStream.map(s -> s.toUpperCase());

      String[] myNewArray =
              myNewStream.toArray(String[]::new);

      // Print the contents of the new array
      for(String s:myNewArray)
        System.out.println(s);
    }

    static void example4() {
      String[] myArray = new String[]{"bob", "alice", "paul", "ellie"};

      String[] myNewArray = Arrays.stream(myArray)
              .filter(s -> s.length() > 4)
              .toArray(String[]::new);

      // Print the contents of the new array
      for(String s:myNewArray)
        System.out.println(s);
    }

    static void example5() {
      int myArray[] = { 1, 5, 8 };
      int sum = Arrays.stream(myArray).sum();

      // Print the sum
      System.out.println(sum);
    }

    static void example6() {
      String[] myArray = { "this", "is", "a", "sentence" };
      String result = Arrays.stream(myArray)
              .reduce("", (a,b) -> a + b);

      // reduce has 2 parameters: identity and accumulator
      // identity is a default value, so if the stream is null, the method will return the identity.
      // accumulator is a lambda function that has conditions to perform reduction

      // Print the result
      System.out.println(result);
    }

    static void example7() {
      int[] test = {1, 2, 4, 6, 10, 12, 23};
      int result = Arrays.stream(test).reduce(0, Integer::max);
      // Double colon operator calls a method by referring to it with the help of its class directly
      System.out.println(result);
    }

    static void example8() {
      Integer[] values = new Integer[] {3 , 4, 7, 8, 11, 23};
      List<Integer> asList = Arrays.asList(values);
      int result = asList.stream().reduce(0, (max , current) -> {
        if (current > max) {
          max = current;
        }
        return max;
      });
      System.out.println("Max number is "+ result);
    }

    static void example9() {
      //prints the square of each element n
      List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
      list.stream().map(n -> n * n).forEach(System.out::println);
    }

    static void example10() {
      //multiplies each element by 5 and saves it into the newList
      List<Integer> newList = new ArrayList<Integer>();
      List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
      list.stream().map(n -> newList.add(n * 5));
    }

  }

