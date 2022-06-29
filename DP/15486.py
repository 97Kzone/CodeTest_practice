import sys
input = sys.stdin.readline

N = int(input())
works = [list(map(int, input().split())) for _ in range(N)]
dp = [0] * (N+1)

for i, work in enumerate(works):
    t, p = work

    if i + t <= N:
        dp[i+t] = max(dp[i+t], dp[i] + p)
    
    dp[i+1] = max(dp[i+1], dp[i])

print(dp[-1]) 