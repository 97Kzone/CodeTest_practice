package Implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class S2_5002 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        Queue<Character> waittingQ = new LinkedList<Character>();
        int manCnt = 0;
        int womanCnt = 0;
        
        for (int i = 0; i < input.length(); i++) {
            char person = input.charAt(i);
            if (!waittingQ.isEmpty()) {
                char waittingPerson = waittingQ.peek();
                if (waittingPerson == 'M') {
                    if (Math.abs((manCnt + 1) - womanCnt) <= n) {
                        manCnt++;
                        waittingQ.poll();
                    }
                } 
                else {
                    if (Math.abs(manCnt - (womanCnt + 1)) <= n) {
                        womanCnt++;
                        waittingQ.poll();
                    }
                }
            }
            
            if (person == 'M') {
                if (Math.abs((manCnt + 1) - womanCnt) <= n) {
                    manCnt++;
                }
                else if (waittingQ.isEmpty()) {
                    waittingQ.add(person);
                } 
                else {
                    break;
                }
            } else {
                if (Math.abs(manCnt - (womanCnt + 1)) <= n) {
                    womanCnt++;
                }  else if (waittingQ.isEmpty()) {
                    waittingQ.add(person);
                } else {
                    break;
                }
            }
            
        }
        
        System.out.println(manCnt + womanCnt);
        
    
    }
 
}

