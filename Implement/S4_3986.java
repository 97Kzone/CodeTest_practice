package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S4_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int res = 0;

        Stack<Character> stk;
        char[] word;
        for (int i = 0; i < N; i++) {
            stk = new Stack<>();
            word = br.readLine().toCharArray();

            if (word.length % 2 == 1) continue;
            
            stk.push(word[0]);
            for (int j = 1; j < word.length; j++) {
                if (stk.size() > 0 && stk.peek() == word[j]) {
                    stk.pop();
                } else {
                    stk.push(word[j]);
                }
            }
            if (stk.isEmpty()) res++;
        }

        System.out.print(res);
    }
}
