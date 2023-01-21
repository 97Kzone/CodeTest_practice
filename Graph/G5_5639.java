package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 트리 구현없이 단순 풀이
public class G5_5639 {
    static int N;
    static ArrayList<Integer> nums;
    public static void main(String[] args) throws IOException {
        sol1();
    }

    static void sol1() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        nums = new ArrayList<>();

        while (true) {
            s = br.readLine();
            if (s == null || s.equals("")) {
                break;
            }
            nums.add(Integer.parseInt(s));
        }

        check(0, nums.size()-1);
    }

    // BST 규칙 1. 루트보다 작으면 왼쪽, 크면 오른쪽
    static void check(int l, int r) {
        if (l > r) return;
        int m = l+1;

        //루트(서브트리)보다 큰 숫자를 만날때까지 탐색
        while (true) {
            //트리범위 벗어나면 break
            if (m <= r) {
                //루트보다 크면 break
                if (nums.get(m) < nums.get(l)) {
                    m += 1;
                } else break;
            } else break;
        }

        check(l+1, m-1); 
        check(m, r); 

        System.out.println(nums.get(l));
    }
}
