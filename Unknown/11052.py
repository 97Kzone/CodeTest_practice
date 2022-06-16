N = int(input())
cards = [0] + list(map(int, input().split()))

dp = [0] * (N+1)

for i in range(1, N+1):
    for k in range(1, i+1):
        dp[i] = max(dp[i], cards[k]+dp[i-k])

print(dp[-1])