import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class UserSolution {

    static TreeSet<String>[] set; // 26개 단어 처리
    static Set<String> words = new HashSet<>(); // 전체 사용 단어
    static List<String> used = new ArrayList<>(); // 라운드 사용한 단어
    static boolean[] player;
    static StringBuffer sb;
    static int res, n;

    public void init(int N, int M, char[][] mWords)
    {
        // 1. 자료구조 초기화
        set = new TreeSet[26];
        words.clear();
        player = new boolean[50001];
        n = N;

        for (int i = 0; i < 26; i++)
            set[i] = new TreeSet<>();

        for (int i = 1; i <= N; i++)
            player[i] = true;
            
        // 2. 단어 사전 순 정렬
        for (int i = 0; i < M; i++) {
            set[mWords[i][0] - 'a'].add(new String(mWords[i]).trim());
        }
    }

    public int playRound(int mID, char mCh)
    {
        used.clear();
        res = mID; // 이번 라운드 탈락자

        // 탈락자가 나올 때 까지 반복
        int idx;
        String tmp;
        while (true) {
            idx = mCh - 'a';
            
            // 단어가 없으면 탈락
            if (set[idx].size() == 0) {
                player[res] = false;
                break;
            }

            // 단어가 있으면?
            // 1. 꺼낸다
            tmp = set[idx].first().trim();
            set[idx].remove(tmp);
            mCh = tmp.charAt(tmp.length() - 1);

            // 2. user 배열에 추가한다
            used.add(tmp);
            words.add(tmp);

            // 3. 턴을 넘긴다
            while (true) {
                if (res == n)res = 0;

                if (player[++res])
                    break;
            }
        }

        // 경기가 끝났으면 used 배열에 있는 단어를 다시 추가 해주자
        for (String word : used) {
            sb = new StringBuffer(word);
            tmp = sb.reverse().toString().trim();

            if (words.contains(tmp))
                continue;

            set[tmp.charAt(0) - 'a'].add(tmp);
        }
        System.out.println(res);
        return res;
    }
}