package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_1991 {
    static int N;
    static Node tree = new Node("A", null, null);

    public static void main(String[] args) throws IOException{
        sol();
    }

    static void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            tree.add(s[0], s[1], s[2]);
        }

        pre(tree);
        System.out.println();
        in(tree);
        System.out.println();
        post(tree);
        System.out.println();
    }

    static class Node {
        String v;
        Node left, right;

        Node (String v, Node left, Node right) {
            this.v = v;
            this.left = left;
            this.right = right;
        }

        void add(String v, String l, String r) {
            if (this.v.equals(v)) {
                this.left = (l.equals(".") ? null : new Node(l, null, null));
                this.right = (r.equals(".") ? null : new Node(r, null, null));
            } else {
                if (this.left != null) this.left.add(v, l, r);
                if (this.right != null) this.right.add(v, l, r);
            }
        }
    }

    static void pre(Node node) {
        if (node == null) return;
        System.out.print(node.v);
        pre(node.left);
        pre(node.right);
    }

    static void in(Node node) {
        if (node == null) return;
        in(node.left);
        System.out.print(node.v);
        in(node.right);
    }

    static void post(Node node) {
        if (node == null) return;
        post(node.left);
        post(node.right);
        System.out.print(node.v);
    }
}
