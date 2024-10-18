package Implement;

import java.util.*;
import java.io.*;

public class S1_32248 {

    static int N;
    static long T;
    static int[] nums;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Long.parseLong(st.nextToken());

        nums = new int[N + 1];
        visit = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int res = check();
        System.out.print(res);
    }
    
    static int check() {
        Arrays.fill(visit, false);
        visit[1] = true;

        int now = 1;
        while (true) {
            now = nums[now];
            T--;

            if (T == 0) {
                return now;
            }

            if (visit[now])
                break;

            visit[now] = true;
        }
        
        List<Integer> list = new ArrayList<>();
        list.add(now);
        int tmp = now;
        now = nums[now];

        while (now != tmp) {
            list.add(now);
            now = nums[now];
        }
        tmp = (int) (T % list.size());
        return list.get(tmp);
    }
}
