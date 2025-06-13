package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class S4_15183 {

    static int N, R;
    static List<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        Deque<String> dq = new ArrayDeque<>();

        String name;
        for (int i = 0; i < N; i++) {
            name = br.readLine();
            list.add(name);
            dq.offer(name);
        }

        int now = 0;
        R = Integer.parseInt(br.readLine());

        int s, m, cnt;
        List<String> tmp;
        for (int i = 0; i < R; i++) {
            st =  new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            cnt = (int) (m % dq.size());
            for (int j = 0; j < cnt; j++) {
                dq.addFirst(dq.pollLast());
            }

            tmp = new ArrayList<>(dq);
            name = tmp.get(s - 1);
            sb.append(name).append(" has been eliminated." + "\n");
            dq.remove(name);
        }

        if (dq.size() == 1) {
            sb.append(dq.peek()).append(" has won.");
        } else {
            tmp = new ArrayList<>(dq);
            tmp.sort(Comparator.comparingInt(list::indexOf));
            sb.append("Players left are");
            for (String n : tmp) {
                sb.append(" ").append(n);
            }
            sb.append(".");
        }

        System.out.print(sb.toString());
    }
}
