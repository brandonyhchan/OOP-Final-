package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class AnonymousFunction {
    // stream -> takes the input "array" and allows operation on each of the elements, similar to a for each loop.
    // map -> does the operation inside the parameter to each element in the stream
    // filter -> returns a list that satisfies the condition in the param
    // collect -> 'converts' the stream back into a list/ arraylist data structure

    public static List<Integer> addOne (List<Integer> list) {
      // TODO: Make an addOne function using map
      return list.stream().map(n -> n+1).collect(Collectors.toList()); // Stub
    }

    public static int add(int a, int b) {
      return a + b;
    }

    public static List<Integer> filterEven (List<Integer> list) {
      // TODO: Make an filterEven function using filter

      return list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList()); // Stub
    }

    public static List<Integer> filterAndAdd (List<Integer> list) {
      // TODO: Make an filterandAdd function using map and filter

      return list.stream().filter(n -> n % 2 == 0).map(n -> n+ 1).collect(Collectors.toList()); // Stub
    }

    public static void main(String[] args) {
      System.out.println("\nSquares: int -> int");
      List<Integer> list1 = Arrays.asList(0, 1, 2, 3, 4);
      List<Integer> list2 = list1.stream().map((n) -> n * n).toList();
      System.out.println(list1);
      System.out.println(list2);

      System.out.println("\nChars from string: int -> string");
      List<Integer> list3 = Arrays.asList(0, 1, 2, 3, 4);
      List<Character> list4 = list3.stream().map((n) -> {
        String s = "Hello!";
        return s.charAt(n);
      }).toList();
      System.out.println(list3);
      System.out.println(list4);

      System.out.println("\nOdds only: int -> int");
      List<Integer> list5 = Arrays.asList(0, 1, 2, 3, 4);
      List<Integer> list6 = list1.stream().filter((n) -> n % 2 > 0).toList();
      System.out.println(list5);
      System.out.println(list6);

      System.out.println("\nFilter then map: int -> int");
      List<Integer> list7 = Arrays.asList(0, 1, 2, 3, 4);
      List<Integer> list8 = list1.stream()
              .filter((n) -> n % 2 > 0)
              .map((n) -> n * n)
              .collect(Collectors.toList());
      System.out.println(list7);
      System.out.println(list8);

      System.out.println("\nDictionary operations: {Dict} -> {Dict}");
      List<Dictionary> data = new ArrayList<>();
      Dictionary p1 = new Hashtable();
      p1.put("name", "paul");
      p1.put("age", 34);

      Dictionary p2 = new Hashtable();
      p2.put("name", "aman");
      p2.put("age", 22);

      data.add(p1);
      data.add(p2);

      List<Dictionary> data_out = data.stream()
              .filter((d) -> (int) d.get("age") > 25)
              .map((d) -> {
                d.put("age", (int) d.get("age") + 1);
                return d;
              }).toList();
      System.out.println(data_out);

      System.out.println("\nAdd with function reference");
      System.out.println(list1.stream().reduce(0, AnonymousFunction::add));
    }
  }

