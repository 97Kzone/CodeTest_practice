import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D4_1486 {
    static int N, B, res;
    static int[] nums;
    static ArrayList<Integer> sub;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            nums = new int[N];
            sub = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            res = Integer.MAX_VALUE;
            check();
            
            sb.append("#").append(t).append(" ").append(res-B).append("\n");
        }
        System.out.print(sb.toString());
    }

    //부분집합 돌려보자
    static void check() {
        int tmp;
        for (int i = 0; i < (1 << N); i++) {
            sub.clear();
            tmp = 0;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    sub.add(nums[j]);
                } 
            }

            for (int n : sub) {
                tmp += n;
            }

            if (tmp >= B && res > tmp) res = tmp;
        }
        
    }
}
