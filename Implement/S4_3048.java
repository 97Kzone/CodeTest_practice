package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S4_3048 {

    static int N1, N2, T;

    static class Ant {
        char name;
        int d;

        Ant (char name, int d) {
            this.name = name;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N1 = Integer.parseInt(st.nextToken());
        N2 = Integer.parseInt(st.nextToken());

        List<Ant> list = new ArrayList<>();
        String s = br.readLine();
        for (int i = N1 - 1; i >= 0; i--) {
            list.add(new Ant(s.charAt(i), 1));
        }

        s = br.readLine();
        for (int i = 0; i < N2; i++) {
            list.add(new Ant(s.charAt(i), -1));
        }

        T = Integer.parseInt(br.readLine());

        Ant now, nxt;
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < list.size() - 1; i++) {
                now = list.get(i);
                nxt = list.get(i + 1);

                if (now.d == 1 && now.d != nxt.d) {
                    list.set(i, nxt);
                    list.set(i + 1, now);
                    i++;
                }
            }
        }

        for (Ant ant : list) {
            sb.append(ant.name);
        }

        System.out.print(sb.toString());
    }
}
