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
      System.out.println("Current root is null, setting value here: " + aData);
      root = new Node(aData);
    } else if (aData.compareTo(getRoot().getData()) < 0) {
      System.out.println("Going left");
      if (root.left() == null)
        root.setLeft(new BinaryTree());
      root.left().insert(aData);
    } else {
      System.out.println("Going right");
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

  public void deleteNode(String aData) {
    BinaryTree found = find(aData);
    if (found != null) {
      if (found.root.left() == null && found.root.right() == null) {
        System.out.println("Löydetyllä ei lapsisolmuja, voidaan poistaa");
      } else if (found.root.left() != null && found.root.right() != null) {
        System.out.println("Löydetyllä kaksi lapsisolmua");
      } else if (found.root.left() != null && found.root.right() == null) {
        System.out.println("Löydetyllä yksi lapsisolmu, vasemmalla");
      } else if (found.root.left() == null && found.root.right() != null) {
        System.out.println("Löydetyllä yksi lapsi, oikealla puolella");
      }
    } else {
      System.out.println("Avainta ei löytynyt puusta");
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