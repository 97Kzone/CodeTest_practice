package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_16677 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String std = br.readLine();
        String res = "";
        int N = Integer.parseInt(br.readLine());

        int diff;
        double tmp;
        double v = 0;
        String word;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            word = st.nextToken();

            diff = word.length() - std.length();
            tmp = Double.parseDouble(st.nextToken()) / diff;

            int idx = 0;
            for (int j = 0; j < word.length(); j++) {
                if (std.charAt(idx) == word.charAt(j)) {
                    idx++;
                    if (idx == std.length())
                        break;
                }
            }

            if (idx >= std.length() && v < tmp) {
                v = tmp;
                res = word;
            }
        }
        System.out.println("".equals(res) ? "No Jam" : res);
    }
}
