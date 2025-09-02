package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S4_29753 {

    static int N;
    static BigDecimal X;
    static Map<String, BigDecimal> map;
    static String[] grades = {"F", "D0", "D+", "C0", "C+", "B0", "B+", "A0", "A+"};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        init();

        N = Integer.parseInt(st.nextToken());
        X = new BigDecimal(st.nextToken());

        BigDecimal tot = BigDecimal.ZERO; // 학점 총합
        BigDecimal sum = BigDecimal.ZERO; // 학점 x 평점의 합

        int c;
        String g;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            c = Integer.parseInt(st.nextToken());
            g = st.nextToken();

            BigDecimal credit = new BigDecimal(c);
            tot = tot.add(credit);
            sum = sum.add(credit.multiply(map.get(g)));
        }

        c = Integer.parseInt(br.readLine());
        BigDecimal lastCredit = new BigDecimal(c);
        tot = tot.add(lastCredit);
        
        BigDecimal tmp, avg;
        for (String grade : grades) {
            tmp = sum.add(lastCredit.multiply(map.get(grade)));
            avg = tmp.divide(tot, 10, RoundingMode.HALF_UP) 
                     .setScale(2, RoundingMode.DOWN);      
            
            if (avg.compareTo(X) > 0) {
                System.out.print(grade);
                return;
            }
        }

        System.out.print("impossible");
    }

    static void init() {
        map = new HashMap<>();
        
        map.put("A+", new BigDecimal("4.50"));
        map.put("A0", new BigDecimal("4.00"));
        map.put("B+", new BigDecimal("3.50"));
        map.put("B0", new BigDecimal("3.00"));
        map.put("C+", new BigDecimal("2.50"));
        map.put("C0", new BigDecimal("2.00"));
        map.put("D+", new BigDecimal("1.50"));
        map.put("D0", new BigDecimal("1.00"));
        map.put("F", new BigDecimal("0.00"));
    }
}