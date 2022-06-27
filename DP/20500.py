N = int(input())

dp = [0] * 1516
dp[2], dp[3] = 1, 1
for i in range(4, 1516):
    dp[i] = ((dp[i-2] * 2) + dp[i-1]) % 1000000007

print(dp[N])