package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class S3_21967 {

    static int N;
    static int[] nums, std;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        std = new int[11];
        Deque<Integer> dq = new ArrayDeque<>();
        int res = 0;
        int idx, min, max, tmp;
        for (int i = 0; i < N; i++) {
            idx = nums[i];
            dq.add(idx);

            std[idx]++;
            max = checkmax();
            min = checkmin();

            if (max - min > 2) {
                tmp = dq.pollFirst();
                std[tmp]--;
                continue;
            }

            res = Math.max(res, dq.size());
        }

        System.out.print(res);
    }

    static int checkmax() {
        for (int i = 10; i > 0; i--) {
            if (std[i] == 0)
                continue;
            return i;
        }

        return -1;
    }
    
    static int checkmin() {
        for (int i = 1; i <= 10; i++) {
            if (std[i] == 0) continue;
            return i;
        }

        return -1;
    }
}
