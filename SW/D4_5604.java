import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 레퍼런스 코드 
public class D4_5604 {
    static long A, B, v;
    static long nums[];
    static void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            A = Long.parseLong(st.nextToken());
            B = Long.parseLong(st.nextToken());

            nums = new long[10];

            A = A == 0 ? 1 : A;

            v = 1;
            check(A, B);

            long res = 0;
            for (int i = 1; i < 10; i++) {
                res += (nums[i] * i);
            }
            System.out.println(Arrays.toString(nums));
            System.out.printf("#%d %d\n", t, res);
        }
    }

    static void check(long s, long e) {
        while (s <= e) {
            while (s % 10 != 0 && s <= e) {
                count(s++);
            }

            if (s > e) return;

            while (e % 10 != 9 && s <= e) {
                count(e--);
            }

            long tmp = (e / 10) - (s / 10) + 1;
            for (int i = 0; i < 10; i++) {
                nums[i] += (tmp * v);
            }

            v *= 10;
            s /= 10;
            e /= 10;
        }
    }

    static void count(long n) {
        for (long i = n; i > 0; i /= 10) {
            String s = Long.toString(i);
            nums[s.charAt(s.length() - 1) - '0'] += v;
        }
    }
    public static void main(String[] args) throws IOException {
        sol();
    }
}
