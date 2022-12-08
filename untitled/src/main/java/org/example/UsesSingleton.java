package org.example;

public class UsesSingleton {


  public static void main(String[] args) {
    Singleton singleton1 = Singleton.getInstance();

    singleton1.setLabel("singleton1");

    System.out.println(singleton1.getLabel());
  }

}
