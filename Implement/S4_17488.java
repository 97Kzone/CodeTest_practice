package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S4_17488 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>> success = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            success.add(new ArrayList<>());
        }
        for (int i = 0; i <= n; i++) {
            ans.add(new ArrayList<>());
        }

        for (int t = 0; t < 2; t++) {
            List<List<Integer>> newSuccess = new ArrayList<>();
            for (int i = 0; i <= m; i++) {
                newSuccess.add(new ArrayList<>(success.get(i)));
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int k = st.countTokens();
                int[] L = new int[k];
                for (int j = 0; j < k; j++) {
                    L[j] = Integer.parseInt(st.nextToken());
                }

                for (int j = 0; j < k - 1; j++) {
                    newSuccess.get(L[j]).add(i + 1);
                }
            }

            for (int i = 1; i <= m; i++) {
                if (newSuccess.get(i).size() <= arr[i]) {
                    success.set(i, new ArrayList<>(newSuccess.get(i)));
                } else {
                    arr[i] = 0;
                }
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int x : success.get(i)) {
                ans.get(x).add(i);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!ans.get(i).isEmpty()) {
                for (int x : ans.get(i)) {
                    sb.append(x).append(" ");
                }
                sb.append("\n");
            } else {
                sb.append("망했어요\n");
            }
        }

        System.out.print(sb.toString());
    }
}
