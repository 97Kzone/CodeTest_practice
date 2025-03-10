package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S3_31409 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(0);
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (list.get(i) == i) {
                if(i == N) {
                    list2.add(i-1);
                } else {
                    list2.add(i+1);
                } 
                cnt++;
            } else {
                list2.add(list.get(i));
            }
        }

        sb.append(cnt + "\n");
        for (int n : list2) {
            sb.append(n + " ");
        }

        System.out.print(sb.toString());
    }
}
