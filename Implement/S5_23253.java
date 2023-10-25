package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_23253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean flag = true;

        int std;
        for (int i = 0; i < M; i++) {
            int c = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            std = 200001;
            for (int j = 0; j < c; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now > std) {
                    flag = false;
                }
                std = now;
            }
        }

        if (flag)
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}
