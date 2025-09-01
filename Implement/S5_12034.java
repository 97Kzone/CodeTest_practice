package Implement;

import java.io.*;
import java.util.*;

public class S5_12034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());  // 할인된 가격 개수
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> priceList = new ArrayList<>();

            for (int i = 0; i < N * 2; i++) {
                priceList.add(Integer.parseInt(st.nextToken()));
            }

            // 큰 값부터 처리하기 위해 내림차순 정렬
            priceList.sort(Comparator.reverseOrder());

            List<Integer> discountPrices = new ArrayList<>();

            while (!priceList.isEmpty()) {
                int price = priceList.remove(0); // 가장 큰 값 꺼내기
                int discounted = (int)(price * 0.75);

                if (priceList.contains(discounted)) {
                    discountPrices.add(discounted);
                    priceList.remove(Integer.valueOf(discounted));
                }
            }

            Collections.sort(discountPrices);

            bw.write("Case #" + t + ":");
            for (int val : discountPrices) {
                bw.write(" " + val);
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
