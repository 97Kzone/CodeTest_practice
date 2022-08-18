import sys
from itertools import accumulate as ac
input = sys.stdin.readline

N, M = map(int, input().split())
P = list(map(int, input().split()))
c = [list(map(int, input().split())) for _ in range(N-1)]

visit = [0] * (N+1)
for i in range(M-1):
    if P[i] < P[i+1]:
        visit[P[i]] += 1
        visit[P[i+1]] -= 1
    else:
        visit[P[i+1]] += 1
        visit[P[i]] -= 1
    
visit = list(ac(visit))

res = 0
for i in range(1, N):
    if visit[i]:
        x, y, z = c[i-1]
        res += min(x * visit[i], z + y * visit[i])

print(res)