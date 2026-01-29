import java.io.IOException;
import java.util.*;

class Main {

    static int n;
    static Node[] list;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = Integer.valueOf(sc.nextLine());
        list = new Node[n];

        for (int i = 0; i < n; i++) {
            char[] arr = change(sc.nextLine().split(" "));

            if (list[arr[0] - 'A'] == null) {
                list[arr[0] - 'A'] = new Node(arr[0]);
            }

            if (arr[1] != '.') {
                list[arr[1] - 'A'] = new Node(arr[1]);
                list[arr[0] - 'A'].left = list[arr[1] - 'A'];
            }

            if (arr[2] != '.') {
                list[arr[2] - 'A'] = new Node(arr[2]);
                list[arr[0] - 'A'].right = list[arr[2] - 'A'];
            }
        }

        preorder(list[0]);
        System.out.println();
        inorder(list[0]);
        System.out.println();
        postorder(list[0]);
        // for (int i = 0; i < n; i++) {
        // Node cur = list[i];

        // System.out.println("value = " + cur.value);
        // System.out.println("left = " + (cur.left == null ? "x" : cur.left.value));
        // System.out.println("right = " + (cur.right == null ? "x" : cur.right.value));

        // System.out.println();
        // }

    }

    private static void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    private static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }

    private static char[] change(String[] tmp) {
        char[] c = new char[3];
        for (int i = 0; i < 3; i++) {
            c[i] = tmp[i].charAt(0);
        }
        return c;
    }

    static class Node {
        char value;
        Node left, right;

        public Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}