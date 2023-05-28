package PG_Level2;

import java.util.*;
import java.lang.Math;
import java.util.Set;

class Solution {
    public int solution(String numbers) {
        String[] num = numbers.split("");
        HashSet<Integer> prim = new HashSet<>();
        
        for(int i = 1; i <= num.length; i++)
        {
            per(num, 0, i, prim);
        }
        
        return prim.size();
    }
    
    public void per(String[] num, int depth, int k, Set prim)
    {
        if(depth == k)
        {
            print(num, k, prim);
            return;
        }
        else{
            for(int i = depth; i < num.length; i++)
            {
                swap(num, depth, i);
                per(num, depth+1, k, prim);
                swap(num, depth, i);
            }
        }
    }
    
    public void swap(String[] num, int i, int j)
    {
        String temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    
    public void print(String[] num, int k, Set prim)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < k; i++)
        {
            sb.append(num[i]);
        }
        Prime(prim, sb);
    }
    
    public void Prime(Set prim, StringBuilder sb)
    {
        int num = Integer.parseInt(String.valueOf(sb));
        boolean flag = true;
        if(num <= 1)
        {
            return;
        }
        
        for(int i = 2; i <= Math.sqrt(num); i++)
        {
            if(num%i == 0)
            {
                flag = false;
                break;
            }
        }
        
        if(flag)
        {
            prim.add(num);
        }
    }
}
