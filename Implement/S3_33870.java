package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_33870 {

    static int N, M;
    static int[] std, num, cnt;
    static boolean[] flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        std = new int[N + 1]; // 강아지별 엉키는 기준
        num = new int[M]; // 빗어주는 강아지 번호
        flag = new boolean[N + 1];
        cnt = new int[N + 1]; // 현재 스택
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            std[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int idx;
        for (int i = 1; i <= M + 1; i++) {
            for (int j = 1; j <= N; j++) {
                flag[j] = flag[j] || std[j] < i - cnt[j];
            }

            if (M < i) break;

            idx = num[i - 1];
            flag[idx] = flag[idx] && cnt[idx] != i - 1;
            cnt[idx] = i;
        }

        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (flag[i]) res++;
        }        

        System.out.print(res);
    }
}
