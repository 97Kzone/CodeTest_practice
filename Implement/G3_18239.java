package Implement;

import java.util.Scanner;

public class G3_18239 {
    static int N, K;
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        // Case 1) N = 2 : 무조건 가능
        if (N == 2) {
            sb.append("YES\n").append("swap 1 2\n swap 1 2\n swap 1 2\n swap 1 2\n swap 1 2");
        } else if (N == 3) { // Case 2) N = 3 : 무조건 불가능
            sb.append("NO");
        } else if (K == 1) { // Case 3) K = 1 or N - 1 : 
            sb.append("YES\n");
            sb.append("swap " + K + " " + (K+1) + "\n");
            sb.append("reverse " + (K+1) + " " + N + "\n");
            sb.append("reverse " + (K+1) + " " + (N-1) + "\n");
            sb.append("reverse 1 " + N + "\n");
            sb.append("reverse 1 " + N);
        } else if (K == N - 1) {
            sb.append("YES\n");
            sb.append("swap " + K + " " + (K+1) + "\n");
            sb.append("reverse 1 " + K + "\n");
            sb.append("reverse 2 " + K + "\n");
            sb.append("reverse 1 " + N + "\n");
            sb.append("reverse 1 " + N);
        } else {
            sb.append("YES\n");
            sb.append("reverse 1 " + K + "\n");
            sb.append("reverse " + (K+1) + " " + N + "\n");
            sb.append("reverse 1 " + N + "\n");
            sb.append("reverse 1 " + N + "\n");
            sb.append("reverse 1 " + N);
        }
        
        // Case 4) 그 외 reverse 5회면 가능
        System.out.print(sb.toString());
    }
}