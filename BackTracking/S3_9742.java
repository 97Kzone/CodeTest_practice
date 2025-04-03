package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_9742 {

    static int cnt, num;
    static boolean[] used;
    static char[] std;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        String tmp, s;
        while((tmp = br.readLine()) != null) {
            st = new StringTokenizer(tmp); 

            s = st.nextToken();
            num = Integer.parseInt(st.nextToken());

            cnt = 0;
            std = new char[s.length()];
            used = new boolean[s.length()];

            sb.append(s + " " + num + " = ");
            check(s, 0);

            if (cnt < num) sb.append("No permutation").append("\n");
        }
        System.out.print(sb.toString());
    }

    static void check(String s, int v) {
        if (v == s.length()) {
            cnt++;
            if (cnt == num) sb.append(new String(std)).append("\n");
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (used[i]) continue;

            used[i] = true;
            std[v] = s.charAt(i);
            check(s, v + 1);
            used[i] = false;
        }
    }
}
