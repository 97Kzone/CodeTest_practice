package Implement;

import java.io.*;
import java.util.*;

public class S4_2331 {

    static int A, P;
    static Map<Integer, Integer> map;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        list = new ArrayList<>();

        int cur = A;
        int idx = 0;

        while (true) {
            if (map.containsKey(cur)) {
                bw.write(String.valueOf(map.get(cur)));
                break;
            }

            map.put(cur, idx++);
            list.add(cur);

            cur = check(cur);
        }

        bw.flush();
        bw.close();
    }

    static int check(int v) {
        int res = 0;
        int mod;
        while (v > 0) {
            mod = v % 10;
            v /= 10;
            res += Math.pow(mod, P);
        }
        return res;
    }
}
