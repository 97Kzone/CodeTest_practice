package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S5_32752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (i < L) {
                list.add(Integer.parseInt(st.nextToken()));
            } else if (L <= i && i <= R) {
                pq.offer(Integer.parseInt(st.nextToken()));
            } else {
                while(!pq.isEmpty()) {
                    list.add(pq.poll());
                }
                list.add(Integer.parseInt(st.nextToken()));
            }
        }

        while(!pq.isEmpty()) {
            list.add(pq.poll());
        }
        
        boolean flag = true;
        for (int i = 1; i < N; i++) {
            if (list.get(i) < list.get(i-1)) {
                flag = false;
                break;
            }
        }

        System.out.print(flag ? 1 : 0);
    }
}
