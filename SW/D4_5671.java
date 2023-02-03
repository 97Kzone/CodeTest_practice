import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

// 조합 + 완전탐색
public class D4_5671 {
    static int N, M, res;
    static String[] key;
    static List<String[]> words;
    static Set<String> word;

    static void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());    
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            words = new ArrayList<>();
            word = new HashSet<>();
            String s = "";

            // 1. 조합에 쓸 알파벳 추출
            for (int i = 0; i < N; i++) {
                s = br.readLine();
                String tmp = "";
                for (int j = 0; j < s.length(); j++) {
                    if (s.indexOf(s.charAt(j)) == j) {
                        tmp += s.charAt(j);
                        word.add(String.valueOf(s.charAt(j)));
                    }
                }
                words.add(tmp.split(""));
            }

            
            // 2. 조합
            key = word.toArray(new String[0]);
            res = 0;
            cb(0, 0, new String[M]);
            System.out.printf("#%d %d\n", t, res);
        }
    }

    static void cb(int cnt, int idx, String[] arr) {
        if (cnt == M) {
            check(arr);
            return;
        }

        for (int i = idx; i < key.length; i++) {
            arr[cnt] = key[i];
            cb(cnt+1, i+1, arr);
        }
    }

    // 3. 가르칠 알파벳 조합으로 몇개까지 될까 판단
    static void check(String[] std) {
        List<String> list = Arrays.asList(std);
        int cnt = 0;
        for (String[] s : words) {
            if(list.containsAll(Arrays.asList(s))) cnt++;
        }
        res = cnt > res ? cnt : res;
    }
    public static void main(String[] args) throws IOException {
        sol();
    }
}
