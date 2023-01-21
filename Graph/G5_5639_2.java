package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_5639_2 {
    static class Node {
        int value;
        Node left;
        Node right;

        Node (int value) {
            this.value = value;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        void add(int v) {
            if (v < this.value) {
                if (this.left == null) {
                    this.left = new Node(v);
                } else {
                    this.left.add(v);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(v);
                } else {
                    this.right.add(v);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        sol();
    }

    static void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        Node node = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            s = br.readLine();
            if (s == null || s.equals("")) break;
            node.add(Integer.parseInt(s));
        }

        check(node);
    }

    static void check(Node root) {
        if (root == null) return;
        
        check(root.left);
        check(root.right);

        System.out.println(root.value);
    }
}
