package PrefixSum;

import java.util.ArrayList;
import java.util.Scanner;

public class G1_1208 {
    static int N, S;
    static long res;
    static int[] nums;
    static ArrayList<Integer> n1;
    static ArrayList<Integer> n2;

    public static void main(String[] args) {
        sol();
    }

    static void sol() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        n1 = new ArrayList<>();
        n2 = new ArrayList<>();

        make(0, N/2, 0, n1);
        make(N/2, N, 0, n2);

        n1.sort(null);
        n2.sort(null);

        check();

        System.out.println(S == 0 ? res-1 : res);
    }

    static void make(int s, int e, int v, ArrayList<Integer> list) {
        if (s == e) {
            list.add(v);
            return;
        }

        make(s+1, e, v + nums[s], list);
        make(s+1, e, v, list);
    }

    static void check() {
        int l = 0, r = n2.size()-1;
        res = 0;

        long v1, v2, tmp;
        long std;
        while (l < n1.size() && r > -1) {
            std = n1.get(l) + n2.get(r);
            
            if (std == S) {
                tmp = n1.get(l);
                v1 = 0;
                while (l < n1.size() && n1.get(l) == tmp) {
                    l++;
                    v1++;
                }

                v2 = 0;
                tmp = n2.get(r);
                while (r > -1 && n2.get(r) == tmp) {
                    r--;
                    v2++;
                }

                res += v1 * v2;
            }
            else if (std < S) {
                l++;
            } else r--;
        }
    }
}
