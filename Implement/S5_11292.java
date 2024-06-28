package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S5_11292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        List<String> list = new ArrayList<>();
        
        double std, val;
        String name;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;

            list.clear();
            std = 0;
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                name = st.nextToken();
                val = Double.parseDouble(st.nextToken());

                if (std < val) {
                    list.clear();
                    list.add(name);
                    std = val;
                } else if (std == val) {
                    list.add(name);
                }
            }

            for (String n : list) {
                sb.append(n + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
