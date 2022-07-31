import sys, heapq
input = sys.stdin.readline

N, M, R = map(int, input().split())
items = list(map(int, input().split()))
g = [[10e9] * (N+1) for _ in range(N+1)]

for _ in range(R):
    s, e, c = map(int, input().split())
    g[s][e] = min(g[s][e], c) 
    g[e][s] = min(g[e][s], c)

for i in range(1, N+1):
    for j in range(1, N+1):
        for k in range(1, N+1):
            g[j][k] = min(g[j][k], g[j][i] + g[i][k])
            if j == k:
                g[j][k] = 0

res = 0

for i in range(1, N+1):
    tmp = 0
    for j in range(1, N+1):
        if g[i][j] <= M:
            tmp += items[j-1]

    res = max(res, tmp)

print(res)