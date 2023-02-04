import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

// 200ms 미만 풀이는 과연 뭘까?
public class D4_5671 {
	static int N, M, res;
	static boolean[] use;
	static char[][] word;
	static HashSet<Character> alpha;
	static ArrayList<Character> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			use = new boolean[26];
			
			alpha = new HashSet<Character>();
			word = new char[N][];
			for (int i = 0; i < N; i++) {
				word[i] = br.readLine().trim().toCharArray();
				for (int j = 0; j < word[i].length; j++)
					alpha.add(word[i][j]);
			}

			list = new ArrayList<Character>();
			list.addAll(alpha);

			if (list.size() <= M) {
				res = N;
			} else {
				res = 0;
				cb(0, 0);
			}
            System.out.printf("#%d %d\n", t, res);
		}
	}

	static void cb(int idx, int cnt) {
		if (cnt == M) {
			check();
			return;
		}

		for (int i = idx; i < list.size(); i++) {
			int temp = list.get(i) - 'a';
			use[temp] = true;
			cb(i + 1, cnt + 1);
			use[temp] = false;
		}
	}

    static void check() {
        int c = 0;
        loop:
		for (int i = 0; i < N; i++) {
			int length = word[i].length;
			for (int j = 0; j < length; j++) {
				if (!use[word[i][j] - 'a'])
					continue loop;
			}
			c++;
		}
		if (res < c) res = c;
    }
}