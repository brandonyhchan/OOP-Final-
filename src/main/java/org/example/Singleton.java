package org.example;

public class Singleton {
  private static Singleton instance;

  public String label;

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;

  }


  public void setLabel(String name) {
    this.label = name;
  }

  public String getLabel() {
    return this.label;
  }
}
