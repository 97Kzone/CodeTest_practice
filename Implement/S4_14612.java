package Implement;

import java.io.*;
import java.util.*;

public class S4_14612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();

        String cmd;
        int a, b;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            cmd = st.nextToken();

            if ("order".equals(cmd)) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                list.add(new int[] { a, b });
                for (int[] now : list) {
                    sb.append(now[0] + " ");
                }
                sb.append("\n");
            } else if ("sort".equals(cmd)) {
                Collections.sort(list, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[1] == o2[1]) {
                            return o1[0] - o2[0];
                        }
                        return o1[1] - o2[1];
                    }
                });

                if (list.size() == 0) {
                    sb.append("sleep" + "\n");
                } else {
                    for (int[] now : list) {
                        sb.append(now[0] + " ");
                    }
                    sb.append("\n");
                }
            } else {
                a = Integer.parseInt(st.nextToken());

                for (int j = 0; j < M; j++) {
                    if (list.get(j)[0] == a) {
                        list.remove(j);
                        break;
                    }
                }

                if (list.size() == 0) {
                    sb.append("sleep" + "\n");
                } else {
                    for (int[] now : list) {
                        sb.append(now[0] + " ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
