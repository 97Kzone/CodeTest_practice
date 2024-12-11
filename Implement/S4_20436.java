package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S4_20436 {
    
    static HashMap<Character, int[]> map1, map2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init();

        char[] start = br.readLine().toCharArray();
        char l = start[0];
        char r = start[2];

        char[] s = br.readLine().toCharArray();
        int res = check(l, r, s);
        System.out.print(res);
    }
    
    static int check(char l, char r, char[] word) {
        int res = 0;

        int[] num1, num2;
        for (char s : word) {
            if (map1.containsKey(s)) {
                num1 = map1.get(l);
                num2 = map1.get(s);
                l = s;
            } else {
                num1 = map2.get(r);
                num2 = map2.get(s);
                r = s;
            }

            res += Math.abs(num1[0] - num2[0]) + Math.abs(num1[1] - num2[1]);
            res++;
        }

        return res;
    }

    static void init() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();

        map1.put('q', new int[] {0, 0});
        map1.put('w', new int[] {0, 1});
        map1.put('e', new int[] {0, 2});
        map1.put('r', new int[] {0, 3});
        map1.put('t', new int[] {0, 4});
        map2.put('y', new int[] {0, 5});
        map2.put('u', new int[] {0, 6});
        map2.put('i', new int[] {0, 7});
        map2.put('o', new int[] {0, 8});
        map2.put('p', new int[] {0, 9});
        
        map1.put('a', new int[] { 1, 0 });
        map1.put('s', new int[] { 1, 1 });
        map1.put('d', new int[] { 1, 2 });
        map1.put('f', new int[] { 1, 3 });
        map1.put('g', new int[] { 1, 4 });
        map2.put('h', new int[] { 1, 5 });
        map2.put('j', new int[] { 1, 6 });
        map2.put('k', new int[] { 1, 7 });
        map2.put('l', new int[] { 1, 8 });

        map1.put('z', new int[] { 2, 0 });
        map1.put('x', new int[] { 2, 1 });
        map1.put('c', new int[] { 2, 2 });
        map1.put('v', new int[] { 2, 3 });
        map2.put('b', new int[] { 2, 4 });
        map2.put('n', new int[] { 2, 5 });
        map2.put('m', new int[] { 2, 6 });
    }
}
