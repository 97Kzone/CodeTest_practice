package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class G4_15961 {
    static int N, D, K, C; // 접시 수, 초밥 수, 연속 먹는 수, 쿠폰 번호
    static List<Integer> sushi; // 회전 초밥 상태 
    static Map<Integer, Integer> eat; // K개 연속먹을 때, 초밥 종류
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        sushi = new ArrayList<>();
        eat = new HashMap<>();

        for (int i = 0; i < N; i++) sushi.add(Integer.parseInt(br.readLine()));

        sushi.addAll(sushi); // 원형 리스트처럼 쓰기 위해 뒤에 붙여버리기
        eat.put(C, 1); // 쿠폰 번호는 늘 먹은거로 처리


        // 초기값 세팅 (초기 K개 먹었을 때 상태)
        int idx, v;
        for (int i = 0; i < K; i++) {
            idx = sushi.get(i);
            v = eat.get(idx) == null ? 1 : eat.get(idx) + 1;
            eat.put(idx, v);
        }

        // 결과값, 2개의 포인터
        int res = 0, i = 0, j = K;

        // 슬라이딩 윈도우로 전체 초밥 체크
        while(j < sushi.size() - 1) {
            res = Math.max(res, eat.size());
            
            if(res == K+1) break; // break 포인트

            idx = sushi.get(i);
            if (eat.get(idx) == 1) eat.remove(idx);
            else eat.put(idx, eat.get(idx) - 1);

            idx = sushi.get(j);
            v = eat.get(idx) == null ? 1 : eat.get(idx) + 1;
            eat.put(idx, v);
            i++;
            j++;
        }

        System.out.print(res);
    }
}
