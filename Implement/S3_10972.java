package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S3_10972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int idx = -1;
        // 1. 피벗 포인트 체크
        for (int i = N-2; i >= 0; i--) {
            if (list[i] < list[i+1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            System.out.print(-1);
            return;
        }

        int tmp;
        // 2. 피벗 포인트보다 큰 수 찾기
        for (int i = N-1; i > idx; i--) {
            if (list[idx] < list[i]) {
                tmp = list[idx];
                list[idx] = list[i];
                list[i] = tmp;
                break;
            }
        }

        int l = idx + 1;
        int r = N - 1;
        while(l < r) {
            tmp = list[l];
            list[l] = list[r];
            list[r] = tmp;
            l++;
            r--;
        }

        for (int i = 0; i < N; i++) {
            sb.append(list[i] + " ");
        }

        System.out.print(sb.toString());
    }
}
