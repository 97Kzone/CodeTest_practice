import java.util.*;

class Solution {
    
    static int N;
    static int[] num1, num2;
    
    public int solution(int coin, int[] cards) {
        N = cards.length;
        int answer = 1;

        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
    
        num1 = new int[N + 1];
        num2 = new int[N + 1];
        
        int tmp;
        for (int i = 0; i < N / 3; i++) {
            tmp = cards[i];
            num1[tmp]++;
            
            if (num1[tmp] != 0 & num1[N+1-tmp] != 0) {
                n1++;
                num1[tmp]--;
                num1[N + 1 - tmp]--;
            }
        }
        
        int a, b;
        for (int i = N / 3; i < N; i += 2) {
            a = cards[i];
            b = cards[i + 1];
            num2[a]++;
            num2[b]++;
            
            if (num2[a] != 0 && num1[N+1-a] != 0) {
                n2++;
                num2[a]--;
                num1[N+1-a]--;
            }
            
            if (num2[b] != 0 && num1[N+1-b] != 0) {
                n2++;
                num2[b]--;
                num1[N+1-b]--;
            }
            
            if (num2[a] != 0 && num2[N+1-a] != 0) {
                n3++;
                num2[a]--;
                num2[N+1-a]--;
            }
            
            if (num2[b] != 0 && num2[N+1-b] != 0) {
                n3++;
                num2[b]--;
                num2[N+1-b]--;
            }
            
            if (n1 != 0) {
                n1--;
                answer++;
            } else if (n2 != 0 && coin != 0) {
                coin--;
                n2--;
                answer++;
            } else if (n3 != 0 && coin >= 2) {
                coin -= 2;
                n3--;
                answer++;
            } else break;
        }
        
        return answer;
    }
}
