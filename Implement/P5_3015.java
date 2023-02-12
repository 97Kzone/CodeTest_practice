package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P5_3015 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        Stack<Integer> sk = new Stack<>();
        long res = 0;

        int v, max;
        max = 0;
        while (N > 0) {
            v = Integer.parseInt(br.readLine());
            // 스택이 비었으면 채워주자
            if (sk.isEmpty()) {
                sk.push(v);
                N--;
                continue;
            }
            System.out.println(sk.toString() + " " + res);
            // 나보다 더 큰 놈이 있을 떄 까지 pop
            if (sk.peek() > v) {
                res++;
            } else {
                res += sk.size();
            }
            sk.push(v);
            N--;
        }
        System.out.print(res);
    }
}
