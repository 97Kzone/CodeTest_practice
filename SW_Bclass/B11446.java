package SW_Bclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11446 {
    static int N;
    static long M, std;
    static Long[] candy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Long.parseLong(st.nextToken());

            candy = new Long[N + 1];
            std = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                candy[i] = Long.parseLong(st.nextToken());
                std = Math.max(std, candy[i]);
            }

            long l = 1, r = std;
            long mid, sum, res = 0;
            while (l <= r) {
                mid = (l + r) / 2;
                sum = 0;

                for (int i = 0; i < N; i++)
                    sum += (candy[i] / mid);

                if (sum < M)
                    r = mid - 1;
                else {
                    res = mid;
                    l = mid + 1;
                }
            }
            sb.append("#" + t + " " + res + "\n");
        }
        System.out.print(sb.toString());  
    }
}
