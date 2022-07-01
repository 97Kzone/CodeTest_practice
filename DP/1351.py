from collections import defaultdict
N, P, Q = map(int, input().split())

dp = defaultdict(int)
dp[0] = 1

def check(i):
    if dp[i] != 0:
        return dp[i]

    dp[i] = check(i//P) + check(i//Q)
    return dp[i]
    
print(check(N))