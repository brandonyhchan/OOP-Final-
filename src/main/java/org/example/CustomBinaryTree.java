package org.example;

/**
 * Referenced from https://www.devglan.com/datastructure/tree-implementation-java AND
 * Referenced from https://www.devglan.com/datastructure/binary-tree-level-order-traversal
 */
public class CustomBinaryTree {
  BSTNode root;

  public CustomBinaryTree() {
    this.root = null;
  }

  public static class BSTNode {
    private int data;
    private BSTNode left;
    private BSTNode right;

    public BSTNode(int data) {
      this.data = data;
    }

    public int getData() {
      return data;
    }

    public void setData(int data) {
      this.data = data;
    }

    public BSTNode getLeftNode() {
      return left;
    }

    public void setLeftNode(BSTNode left) {
      this.left = left;
    }

    public BSTNode getRightNode() {
      return right;
    }

    public void setRightNode(BSTNode right) {
      this.right = right;
    }

    public BSTNode insert(BSTNode node, int data) {
      if (node == null) {
        node = new BSTNode(data);
      } else {
        if (data < node.getData()) {
          node.setLeftNode(insert(node.getLeftNode(), data));
        } else if (data > node.getData()) {
          node.setRightNode(insert(node.getRightNode(), data));
        }
      }
      return node;
    }

    public BSTNode search(BSTNode root, int data) {
      if (root == null) {
        return null;
      }
      while (root != null) {
        if (data == root.getData()) {
          return root;
        } else if (data > root.getData()) {
          root = root.getRightNode();
        } else {
          root = root.getLeftNode();
        }
      }
      return null;
    }
  }

  //pre-order traversal
  public void preorderTraversal(BSTNode root) {
    if (root != null) {
      System.out.println(root.getData());
      preorderTraversal(root.getLeftNode());
      preorderTraversal(root.getRightNode());
    }
  }

  public static void main(String[] args) {
    CustomBinaryTree tree = new CustomBinaryTree();
    BSTNode root = new BSTNode(5);
    tree.root = root;
    root.setLeftNode(new CustomBinaryTree.BSTNode(7));
    root.setRightNode(new CustomBinaryTree.BSTNode(10));
    root.getLeftNode().setLeftNode(new CustomBinaryTree.BSTNode(14));
    root.getLeftNode().setRightNode(new CustomBinaryTree.BSTNode(19));

    root.getRightNode().setLeftNode(new CustomBinaryTree.BSTNode(30));
    root.getRightNode().setRightNode(new CustomBinaryTree.BSTNode(15));

    root.getRightNode().getRightNode().setLeftNode(new CustomBinaryTree.BSTNode(25));

    tree.preorderTraversal(root);
  }
}
