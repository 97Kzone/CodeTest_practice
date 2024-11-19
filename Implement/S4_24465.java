package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S4_24465 {

    static boolean[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        nums = new boolean[12];
        int m, d;
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            nums[check(m, d)] = true;
        }

        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            if (nums[check(m, d)])
                continue;

            list.add(new int[] { m, d });
        }
        
        if (list.isEmpty()) {
            sb.append("ALL FAILED");
        } else {
            list.sort((o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            });

            for (int[] num : list) {
                sb.append(num[0] + " " + num[1] + "\n");
            }
        }

        System.out.print(sb);
    }
    
    static int check(int month, int day) {
        if (month == 1) {
            return day < 20 ? 11 : 0;
        } else if (month == 2) {
            return day < 19 ? 0 : 1;
        } else if (month == 3) {
            return day < 21 ? 1 : 2;
        } else if (month == 4) {
            return day < 20 ? 2 : 3;
        } else if (month == 5) {
            return day < 21 ? 3 : 4;
        } else if (month == 6) {
            return day < 22 ? 4 : 5;
        } else if (month == 7) {
            return day < 23 ? 5 : 6;
        } else if (month == 8) {
            return day < 23 ? 6 : 7;
        } else if (month == 9) {
            return day < 23 ? 7 : 8;
        } else if (month == 10) {
            return day < 23 ? 8 : 9;
        } else if (month == 11) {
            return day < 23 ? 9 : 10;
        } else {
            return day < 22 ? 10 : 11;
        }
    }
}