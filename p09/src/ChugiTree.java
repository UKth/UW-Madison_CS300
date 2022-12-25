
// TODO Add file header
import java.util.NoSuchElementException;

/**
 * This class implements a ChugidexStorage as a Binary Search Tree.
 * 
 * Notes: 1) You may NOT use any arrays or Collections objects (ArrayLists, etc) in this class. 2)
 * You may NOT use any loops (for, while, etc) in this class. Recursive strategies only.
 *
 */
public class ChugiTree implements ChugidexStorage {

  /**
   * The root of this ChugiTree. Set to null when tree is empty.
   */
  private BSTNode<Chugimon> root;

  /**
   * The size of this ChugiTree (total number of Chugimon stored in this BST)
   */
  private int size;

  /**
   * Constructor for Chugitree. Should set size to 0 and root to null.
   */
  public ChugiTree() {
    size = 0;
    root = null;
  }

  /**
   * Getter method for the Chugimon at the root of this BST.
   * 
   * @return the root of the BST.
   */
  public Chugimon getRoot() {
    return root.getData(); // default return statement
  }

  /**
   * A method for determining whether this ChugiTree is a valid BST. In order to be a valid BST, the
   * following must be true: For every internal (non-leaf) node X of a binary tree, all the values
   * in the node's left subtree are less than the value in X, and all the values in the node's right
   * subtree are greater than the value in X.
   * 
   * @return true if this ChugiTree is a valid BST, false otherwise
   */
  public boolean isValidBST() {
    return isValidBSTHelper(root);
  }

  /**
   * A helper method for determining whether this ChugiTree is a valid BST. In order to be a valid
   * BST, the following must be true: For every internal (non-leaf) node X of a binary tree, all the
   * values in the node's left subtree are less than the value in X, and all the values in the
   * node's right subtree are greater than the value in X.
   * 
   * @param node The root of the BST.
   * @return true if the binary tree rooted at node is a BST, false otherwise
   */
  public static boolean isValidBSTHelper(BSTNode<Chugimon> node) {
    if (node == null) {
      return true;
    }
    BSTNode<Chugimon> leftNode = node.getLeft();
    BSTNode<Chugimon> rightNode = node.getRight();

    if (leftNode != null) {
      BSTNode<Chugimon> rightMost = leftNode;
      while (rightMost.getRight() != null) {
        rightMost = rightMost.getRight();
      }
      if (rightMost.getData().compareTo(node.getData()) >= 0) {
        return false;
      }
    }

    if (rightNode != null) {
      BSTNode<Chugimon> leftMost = rightNode;
      while (leftMost.getLeft() != null) {
        leftMost = leftMost.getLeft();
      }
      if (node.getData().compareTo(leftMost.getData()) >= 0) {
        return false;
      }
    }

    return isValidBSTHelper(leftNode) && isValidBSTHelper(rightNode);
  }

  /**
   * Checks whether this ChugiTree is empty or not
   * 
   * @return true if this tree is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return root == null;
  }

  /**
   * Gets the size of this ChugiTree
   * 
   * @return the total number of Chugimons stored in this tree
   */
  @Override
  public int size() {
    return subTreeSize(root);
  }

  public int subTreeSize(BSTNode<Chugimon> node) {
    if (node == null) {
      return 0;
    }
    return subTreeSize(node.getLeft()) + subTreeSize(node.getRight()) + 1;
  }

  /**
   * Returns a String representation of all the Chugimons stored within this ChugiTree in the
   * increasing order with respect to the result of Chugimon.compareTo() method. The string should
   * be a comma-separated list of all the Chugimon toString() values. No spaces are expected to be
   * in the resulting string. No comma should be at the end of the resulting string. For instance,
   * 
   * "nameOne#12.25,nameTwo#12.56,nameTwo#89.27"
   * 
   * @return a string containing all of the Chugimon, in the increasing order. Returns an empty
   *         string "" if this BST is empty.
   * 
   */
  @Override
  public String toString() {
    return toStringHelper(root);
  }

  /**
   * Recursive helper method which returns a String representation of the ChugiTree rooted at node.
   * An example of the String representation of the contents of a ChugiTree storing three Chugimons
   * is provided in the description of the above toString() method.
   * 
   * @param node references the root of a subtree
   * @return a String representation of all the Chugimons stored in the sub-tree rooted at node in
   *         increasing order. Returns an empty String "" if current is null.
   */
  protected static String toStringHelper(BSTNode<Chugimon> node) {
    if (node == null) {
      return "";
    }
    String leftString = toStringHelper(node.getLeft());
    String rightString = toStringHelper(node.getRight());

    return leftString + (leftString != "" ? "," : "") + node.toString()
        + (rightString != "" ? "," : "") + rightString; // Default return statement added to resolve
    // compiler errors
  }

