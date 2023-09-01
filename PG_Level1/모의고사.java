import java.util.*;
import java.lang.Math;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int arr1[] = {1,2,3,4,5};
        int arr2[] = {2,1,2,3,2,4,2,5};
        int arr3[] = {3,3,1,1,2,2,4,4,5,5};
        int count[] = {0 ,0, 0};

        for(int i = 0; i < answers.length; i++)
        {
            if(arr1[i%arr1.length] == answers[i])
            {
                count[0]++;
            }
            
            if(arr2[i%arr2.length] == answers[i])
            {
                count[1]++;
            }
            
            if(arr3[i%arr3.length] == answers[i])
            {
                count[2]++;
            }
        }
        int Max = Math.max(count[0], Math.max(count[1], count[2]));
        int tmp = 0;
        int num[]= {0, 0, 0};
        for(int i = 0; i < 3; i++)
        {
            if(count[i] == Max)
            {
                num[tmp] = i+1;
                tmp++;
            }
        }
        answer = new int[tmp];

        for(int i = 0; i < tmp; i++)
        {
            if(num[i] > 0)
            {
                answer[i] = num[i];
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}