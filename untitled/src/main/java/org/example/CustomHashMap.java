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

    public Node<K, V> getNext() {
      return next;
    }

    public void setNext(Node<K, V> next) {
      this.next = next;
    }
  }

  private int size = 100;
  private Node<K, V>[] map;

  public CustomHashMap() {
    map = new Node[size];
  }

  public void put(K key, V value) {
    int i = index(key);
    Node newNode = new Node(key, value, null);
    if(map[i] == null) {
      map[i] = newNode;
    } else {
      Node<K, V> previousNode = null;
      Node<K, V> currentNode = map[i];
      while(currentNode != null){
        if(currentNode.getKey().equals(key)){
          currentNode.setValue(value);
          break;
        }
        previousNode = currentNode;
        currentNode = currentNode.getNext();
      }
      if(previousNode != null)
        previousNode.setNext(newNode);
    }
  }

  public V get(K key){
    V value = null;
    int index = index(key);
    Node<K, V> entry = map[index];
    while (entry != null){
      if(entry.getKey().equals(key)) {
        value = entry.getValue();
        break;
      }
      entry = entry.getNext();
    }
    return value;
  }

  public void print(){
    for(int i = 0; i < size; i++){
      if(map[i] != null){
        Node<K, V> currentNode = map[i];
        while (currentNode != null){
          System.out.println(String.format("Key is %s and value is %s", currentNode.getKey(), currentNode.getValue()));
          currentNode = currentNode.getNext();
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
    CustomHashMap<Integer, String> map = new CustomHashMap<>();
    map.put(1, "Hello");
    map.put(2, "World");
    map.print();
  }
}
