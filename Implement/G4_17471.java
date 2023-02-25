package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_17471 {
    static int N, res;
    static int[] pp;
    static boolean[] select, visit; 
    static ArrayList<Integer>[] graph; // 연결 확인용
    static ArrayList<Integer> a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        pp = new int[N+1];
        graph = new ArrayList[N+1];
        select = new boolean[N+1];
        res = Integer.MAX_VALUE;

        // 그래프 초기화
        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            pp[i] = Integer.parseInt(st.nextToken());
        }

        int e;
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            e = Integer.parseInt(st.nextToken());
            for (int j = 0; j < e; j++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        cb(1);
        if (res == Integer.MAX_VALUE) res = -1;
        System.out.print(res);
    }   
    
    // 조합
    static void cb(int idx) {
        if (idx == N+1) {
            check();
            return;
        }

        select[idx] = true;
        cb(idx + 1);
        select[idx] = false;
        cb(idx + 1);
        
    }    

    // 가능한 구성인지 판단
    static void check() {
        a = new ArrayList<>();
        b = new ArrayList<>();

        for (int i = 1; i < N+1; i++) {
            if (select[i]) a.add(i);
            else b.add(i);
        }

        if (a.size() == 0 || b.size() == 0) return;

        if (isLink(a) && isLink(b)) count(a, b);
    }

    // 두 선거구 인구 차이
    static void count(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        int aSum = 0, bSum = 0;

        for (int v : l1) aSum += pp[v];
        for (int v : l2) bSum += pp[v];

        res = Math.min(res, Math.abs(aSum - bSum));
    }

    // 연결 되어있는지 확인
    static boolean isLink(ArrayList<Integer> list) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(list.get(0));

        visit = new boolean[N+1];
        visit[list.get(0)] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int nxt : graph[now]) {
                if (!list.contains(nxt) || visit[nxt]) continue;
                visit[nxt] = true;
                q.offer(nxt);
                cnt++;
            }
        }

        return cnt == list.size() ? true : false;
    }
}
