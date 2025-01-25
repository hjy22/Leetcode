package Tiktok2025;

public class PopulatingNextRightPointersinEachNode116M {
    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3, 4, 5 };
        Node root = Node.arrayToNode(array);
        System.out.println(connect(root));
    }

    public static Node connect(Node root) {
        if (root == null) return null;
        traverse(root.left, root.right);
        return root;
    }

    public static void traverse(Node n1, Node n2) {
        if (n1 == null || n2 == null) {
            return;
        }

        n1.next = n2;
        traverse(n1.left, n1.right);
        traverse(n1.right, n2.left);
        traverse(n2.left, n2.right);
    }
}
