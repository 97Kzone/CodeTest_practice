package PG_Level2;

class Solution {

    static int numA, numB;
    static boolean fa, fb;

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        numA = arrayA[0];
        numB = arrayB[0];
        for (int n : arrayA) numA = gcd(numA, n);
        for (int n : arrayB) numB = gcd(numB, n);

        fa = check(numA, arrayB);
        fb = check(numB, arrayA);

        if (fa && fb) answer = Math.max(numA, numB);
        else if (fa) answer = numA;
        else if (fb) answer = numB;

        return answer;
    }

    static boolean check(int num, int[] std) {
        if (num == 1) return false;

        for (int n : std) {
            if (n % num == 0) return false;
        }

        return true;
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
