package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S5_18706 {

    static Map<String, int[]> menus;
    static Map<String, Integer> price;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        price = new HashMap<>();
        price.put("small", 0);
        price.put("medium", 1);
        price.put("large", 2);

        int T = Integer.parseInt(br.readLine());
        int C, P;        

        int s, m, l, cost1, cost2;
        Map<String, int[]> menus;
        String name, size, menu;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            C = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            menus = new HashMap<>();
            cost1 = Math.round(100 / P);
            for (int i = 0; i < C; i++) {
                st = new StringTokenizer(br.readLine());

                menu = st.nextToken();
                s = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());
                l = Integer.parseInt(st.nextToken());

                menus.put(menu, new int[] {s, m, l});
            }
            
            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());

                name = st.nextToken();
                size = st.nextToken();
                menu = st.nextToken();

                
                cost2 = cost1 + menus.get(menu)[price.get(size)];
                if (cost2 % 5 == 1) {
                    cost2 -= 1;
                } else if (cost2 % 5 == 4) {
                    cost2 += 1;
                }

                bw.write(name + " " + cost2 + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
