package PG_Level2;

public class 멀쩡한사각형 {
    static long answer = 1;
    static long temp;

    public long solution(int w, int h) {
        long area = (long) w * h;
        temp = 0;

        if (w >= h)
            check(w, h);
        else
            check(h, w);

        answer = area - (w + h - temp);
        return answer;
    }

    static void check(int a, int b) {
        for (int i = 1; i <= b; i++) {
            if (a % i == 0 && b % i == 0)
                temp = i;
        }
    }
}