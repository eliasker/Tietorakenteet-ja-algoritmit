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
      System.out.println("Juuri on null, asetetaan " + aData);
      root = new Node(aData);
    } else if (aData.compareTo(getRoot().getData()) < 0) {
      System.out.println("Vasemmalle");
      if (root.left() == null)
        root.setLeft(new BinaryTree());
      root.left().insert(aData);
    } else {
      System.out.println("Oikealle");
      if (root.right() == null)
        root.setRight(new BinaryTree());
      root.right().insert(aData);
    }
  }

  public BinaryTree find(String aData) {
    if (root == null)
      return null;
    if (aData.compareTo(root.getData()) == 0)
      return this;
    if (aData.compareTo(root.getData()) < 0 && root.left() != null) {
      return root.left().find(aData);
    }
    if (aData.compareTo(root.getData()) > 0 && root.right() != null) {
      return root.right().find(aData);
    }
    return null;
  }

  public BinaryTree findSmallest() {
    if (root.left() != null) {
      return root.left().findSmallest();
    }
    return this;
  }

  public void deleteNode(String aData) {
    BinaryTree found = find(aData);
    if (found == null)
      System.out.println("Ei löytynyt avaimella " + aData);
    else {
      if (found.root.left() == null && found.root.right() == null) {
        System.out.println("Ei lapsia, poistetaan " + aData);
        found.root = null;
      } else if (found.root.left() != null && found.root.right() != null) {
        System.out.println(aData + ":lla on kaksi lapsipuuta");
        BinaryTree smallest = found.root.right().findSmallest();
        String temp = smallest.getRoot().getData();
        System.out.println("Pienin arvo oikealla: " + temp);
        found.deleteNode(temp);
        found.root.setData(temp);
      } else {
        System.out.println(aData + ":lla on yksi lapsipuu...");
        if (found.root.left() != null) {
          System.out.println("...vasemmalla");
          found.root = found.root.left().getRoot();
        } else {
          System.out.println("...oikealla");
          found.root = found.root.right().getRoot();

        }
      }
    }
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

  public Node getRoot() {
    return root;
  }

  public void setLeft(BinaryTree tree) {
    root.setLeft(tree);
  }

  public void setRight(BinaryTree tree) {
    root.setRight(tree);
  }
}