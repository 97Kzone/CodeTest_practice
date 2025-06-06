package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S3_31845 {

    static int N, M;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list, (o1, o2) -> (o2 - o1));

        int res = 0;
        for (int i = 0; i < M; i++) {
            if (list.get(0) <= 0) break;

            if (list.get(0) > 0) {
                res += list.get(0);
                list.remove(0);

                if (list.size() != 0) {
                    list.remove(list.size() - 1);
                }
            }

            if (list.isEmpty()) break;
        }

        System.out.print(res);
    }
}
