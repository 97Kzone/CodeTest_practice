package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class G5_6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> sk = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        long res = 0;
        while (N > 0) {
            int h = Integer.parseInt(br.readLine());
            if (sk.isEmpty() || sk.peek() > h) {
                sk.push(h);
            } else {
                while (sk.peek() <= h) {
                    sk.pop();
                    if (sk.isEmpty()) break;
                    res += sk.size();
                }
                sk.push(h);
            }
            N--;
        }

        while (!sk.isEmpty()) {
            sk.pop();
            res += sk.size();
        }

        System.out.print(res);
    }
}
