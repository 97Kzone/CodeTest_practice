package SC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a {
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        // 1. N 이 홀수인가?
        if (N % 2 == 1) {
            //1-1. M 이 홀수면 실패
            if (M % 2 == 0) {
                sb.append(M + "\n");
                for (int i = 0; i < M; i++) {
                    sb.append(i * 2 + 1).append(" ");
                }
            }
        } else {
            // 1-2 M 이 짝수면 실패
            if (M % 2 == 1) {
                sb.append(M + "\n");
                for (int i = 1; i <= M; i++) {
                    sb.append(i * 2).append(" ");
                }
            }
        }
        
        if (sb.length() == 0) sb.append("-1");
        System.out.print(sb.toString());
    }
}