  /**
   * Adds a new Chugimon to this ChugiTree. Duplicate Chugimons are NOT allowed.
   * 
   * @param newChugimon Chugimon to add to this ChugiTree
   * @return true if if the newChugimon was successfully added to the ChugiTree, false if a match
   *         with newChugimon is already present in the tree.
   * @throws IllegalArgumentException with a descriptive error message if newChugimon is null.
   */
  @Override
  public boolean add(Chugimon newChugimon) {
    if (newChugimon == null) {
      throw new IllegalArgumentException();
    }

    if (root == null) {
      root = new BSTNode<Chugimon>(newChugimon);
      return true;
    }

    boolean res = addHelper(newChugimon, root);
    if (res) {
      size += 1;
    }

    return res;
  }

  /**
   * Recursive helper method to insert a new Chugimon to a Pokedex rooted at node.
   * 
   * @param node The "root" of the subtree we are inserting the new Chugimon into.
   * @param newChugimon The Chugimon to be added to a BST rooted at node. We assume that newChugimon
   *        is NOT null.
   * @return true if the newChugimon was successfully added to the ChugiTree, false if a match with
   *         newChugimon is already present in the subtree rooted at node.
   */
  protected static boolean addHelper(Chugimon newChugimon, BSTNode<Chugimon> node) {

    int cmp = node.getData().compareTo(newChugimon);
    BSTNode<Chugimon> newNode = cmp < 0 ? node.getRight() : node.getLeft();
    if (newNode == null) {
      if (cmp == 0) {
        return false;
      } else if (cmp < 0) {
        node.setRight(new BSTNode<Chugimon>(newChugimon));
      } else {
        node.setLeft(new BSTNode<Chugimon>(newChugimon));
      }
      return true;
    }
    return addHelper(newChugimon, newNode);

  }

  /**
   * Searches a Chugimon given its first and second identifiers.
   * 
   * @param firstId First identifier of the Chugimon to find
   * @param secondId Second identifier of the Chugimon to find
   * @return the matching Chugimon if match found, null otherwise.
   */
  @Override
  public Chugimon lookup(int firstId, int secondId) {
    return lookupHelper(new Chugimon(firstId, secondId), root);
  }

  /**
   * Recursive helper method to search and return a match with a given Chugimon in the subtree
   * rooted at node, if present.
   * 
   * @param toFind a Chugimon to be searched in the BST rooted at node. We assume that toFind is NOT
   *        null.
   * @param node "root" of the subtree we are checking whether it contains a match to target.
   * @return a reference to the matching Chugimon if found, null otherwise.
   */
  protected static Chugimon lookupHelper(Chugimon toFind, BSTNode<Chugimon> node) {
    if (node == null) {
      return null;
    }
    if (node.getData().equals(toFind)) {
      return node.getData();
    }
    return lookupHelper(toFind,
        node.getData().compareTo(toFind) < 0 ? node.getRight() : node.getLeft());
  }

  /**
   * Computes and returns the height of this BST, counting the number of NODES from root to the
   * deepest leaf.
   * 
   * @return the height of this Binary Search Tree
   */
  public int height() {
    return heightHelper(root); // Default return statement
  }

  /**
   * Recursive helper method that computes the height of the subtree rooted at node counting the
   * number of nodes and NOT the number of edges from node to the deepest leaf
   * 
   * @param node root of a subtree
   * @return height of the subtree rooted at node
   */
  protected static int heightHelper(BSTNode<Chugimon> node) {
    if (node == null) {
      return 0;
    }
    int left_H = heightHelper(node.getLeft());
    int right_H = heightHelper(node.getRight());
    return 1 + Math.max(left_H, right_H);
  }

  /**
   * Recursive method to find and return the first Chugimon, in the increasing order, within this
   * ChugiTree (meaning the smallest element stored in the tree).
   * 
   * @return the first element in the increasing order of this BST, and null if the tree is empty.
   */
  @Override
  public Chugimon getFirst() {
    return getFirstHelper(root);
  }

  /**
   * Recursive helper method for getFirst().
   * 
   * @param root the node from which to find the the minimum node
   * @return the minimum element in the increasing order from the node <b>root</b>
   */
  protected static Chugimon getFirstHelper(BSTNode<Chugimon> root) {
    BSTNode<Chugimon> p = root;
    while (p.getLeft() != null) {
      p = p.getLeft();
    }

    return p.getData(); // default return statement
  }

