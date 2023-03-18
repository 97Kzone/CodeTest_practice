package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 굉장히 신선한 DP 활용 문제
 * 이걸 어떻게 떠올릴 수 있을까
 */
public class G1_12969 {
    static int N, K;
    static boolean[][][][] visit;
    static char[] res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new boolean[31][31][31][456]; // N, A, B, 쌍의 개수
        res = new char[N];

        if(check(0, 0, 0, 0)) System.out.print(String.valueOf(res));
        else System.out.print(-1);
    }

    static boolean check(int idx, int aCnt, int bCnt, int v) {
        if (idx == N) return v == K ? true : false;
        
        if(visit[idx][aCnt][bCnt][v]) return false;
        visit[idx][aCnt][bCnt][v] = true;

        res[idx] = 'A';
        if (check(idx+1, aCnt+1, bCnt, v)) return true;

        res[idx] = 'B';
        if (check(idx+1, aCnt, bCnt+1, v+aCnt)) return true;

        res[idx] = 'C';
        if (check(idx+1, aCnt, bCnt, v + aCnt + bCnt)) return true;

        return false;
    }
}
