import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class D3_1221 {
    static String[] nums = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
    static Map<String, Integer> board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            init();
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            int N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                String s = st.nextToken();
                board.put(s, board.get(s)+1);
            }

            System.out.printf("#%d\n", t);
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < board.get(nums[i]); j++) {
                    System.out.print(nums[i] + " ");
                }
            }
            System.out.println();
        }
    }

    static void init() {
        board = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            board.put(nums[i], 0);
        }
    }
}
