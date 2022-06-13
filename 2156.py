N = int(input())

wines = [int(input()) for _ in range(N)]
dp = [0] * 10000

if N < 3:
    print(sum(wines))
else:
    dp[0] = wines[0]
    dp[1] = wines[1] + wines[0]
    dp[2] = max(wines[2]+wines[1], wines[2]+wines[0], dp[1])

    for i in range(3, N):
        dp[i] = max(wines[i] + dp[i-2], wines[i] + wines[i-1] + dp[i-3], dp[i-1])

    print(max(dp))