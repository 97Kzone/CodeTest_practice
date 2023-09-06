package Implement;

import java.util.*;

public class S1_9765 {
    static final int MAX = 20000000;
    static boolean[] isPrime = new boolean[MAX + 1];
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        generatePrimes();

        Scanner scanner = new Scanner(System.in);
        long c1 = scanner.nextLong();
        long c3 = scanner.nextLong();
        long c5 = scanner.nextLong();
        long c6 = scanner.nextLong();

        Set<Long> usedPrimes = new HashSet<>();

        long x1 = findPrimeFactor(c1);
        usedPrimes.add(x1);
        long x2 = c1 / x1;
        usedPrimes.add(x2);

        long x3 = findUnusedPrimeFactor(c5 / x2, usedPrimes);
        usedPrimes.add(x3);

        long x5 = findUnusedPrimeFactor(c6 / findPrimeFactor(c3), usedPrimes);
        usedPrimes.add(x5);

        long x6 = c6 / x5;
        usedPrimes.add(x6);

        long x7 = c3 / x6;

        System.out.printf("%d %d %d %d %d %d", x1, x2, x3, x5, x6, x7);
    }

    public static void generatePrimes() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= MAX; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (long j = (long) i * i; j <= MAX; j += i) {
                    isPrime[(int) j] = false;
                }
            }
        }
    }

    public static long findPrimeFactor(long n) {
        for (int prime : primes) {
            if (n % prime == 0) {
                return prime;
            }
        }
        return -1;
    }

    public static long findUnusedPrimeFactor(long n, Set<Long> used) {
        for (int prime : primes) {
            if (n % prime == 0 && !used.contains((long) prime)) {
                return prime;
            }
        }
        return -1;
    }
}