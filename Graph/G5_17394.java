package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_17394 {

    static boolean[] isPrime;
    static int N, A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        init();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            bw.write(check(N, A, B) + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int check(int n, int s, int e) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] visited = new int[1_000_001];
        q.offer(n);
        visited[n] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();

            if (now >= s && now <= e && !isPrime[now]) {
                return visited[now] - 1;
            }

            int tmp = now / 2;
            if (tmp >= 0 && visited[tmp] == 0) {
                visited[tmp] = visited[now] + 1;
                q.offer(tmp);
            }

            tmp = now / 3;
            if (tmp >= 0 && visited[tmp] == 0) {
                visited[tmp] = visited[now] + 1;
                q.offer(tmp);
            }

            tmp = now + 1;
            if (tmp <= 1_000_000 && visited[tmp] == 0) {
                visited[tmp] = visited[now] + 1;
                q.offer(tmp);
            }

            tmp = now - 1;
            if (tmp >= 0 && visited[tmp] == 0) {
                visited[tmp] = visited[now] + 1;
                q.offer(tmp);
            }
        }

        return -1;
    }

    static void init() {
        isPrime = new boolean[1_000_001];
        for(int i = 2; i <= Math.sqrt(1_000_000) + 1; i++) {
            if(!isPrime[i]) { 
                int j = 2;
                while(i * j <= 1_000_000) {
                    isPrime[i * j] = true; 
                    j += 1;
                }
            }
        }
    }
}