import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lv3_성적평균 {
    static int N, K;
    static double[] nums;
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new double[N];
      
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Double.parseDouble(st.nextToken());
        }

        int a, b;
        double score;
        String s;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            score = 0.0;
            for (int j = a - 1; j < b; j++) {
                score += nums[j];
            }
          
            s = String.format("%.2f", score / (b - a + 1));
            sb.append(s + "\n");
        }
        System.out.print(sb.toString());
    }
}
