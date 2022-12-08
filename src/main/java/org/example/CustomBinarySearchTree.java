package org.example;

/**
 * Referenced from:
 * https://www.javatpoint.com/java-program-to-construct-a-binary-search-tree-
 * and-perform-deletion-and-in-order-traversal
 */
public class CustomBinarySearchTree {
  public class BSTNode {
    private int data;
    private BSTNode left;
    private BSTNode right;

    public BSTNode(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  public BSTNode root;

  public CustomBinarySearchTree() {
    root = null;
  }

  public void insert(int data) {
    BSTNode newNode = new BSTNode(data); //make new node with data
    BSTNode parent; //declare parent node

    if (root == null) {
      root = newNode; //assign new node to root if root is null
    } else {
      BSTNode current = root; //otherwise assign root to current node
      while (root != null) { //while loop runs if true
        parent = current; //assign current node as parent
        if (data < current.data) { //insert node to left of tree if data is less than current node's data
          current = current.left;
          if (current == null) { //if current is null assign new node to the left node of the parent
            parent.left = newNode;
            return;
          }
        } else { //if data is greater than current's data, node will be inserted to the right of tree
          current = current.right;
          if (current == null) {
            parent.right = newNode;
            return;
          }
        }
      }
    }
  }

  public BSTNode minNode(BSTNode root) {
    if (root.left != null)
      return minNode(root.left);
    else
      return root;
  }

  public BSTNode deleteNode(BSTNode node, int data) {
    if (node == null){
      return null;
    } else {
      if (data < node.data) { //value is less than node's data then, search the value in left subtree
        node.left = deleteNode(node.left, data);
      } else if (data > node.data) { //value is greater than node's data then, search the value in right subtree
        node.right = deleteNode(node.right, data);
      } else { //if value is equal to node's data that is, we have found the node to be deleted
        if(node.left == null && node.right == null) { //if node to be deleted has no child then, set the node to null
          node = null;
        } else if (node.left == null) { //if node to be deleted has only one right child
          node = node.right;
        } else if(node.right == null) { //if node to be deleted has only one left child
          node = node.left;
        } else { //if node to be deleted has two children node find the minimum node from right subtree
          BSTNode temp = minNode(node.right);
          node.data = temp.data; //reassign the data between node and temp
          node.right = deleteNode(node.right, temp.data); //delete the node duplicate node from right subtree
        }
      }
      return node;
    }
  }

  public void inorderTraversal(BSTNode node) {
    if (root == null) {
      System.out.println("Tree is empty!");
    } else {
      if (node.left != null) {
        inorderTraversal(node.left);
      }
      System.out.print(node.data + " ");
      if (node.right != null) {
        inorderTraversal(node.right);
      }
    }
  }

  public static void main(String[] args) {
    CustomBinarySearchTree tree = new CustomBinarySearchTree();
    //add nodes to the binary tree
    tree.insert(50);
    tree.insert(30);
    tree.insert(70);
    tree.insert(60);
    tree.insert(10);
    tree.insert(90);

    System.out.println("Binary search tree after insertion:");
    //prints the binary tree
    tree.inorderTraversal(tree.root);

    BSTNode deletedNode = null;
    //deletes node 90 which has no child
    deletedNode = tree.deleteNode(tree.root, 90);
    System.out.println("\nBinary search tree after deleting node 90:");
    tree.inorderTraversal(tree.root);

    //deletes node 30 which has one child
    deletedNode = tree.deleteNode(tree.root, 30);
    System.out.println("\nBinary search tree after deleting node 30:");
    tree.inorderTraversal(tree.root);

    //deletes node 50 which has two children
    deletedNode = tree.deleteNode(tree.root, 50);
    System.out.println("\nBinary search tree after deleting node 50:");
    tree.inorderTraversal(tree.root);
  }
}
