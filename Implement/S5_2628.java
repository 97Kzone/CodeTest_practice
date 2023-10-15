package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_2628 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] numM = new int[M + 1];
		int[] numN = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken());
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (type == 0) {
				numN[num] = 1;
			} else
				numM[num] = 1;
		}
		int temp = 0, maxN = 0, maxM = 0;
		for (int i = 1; i <= N; i++) {
			temp++;
			if (numN[i] == 1 || i == N) {
				maxN = Math.max(maxN, temp);
				temp = 0;
			}
		}

		temp = 0;
		for (int i = 1; i <= M; i++) {
			temp++;
			if (numM[i] == 1 || i == M) {
				maxM = Math.max(maxM, temp);
				temp = 0;
			}
		}
		System.out.println(maxM * maxN);
	}
}
