N = int(input())

dp = [50001 for _ in range(N+1)]
dp[0] = 0

for i in range(1, N+1):
    for j in range(1, i+1):
        v = j ** 2
        if v > i:
            break
        dp[i] = min(dp[i], dp[i-v] + 1)
        
print(dp[N])