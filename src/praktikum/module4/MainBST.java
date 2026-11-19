package praktikum.module4;

public class MainBST {
    static class Node {
        String ticketCode;
        Node left,right;

        public Node(String ticketCode) {
            this.ticketCode = ticketCode;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;

    public void insert(String ticketCode) {
        root = insertRec(root,ticketCode);
    }
    private Node insertRec(Node root, String ticketCode) {
        if (root == null) {
            return new Node(ticketCode);
        }
        if (ticketCode.compareTo(root.ticketCode) < 0) {
            root.left = insertRec(root.left, ticketCode);
        } else if (ticketCode.compareTo(root.ticketCode) > 0) {
            root.right = insertRec(root.right, ticketCode);
        }
        return root;
    }

    public void inorderTraversal() {
        System.out.println("\n=== SORTED TICKET LEDGER (Inorder) ===");
        inorderRec(root);
        System.out.println();
    }
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.ticketCode+" ");
            inorderRec(root.right);
        }
    }

    public boolean search(String ticketCode) {
        return searchRec(root, ticketCode);
    }
    private boolean searchRec(Node root, String ticketCode) {
        if (root == null) return false;
        if (root.ticketCode.equals(ticketCode)) return true;
        if (ticketCode.compareTo(root.ticketCode) < 0)
            return searchRec(root.left,ticketCode);
        return searchRec(root.right, ticketCode);
    }

    public String findMin() {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.ticketCode;
    }
    public String findMax() {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.ticketCode;
    }

    public void delete(String ticketCode) {
        root = deleteRec(root, ticketCode);
    }
    private Node deleteRec(Node root, String ticketCode) {
        if (root == null) return null;

        if (ticketCode.compareTo(root.ticketCode) < 0) {
            root.left = deleteRec(root.left, ticketCode);
        } else if (ticketCode.compareTo(root.ticketCode) > 0) {
            root.right = deleteRec(root.right, ticketCode);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            Node successor = root.right;
            while (successor.right != null) {
                successor = successor.right;
            }
            root.ticketCode = successor.ticketCode;
            root.right = deleteRec(root.right, ticketCode);
        }
        return root;
    }

    public static void main(String[] args) {
        MainBST tree = new MainBST();

        System.out.println("Booking TTX-003, TTX-001, TTX-004, TTX-002...");
        tree.insert("TTX-003");
        tree.insert("TTX-001");
        tree.insert("TTX-004");
        tree.insert("TTX-002");

        tree.inorderTraversal();

        System.out.println("Search TTX-002: "+(tree.search("TTX-002") ? "Found":"Not found"));
        System.out.println("Search TTX-099: "+(tree.search("TTX-099") ? "Found":"Not found"));

        System.out.println("\nFirst ticket booked: "+tree.findMin());
        System.out.println("Last ticket booked: "+tree.findMax());

        System.out.println("\nCancelled TTX-002...");
        tree.delete("TTX-002");
        tree.inorderTraversal();
    }
}
