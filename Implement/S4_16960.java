package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class S4_16960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] sch = new ArrayList[N];
        int[] nums = new int[M+1];

        for (int i = 0; i < N; i++) {
            sch[i] = new ArrayList<>();
        }

        int n, idx;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                idx = Integer.parseInt(st.nextToken());
                sch[i].add(idx);
                nums[idx]++;
            }
        }

        // 1번 스위치부터 차례대로 꺼보기
        boolean flag;
        int res = 0;
        for (int i = 0; i < N; i++) {
            flag = true;
            for (int std : sch[i]) {
                nums[std]--;
            }

            for (int j = 1; j <= M; j++) {
                if (nums[j] == 0) {
                    flag = false;
                }
            }

            if (flag) {
                res = 1;
                break;
            }
            
            for (int std : sch[i]) {
                nums[std]++;
            }
        }

        System.out.print(res);
    }
}
