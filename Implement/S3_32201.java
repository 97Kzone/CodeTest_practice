package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class S3_32201 {

    static int N;
    static int[] keys;
    static Map<Integer, Integer> map1, map2;
    static Map<Integer, List<Integer>> rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        keys = new int[N];
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        rank = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            map1.put(Integer.parseInt(st.nextToken()), i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            keys[i-1] = Integer.parseInt(st.nextToken()); 
            map2.put(keys[i-1], i);
        }

        int v;
        int std = Integer.MIN_VALUE;
        List<Integer> tmp;
        for (int key : keys) {
            v = map1.get(key) - map2.get(key);
            std = Math.max(v, std);

            if(rank.containsKey(v)) {
                tmp = rank.get(v);
            } else {
                tmp = new ArrayList<>();
            }
            tmp.add(key);
            rank.put(v, tmp);
        }

        tmp = new ArrayList<>();
        for (int val : rank.get(std)) {
            tmp.add(val);
        }

        bw.write(tmp.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        bw.flush();
        bw.close();
    }
}
