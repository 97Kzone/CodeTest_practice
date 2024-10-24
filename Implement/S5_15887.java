package Implement;

import java.util.*;
import java.io.*;

public class S5_15887 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] num1 = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num1[i] = Integer.parseInt(st.nextToken());
        }

        int[] num2 = num1.clone();
        Arrays.sort(num2);

        int i = 1;
        int cnt = 0;
        List<int[]> list = new ArrayList<>();

        int std;
        while (!Arrays.equals(num1, num2)) {
            if (num1[i - 1] == i) {
                i++;
                continue;
            }

            cnt++;
            std = 0;
            for (int j = 0; j < N; j++) {
                if (num1[j] == i) {
                    std = j + 1;
                    break;
                }
            }

            reverse(num1, i - 1, std - 1);
            list.add(new int[] { i, std });
            i++;
        }

        sb.append(list.size() + "\n");
        for (int[] n : list) {
            sb.append(n[0] + " " + n[1] + "\n");
        }

        System.out.println(sb);
    }
    
    static void reverse(int[] num, int l, int r) {
        int tmp;
        while (l < r) {
            tmp = num[l];
            num[l] = num[r];
            num[r] = tmp;
            l++;
            r--;
        }
    }
}