  /**
   * Recursive method to find and return the last Chugimon, in the increasing order, within this
   * ChugiTree (meaning the greatest element stored in the tree).
   * 
   * @return the last element in the increasing order of this BST, and null if the tree is empty.
   */
  @Override
  public Chugimon getLast() {
    // TODO Implement this method.

    // HINT: The greatest element in a non-empty BST is the right most element

    return getLastHelper(root);
  }

  /**
   * Recursive helper method for getLast().
   * 
   * @param root the node from which to find the the maximum node
   * @return the maximum element in the increasing order from the node <b>root</b>
   */
  protected static Chugimon getLastHelper(BSTNode<Chugimon> root) {
    BSTNode<Chugimon> p = root;
    while (p.getRight() != null) {
      p = p.getRight();
    }

    return p.getData(); // default return statement

  }

  /**
   * Recursive method to get the number of Chugimon with a primary or secondary type of the
   * specified type, stored in this ChugiTree.
   * 
   * @param chugiType the type of Chugimons to count. We assume that chugiType is NOT null.
   * @return the number of all the Chugimon objects with a primary or secondary type of the
   *         specified type stored in this ChugiTree.
   */
  public int countType(ChugiType chugiType) {
    return countTypeHelper(root, chugiType);
  }

  protected static int countTypeHelper(BSTNode<Chugimon> node, ChugiType chugiType) {
    if (node == null) {
      return 0;
    }
    int cnt = 0;
    Chugimon c = node.getData();
    if (c.getPrimaryType() == chugiType || c.getSecondaryType() == chugiType) {
      cnt += 1;
    }
    return cnt + countTypeHelper(node.getLeft(), chugiType)
        + countTypeHelper(node.getRight(), chugiType);
  }

  /**
   * Finds and returns the in-order successor of a specified Chugimon in this ChugiTree
   * 
   * @param chugi the Chugimon to find its successor
   * @return the in-order successor of a specified Chugimon in this ChugiTree
   * 
   * @throws IllegalArgumentException with a descriptive error message if <b>chugi</b> is null
   * @throws NoSuchElementException with a descriptive error message if the Chugimon provided as
   *         input has no in-order successor in this ChugiTree.
   */
  @Override
  public Chugimon next(Chugimon chugi) {
    // TODO: Implement this method.
    return nextHelper(chugi, root, root);
  }

  /**
   * Recursive helper method to find and return the next Chugimon in the tree rooted at node.
   * 
   * @param chugi a Chugimon to search its in-order successor. We assume that <b>chugi</b> is NOT
   *        null.
   * @param node "root" of a subtree storing Chugimon objects
   * @param next a BSTNode which stores a potentional candidate for next node
   * @return the next Chugimon in the tree rooted at node.
   * @throws NoSuchElementException with a descriptive error message if the Chugimon provided as
   *         input has no in-order successor in the subtree rooted at node.
   */
  protected static Chugimon nextHelper(Chugimon chugi, BSTNode<Chugimon> node, BSTNode next) {
    if (node == null) {
      throw new NoSuchElementException();
    }
    if (node.getData().equals(chugi)) {
      BSTNode<Chugimon> p = node.getRight();
      if (p == null) {
        throw new NoSuchElementException();
      }
      while (p.getLeft() != null) {
        p = p.getLeft();
      }
      return p.getData();
    }

    return nextHelper(chugi, node.getData().compareTo(chugi) < 0 ? node.getRight() : node.getLeft(),
        node);
  }

  /**
   * Finds and returns the in-order predecessor of a specified Chugimon in this ChugiTree
   * 
   * @param chugi the Chugimon to find its predecessor
   * @return the in-order predecessor of a specified Chugimon in this ChugiTree.
   * 
   * @throws IllegalArgumentException with a descriptive error message if <b>chugi</b> is null
   * @throws NoSuchElementException if there is no Chugimon directly before the provided Chugimon
   */
  @Override
  public Chugimon previous(Chugimon chugi) {
    return previousHelper(chugi, root, null);
  }

