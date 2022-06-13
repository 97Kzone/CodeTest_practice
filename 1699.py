N = int(input())
dp = [i for i in range(N+1)]

for i in range(1, N+1):
    for k in range(1, i):
        if k**2 > i:
            break
            
        if dp[i] > dp[i-k**2] + 1:
            dp[i] = dp[i-k**2] + 1

print(dp[N])