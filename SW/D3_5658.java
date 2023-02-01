import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class D3_5658 {
    static int N, K;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            set = new HashSet<>(); // 집합생성

            String s = br.readLine();
            int l = s.length() / 4;
            s += s.substring(0, l-1);

            // 가능한 모든 수 집합에 삽입
            for (int i = 0; i <= s.length()-l; i++) {
                set.add(Integer.parseInt(s.substring(i, i+l), 16));                
            }

            // Set -> List and sort
            ArrayList<Integer> nums = new ArrayList<>(set);
            Collections.sort(nums, Collections.reverseOrder());
            
            System.out.printf("#%d %d\n", t, nums.get(K-1));
        }
    }
}
