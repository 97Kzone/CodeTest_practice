package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S2_30786 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        int x, y;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if ((x + y) % 2 == 0) list1.add(i);
            else list2.add(i);
        }

        int cnt1 = list1.size();
        int cnt2 = list2.size();

        if (cnt1 == 0 || cnt2 == 0) {
            sb.append("NO");
        } else {
            sb.append("YES" + "\n");

            for (int num : list1) {
                sb.append(num + " ");
            }

            for (int num : list2) {
                sb.append(num + " ");
            }
        }

        System.out.print(sb.toString());
    }
}
