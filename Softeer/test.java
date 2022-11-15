import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {
	static StringTokenizer st;
	static boolean[][] visit;
	static int[][] area;
	static int[] res;
	static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int lines;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        lines = Integer.parseInt(br.readLine());
        area = new int[lines][lines];
		visit = new boolean[lines][lines];

        for(int i=0; i<lines; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<lines; j++){
				int tmp = Integer.parseInt(st.nextToken());
				area[i][j] = tmp;
			}
        }

		ArrayList<Integer> res = new ArrayList<>();
		for (int i=0; i<lines; i++) {
			for(int j=0; j<lines; j++) {
				if (area[i][j] == 1 && !visit[i][j]) {
					int v = bfs(i, j);
					if (v > 0) res.add(v);
				}
			}
		}

		Collections.sort(res);
		System.out.println(res.size());
		for (int v : res) {
			System.out.print(v + " ");
		}
		System.out.println();
	}

	public static int bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i, j});
		visit[i][j] = true;
		int cnt = 1;

		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();

			for (int k=0; k<4; k++) {
				int nx = x + moves[k][0];
				int ny = y + moves[k][1];
				if (0 <= nx && nx < lines && 0 <= ny && ny < lines) {
					if (area[nx][ny] == 1 && !visit[nx][ny]) {
						q.add(new int[] {nx, ny});
						visit[nx][ny] = true;
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}