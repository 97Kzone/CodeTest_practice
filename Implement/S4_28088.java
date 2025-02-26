package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_28088 {

    static int N, M, K;
    static int[] nums1, nums2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums1 = new int[N];
        nums2 = new int[N];
        for (int i = 0; i < M; i++) {
            nums1[Integer.parseInt(br.readLine())] = 1;
        }

        int nxt, prev;
        int[] tmp;
        for (int i = 0; i < K; i++) {
            Arrays.fill(nums2, 0);
            for (int j = 0; j < N; j++) {
                nxt = (j + 1) % N;
                prev = (j + N - 1) % N;

                if (nums1[j] == 1) {
                    nums2[nxt] ^= 1;
                    nums2[prev] ^= 1;
                }
            }

            tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        System.out.println(Arrays.stream(nums1).sum());
    }
}
