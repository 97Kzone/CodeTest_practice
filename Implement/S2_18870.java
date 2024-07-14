package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S2_18870 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] num1 = new int[N];
        int[] num2 = new int[N];
        Map<Integer, Integer> maps = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num1[i] = Integer.parseInt(st.nextToken());
        }
        num2 = deepCopy(num1);

        Arrays.sort(num2);
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (maps.containsKey(num2[i])) {
                continue;
            }

            maps.put(num2[i], idx++);
        }
        
        for (int num : num1) {
            sb.append(maps.get(num) + " ");
        }

        System.out.print(sb);
    }
    
    static int[] deepCopy(int[] num1) {
        int[] tmp = new int[N];
        for (int i = 0; i < N; i++) {
            tmp[i] = num1[i];
        }

        return tmp;
    }
    
} 
