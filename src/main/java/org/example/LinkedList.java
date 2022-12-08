package org.example;

public class LinkedList<T> {

  Node<T> head; // head of list

  // Linked list Node.
  // This inner class is made static
  // so that main() can access it
  static class Node<T> {

     Object data;
    Node<T> next;

    // Constructor
    Node(T data) {
      this.data = data;
      next = null;
    }
  }

  // Method to insert a new node
  public void insert(T data) {
    // Create a new node with given data
    Node<T> new_node = new Node<T>(data);

    // If the Linked List is empty,
    // then make the new node as head
    if (this.head == null) {
      this.head = new_node;
    } else {
      // Else traverse till the last node
      // and insert the new_node there
      Node<T> last = this.head;
      while (last.next != null) {
        last = last.next;
      }

      // Insert the new_node at last node
      last.next = new_node;
    }
  }

  // Method to print the LinkedList.
  public void printList() {
    Node<T> currNode = this.head;

    System.out.print("LinkedList: ");

    // Traverse through the LinkedList
    while (currNode != null) {
      // Print the data at current node
      System.out.print(currNode.data + " ");

      // Go to next node
      currNode = currNode.next;
    }
  }

  public void clearList() {
    this.head = null;
  }

  // Driver code
  public static void main(String[] args) {
    /* Start with the empty list. */
    LinkedList<Integer> list = new LinkedList<Integer>();

    //
    // ******INSERTION******
    //

    list.insert(1);
    list.insert(12);
    list.insert(23);

    // Print the LinkedList
    list.printList();
    System.out.print("\n");

    LinkedList<String> list2 = new LinkedList<String>();
    list2.insert("Hello");
    list2.insert("World");
    list2.printList();
  }
}
