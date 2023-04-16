package ACG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    static int N;
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        s = br.readLine();

        String s1, s2;
        // 길이를 1부터 N-1 까지 잘라가면서 비교...?
        for (int i = 1; i < N; i++) {
            s1 = s.substring(0, i);
            s2 = s.substring(N - i);
            
            if (check(s1, s2)) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
    
    static boolean check(String s1, String s2) {
        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            res++;
            if (res > 1) return false;
        }
        
        if (res == 0) return false;
        return true;
    } 
}
