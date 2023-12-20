package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class G5_30023 {

    static int N;
    static final int VALUE = 1000000000;
    static char[] arr;
    static Map<Character, Character> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init();
        N = Integer.parseInt(br.readLine());
        int res = VALUE;

        arr = br.readLine().toCharArray();

        for (int i = 0; i < 3; i++) {
            res = Math.min(res, check(arr.clone()) + i);
            change(arr, 0);
        }

        if (res == VALUE) {
            res = -1;
        }
        
        System.out.println(res);
    }
    
    static int check(char[] arr2) {
        int cnt = 0;

        for (int i = 1; i < N - 2; i++) {
            while (arr2[0] != arr2[i]) {
                cnt++;
                change(arr2, i);
            }
        }

        if (arr2[0] == arr2[N - 1] && arr2[0] == arr2[N - 2]) {
            return cnt;
        }
        return VALUE;
    }

    static void change(char[] arr, int idx) {
        arr[idx] = map.get(arr[idx]);
        arr[idx + 1] = map.get(arr[idx + 1]);
        arr[idx + 2] = map.get(arr[idx + 2]);

    }

    static void init() {
        map.clear();

        map.put('R', 'G');
        map.put('G', 'B');
        map.put('B', 'R');
    }
}
