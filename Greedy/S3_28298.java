package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S3_28298 {
    static int N, M, K;
    static Map<Character, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];

        String s;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int res = 0;
        int cnt;
        char std;
        map = new HashMap<>();
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                map.clear();
                ;
                cnt = Integer.MIN_VALUE;
                std = board[i][j];

                for (int a = i; a < N; a += K) {
                    for (int b = j; b < M; b += K) {
                        map.put(board[a][b], map.getOrDefault(board[a][b], 0) + 1);
                    }
                }

                for (char key : map.keySet()) {
                    if (map.get(key) > cnt) {
                        cnt = map.get(key);
                        std = key;
                    }
                }

                res += (N / K) * (M / K) - cnt;
                for (int a = i; a < N; a += K) {
                    for (int b = j; b < M; b += K) {
                        board[a][b] = std;
                    }
                }
            }
        }
        
        System.out.println(res);
        for (int i = 0; i < N; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                sb.append(board[i][j]);
            }
            System.out.println(sb);
        }        
    }
}
