import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SW_4008 {
    static int N, rMin, rMax;
    static int[] nums, select, op; // 0 : +, 1 : -, 2 : *, 3 : /
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
 
            nums = new int[N];
            select = new int[N-1];
            op = new int[4];
 
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                op[i] = Integer.parseInt(st.nextToken());
            }
 
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
             
            rMin = Integer.MAX_VALUE;
            rMax = Integer.MIN_VALUE;
            pm(0);
             
            sb.append("#" + t + " ").append(rMax-rMin + " \n");
        }
        System.out.print(sb.toString());
    }
 
    static void pm(int cnt) {
        if (cnt == N-1) {
            check();
            return;
        }
 
        for (int i = 0; i < 4; i++) {
            if (op[i] == 0) continue;
 
            op[i]--;
            select[cnt] = i;
            pm(cnt + 1);
            op[i]++;
        }
    }
 
    static void check() {   
        int v = nums[0];
        for (int i = 1; i < N; i++) {
            if (select[i-1] == 0) v += nums[i];
            else if (select[i-1] == 1) v -= nums[i];
            else if (select[i-1] == 2) v *= nums[i];
            else v /= nums[i];
        }
 
        rMin = Math.min(rMin, v);
        rMax = Math.max(rMax, v);
    }
}