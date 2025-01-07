package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S5_25374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = { 0, 4, 7, 12, 17, 20, 17, 12, 7, 4 };
        int[] res = new int[10];
        
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(Collections.reverseOrder());

        int std = 1;
        res[std]++;
        nums[std]--;

        int tmp;
        for (int i = 1; i < N; i++) {
            if (nums[std] == 0) {
                tmp = std + 1;
                if (list.get(i - 1) == (list.get(i))) {
                    while (nums[tmp] == 0) tmp++;

                    nums[std]++;
                    nums[tmp]--;
                } else {
                    while (nums[tmp] == 0) tmp++;
                    std = tmp;
                }
            }
            res[std]++;
            nums[std]--;
        }

        for (int i = 1; i < 10; i++) {
            sb.append(res[i] + "\n");
        }
        System.out.print(sb);
    }
}
