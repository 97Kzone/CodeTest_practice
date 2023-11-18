package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class S1_1141 {

    static int N, res;
    static List<String> words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        res = 0;
        N = Integer.parseInt(br.readLine());
        words = new ArrayList<>();

        String s;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            words.add(s);
        }

        Collections.sort(words, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length())
                    return 1;
                else if (o1.length() > o2.length())
                    return -1;
                else {
                    return o1.compareTo(o2);
                }
            }
        });

        String word;
        boolean flag;
        List<String> set = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            set.clear();
            for (int j = i; j < N; j++) {

                word = words.get(j);
                flag = true;

                for (String std : set) {
                    if (std.startsWith(word) || word.startsWith(std)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    set.add(word);
                }
            }
            res = Math.max(res, set.size());
        }

        System.out.print(res);
    }
}
