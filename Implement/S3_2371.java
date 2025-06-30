package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class S3_2371 {

    static int N;
    static List<List<Integer>> lists;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        lists = new ArrayList<>();

        List<Integer> list;
        int v;
        for (int i = 0; i < N; i++) {
            list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            while(true) {
                v = Integer.parseInt(st.nextToken());
                if(v == -1) break;

                list.add(v);
            }

            lists.add(list);
        }

        int res = 0;
        set = new HashSet<>();
        while(true) {
            if (check(res++)) break;
            set.clear();
        }

        System.out.print(res);
    }

    static boolean check(int v) {
        for (List<Integer> list : lists) {
            if (v >= list.size()) continue;

            if(set.contains(list.get(v))) return false;
            set.add(list.get(v));
        }

        return true;
    }
}
