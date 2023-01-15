from collections import defaultdict

def check(n):
    if dp[n] == 0:
        if n % 2 == 0:
            fm = check((n//2) - 1)
            fn = check(n//2)

            dp[n] = (fn * (2 * fm + fn)) % 1000000007
        else:
            fm = check((n//2)+1)
            fn = check(n//2)

            dp[n] = (fm**2 + fn**2) % 1000000007

    return dp[n]

N = int(input())
dp = defaultdict(int)
dp[1] = 1
dp[2] = 1

print(check(N))



