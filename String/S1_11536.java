package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class S1_11536 {
    static List<String> words1, words2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        words1 = new ArrayList<>();
        words2 = new ArrayList<>();

        String s;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            words1.add(s);
            words2.add(s);
        }

        String res = "NEITHER";

        Collections.sort(words1);
        for (int i = 0; i < N; i++) {
            if (!words1.get(i).equals(words2.get(i))) {
                break;
            }

            if (i == N - 1)
                res = "INCREASING";
        }

        Collections.sort(words1, Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            if (!words1.get(i).equals(words2.get(i))) {
                break;
            }

            if (i == N - 1)
                res = "DECREASING";
        }

        System.out.print(res);
    }
}