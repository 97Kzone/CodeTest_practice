package PG_Level2;

class PCCP2 {

    static final int COUNT = 1426; // 0, 0, 0 ~ 11, 59, 59 까지 횟수
    static double dm, ds, ds2;

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int t1 = h1 >= 12 ? check(h1 % 12, m1, s1) + COUNT : check(h1, m1, s1);
        int t2 = h2 >= 12 ? check(h2 % 12, m2, s2) + COUNT : check(h2, m2, s2);

        // 마지막 1초에 겹치는지 확인
        dm = m2 / 60.0;
        ds = s2 / 3600.0;
        ds2 = s2 / 60.0;
        h2 %= 12;

        if ((h2 + dm + ds) * 5 == s2 || (m2 + ds2) == s2)
            return t2 - t1 + 1;
        else
            return t2 - t1;
    }

    static int check(int h, int m, int s) {
        if (h == 0 && m == 0 && s == 0)
            return 0;

        // 현재 시간까지 오면서 겹친 횟수, 11시 59분 59초 기준 1426회
        int res = (h * 60) + (h * 59) + (m * 2) - 1;

        dm = m / 60.0;
        ds = s / 3600.0;
        ds2 = s / 60.0;

        // 시침의 각도식으로 위치 구하기
        if ((h + dm + ds) * 5 < s)
            res++;

        // 분침의 각도식으로 위치 구하기
        if (m + ds2 < s)
            res++;

        return res;
    }
}