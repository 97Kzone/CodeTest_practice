package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class G4_17298 {
    static int N;
    static int[] nums, res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        res = new int[N];
        nums = new int[N];
        Stack<Integer> sk = new Stack<>();
        Arrays.fill(res, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            while (!sk.isEmpty() && nums[sk.peek()] < nums[i]) {
                res[sk.peek()] = nums[i];
                sk.pop();
            }
            sk.push(i);
        }

        for (int n : res) {
            sb.append(n + " ");
        }

        System.out.print(sb.toString());
    }
}
