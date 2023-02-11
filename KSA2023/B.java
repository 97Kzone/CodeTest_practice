package KSA2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B {
    static int N, M;
    static Stack<Character> sk;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sk = new Stack<>();

        String s = br.readLine();
        int cntA = 0;
        
        for (int i = 0; i < s.length(); i++) {
            sk.push(s.charAt(i));
            if (sk.peek() == 'A') cntA++;
        }

        if (cntA < 2) {
            System.out.print("NO");
        } else {
            if (N == M) {
                char std = sk.peek();
                if (std == 'A' || std == 'E' || std == 'I' || std == 'O' || std == 'U') {
                    System.out.print("NO");
                } else {
                    sb.append(sk.pop()).append(sk.pop());
                    if (sb.charAt(1) != 'A' || sk.peek() != 'A') {
                        System.out.print("NO");
                    } else {
                        while (!sk.isEmpty()) {
                            sb.append(sk.pop());
                        }
                        System.out.println("YES");
                        System.out.print(sb.reverse().toString());
                    }
                }
            } else {

                // 조건 1 만들기
                while (!sk.isEmpty()) {
                    if (sk.peek() == 'A' || sk.peek() == 'E' || sk.peek() == 'I' || 
                        sk.peek() == 'O' || sk.peek() == 'U') sk.pop();
                    else{
                        sb.append(sk.pop());
                        break;
                    }
                }
                // 조건 2 만들기
                int cnt = 2;
                while (cnt > 0 && !sk.isEmpty()) {
                    if (sk.peek() == 'A') {
                        sb.append(sk.pop());
                        cnt--;
                    } else {
                        sk.pop();
                    }
                }

                // 조건 3 만들기
                M -= 3;
                if (M  > sk.size()) {
                    System.out.print("NO");
                } else {
                    while (M > 0) {
                        sb.append(sk.pop());
                        M--;
                    } 

                    System.out.println("YES");
                    System.out.print(sb.reverse().toString());
                }
            }
        }
    }
}  
