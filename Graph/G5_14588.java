package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_14588 {

    static int N, M;
    static int[][] board, graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
        }

        graph = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], N+1);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if((board[j][0] >= board[i][0] && board[j][0] <= board[i][1]) ||
                   (board[j][1] >= board[i][0] && board[j][1] <= board[i][1]) ||
                   (board[j][0] < board[i][0] && board[j][1] > board[i][1])) {
                    graph[i][j] = graph[j][i] = 1;
                }
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        M = Integer.parseInt(br.readLine());

        int s, e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            bw.write(graph[s][e] == N + 1 ? "-1" : graph[s][e] + "");
            bw.write("\n");
        }
        
        bw.flush();
        bw.close();
    }
}
