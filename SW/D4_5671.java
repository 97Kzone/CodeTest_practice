import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_5671 {
    static int N, M, cnt;
    static int[] std, word;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            std = new int[26];
            String s = "";
            for (int i = 0; i < N; i++) {
                word = new int[26];
                s = br.readLine();
                
                for (int j = 0; j < s.length(); j++) {
                    word[s.charAt(j)-'a'] = 1;
                }
                
                cnt = 0;
                for (int n : word) {
                    cnt += n;
                }

                if (cnt > M) continue; // M개 이상의 알파벳이면 continue
                
                // M개 이하의 단어면 std 배열에 더해준다
                for (int j = 0; j < 26; j++) {
                    std[j] += word[j];
                }
            }

            Arrays.sort(std);
            System.out.printf("#%d %d\n", t, std[25]);
        }
    }
}
