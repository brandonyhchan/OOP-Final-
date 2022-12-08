

public class GenericNode<K, T> {

  GenericNode<K,T> next;//generic node with T type as value

  K key;
  T value;//the val in the node

  //constructor
  public GenericNode(K key, T value) {
    this.key = key;
    this.value = value;
  }

  //value getter
  public T getValue() {
    return value;
  }

  //val setter
  public void setValue(T value) {
    this.value = value;
  }

  //go next
  public GenericNode getNext() {
    return next;
  }

  //set next
  public void setNext(GenericNode next) {
    this.next = next;
  }

}
