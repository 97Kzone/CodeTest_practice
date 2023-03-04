import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


// 큐 없는 풀이.. 신기하다
public class SW_2477 {
    static int N, M, K, A, B, res;
    static int[] info1, info2; // 접수, 정비 
    static int[][] people; // 고객정보

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken()); // 타켓 창구
            B = Integer.parseInt(st.nextToken()); // 타켓 정비

            info1 = new int[N];
            info2 = new int[M];
            people = new int[K][3]; // 고객번호, 도착시간, 접수창구

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) info1[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) info2[i] = Integer.parseInt(st.nextToken());
        
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                people[i][0] = i + 1;
                people[i][1] = Integer.parseInt(st.nextToken());
            }
            
            res = 0;
            check();
            res = res == 0 ? -1 : res;
            sb.append("#" + t + " ").append(res + "\n");
        }
        System.out.print(sb.toString());
    }

    static void check() {
        int[] wait = new int[N]; // 접수창구 대기시간

        int gate;
        for (int i = 0; i < K; i++) { // 접수 하려는 고객에 대하여
            gate = 0;

            for (int j = 0; j < N; j++) {
                if (wait[j] <= people[i][1]) {
                    gate = j;
                    break;
                } else if (wait[j] < wait[gate]) gate = j;
            }

            people[i][2] = gate;
            if (wait[gate] < people[i][1]) wait[gate] = people[i][1] + info1[gate];
            else wait[gate] += info1[gate];
            people[i][1] = wait[gate];
        }

        // 1. 먼저 도착한 사람이 2. 더 적은 번호 창구를 쓴 사람이
        Arrays.sort(people, new Comparator<int[]>() { 
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[2] - o2[2];
                return o1[1] - o2[1];
            }
        });

        wait = new int[M];
        for (int i = 0; i < K; i++) {
            gate = 0;

            for (int j = 0; j < M; j++) {
                if (wait[j] <= people[i][1]) {
                    gate = j;
                    break;
                } 

                if (wait[j] < wait[gate]) gate = j;
            }
            if (wait[gate] < people[i][1]) wait[gate] = people[i][1] + info2[gate];
            else wait[gate] += info2[gate];

            if (people[i][2] == A-1 && gate == B-1) res += people[i][0];
        } 
    }
}
