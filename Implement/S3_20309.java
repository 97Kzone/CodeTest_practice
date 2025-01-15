package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_20309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int num;
        String res = "YES";
        for (int i = 1; i <= N; i++) {
            num = Integer.parseInt(st.nextToken());
            if (i % 2 == num % 2)
                continue;

            res = "NO";
            break;
        }
        
        System.out.print(res);
    }
}
