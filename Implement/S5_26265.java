package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S5_26265 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String[][] words = new String[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            words[i][0] = st.nextToken();
            words[i][1] = st.nextToken();
        }

        Arrays.sort(words, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].equals(o2[0])) {
                    return o2[1].compareTo(o1[1]);
                }
                return o1[0].compareTo(o2[0]);
            }
        });

        for (String[] word : words) {
            sb.append(word[0] + " " + word[1] + '\n');
        }

        System.out.print(sb);
    }
}
