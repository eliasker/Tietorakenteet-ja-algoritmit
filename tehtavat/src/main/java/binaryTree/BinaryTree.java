package binaryTree;

public class BinaryTree {
  private Node root;

  public BinaryTree(String rootValue) {
    root = new Node(rootValue);
  }

  public BinaryTree() {
    root = null;
  }

  public BinaryTree(String rootValue, BinaryTree left, BinaryTree right) {
    root = new Node(rootValue, left, right);
  }

  public void insert(String aData) {
    if (root == null) {
      root = new Node(aData);
    }
    if (aData.compareTo(root.getData()) < 0) {
      if (root.left() == null) {
        root.setLeft(new BinaryTree(aData));
      } else {
        root.left().insert(aData);
      }
    }
    if (aData.compareTo(root.getData()) > 0) {
      if (root.right() == null) {
        root.setRight(new BinaryTree(aData));
      } else {
        root.right().insert(aData);

      }
    }
  }

  public BinaryTree find(String aData) {
    return null;
  }

  public void preOrder() {
    if (root != null) {
      System.out.println(root.getData() + ',');
      if (root.left() != null) // pääseeekö vasemmalle?
        root.left().preOrder();
      if (root.right() != null) // pääseekö oikealle?
        root.right().preOrder();
    }

  }

  public void setLeft(BinaryTree tree) {
    root.setLeft(tree);
  }

  public void setRight(BinaryTree tree) {
    root.setRight(tree);
  }
}