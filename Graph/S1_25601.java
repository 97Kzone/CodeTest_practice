package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class S1_25601 {

    static int N;
    static Map<String, List<String>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        String s, e;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());

            s = st.nextToken();
            e = st.nextToken();

            if (!map.containsKey(s)) map.put(s, new ArrayList<>());
            map.get(s).add(e);
        }

        st = new StringTokenizer(br.readLine());
        s = st.nextToken();
        e = st.nextToken();

        boolean flag1 = check(s, e);
        boolean flag2 = check(e, s);

        System.out.print(flag1 || flag2 ? 1 : 0);
    }

    static boolean check(String s, String e) {
        if (s.equals(e)) return true;

        if (map.get(s) == null) return false;

        for (String nxt : map.get(s)) {
            if (check(nxt, e)) return true;
        }

        return false;
    }
}
