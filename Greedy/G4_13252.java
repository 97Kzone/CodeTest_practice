package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class G4_13252 {
 
    static Map<Long, double[]> map = new HashMap<>();    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        double res = check(N, M, K);
        System.out.print(res);
    }

    static double check(long n, int m, int k) {
        if (n == 0) return 0;

        if (k == 1) {
            if (n >= 2) return 1;
            else return (double) (m - n) / m;
        }
        
        if (map.get(n) != null) {
            if (map.get(n)[k] != 0) return map.get(n)[k];
        }

        long[] temp = new long[m];
        long left = n;
        for (int i = 0; i < m; i++) {
            if (n > m) {
                if (i != m - 1) {
                    temp[i] = n / m;
                    left -= n / m;
                } else
                    temp[i] = left;
            } else {
                if (left != 0) {
                    temp[i] = 1;
                    left--;
                } else
                    temp[i] = 0;
            }
        }
        
        double res = 0;
        res += (double) (n % m) / m * check(n - (n / m + 1), m, k - 1) + (double)(m - n % m) / m * check(n - (n / m), m, k - 1);
		if (map.get(n) == null) {
			double[] d = new double[51];
			d[k] = res;
			map.put(n, d);
		}
		else {
			double[] d = map.get(n);
			d[k] = res;
			map.put(n, d);
		}
		
		return map.get(n)[k];
    }
}