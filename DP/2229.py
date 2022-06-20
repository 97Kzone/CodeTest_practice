import sys
input = sys.stdin.readline

N = int(input())
scores = list(map(int, input().split()))
dp = [0] * (N+1)

for i in range(1, N):
    dp[i+1] = dp[i]
    m = M = scores[i]

    for j in range(i-1, -1, -1):
        M = max(M, scores[j])
        m = min(m, scores[j])

        dp[i+1] = max(dp[i+1], dp[j] + M-m)
    
print(dp[-1])