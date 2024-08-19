package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class S3_31869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<String, int[]> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        String name;
        int w, d, p;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            name = st.nextToken();
            w = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            map.put(name, new int[] { w, d, p });
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            name = st.nextToken();
            w = Integer.parseInt(st.nextToken());

            if (map.get(name)[2] > w) {
                map.remove(name);
            }
        }

        List<int[]> list = new ArrayList<>();
        int[] val;
        for (String key : map.keySet()) {
            val = map.get(key);
            list.add(new int[] { val[0], val[1] });
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } 
                return o1[0] - o2[0];
            }
        });

        int res = 0;
        if (list.size() == 0) {
            System.out.print(res);
            return;
        }

        int s1 = list.get(0)[0];
        int s2 = list.get(0)[1];
        int cnt = 1;
        for (int i = 1; i < list.size(); i++) {
            val = list.get(i);

            // 같은 날에는 2명에게 못 얻어 먹는다
            if (s1 == val[0] && s2 == val[1]) {
                continue;
            }

            // 기준이 막날이라면
            if (s2 == 6) {
                if (val[0] == s1 + 1 && val[1] == 0) {
                    cnt++;
                } else {
                    res = Math.max(res, cnt);
                    cnt = 1;
                }
                // 같은주라면
            } else if (s1 == val[0]) {
                if (val[1] == s2 + 1) {
                    cnt++;
                } else {
                    res = Math.max(res, cnt);
                    cnt = 1;
                }
            } else {
                res = Math.max(res, cnt);
                cnt = 1;
            }
            s1 = val[0];
            s2 = val[1];
        }
        res = Math.max(res, cnt);
        System.out.print(res);        
    }
}
