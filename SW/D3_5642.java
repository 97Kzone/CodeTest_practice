import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class D3_5642 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N  = Integer.parseUnsignedInt(st.nextToken());
             
            int[] nums = new int[N];
 
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
 
            int res = nums[0];
            for (int i = 2; i < N; i++) {
                if (nums[i-1] > 0 && nums[i] + nums[i-1] > 0) {
                    nums[i] += nums[i-1];
                } 
 
                if (nums[i] > res) {
                    res = nums[i];
                }
            }
            System.out.printf("#%d %d\n", t, res);
        }
    }
}