  /**
   * Recursive helper method to find and return the previous Chugimon in the tree rooted at node.
   * 
   * @param chugi a Chugimon to search its in-order predecessor. We assume that <b>chugi</b> is NOT
   *        null.
   * @param node "root" of a subtree storing Chugimon objects
   * @param prev a BSTNode which stores a potentional candidate for previous node
   * @return the previous Chugimon in the tree rooted at node.
   * @throws NoSuchElementException with a descriptive error message if the Chugimon provided as
   *         input has no in-order predecessor in the subtree rooted at node.
   */
  protected static Chugimon previousHelper(Chugimon chugi, BSTNode<Chugimon> node,
      BSTNode<Chugimon> prev) {

    if (node == null) {
      throw new NoSuchElementException();
    }
    if (node.getData().equals(chugi)) {
      BSTNode<Chugimon> p = node.getLeft();
      if (p == null) {
        throw new NoSuchElementException();
      }
      while (p.getRight() != null) {
        p = p.getRight();
      }
      return p.getData();
    }

    return nextHelper(chugi, node.getData().compareTo(chugi) < 0 ? node.getRight() : node.getLeft(),
        node);
  }

  /**
   * Deletes a specific Chugimon from this ChugiTree.
   * 
   * @param chugi the Chugimon to delete
   * @return true if the specific Chugimon is successfully deleted, false if no match found with any
   *         Chugimon in this tree.
   * @throws IllegalArgumentException with a descriptive error message if <b>chugi</b> is null
   */
  @Override
  public boolean delete(Chugimon chugi) {
    if (chugi == null) {
      throw new IllegalArgumentException();
    }

    deleteChugimonHelper(chugi, root);

    BSTNode<Chugimon> p = root;
    BSTNode<Chugimon> q = p.getData().compareTo(chugi) < 0 ? p.getRight() : p.getLeft();
    while (true) {
      if (q == null) {
        return false;
      }
      if (q.getData().equals(chugi)) {
        break;
      }
      p = q;
      q = q.getData().compareTo(chugi) < 0 ? q.getRight() : q.getLeft();
    }
    return deleteNodeHelper(p, q);
  }

  /**
   * Recursive helper method to search and delete a specific Chugimon from the BST rooted at node
   * 
   * @param target a reference to a Chugimon to delete from the BST rooted at node. We assume that
   *        target is NOT null.
   * @param node "root" of the subtree we are checking whether it contains a match with the target
   *        Chugimon.
   * 
   * 
   * @return the new "root" of the subtree we are checking after trying to remove target
   * @throws NoSuchElementException with a descriptive error message if there is no Chugimon
   *         matching target in the BST rooted at <b>node</b>
   */
  protected static BSTNode<Chugimon> deleteChugimonHelper(Chugimon target, BSTNode<Chugimon> node) {
    // TODO complete the implementation of this method. Problem decomposition and
    // hints are provided in the comments below

    // if node == null (empty subtree rooted at node), no match found, throw an
    // exception

    // Compare the target to the data at node and proceed accordingly
    // Recurse on the left or right subtree with respect to the comparison result
    // Make sure to use the output of the recursive call to appropriately set the
    // left or the right child of node accordingly

    // if match with target found, three cases should be considered. Feel free to
    // organize the order of these cases at your choice.

    // Case 1: node may be a leaf (has no children), set node to null.

    // Case 2: node may have only one child, set node to that child (whether left or
    // right child)

    // Case 3: node may have two children,
    // Replace node with a new BSTNode whose data field value is the successor of
    // target in the tree, and having the same left and right children as node.
    // Notice carefully that you cannot set the data of a BSTNode. Hint: The
    // successor is the smallest element at the right subtree of node
    //
    // Then, remove the successor from the right subtree. The successor must have up
    // to one child.

    // Make sure to return node (the new root to this subtree) at the end of each
    // case or at the end of the method.

    return null; // Default return statement added to resolve compiler errors

  }

  protected static boolean deleteNodeHelper(BSTNode<Chugimon> parent, BSTNode<Chugimon> node) {
    int cmp = parent.getData().compareTo(node.getData());
    BSTNode<Chugimon> leftNode = node.getLeft();
    BSTNode<Chugimon> rightNode = node.getRight();
    if (leftNode == null && rightNode == null) {
      if (cmp < 0) {
        parent.setRight(null);
      } else {
        parent.setLeft(null);
      }
    }
    if (leftNode == null) { // right subtree
      BSTNode<Chugimon> p = node;
      BSTNode<Chugimon> q = rightNode;
      while (q.getLeft() == null) {
        p = q;
        q = q.getLeft();
        if (cmp < 0) {
          parent.setRight(q);
        } else {
          parent.setLeft(q);
        }
        deleteNodeHelper(p, q);
      }
    } else { // left subtree
      BSTNode<Chugimon> p = node;
      BSTNode<Chugimon> q = leftNode;
      while (q.getRight() == null) {
        p = q;
        q = q.getRight();
        if (cmp < 0) {
          parent.setRight(q);
        } else {
          parent.setLeft(q);
        }
        deleteNodeHelper(p, q);
      }
    }
    return true;
  }

}
