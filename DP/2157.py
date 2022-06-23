import sys
input = sys.stdin.readline

N, M, K = map(int, input().split())
trips = [[] for _ in range(N+1)]

for _ in range(K):
    start, end, score = map(int, input().split())
    if start >= end:
        continue

    trips[start].append((end, score))

dp = [[-1e9] * M for _ in range(N+1)]
dp[1][0] = 0

for s in range(1, N+1):
    for m in range(0, M-1):
        if dp[s][m] != -1e9:
            for end, score in trips[s]:
                dp[end][m+1] = max(dp[end][m+1], dp[s][m] + score)

print(max(dp[-1]))
