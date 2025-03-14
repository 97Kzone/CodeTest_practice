package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S3_12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stk = new Stack<>();
        int idx = 1;

        for (int i = 0; i < N; i++) {
            if (nums[i] == idx) {
                idx++;
                continue;
            }

            if(!stk.isEmpty() && stk.peek() == idx) {
                stk.pop();
                i--;
                idx++;
            } else {
                stk.push(nums[i]);
            }
        }

        boolean flag = true;
        int tmp;
        for (int i = 0; i < stk.size(); i++) {
            tmp = stk.pop();

            if (tmp == idx) {
                idx++;
            } else {
                flag = false;
                break;
            }
        }

        System.out.print(flag ? "Nice" : "Sad");
    }
}
