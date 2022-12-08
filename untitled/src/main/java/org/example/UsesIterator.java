package org.example;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Basically for iterator, you need to make an iterator class. It will check if there is a next
 * value, and then if there is a next, you need to return that next object. It is used so that you
 * can decide how you want to iterate through each item.
 */

/**
 * Implements iterable.
 */
public class UsesIterator<T> implements Iterable {


  ArrayList<T> list;

  /**
   * Constructor for list.
   */
  public UsesIterator() {
    list = new ArrayList<>();
  }

  /**
   * Gets the list.
   *
   * @return list
   */
  public ArrayList<T> getList() {
    return list;
  }

  /**
   * Gets the size of the list.
   *
   * @return list size
   */
  public int getListSize() {
    return list.size();
  }

  /**
   * Adds an item to the list.
   *
   * @param item
   */
  public void add(T item) {
    list.add(item);
  }

  /**
   * Removes the item from the list.
   *
   * @param item
   */
  public void remove(T item) {
    list.remove(item);
  }

  /**
   * An interator for the list.
   *
   * @return iterator
   */
  @Override
  public Iterator<T> iterator() {
    return new UsingIterator<>(list);
  }

  /**
   * Iterator class.
   */
  public static class UsingIterator<T> implements Iterator<T> {

    /**
     * Array list of items.
     */
    ArrayList<T> iteratingThroughList;

    /**
     * Position of where we are in the iteration.
     */
    int position = 0;

    /**
     * Constructor.
     *
     * @param list as an UsesIterator object
     */
    public UsingIterator(ArrayList<T> list) {
      this.iteratingThroughList = list;
    }

    /**
     * Checks if there is a next in the list.
     *
     * @return boolean value
     */
    @Override
    public boolean hasNext() {
      return iteratingThroughList.size() > position;
    }

    /**
     * Gets the next item.
     *
     * @return item
     */
    @Override
    public T next() {
      T item = this.iteratingThroughList.get(position);
      position++;
      return item;
    }
  }
}