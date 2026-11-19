package belajar.BST;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class Bst {

    public Node root;

    public void insert(int data) {
        root = insertRec(root,data);
    }
    private Node insertRec(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insertRec(node.left, data);
        } else if (data > node.data) {
            node.right = insertRec(node.right, data);
        }
        return node;
    }

    public boolean search(int data) {
         return searchRec(root,data);
    }
    private boolean searchRec(Node node, int data) {
        if (node == null) return false;
        if (node.data == data) return true;
        if (data < node.data) return searchRec(node.left, data);
        return searchRec(node.right, data);
    }

    public void delete(int data) {
        root = deleteRec(root,data);
    }
    private Node deleteRec(Node node, int data) {
        if (node == null) return null;
        if (data < node.data) {
            node.left = deleteRec(node.left, data);
        } else if (data > node.data) {
            node.right = deleteRec(node.right, data);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            node.data = minValue(node.right);
            node.right = deleteRec(node.right,node.data);
        }
        return node;
    }

    public int findMin() {
        if (root == null) throw new IllegalArgumentException("Tree is empty");
        return minValue(root);
    }
    public int findMax() {
        if (root == null) throw new IllegalArgumentException("Tree is empty");
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }
    private int minValue(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    public int height() {
        return heightRec(root);
    }
    private int heightRec(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(heightRec(node.left),heightRec(node.right));
    }

    public static void main(String[] args) {
        Bst bst = new Bst();
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        System.out.println(bst.root.right.right.data);
        System.out.println(bst.search(4));
        bst.delete(2);
        System.out.println(bst.root.data);
        System.out.println(bst.root.right.data);
        System.out.println(bst.root.right.right.data);
        System.out.println(bst.findMax());
        System.out.println(bst.findMin()+"\n");
        System.out.println(bst.height());
    }
}
