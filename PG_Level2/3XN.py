def solution(n):
    dp = [1, 0, 3] + ([0] * n)

    for i in range(4, n+1):
        if i % 2 == 1:
            continue

        dp[i] = ((dp[i-2] * 4) - dp[i-4]) % 1000000007

    return dp[n]