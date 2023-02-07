package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class P5_14003 {
    static int N;
    static ArrayList<Integer> nums;
    static int[] lis, std; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new ArrayList<>();
        lis = new int[N];
        std = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        lis[cnt] = nums.get(0);
        std[cnt++] = 0;

        for (int i = 1; i < N; i++) {
            if (lis[cnt] < nums.get(i)) {
                cnt++;
                lis[cnt] = nums.get(i);
                std[i] = cnt;
            } else {
                int idx = check(nums.get(i), 0, cnt);

                lis[idx] = nums.get(i);
                std[i] = idx;
            }
        }

        Stack<Integer> stack = new Stack<>();
        int idx = cnt;
        System.out.println(Arrays.toString(std));
        for (int i = N-1; i >= 0; i--) {
            if (std[i] == idx) {
                idx--;
                stack.push(nums.get(i));
            }
        }

        System.out.println(cnt);
        for (int i = 0; i < cnt; i++) {
            System.out.print(stack.pop() + " ");
        }
    }

    static int check(int v, int s, int e) {
        int m;
        while (s < e) {
            m = (s + e) / 2;

            if (v <= lis[m]) {
                e = m;
            } else {
                s = m + 1;
            }
        }

        return s;
    }
}
