package untitled.src.main.java.org.example;

/**
 * Referenced from https://www.devglan.com/java8/hashmap-custom-implementation-java#:~:
 * text=HashMap%20is%20an%20implementation%20of,as%20to%20get%20and%20put.
 * @param <K> the key
 * @param <V> the value
 */
public class CustomHashMap<K, V> {
  public class Node<K, V> {
    private K key;
    private V value;
    private Node<K, V> next;

    public Node(K key, V value, Node<K, V> next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }

    public K getKey() {
      return key;
    }

    public void setKey(K key) {
      this.key = key;
    }

    public V getValue() {
      return value;
    }

    public void setValue(V value) {
      this.value = value;
    }

    public Node<K, V> getNextNode() {
      return next;
    }

    public void setNextNode(Node<K, V> next) {
      this.next = next;
    }
  }

  private int size = 100; //because we are using an array, we need to initalize the size
  private Node<K, V>[] array;

  public CustomHashMap() {
    array = new Node[size];
  }

  public void put(K key, V value) {
    int i = index(key);
    Node newNode = new Node(key, value, null);
    if(array[i] == null) {
      array[i] = newNode; //assign new node to array if array is null
    } else {
      Node<K, V> previousNode = null; //set first node's previous node to null
      Node<K, V> currentNode = array[i];
      while(currentNode != null){
        if(currentNode.getKey().equals(key)){
          currentNode.setValue(value); //set value for the key
          break;
        }
        previousNode = currentNode;
        currentNode = currentNode.getNextNode(); //iterate to next node
      }
      if(previousNode != null)
        previousNode.setNextNode(newNode);
    }
  }

  public V get(K key){
    V value = null;
    int index = index(key);
    Node<K, V> entry = array[index];
    while (entry != null){
      if(entry.getKey().equals(key)) {
        value = entry.getValue();
        break;
      }
      entry = entry.getNextNode();
    }
    return value;
  }

  public void print(){
    for(int i = 0; i < size; i++){
      if(array[i] != null){
        Node<K, V> currentNode = array[i];
        while (currentNode != null){
          System.out.println(String.format("Key is %s and value is %s", currentNode.getKey(), currentNode.getValue()));
          currentNode = currentNode.getNextNode(); //iterate to next node
        }
      }
    }
  }

  private int index(K key){
    if(key == null){
      return 0;
    }
    return Math.abs(key.hashCode() % size);
  }

  public static void main(String[] args) {
    CustomHashMap<String, String> map1 = new CustomHashMap<>();
    map1.put("Hello", "World");
    map1.put("First", "Name");
    map1.print();

    CustomHashMap<Integer, String> map2 = new CustomHashMap<>();
    map2.put(1, "Hello");
    map2.put(2, "World");
    map2.print();
  }
}
