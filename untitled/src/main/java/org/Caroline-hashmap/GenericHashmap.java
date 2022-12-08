

public class GenericHashmap<K, T> {
  private GenericLinkedList[] gmp;//declare an array of linkedlist


  public GenericHashmap(int buckets) {
    gmp = new GenericLinkedList[buckets];//instantiate the array with how many buckets
  }

  //put new node into the hashmap
  public void put(K key, T val) {
    int whichBucket = getHash(key);//find which bucket according to the key

    gmp[whichBucket].insert(key, val);//already traversed in the insert()
  }

  public T get(K key) {
    int whichBucket = getHash(key);//find the bucket number
    GenericNode traverse = gmp[whichBucket].head;//go to the head of that bucket

    //go to the bucket
    //traverse thru the ll until the keys match
    while (traverse.key != key && traverse != null) {
      traverse = traverse.next;
    }
    return (T)traverse.value;
  }

  //a method to get the hash
  public int getHash(K key) {
    return 0;
  }

}
