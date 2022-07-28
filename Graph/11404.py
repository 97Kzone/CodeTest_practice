from cmath import inf
import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
res = [[inf] * N for _ in range(N)]

for i in range(N):
    res[i][i] = 0

for _ in range(M):
    s, e, c = map(int, input().split())
    res[s-1][e-1] = min(res[s-1][e-1], c)

for i in range(N):
    for j in range(N):
        for k in range(N):
            res[j][k] = min(res[j][k], res[j][i] + res[i][k])

for i in range(N):
    for j in range(N):
        if res[i][j] == inf:
            res[i][j] = 0

for v in res:
    print(" ".join(str(n) for n in v))