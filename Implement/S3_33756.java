package Implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S3_33756 { 

    static int Q;
    static final List<Long> EIGHT_NUMBERS = new ArrayList<>();
    
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Q = Integer.parseInt(br.readLine());
        init();
        for (int i = 0; i < Q; i++) {
            long N = Long.parseLong(br.readLine());

            if (solve(N, 8, 0)) bw.write("Yes\n");
            else bw.write("No\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    static void init() {
        long current = 8;
    
        while (true) { 
            EIGHT_NUMBERS.add(current);
            
            if (current > Long.MAX_VALUE / 10) { 
                break; 
            }
            
            long next = current * 10 + 8;
            if (next <= current || next < 0) { 
                break;
            }
            current = next;
        }
        Collections.reverse(EIGHT_NUMBERS);
    }

    private static boolean solve(long remainingN, int limit, int idx) {
        if (remainingN == 0) {
            return true;
        }
        if (limit == 0 || idx >= EIGHT_NUMBERS.size()) {
            return false;
        }

        for (int i = idx; i < EIGHT_NUMBERS.size(); i++) {
            long eightNum = EIGHT_NUMBERS.get(i);
            
            if (eightNum <= remainingN) {
                if (solve(remainingN - eightNum, limit - 1, i)) {
                    return true;
                }
            }
        }

        return false;
    }
}