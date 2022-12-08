

public class GenericLinkedList<K, T> {

	GenericNode<K, T> head;//head
	T value;

	public GenericLinkedList(K key, T val) {
		insert (key, val);
	}

	//inserting the val to a node then add into the list
	public GenericLinkedList insert(K key, T data) {
		GenericNode newNode = new GenericNode(key, data);//creating a new node
		GenericNode traverseNode;//ptr for the traversing node container

		//if the head of the list is null, assign it to the head
		if (this.head == null) {
			this.head = newNode;
		} else {//or traverse to the last node to insert the new node
			traverseNode = this.head;
			while (traverseNode.next != null) {
				traverseNode = traverseNode.next;
			}
			traverseNode.next = newNode;
		}
		return this;
	}



}
