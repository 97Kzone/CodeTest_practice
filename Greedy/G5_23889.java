package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class G5_23889 {

    static int N, M, K;
    static int[] town, rock;
    static List<int[]> cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        town = new int[N];
        rock = new int[K];
        cnt = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            town[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            rock[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        int sum;
        for (int i = 0; i < K - 1; i++) {
            sum = 0;
            for (int j = rock[i]; j < rock[i + 1]; j++) {
                sum += town[j];
            }

            cnt.add(new int[] { sum, rock[i] });

            if (i == K - 2) {
                sum = 0;
                for (int j = rock[i + 1]; j < N; j++) {
                    sum += town[j];
                }
                cnt.add(new int[] { sum, rock[i + 1] });
            }
        }

        if (K == 1) {
            sum = 0;
            for (int j = 0; j < N; j++) {
                sum += town[j];
            }
            cnt.add(new int[] { sum, rock[0] });
        }

        Collections.sort(cnt, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o2[0] - o1[0];
                return o1[1] - o2[1];
            }
        });

        List<int[]> topM = new ArrayList<>(cnt.subList(0, Math.min(M, cnt.size())));
        Collections.sort(topM, Comparator.comparingInt(o -> o[1]));

        for (int[] item : topM) {
            System.out.println(item[1] + 1);
        }
    }
}
