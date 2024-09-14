package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class S5_26122 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int K = Integer.parseInt(st.nextToken());
        String S = br.readLine();
    
        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        ArrayList<Integer> nums = new ArrayList<>();
        boolean flag = false; 
    
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'N') {
                stk1.push(1);
                if (!flag) {
                    nums.add(stk2.size());
                    stk2.clear(); 
                }
                flag = true;
            } else if (S.charAt(i) == 'S') {
                stk2.push(1);
                if (flag) {
                    nums.add(stk1.size());
                    stk1.clear();             
                }
                flag = false;
            }
        }

        if (flag) {
            
            nums.add(stk1.size());
        } else {
            nums.add(stk2.size());
        }

        nums.add(0); 

        int res = 0;
        
        for (int i = 1; i < nums.size(); i++) {
            res = Math.max(res, 2 * Math.min(nums.get(i - 1), nums.get(i)));
        }

        System.out.print(res);
    }
}
