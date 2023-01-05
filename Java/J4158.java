package Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class J4158 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N==0 && M==0) {
                break;
            }

            set = new HashSet<>();
            int res = 0;

            for (int i=0; i<N; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }
            
            for (int i=0; i<M; i++) {
                int tmp = Integer.parseInt(br.readLine());
                if (set.contains(tmp)) {
                    res += 1;
                }
            }
            System.out.println(res);
        }
    }
}
