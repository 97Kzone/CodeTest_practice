package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class S4_1835 {

    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            dq.offer(i);
        }

        int idx = 1;
        int std;
        while(!dq.isEmpty()) {
            for (int i = 0; i < idx; i++) {
                dq.addLast(dq.pollFirst());
            }

            std = dq.pollFirst();
            nums[std] = idx++;
        }

        for (int i = 0; i < N; i++) {
            sb.append(nums[i] + " ");
        }

        System.out.print(sb.toString());
    }
}
