package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//chatGPT 가 작성한 코드
public class test {
    static int T, n, a[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine().trim());
            a = new int[n][3];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine().trim());
                a[i][0] = Integer.parseInt(st.nextToken());
                a[i][1] = Integer.parseInt(st.nextToken());
                a[i][2] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a, (x, y) -> x[1] - y[1]); // 배열을 b 값을 기준으로 정렬
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int max = 0;
                for (int j = i; j >= 0; j--) {
                    if (a[j][1] <= a[i][0]) break; // a[i][0] 값보다 b[j] 가 작아지면 break
                    max = Math.max(max, a[j][2]); // max 값 갱신
                }
                ans = Math.max(ans, max + a[i][1]);
            }
            System.out.println(ans);
        }
    }
}
