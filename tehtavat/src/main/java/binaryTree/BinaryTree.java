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

  public void deleteNode(String aData) {
    if (aData.compareTo(root.getData()) == 0) {
      System.out.println(aData + " löytyi");
      if (root.left() == null && root.right() == null) {
        System.out.println("Ei lapsia, poistetaan " + aData);
        root = null;
      } else if (root.left() != null && root.right() != null) {
        // TODO
        // kaksi lapsipuuta
        // mene oikealle, etsi pienin
        // temp = pienin, poista pienin (rekursio)
        // tee funktio (find, temp)
      } else if (root.left() != null || root.right() != null) {
        System.out.println(aData + " yksi lapsi, korvataan...");
        if (root.left() != null) {
          System.out.println("...vasemmanpuoleisella lapsipuulla");
          root = root.left().getRoot();
        } else {
          System.out.println("...oikeanpuoleisella lapsipuulla");
          root = root.right().getRoot();
        }
      }
    } else if (aData.compareTo(root.getData()) < 0) {
      System.out.println("Rekursio vasemmalle");
      if (root.left() != null)
        root.left().deleteNode(aData);
    } else if (aData.compareTo(root.getData()) > 0) {
      System.out.println("Rekursio oikealle");
      if (root.right() != null)
        root.right().deleteNode(aData);
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